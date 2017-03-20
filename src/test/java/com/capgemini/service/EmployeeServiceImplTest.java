package com.capgemini.service;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.domain.Contact;
import com.capgemini.domain.DepartmentEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.exceptions.EmployeeNotFoundException;
import com.capgemini.exceptions.InvalidInputException;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class EmployeeServiceImplTest {

	@Autowired
	EmployeeService employeeService;

	@Test
	public void shouldAddEmployee() throws EmployeeNotFoundException, InvalidInputException {
		// given
		EmployeeEntity testEmployee = new EmployeeEntity();
		Contact contact = new Contact();
		contact.setEmail("mail@mailcom");
		contact.setPhoneHome(67666578);
		contact.setPhoneMobile(767776767);
		testEmployee.setPesel("145678907");
		testEmployee.setName("andrzej");
		testEmployee.setSurname("dupa");
		testEmployee.setDepartmentEntity(null);
		testEmployee.setBirthDate(null);
		testEmployee.setContact(contact);

		// when
		employeeService.addEmployee(testEmployee);

		// then
		assertEquals("andrzej", testEmployee.getName());

	}

	@Test
	public void shouldNotAddEmployeeWithInvalidInput() {
		// given
		// when
		// then
	}

	@Test
	public void shouldDeleteEmployee() throws EmployeeNotFoundException, InvalidInputException {
		// given
		int idEmployee = 2;
		// when
		employeeService.deleteEmployee(idEmployee);
		// then
		assertEquals(1, employeeService.findAllEmployee().size());
	}

	@Test(expected = EmployeeNotFoundException.class)
	public void shouldNotDeleteEmployeeWithInvalidId() throws EmployeeNotFoundException, InvalidInputException {
		// given
		int idEmployee = 999;
		// when
		employeeService.deleteEmployee(idEmployee);
	}

	@Test
	public void shouldNotDeleteEmployeeIfIsManager() {
		// given
		// when
		// then
	}

	// @Test
	// public void shouldDeleteAllProjectsAssignedToEmployee() {
	// // given
	// // when
	// // then
	// }

	@Test
	public void shouldUpdateEmployee() {
		// given
		EmployeeEntity testEmployee = new EmployeeEntity();
		int idEmployee = 1;
		testEmployee.setIdEmployee(idEmployee);
		Contact contact = new Contact();
		contact.setEmail("newmail@mailcom");
		contact.setPhoneHome(717897654);
		contact.setPhoneMobile(777888999);
		testEmployee.setPesel("87102366543");
		testEmployee.setName(employeeService.findEmployeeById(idEmployee).getName());
		testEmployee.setSurname(employeeService.findEmployeeById(idEmployee).getSurname());
		testEmployee.setDepartmentEntity(employeeService.findEmployeeById(idEmployee).getDepartmentEntity());
		testEmployee.setBirthDate(employeeService.findEmployeeById(idEmployee).getBirthDate());
		testEmployee.setContact(contact);

		// when
		employeeService.updateEmployee(testEmployee);

		// then
		assertEquals("newmail@mailcom", testEmployee.getContact().getEmail());
	}

	@Test
	public void shouldAssignEmployeeToDepartment() throws EmployeeNotFoundException {
		// given
		int idEmployee = 1;
		int idDepartment = 1;
		EmployeeEntity testEmployee = new EmployeeEntity();
		DepartmentEntity department = new DepartmentEntity();
		department.setIdDepartment(idDepartment);
		testEmployee.setIdEmployee(idEmployee);
		testEmployee.setDepartmentEntity(department);
		// when
		employeeService.assignEmployeeToDepartment(idEmployee, department);
		// then
		assertEquals(1, employeeService.findEmployeeById(idEmployee).getDepartmentEntity().getIdDepartment());
	}

	@Test(expected = EmployeeNotFoundException.class)
	public void shouldNotAssignEmployeeToDepartmentIfInvalidId() throws EmployeeNotFoundException {
		// given
		int employeeId = 999;
		int idDepartment = 1;
		EmployeeEntity testEmployee = new EmployeeEntity();
		DepartmentEntity department = new DepartmentEntity();
		department.setIdDepartment(idDepartment);
		testEmployee.setIdEmployee(employeeId);
		testEmployee.setDepartmentEntity(department);

		// then
		employeeService.assignEmployeeToDepartment(employeeId, department);
		
	}

	@Test
	public void shouldFindEmployeeByName() throws EmployeeNotFoundException {
		// given
		String name = "Andrzej";
		// when
		List<EmployeeEntity> resultList = employeeService.findEmployeeByName(name);
		// then
		assertEquals(name, resultList.get(0).getName());
	}

	@Test
	public void shouldFindEmployeeBySurame() throws EmployeeNotFoundException {
		// given
		String surname = "Nowak";
		// when
		List<EmployeeEntity> resultList = employeeService.findEmployeeBySurname(surname);
		// then
		assertEquals(surname, resultList.get(0).getSurname());
	}

	@Test
	public void shouldFindEmployeeByNameAndSurname() throws EmployeeNotFoundException {
		// given
		String name = "Andrzej";
		String surname = "Nowak";
		// when
		List<EmployeeEntity> resultList = employeeService.findByNameAndSurname(name, surname);
		assertEquals(name, resultList.get(0).getName());
		assertEquals(surname, resultList.get(0).getSurname());
	}

	@Test(expected = EmployeeNotFoundException.class)
	public void shouldThrowExceptionForEmployeeWithGivenFirstAndLastNameForInvalidData()
			throws EmployeeNotFoundException {
		// given
		String name = "Gustav";
		String surname = "Kaczka";

		// when
		employeeService.findByNameAndSurname(name, surname);

		// then

	}
}
