package com.capgemini.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.dao.ProjectDao;
import com.capgemini.dao.ProjectEmployeeDao;
import com.capgemini.domain.DepartmentEntity;
import com.capgemini.domain.EmployeeAndProjectEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.ProjectEntity;
import com.capgemini.exceptions.EmployeeNotFoundException;
import com.capgemini.exceptions.InvalidInputException;
import com.capgemini.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private ProjectEmployeeDao projectEmployeeDao;

	@Autowired
	private ProjectDao projectDao;

	
	
	
	@Override
	public void addEmployee(EmployeeEntity employee) throws InvalidInputException {
		EmployeeEntity employeeEntity = employeeDao.save(employee);
		if (employeeEntity == null) {
			throw new InvalidInputException();
		}

	}
	
	
	
	
	
	

	@Override
	public void deleteEmployee(int idEmployee) throws EmployeeNotFoundException, InvalidInputException {
		checkIfIsManager(idEmployee);
		deleteAllProjectsAssignedToEmployee(idEmployee);
		try {
			employeeDao.delete(idEmployee);
		} catch (NullPointerException e) {
			throw new EmployeeNotFoundException(); //message dod
		}
	}

	private void checkIfIsManager(int idEmployee) throws InvalidInputException{
		List<ProjectEntity> listOfAssignedprojects=projectDao.findProjectByManagerId(idEmployee);
		if (listOfAssignedprojects!= null) {
			throw new InvalidInputException(); //exc message dodac
	}
	}

	private void deleteAllProjectsAssignedToEmployee(int idEmployee){
		List<EmployeeAndProjectEntity> listOfAssignedprojects=projectEmployeeDao.findProjectByEmployeeId(idEmployee);
		for (EmployeeAndProjectEntity ap : listOfAssignedprojects) {
			ap.setEmployeeEntity(null);
			ap.setProjectEntity(null);
		}
	}

	
	
	
	
	
	
	
	@Override
	public EmployeeEntity updateEmployee(EmployeeEntity employee) {
		return employeeDao.update(employee);
	}

	@Override
	public EmployeeEntity assignEmployeeToDepartment(int idEmployee, DepartmentEntity department)
			throws EmployeeNotFoundException {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		try {
			employeeEntity = employeeDao.findOne(idEmployee);
			employeeEntity.setDepartmentEntity(department);
		} catch (NullPointerException e) {
			throw new EmployeeNotFoundException();
		}

		return employeeDao.update(employeeEntity);
	}

	@Override
	public List<EmployeeEntity> findEmployeeByName(String name) throws EmployeeNotFoundException {
		List<EmployeeEntity> searchList = employeeDao.findByName(name);
		if (searchList == null) {
			throw new EmployeeNotFoundException();
		} else {
			return searchList;
		}
	}

	@Override
	public List<EmployeeEntity> findEmployeeBySurname(String surname) throws EmployeeNotFoundException {
		List<EmployeeEntity> searchList = employeeDao.findBySurname(surname);
		if (searchList == null) {
			throw new EmployeeNotFoundException();
		} else {
			return searchList;
		}
	}

	@Override
	public List<EmployeeEntity> findByNameAndSurname(String name, String surname) throws EmployeeNotFoundException {
		List<EmployeeEntity> searchList = employeeDao.findByNameAndSurname(name, surname);
		if (searchList == null) {
			throw new EmployeeNotFoundException();
		} else {

			return searchList;
		}
	}

	@Override
	public List<EmployeeEntity> findByDepartmentId(int idDepartment) throws EmployeeNotFoundException {
		List<EmployeeEntity> searchList = employeeDao.findByDepartmentId(idDepartment);
		if (searchList == null) {
			throw new EmployeeNotFoundException();
		} else {
			return searchList;
		}
	}
	
	@Override
	public List<EmployeeEntity> findAllEmployee() throws EmployeeNotFoundException {
		List<EmployeeEntity> searchList = employeeDao.findAll();
		if (searchList == null) {
			throw new EmployeeNotFoundException();
		} else {
			return searchList;
		}
	}







	@Override
	public EmployeeEntity findEmployeeById(int idEmployee) {
		return employeeDao.findOne(idEmployee);
	}

}
