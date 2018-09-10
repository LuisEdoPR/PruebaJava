/**
 * 
 */
package com.almundo.employee;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Test {@link Employee}
 * @author LuisEdo
 *
 */
public class EmployeeTest {

	@Test
	public void testCreateEmpleado() {
		Employee employee = getEmployeeTest(TypeEmployee.OPERATOR, Employee.AVAILABLE);
		assertNotNull(employee);
		assertEquals(TypeEmployee.OPERATOR.getCode(), employee.getTypeEmployee());
	}
	
	@Test
	public void testGetEmployeeAvailable_OnlyOperatorAvailable() {
		List<Employee> listEmployees = new ArrayList<Employee>();
		listEmployees.add( getEmployeeTest(TypeEmployee.OPERATOR, Employee.AVAILABLE) );
		Employee employee = Employee.getEmployeeAvailable(listEmployees);
		assertNotNull(employee);
		assertEquals(TypeEmployee.OPERATOR.getCode(), employee.getTypeEmployee());
	}
	
	@Test
	public void testGetEmployeeAvailable_OnlySupervisorAvailable() {
		List<Employee> listEmployees = new ArrayList<Employee>();
		listEmployees.add( getEmployeeTest(TypeEmployee.SUPERVISOR, Employee.AVAILABLE) );
		Employee employee = Employee.getEmployeeAvailable(listEmployees);
		assertNotNull(employee);
		assertEquals(TypeEmployee.SUPERVISOR.getCode(), employee.getTypeEmployee());
	}
	
	@Test
	public void testGetEmployeeAvailable_OnlyDirectorAvailable() {
		List<Employee> listEmployees = new ArrayList<Employee>();
		listEmployees.add( getEmployeeTest(TypeEmployee.DIRECTOR, Employee.AVAILABLE) );
		Employee employee = Employee.getEmployeeAvailable(listEmployees);
		assertNotNull(employee);
		assertEquals(TypeEmployee.DIRECTOR.getCode(), employee.getTypeEmployee());
	}
	
	@Test
	public void testGetEmployeeAvailable_AllTypesCreatedAvailable() {
		List<Employee> listEmployees = new ArrayList<Employee>();
		listEmployees.add( getEmployeeTest(TypeEmployee.OPERATOR, Employee.AVAILABLE) );
		listEmployees.add( getEmployeeTest(TypeEmployee.SUPERVISOR, Employee.AVAILABLE) );
		listEmployees.add( getEmployeeTest(TypeEmployee.DIRECTOR, Employee.AVAILABLE) );
		Employee employee = Employee.getEmployeeAvailable(listEmployees);
		assertNotNull(employee);
		assertEquals(TypeEmployee.OPERATOR.getCode(), employee.getTypeEmployee());
	}
	
	@Test
	public void testGetEmployeeAvailable_AllTypesCreatedSupervisorAvailable() {
		List<Employee> listEmployees = new ArrayList<Employee>();
		listEmployees.add( getEmployeeTest(TypeEmployee.OPERATOR, Employee.BUSY) );
		listEmployees.add( getEmployeeTest(TypeEmployee.SUPERVISOR, Employee.AVAILABLE) );
		listEmployees.add( getEmployeeTest(TypeEmployee.DIRECTOR, Employee.AVAILABLE) );
		Employee employee = Employee.getEmployeeAvailable(listEmployees);
		assertNotNull(employee);
		assertEquals(TypeEmployee.SUPERVISOR.getCode(), employee.getTypeEmployee());
	}
	
	@Test
	public void testGetEmployeeAvailable_AllTypesCreatedOnlyOperatorAvailable() {
		List<Employee> listEmployees = new ArrayList<Employee>();
		listEmployees.add( getEmployeeTest(TypeEmployee.OPERATOR, Employee.AVAILABLE) );
		listEmployees.add( getEmployeeTest(TypeEmployee.SUPERVISOR, Employee.BUSY) );
		listEmployees.add( getEmployeeTest(TypeEmployee.DIRECTOR, Employee.BUSY) );
		Employee employee = Employee.getEmployeeAvailable(listEmployees);
		assertNotNull(employee);
		assertEquals(TypeEmployee.OPERATOR.getCode(), employee.getTypeEmployee());
	}
	
	@Test
	public void testGetEmployeeAvailable_AllTypesCreatedOnlySupervisorAvailable() {
		List<Employee> listEmployees = new ArrayList<Employee>();
		listEmployees.add( getEmployeeTest(TypeEmployee.OPERATOR, Employee.BUSY) );
		listEmployees.add( getEmployeeTest(TypeEmployee.SUPERVISOR, Employee.AVAILABLE) );
		listEmployees.add( getEmployeeTest(TypeEmployee.DIRECTOR, Employee.BUSY) );
		Employee employee = Employee.getEmployeeAvailable(listEmployees);
		assertNotNull(employee);
		assertEquals(TypeEmployee.SUPERVISOR.getCode(), employee.getTypeEmployee());
	}
	
	@Test
	public void testGetEmployeeAvailable_AllTypesCreatedOnlyDirectorAvailable() {
		List<Employee> listEmployees = new ArrayList<Employee>();
		listEmployees.add( getEmployeeTest(TypeEmployee.OPERATOR, Employee.BUSY) );
		listEmployees.add( getEmployeeTest(TypeEmployee.SUPERVISOR, Employee.BUSY) );
		listEmployees.add( getEmployeeTest(TypeEmployee.DIRECTOR, Employee.AVAILABLE) );
		Employee employee = Employee.getEmployeeAvailable(listEmployees);
		assertNotNull(employee);
		assertEquals(TypeEmployee.DIRECTOR.getCode(), employee.getTypeEmployee());
	}
	
	@Test
	public void testGetEmployeeAvailable_AllEmployeesBusy_EmployeeNull() {
		List<Employee> listEmployees = new ArrayList<Employee>();
		listEmployees.add( getEmployeeTest(TypeEmployee.OPERATOR, Employee.BUSY) );
		listEmployees.add( getEmployeeTest(TypeEmployee.SUPERVISOR, Employee.BUSY) );
		listEmployees.add( getEmployeeTest(TypeEmployee.DIRECTOR, Employee.BUSY) );
		Employee employee = Employee.getEmployeeAvailable(listEmployees);
		assertNull(employee);
	}
	
	
	private Employee getEmployeeTest (TypeEmployee typeEmployee, boolean isAvailable) {
		return new Employee(typeEmployee.getDescription(), isAvailable, typeEmployee.getCode());
	}

}
