package com.almundo.dispatch;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.almundo.employee.Employee;


/**
 * Clase para manejar la informacion de la llamada entrante
 * @author LuisEdo
 *
 */
public class IncomingCall {
	
	/** Manejador de logs */
    private static final Logger LOGGER = LoggerFactory.getLogger(IncomingCall.class);
    /** ID de la llamada */
    private String uuid;
    /** Descripcion de la llamada */
    private String description;
    /** Indica si la llamada fue atendida o no */
    private boolean attended;
    /** empleado que atendio la llamada */
    private Employee employee;
    /** duracion de la llamada, se genera aleatoriamente */
    private int duration;
    
    /** Constante para el maximo de la duracion de una llamada en segundos */
    private static final int MAX_TIME_CALL = 10;
    /** Constante para el minimo de la duracion de una llamada en segundos */
    private static final int MIN_TIME_CALL = 5;

    /**
     * Constructor
     * @param description
     * @param attended
     */
    public IncomingCall(String description, boolean attended) {
    	this.uuid = UUID.randomUUID().toString();
        this.attended = attended;
        this.description = description;
        this.duration = IncomingCall.getRandomDuration();
        this.employee = null;
    }

    /**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}


	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
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


	/**
	 * @return the attended
	 */
	public boolean isAttended() {
		return attended;
	}


	/**
	 * @param attended the attended to set
	 */
	public void setAttended(boolean attended) {
		this.attended = attended;
	}


	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}


	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
		this.employee.setAvailable(false);
	}


	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}


	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}


	/**
	 * Metodo que genera aleatoriamente un numero dentro del rango de maximo 
	 * y minimo para asignar a la duracion de la llamada
	 * @return Tiempo o duracion de una llamada en segundos
	 */
	private static int getRandomDuration() {
        Random random = new Random();
        return random.nextInt((MAX_TIME_CALL - MIN_TIME_CALL) + 1) + MIN_TIME_CALL;
    }
	

    /**
     * Metodo que se encarga de simular el procesamiento de una llamada, 
     * en este caso solo se pone en espera el proceso durante el tiempo de duracion indicado para cada llamada
     * Al final del proceso se libera o se actualiza a Disponible el estado del empleado para que pueda atender otra llamada. 
     * @throws InterruptedException
     */
    public void callInProcess() throws InterruptedException {
        AtomicLong startTime = new AtomicLong(System.currentTimeMillis());
        LOGGER.info("Se inicia la atencion de la llamada '" + this.description + "'");
        TimeUnit.SECONDS.sleep(this.duration);
        AtomicLong totalTime = new AtomicLong(System.currentTimeMillis() - startTime.get());
        this.employee.setAvailable(true);
        LOGGER.info("Se finaliza la atencion de la llamada '" + this.description + "', el tiempo fue de -> " + totalTime.get() / 1000L + "seg");
    }

    @Override
    public String toString() {
        return "Description = " + this.description + ", Uuid = " + this.uuid + ", attended = " + this.attended + ", Duration = " + this.duration;
    }

}

