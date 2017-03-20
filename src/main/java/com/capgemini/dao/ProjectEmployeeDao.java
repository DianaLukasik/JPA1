package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.EmployeeAndProjectEntity;

public interface ProjectEmployeeDao extends Dao<EmployeeAndProjectEntity, Integer> {

	List<EmployeeAndProjectEntity> findActiveEmployeeByProjectId(int idProject);

	EmployeeAndProjectEntity findActiveEmployeeByProjectIdAndEmployeeId(int idProject, int idEmployee);

	List<EmployeeAndProjectEntity> findProjectByEmployeeId(int idEmployee);

	List<EmployeeAndProjectEntity> findEmployeeWorkingLongerThan (int
	 numberOfMonths);
}
