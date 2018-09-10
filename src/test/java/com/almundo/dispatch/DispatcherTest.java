/**
 * 
 */
package com.almundo.dispatch;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.almundo.employee.Employee;
import com.almundo.prueba.PruebaApplication;

/**
 * Test {@link Dispatcher}
 * @author LuisEdo
 *
 */
public class DispatcherTest {

	@Test
	public void test_DispatchCall() {
		IncomingCall call = new IncomingCall("Llamada Test", false);
		List<Employee> listEmployees = PruebaApplication.getListEmployees();
		new Dispatcher(listEmployees).dispatchCall(call);
		assertNotNull(call);
		
	}

}
