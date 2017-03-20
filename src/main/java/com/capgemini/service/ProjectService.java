package com.capgemini.service;

import java.sql.Date;
import java.util.List;

import com.capgemini.domain.EmployeeAndProjectEntity;

import com.capgemini.domain.JobPositionEntity;
import com.capgemini.domain.ProjectEntity;
import com.capgemini.exceptions.InvalidInputException;

public interface ProjectService {

	void addProject(ProjectEntity project) throws InvalidInputException;

	void deleteProject(int idProject) throws InvalidInputException;

	ProjectEntity updateProject(ProjectEntity project);

	EmployeeAndProjectEntity addEmployeeToProject(ProjectEntity projectEntity, int idEmployee, Date dateFrom,
			JobPositionEntity jobPositionEntity, double salary);

	void removeEmployeeFromProject(int idproject, int idEmployee, Date dateTo) throws InvalidInputException;

	List<EmployeeAndProjectEntity> findEmployeeWorkingLongerThan(int numberOfMonths);

	List<EmployeeAndProjectEntity> findActiveEmployeeByProjectId(int idProject);
	
	List<ProjectEntity> findAllProjects ();

}
