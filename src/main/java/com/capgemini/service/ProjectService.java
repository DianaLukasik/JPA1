package com.capgemini.service;

import java.time.LocalDate;
import com.capgemini.domain.EmployeeAndProjectEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.JobPositionEntity;
import com.capgemini.domain.ProjectEntity;
import com.capgemini.exceptions.InvalidInputException;


public interface ProjectService {

	void addProject (ProjectEntity project) throws InvalidInputException;
	
	void deleteProject (int idProject) throws InvalidInputException;
	
	ProjectEntity updateProject (ProjectEntity project);
	
	EmployeeAndProjectEntity addEmployeeToProject (EmployeeAndProjectEntity employeeAndProject, int idEmployee, LocalDate dateFrom,
			JobPositionEntity jobPositionEntity, double salary);
	
	void removeEmployeeFromProject (int idproject, int idEmployee, LocalDate dateTo) throws InvalidInputException;
	
	
}
