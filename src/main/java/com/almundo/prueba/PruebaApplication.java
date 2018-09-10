package com.almundo.prueba;

import com.almundo.dispatch.Dispatcher;
import com.almundo.dispatch.IncomingCall;
import com.almundo.employee.Employee;
import com.almundo.employee.TypeEmployee;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Clase main de la aplicacion
 * @author LuisEdo
 *
 */
public class PruebaApplication {
	
	/** Manejador de logs */
    private static final Logger LOGGER = LoggerFactory.getLogger(PruebaApplication.class);
    /** Parametro que indica la cantidad de Operadores que se van a crear */
    private static int cantidadEmpleadosOperadores = 4;
    /** Parametro que indica la cantidad de Operadores que se van a crear */
    private static int cantidadEmpleadosSupervisores = 4;
    /** Parametro que indica la cantidad de Supervisores que se van a crear */
    private static int cantidadEmpleadosDirectores = 4;
    /** Parametro que indica la cantidad de llamadas que se van a crear */
    private static int cantidadDeLlamadas = 30;


    /**
     * Metodo main que inicia la app
     * @param args
     */
    public static void main(String[] args) {
        if (PruebaApplication.iniciarAplicacion()) {
            LOGGER.info("Finaliza el proceso de ingreso de las llamadas ...");
        }
    }

    /**
     * Metodo que se encarga de inicializar los empleados y el proceso de llamadas.
     * Se tiene una variable que nos indica cuantas llamadas se van a ejecutar, y de acuerdo a esto se crea esa cantidad
     * de llamadas para que sean atendidas
     * @return booleano que indica que todas las llamadas fueron agregadas para ser atendidas
     */
    public static boolean iniciarAplicacion() {
        LOGGER.info("Inicia Aplicacion ...");
        Dispatcher dispatcher = new Dispatcher(getListEmployees());
        LOGGER.info("Inicial el proceso de Ingreso de las llamadas ...");
        for (int i = 1; i <= cantidadDeLlamadas; ++i) {
            dispatcher.dispatchCall(new IncomingCall("Llamada " + i, false));
        }
        return true;
    }

    /**
     * Metodo que crea la lista de empleados con los cuales se van a atender las llamadas
     * @return lista de empleados
     */
    public static List<Employee> getListEmployees() {
        ArrayList<Employee> listEmployees = new ArrayList<Employee>();
        addEmpleados(listEmployees, (TypeEmployee)TypeEmployee.OPERATOR, (int)cantidadEmpleadosOperadores);
        addEmpleados(listEmployees, (TypeEmployee)TypeEmployee.SUPERVISOR, (int)cantidadEmpleadosSupervisores);
        addEmpleados(listEmployees, (TypeEmployee)TypeEmployee.DIRECTOR, (int)cantidadEmpleadosDirectores);
        return listEmployees;
    }

    /**
     * Metodo que agrega a la lista de empleados , una nueva cantidad de emppleados de acuerdo al tipo de 
     * empleados recibido como parametro
     * @param listEmployees lista de empleados
     * @param tipoEmpleado tipo de empleado
     * @param cantidadEmpleados cantidad de empleados a crear del tipo indicado
     */
    private static void addEmpleados(List<Employee> listEmployees, TypeEmployee tipoEmpleado, int cantidadEmpleados) {
        for (int i = 1; i <= cantidadEmpleados; ++i) {
            listEmployees.add(new Employee(tipoEmpleado.getDescription() + i, true, tipoEmpleado.getCode()));
        }
    }

    /**
     * Metodo que permite modificar el parametro de cantidad de llamadas para poder realizar las pruebas
     * @param cantidadLlamadas
     */
    public static void setCantidadDellamadas(int cantidadLlamadas) {
        cantidadDeLlamadas = cantidadLlamadas;
    }

    /**
     * Metodo que permite modificar el parametro de cantidad de Operadores para poder realizar las pruebas
     * @param cantidadOperadores
     */
    public static void setCantidadEmpleadosOperadores(int cantidadOperadores) {
        cantidadEmpleadosOperadores = cantidadOperadores;
    }

    /**
     * Metodo que permite modificar el parametro de cantidad de supervisores para poder realziar las pruebas
     * @param cantidadSupervisores
     */
    public static void setCantidadEmpleadosSupervisores(int cantidadSupervisores) {
        cantidadEmpleadosSupervisores = cantidadSupervisores;
    }

    /**
     * Metodo que permite modificar el parametro de cantidad de directores para poder realziar las pruebas
     * @param cantidadDirectores
     */
    public static void setCantidadEmpleadosDirectores(int cantidadDirectores) {
        cantidadEmpleadosDirectores = cantidadDirectores;
    }
}

