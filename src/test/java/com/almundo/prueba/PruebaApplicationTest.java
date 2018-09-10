/**
 * 
 */
package com.almundo.prueba;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.almundo.employee.Employee;

/**
 * Test {@link PruebaApplication}
 * @author LuisEdo
 *
 */
public class PruebaApplicationTest {
	
	@Test
	public void test_IniciarAplicacion_Con_10_llamadas() {
		PruebaApplication.setCantidadDellamadas(10);
		boolean llamadasAtendidas = PruebaApplication.iniciarAplicacion();
		assertEquals(true, llamadasAtendidas);
	}

	@Test
	public void test_IniciarAplicacion_Con_30_llamadas() {
		PruebaApplication.setCantidadDellamadas(30);
		boolean llamadasAtendidas = PruebaApplication.iniciarAplicacion();
		assertEquals(true, llamadasAtendidas);
	}

	@Test
	public void test_IniciarAplicacion_Con_100_llamadas() {
		PruebaApplication.setCantidadDellamadas(100);
		boolean llamadasAtendidas = PruebaApplication.iniciarAplicacion();
		assertEquals(true, llamadasAtendidas);
	}

	
	@Test
	public void test_GetListEmployees_6_Creados() {
		PruebaApplication.setCantidadEmpleadosOperadores(3);
		PruebaApplication.setCantidadEmpleadosSupervisores(2);
		PruebaApplication.setCantidadEmpleadosDirectores(1);
		List<Employee> listEmployees = PruebaApplication.getListEmployees();
		assertNotNull(listEmployees);
		assertEquals(6, listEmployees.size());
	}
	
	@Test
	public void test_GetListEmployees_7_Creados() {
		PruebaApplication.setCantidadEmpleadosOperadores(5);
		PruebaApplication.setCantidadEmpleadosSupervisores(2);
		PruebaApplication.setCantidadEmpleadosDirectores(0);
		List<Employee> listEmployees = PruebaApplication.getListEmployees();
		assertNotNull(listEmployees);
		assertEquals(7, listEmployees.size());
	}
	
	@Test
	public void test_GetListEmployees_Ninguno_Creado() {
		PruebaApplication.setCantidadEmpleadosOperadores(0);
		PruebaApplication.setCantidadEmpleadosSupervisores(0);
		PruebaApplication.setCantidadEmpleadosDirectores(0);
		List<Employee> listEmployees = PruebaApplication.getListEmployees();
		assertNotNull(listEmployees);
		assertEquals(0, listEmployees.size());
	}

}
