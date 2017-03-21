package com.capgemini.service.impl;

import java.time.LocalDate;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.dao.ProjectDao;
import com.capgemini.dao.ProjectEmployeeDao;
import com.capgemini.domain.EmployeeAndProjectEntity;
import com.capgemini.domain.EmployeeEntity;
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
	public void deleteProject(int idProject) {
		List<EmployeeAndProjectEntity> projectList = projectEmployeeDao.findActiveEmployeeByProjectId(idProject);
		if (projectList != null) {
			deleteAllEmployeeAssignments(projectList);
		}
		projectDao.delete(projectDao.findOne(idProject));
	}

	private void deleteAllEmployeeAssignments(List<EmployeeAndProjectEntity> projectList) {
		for (EmployeeAndProjectEntity ep : projectList) {
			ep.setProjectEntity(null);
		}

	}

	@Override
	public ProjectEntity updateProject(ProjectEntity project) {
		return projectDao.update(project);
	}

	// @Override
	public EmployeeAndProjectEntity addEmployeeToProject(EmployeeEntity employeeEntity, ProjectEntity projectEntity,
			int idEmployee, LocalDate dateFrom, JobPositionEntity jobPositionEntity, double salary) {
		EmployeeAndProjectEntity employeeAndProjectEntity = new EmployeeAndProjectEntity();
		employeeAndProjectEntity.setEmployeeEntity(employeeEntity);
		employeeAndProjectEntity.setProjectEntity(projectEntity);
		employeeAndProjectEntity.setDateFrom(dateFrom);
		employeeAndProjectEntity.setJobPositionEntity(jobPositionEntity);
		employeeAndProjectEntity.setSalary(salary);
		return projectEmployeeDao.save(employeeAndProjectEntity);

	}


	@Override
	public void removeEmployeeFromProject(int idProject, int idEmployee, LocalDate dateTo)
			throws InvalidInputException {
		EmployeeAndProjectEntity emloyeeAndProjectEntity = projectEmployeeDao
				.findActiveEmployeeByProjectIdAndEmployeeId(idProject, idEmployee);
		if (emloyeeAndProjectEntity == null) {
			throw new InvalidInputException("There is no assigment of employee to any project!");
		}
		if (dateTo.compareTo(emloyeeAndProjectEntity.getDateFrom()) < 0) {
			throw new InvalidInputException(
					"Date when employee finished project can not be earlier than date when employee started!");
		} else {
			emloyeeAndProjectEntity.setDateTo(dateTo);
		}

	}

	@Override
	public List<EmployeeAndProjectEntity> findEmployeeWorkingLongerThan(int numberOfMonths) {
		return projectEmployeeDao.findEmployeeWorkingLongerThan(numberOfMonths);
	}

	@Override
	public List<EmployeeAndProjectEntity> findActiveEmployeeByProjectId(int idProject) {
		return projectEmployeeDao.findActiveEmployeeByProjectId(idProject);
	}

	@Override
	public List<ProjectEntity> findAllProjects() {
		return projectDao.findAll();
	}

	@Override
	public ProjectEntity findProjectById(int testId) {
		return projectDao.findOne(testId);
	}

	@Override
	public List<EmployeeAndProjectEntity> findProjectsAssignedToEmployee(int idEmployee) {
		return projectEmployeeDao.findProjectByEmployeeId(idEmployee);
	}

	@Override
	public ProjectEntity findProjectByName(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectEntity getOneProject(int idProject) {
		return projectDao.findOne(idProject);
	}

	@Override
	public EmployeeAndProjectEntity findActiveEmployeeByProjectIdAndEmployeeId(int idProject, int idEmployee) {
		return projectEmployeeDao.findActiveEmployeeByProjectIdAndEmployeeId(idProject, idEmployee);
	}

}
