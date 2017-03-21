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

import com.capgemini.domain.EmployeeAndProjectEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.ProjectEntity;
import com.capgemini.domain.ProjectTypeEntity;
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
	public void shouldAddProject() throws InvalidInputException {
		// given
		ProjectEntity testProject = new ProjectEntity();
		ProjectTypeEntity projectTypeEntity = new ProjectTypeEntity();
		projectTypeEntity.setIdProjectType(1);
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setIdEmployee(1);

		testProject.setProjectName("Projekt testowy");
		testProject.setProjectTypeEntity(projectTypeEntity);
		testProject.setEmployeeEntity(employeeEntity);
		// when
		projectService.addProject(testProject);
		// then
		assertEquals(6, projectService.findAllProjects().size()); // DODAC W
																	// INSETRACH
																	// 5
																	// PROJEKTOW
	}

	@Test
	public void shouldUpdateProject() {
		// given
		ProjectEntity testProject = new ProjectEntity();
		int testId = testProject.getIdProject();

		// when
		testProject.setProjectName("Zmieniona nazwa");

		// then
		assertEquals("Zmieniona nazwa", projectService.findProjectById(testId));
	}

	@Test
	public void shouldDeleteProject() throws InvalidInputException {
		// given
		int idProject = 1;
		// when
		projectService.deleteProject(idProject);
		// then
		assertEquals(3, projectService.findAllProjects().size());
	}

	@Test
	public void shouldAddEmployeeToProject() {
		// given
		
		int idEmployee =1;
		int idProject=1;
		double testSalary=100;
		EmployeeEntity testEmployee = employeeService.findEmployeeById(idEmployee);
		ProjectEntity testProject = projectService.findProjectById(idProject);
	LocalDate dateFrom = LocalDate.of(2017, 01, 30);
		
		// when
		EmployeeAndProjectEntity testEmpProj = projectService.addEmployeeToProject(testProject, idEmployee, dateFrom, null, testSalary);
		
		// then
		assertEquals(testEmployee,testEmpProj.getEmployeeEntity());
	}

	@Test
	public void shouldRemoveEmployeefromProject() throws InvalidInputException {
		// given
		int idEmployee = 1;
		int idProject = 1;
		LocalDate dateTo = LocalDate.of(2017, 02, 30);
		// when
		projectService.removeEmployeeFromProject(idProject, idEmployee, dateTo);
		// then
		assertEquals(dateTo,projectService.findProjectsAssignedToEmployee(idEmployee).get(0).getDateTo());
	}

	@Test(expected = InvalidInputException.class)
	public void shouldNotRemoveEmployeefromProjectIfEndDateIsEarlierThanStartDate() throws InvalidInputException {
		// given
		int idEmployee = 1;
		int idProject = 1;
		LocalDate dateTo = LocalDate.of(1999, 02, 30);
		// when
		projectService.removeEmployeeFromProject(idProject, idEmployee, dateTo);
	}

	@Test(expected = InvalidInputException.class)
	public void shouldNotRemoveEmployeefromProjectIfProjectIdIsInvalid() throws InvalidInputException {
		// given
		int idEmployee = 1;
		int idProject = 999;
		LocalDate dateTo = LocalDate.of(1999, 02, 30);
		// when
		projectService.removeEmployeeFromProject(idProject, idEmployee, dateTo);
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