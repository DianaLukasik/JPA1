package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.EmployeeEntity;

public interface ProjectEmployeeDao {

	List<EmployeeEntity> findActiveEmployeeByProjectId (int idProject);
}
