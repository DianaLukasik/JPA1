package com.capgemini.service;

import java.util.List;

import com.capgemini.domain.DepartmentEntity;
import com.capgemini.domain.EmployeeAndProjectEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.exceptions.EmployeeNotFoundException;
import com.capgemini.exceptions.InvalidInputException;

public interface EmployeeService {

	void addEmployee(EmployeeEntity employee) throws InvalidInputException;

	void deleteEmployee(int idEmployee) throws EmployeeNotFoundException, InvalidInputException;

	EmployeeEntity updateEmployee(EmployeeEntity employee);

	EmployeeEntity assignEmployeeToDepartment(int idEmployee, DepartmentEntity idDepartment)
			throws EmployeeNotFoundException;

	List<EmployeeEntity> findEmployeeByName(String name) throws EmployeeNotFoundException;

	List<EmployeeEntity> findEmployeeBySurname(String surname) throws EmployeeNotFoundException;

	List<EmployeeEntity> findByNameAndSurname(String name, String surname) throws EmployeeNotFoundException;

	List<EmployeeEntity> findByDepartmentId(int idDepartment) throws EmployeeNotFoundException;

	List<EmployeeEntity> findAllEmployee() throws EmployeeNotFoundException;

	EmployeeEntity findEmployeeById(int id);
}
