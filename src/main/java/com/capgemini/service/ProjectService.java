package com.capgemini.service;

import java.time.LocalDate;
import java.util.List;
import com.capgemini.domain.EmployeeAndProjectEntity;
import com.capgemini.domain.JobPositionEntity;
import com.capgemini.domain.ProjectEntity;
import com.capgemini.exceptions.InvalidInputException;
import com.capgemini.domain.EmployeeEntity;

public interface ProjectService {

	void addProject(ProjectEntity project) throws InvalidInputException;

	void deleteProject(int idProject) throws InvalidInputException;

	ProjectEntity updateProject(ProjectEntity project);

	EmployeeAndProjectEntity addEmployeeToProject(EmployeeEntity employeeEntity,ProjectEntity projectEntity, int idEmployee, LocalDate dateFrom,
			JobPositionEntity jobPositionEntity, double salary);

	void removeEmployeeFromProject(int idproject, int idEmployee, LocalDate dateTo) throws InvalidInputException;

	List<EmployeeAndProjectEntity> findEmployeeWorkingLongerThan(int numberOfMonths);

	List<EmployeeAndProjectEntity> findActiveEmployeeByProjectId(int idProject);
	
	EmployeeAndProjectEntity findActiveEmployeeByProjectIdAndEmployeeId (int idProject, int idEmployee);
	
	List<ProjectEntity> findAllProjects ();

	ProjectEntity findProjectById(int testId);

	List<EmployeeAndProjectEntity> findProjectsAssignedToEmployee(int idEmployee);

	ProjectEntity findProjectByName(String string);

	ProjectEntity getOneProject(int idProject);
	

}
