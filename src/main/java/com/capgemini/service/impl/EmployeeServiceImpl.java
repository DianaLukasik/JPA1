package com.capgemini.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.DepartmentEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.exceptions.EmployeeNotFoundException;
import com.capgemini.exceptions.InvalidInputException;
import com.capgemini.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void addEmployee(EmployeeEntity employee) throws InvalidInputException {
		EmployeeEntity employeeEntity = employeeDao.save(employee);
		if (employeeEntity == null) {
			throw new InvalidInputException();
		}
		
	}

	@Override
	public void deleteEmployee(EmployeeEntity employee) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmployeeEntity updateEmployee(EmployeeEntity employee) {
		return employeeDao.update(employee);
	}

	@Override
	public EmployeeEntity assignEmployeeToDepartment(int idEmployee, DepartmentEntity department)
			throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeEntity> findEmployeeByName(String name) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeEntity> findEmployeeBySurname(String surname) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeEntity> findByNameAndSurname(String name, String surname) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeEntity> findByDepartmentId(int idDepartment) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


}
