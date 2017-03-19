package com.capgemini.service;

import static org.junit.Assert.*;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.domain.Contact;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.exceptions.EmployeeNotFoundException;
import com.capgemini.exceptions.InvalidInputException;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class EmployeeServiceTest {
	
	@Autowired
	EmployeeService employeeService;

	@Test
	public void shouldAddEmployee() throws EmployeeNotFoundException, InvalidInputException {
		// given
		EmployeeEntity testUser = new EmployeeEntity();
//		Contact contact = new Contact();
//		contact.setEmail("mail@mailcom");
//		contact.setPhoneHome(67666578);
//		contact.setPhoneMobile(767776767);
//		testUser.setPesel(145678907);
		testUser.setName("andrzej");
//		testUser.setSurname("dupa");
//		testUser.setDepartmentEntity(null);
//		testUser.setBirthDate(null);
//		testUser.setContact(contact);

		// when
		employeeService.addEmployee(testUser);

		// then
		assertEquals("andrzej", testUser.getName());

	}
}
