/**
 * 
 */
package com.almundo.dispatch;

import static org.junit.Assert.*;

import org.junit.Test;

import com.almundo.employee.Employee;

/**
 * Test {@link IncomingCall}
 * @author LuisEdo
 *
 */
public class IncomingCallTest {

	@Test
	public void test_CallInProcess() throws InterruptedException {
		// Se crea un empleado en estado No Disponible "false" para que el metodo callInProcess lo libere
		Employee employee = new Employee("test", Employee.BUSY, 1);
		IncomingCall incomingCall = new IncomingCall("Llamada test", false);
		incomingCall.setEmployee(employee);
		incomingCall.callInProcess();
		assertEquals(true, incomingCall.getEmployee().isAvailable());
	}

}
