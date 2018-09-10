package com.almundo.dispatch;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.almundo.employee.Employee;

/**
 * Clase para la gestion de las llamadas, es la que se encarga de procesar las llamadas, asignar un empleado disponible, 
 * y en caso de no encontrar un empleado disponible, la llamada se continua procesando hasta que se encuentre un empleado para que
 * pueda atender la llamada
 * @author LuisEdo
 *
 */
public class Dispatcher {
	
	/** manejador de logs */
    private static final Logger LOGGER = LoggerFactory.getLogger(Dispatcher.class);
    
    /** Lista de empleados creados en el sistema para atender las llamadas */
    private List<Employee> listEmployees;
    /** ExecutorService para el manejo de los threads */
    private ExecutorService executor;
    
    /** Constante para indicar la cantidad maxima de threads o procesos concurrentes a ejecutar */
    private static final int CANTIDAD_MAXIMA_PROCESAMIENTO = 10;

    
    /**
     * Constructor
     * @param listEmployees lista de empleados
     */
    public Dispatcher(List<Employee> listEmployees) {
        this.listEmployees = listEmployees;
        // se define la cantidad maxima de Threads que va a manejar concurrentemente
        this.executor = Executors.newFixedThreadPool(CANTIDAD_MAXIMA_PROCESAMIENTO);
    }

    /**
     * Metodo que procesa una llamada, busca un empleado disponible y se lo asigna a la llamada.
     * Se maneja un ExecutorService para la adminnistracion de los threads, este permite indicar
     * cuantos procesos concurrente puede manejar y se ajusta a la necesidad.
     * 
     * Este proceso garantiza que la llamada sera atendida por un empleado, ya que si no encuentra un empleado disponible,
     * continua buscando hasta que alguno se libere
     * 
     * @param call
     */
    public void dispatchCall(IncomingCall call) {
        LOGGER.info("Ingresa llamada --> " + call.toString());
        this.executor.submit(() -> {
            try {
                Employee employeeAvailable = null;
                do {
                	employeeAvailable = Employee.getEmployeeAvailable(this.listEmployees);
                    if ( employeeAvailable != null) {
                    	call.setEmployee(employeeAvailable);
                    	LOGGER.info("Empleado " + employeeAvailable.getName() + " Disponible para antender llamada " + call.toString());
                    }
                } while (employeeAvailable == null);
                call.callInProcess();
                call.setAttended(true);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                LOGGER.error("error atendiendo llamada", e);
            }
        });
    }

    /**
     * Metodo que retorna la lista de empleados
     * @return lista de empleados
     */
    public List<Employee> getListEmployees() {
        return this.listEmployees;
    }

    /**
     * Metodo que setea la lista de empleados
     * @param listEmployees lista de empleados
     */
    public void setListEmployees(List<Employee> listEmployees) {
        this.listEmployees = listEmployees;
    }
}

