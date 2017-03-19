package com.capgemini.service.impl;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.ProjectDao;
import com.capgemini.dao.ProjectEmployeeDao;
import com.capgemini.domain.EmployeeAndProjectEntity;
import com.capgemini.domain.JobPositionEntity;
import com.capgemini.domain.ProjectEntity;
import com.capgemini.exceptions.InvalidInputException;
import com.capgemini.service.ProjectService;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectDao projectDao;
	
	@Autowired
	ProjectEmployeeDao projectEmployeeDao;

	@Override
	public void addProject(ProjectEntity project) throws InvalidInputException {
		projectDao.save(project);

	}

	@Override
	public void deleteProject(int idProject) throws InvalidInputException {
		List<ProjectEntity> projectList = projectDao.findProjectById(idProject);
		if (projectList != null) {
			throw new InvalidInputException();
		}
		projectDao.delete(projectDao.findOne(idProject));
	}

	@Override
	public ProjectEntity updateProject(ProjectEntity project) {
		return projectDao.update(project);
	}

	@Override
	public EmployeeAndProjectEntity addEmployeeToProject(EmployeeAndProjectEntity employeeAndProject, int idEmployee, LocalDate dateFrom,
			JobPositionEntity jobPositionEntity, double salary) {
		EmployeeAndProjectEntity emplAndProjEntity = new EmployeeAndProjectEntity();
		emplAndProjEntity.setIdProjectEmployee(idEmployee);
		emplAndProjEntity.setDateFrom(dateFrom);
		emplAndProjEntity.setJobPositionEntity(jobPositionEntity);
		emplAndProjEntity.setSalary(salary);
		return projectEmployeeDao.save(emplAndProjEntity);

	}

	@Override
	public void removeEmployeeFromProject(int idProject, int idEmployee, LocalDate dateTo) throws InvalidInputException {
		EmployeeAndProjectEntity emloyeeAndProjectEntity = projectEmployeeDao.findActiveEmployeeByProjectIdAndEmployeeId(idProject, idEmployee);
		if (emloyeeAndProjectEntity == null) {
			throw new InvalidInputException();
		}
		if (dateTo.compareTo(emloyeeAndProjectEntity.getDateTo()) < 0) {
			throw new InvalidInputException();
		}
		emloyeeAndProjectEntity.setDateTo(dateTo);
		
		
	}

}
