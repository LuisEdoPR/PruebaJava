package com.almundo.employee;

import java.util.List;
import java.util.UUID;


/**
 * Clase para manejar la informacion de los empleados
 * @author LuisEdo
 *
 */
public class Employee {
	
	/** ID del empleado generado aleatoriamente */
    private String uuid;
    /** Nombre del empleado */
    private String name;
    /** Boolean que indica si el empleado esta disponible para atender una llamada */
    private boolean available;
    /** Tipo del empleado */
    private int typeEmployee;
    
    /** Constante para indicar que el empleado esta Disponible */
    public static final boolean AVAILABLE = true;
    /** Constante para indicar que el empleado esta No Disponible u Ocupado */
    public static final boolean BUSY = false;

    /**
     * Constructor
     * @param name
     * @param available
     * @param typeEmployee
     */
    public Employee(String name, boolean available, int typeEmployee) {
        this.uuid = UUID.randomUUID().toString();
    	this.name = name;
        this.available = available;
        this.typeEmployee = typeEmployee;
    }

    /**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the available
	 */
	public boolean isAvailable() {
		return available;
	}


	/**
	 * @param available the available to set
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}


	/**
	 * @return the typeEmployee
	 */
	public int getTypeEmployee() {
		return typeEmployee;
	}


	/**
	 * @param typeEmployee the typeEmployee to set
	 */
	public void setTypeEmployee(int typeEmployee) {
		this.typeEmployee = typeEmployee;
	}


	/**
	 * Metodo que retorne el empleado disponible de acuerdo a la prioridad de busqueda, 
	 * en donde se buscar Primero los de tipo Operador, luego se busca los Supervisores,
	 * y por ultimo se buscan los Directores. En caso que no existan empleados disponibles,
	 * se retorne null
	 * @param listEmployees lista de empleados
	 * @return Employee disponible para atender llamada
	 */
	public static Employee getEmployeeAvailable(List<Employee> listEmployees) {
        Employee employee = Employee.getEmployeeAvailableByType(listEmployees, (int)TypeEmployee.OPERATOR.getCode());
        if (employee == null) {
            employee = Employee.getEmployeeAvailableByType(listEmployees, (int)TypeEmployee.SUPERVISOR.getCode());
        }
        if (employee == null) {
            employee = Employee.getEmployeeAvailableByType(listEmployees, (int)TypeEmployee.DIRECTOR.getCode());
        }
        return employee;
    }

    /**
     * Metodo que busca en una lista de empleados el primero empleado disponible de acuerdo a un tipo de empleado
     * definido, en caso de no encontrar se retorna null
     * @param listEmployees lista de empleados
     * @param typeEmployee tipo del empleado a filtrar
     * @return Employee
     */
    private static Employee getEmployeeAvailableByType(List<Employee> listEmployees, int typeEmployee) {
        return listEmployees.stream().filter(emp -> emp.getTypeEmployee() == typeEmployee && emp.isAvailable()).findFirst().orElse(null);
    }
}

