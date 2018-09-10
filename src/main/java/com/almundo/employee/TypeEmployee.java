package com.almundo.employee;

/**
 * Enum para el manejo de los tipos de empleados
 * @author LuisEdo
 */

public enum TypeEmployee {
    OPERATOR(1, "Operator"),
    SUPERVISOR(2, "Supervisor"),
    DIRECTOR(3, "Director");
    
    /** Codigo del tipo de empleado */
    private int code;
    
    /** Descripcion del tipo de empleado */
    private String description;

    /**
     * Constructor
     * @param code
     * @param description
     */
    private TypeEmployee(int code, String description) {
        this.code = code;
        this.description = description;
    }

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}

