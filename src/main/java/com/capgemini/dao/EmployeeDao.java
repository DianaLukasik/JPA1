package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.EmployeeEntity;

public interface EmployeeDao extends Dao<EmployeeEntity, Integer>{

	public List<EmployeeEntity> findByNameAndSurname(String name, String surname);

	public List<EmployeeEntity> findByName(String name);

	public List<EmployeeEntity> findBySurname(String surname);
	
	public List<EmployeeEntity> findByDepartmentId (int idDepartment);

}
