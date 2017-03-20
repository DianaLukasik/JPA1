package com.capgemini.service;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.exceptions.InvalidInputException;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class ProjectServiceImplTest {

	@Autowired
	ProjectService projectService;
	
	@Autowired
	EmployeeService employeeService;
	
	
	@Test
	public void shouldAddProject() {
		// given
		// when
		// then
	}

	@Test
	public void shouldUpdateProject() {
		// given
		int idProject=1;
		// when
		// then
	}

	@Test
	public void shouldDeleteProject() throws InvalidInputException {
		// given
		int idProject=1;
		// when
		projectService.deleteProject(idProject);
		// then
		assertEquals(3, projectService.findAllProjects().size());
	}

	@Test
	public void shouldAddEmployeeToProject() {
		// given
		// when
		// then
	}

	@Test
	public void shouldRemoveEmployeefromProject() {
		// given
		// when
		// then
	}

	@Test
	public void shouldNotRemoveEmployeefromProjectIfEndDateIsEarlierThanStartDate() {
		// given
		// when
		// then
	}

	@Test
	public void shouldNotRemoveEmployeefromProjectIfProjectIdIsInvalid() {
		// given
		// when
		// then
	}

	@Test
	public void shouldNotRemoveEmployeefromProjectIfEmployeeIdIsInvalid() {
		// given
		// when
		// then
	}

	@Test
	public void shouldFindEmployeesWorkingLongerThanXMonths() {
		// given
		// when
		// then
	}

	@Test
	public void shouldFindActiveEmployeeByProjectId() {
		// given
		// when
		// then
	}

	@Test
	public void shouldDeleteAllProjectsAssignedToEmployee() {
		// given
		// when
		// then
	}



}