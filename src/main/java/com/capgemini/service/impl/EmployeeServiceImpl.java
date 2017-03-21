package com.capgemini.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
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
			throw new InvalidInputException(""); //DODAC MESSAGE
		}

	}
	
	
	
	
	
	

	@Override
	public void deleteEmployee(int idEmployee) throws EmployeeNotFoundException, InvalidInputException {
		validateIfIsManager(idEmployee);
		deleteAllProjectsAssignedToEmployee(idEmployee);
		try {
			employeeDao.delete(idEmployee);
		} catch (JpaObjectRetrievalFailureException e) {
			throw new EmployeeNotFoundException("Employee with given ID do not exist!"); 
		}
	}

	private void validateIfIsManager(int idEmployee) throws InvalidInputException{
		List<ProjectEntity> listOfAssignedprojects=projectDao.findProjectByManagerId(idEmployee);
		if (listOfAssignedprojects!= null) {
			throw new InvalidInputException("Employee is a menager in some project, you should update project before delete");
	}
	}

	private void deleteAllProjectsAssignedToEmployee(int idEmployee){
		List<EmployeeAndProjectEntity> listOfAssignedprojects=projectEmployeeDao.findProjectByEmployeeId(idEmployee);
		for (EmployeeAndProjectEntity ap : listOfAssignedprojects) {
			ap.setEmployeeEntity(null);
	//		ap.setProjectEntity(null);
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
			throw new EmployeeNotFoundException("Employee with given ID do not exist!");
		}

		return employeeDao.update(employeeEntity);
	}

	@Override
	public List<EmployeeEntity> findEmployeeByName(String name) throws EmployeeNotFoundException {
		List<EmployeeEntity> searchList = employeeDao.findByName(name);
		if (searchList == null) {
			throw new EmployeeNotFoundException("Employee with given surname do not exist!");
		} else {
			return searchList;
		}
	}

	@Override
	public List<EmployeeEntity> findEmployeeBySurname(String surname) throws EmployeeNotFoundException {
		List<EmployeeEntity> searchList = employeeDao.findBySurname(surname);
		if (searchList == null) {
			throw new EmployeeNotFoundException("There is no employee on the list!");
		} else {
			return searchList;
		}
	}

	@Override
	public List<EmployeeEntity> findByNameAndSurname(String name, String surname) throws EmployeeNotFoundException {
		List<EmployeeEntity> searchList = employeeDao.findByNameAndSurname(name, surname);
		if (searchList.isEmpty()) {
			throw new EmployeeNotFoundException("Employee with given name and surname do not exist!");
		} else {

			return searchList;
		}
	}

	@Override
	public List<EmployeeEntity> findByDepartmentId(int idDepartment) throws EmployeeNotFoundException {
		List<EmployeeEntity> searchList = employeeDao.findByDepartmentId(idDepartment);
		if (searchList == null) {
			throw new EmployeeNotFoundException("Department with given ID do not exist!");
		} else {
			return searchList;
		}
	}
	
	@Override
	public List<EmployeeEntity> findAllEmployee() throws EmployeeNotFoundException {
		List<EmployeeEntity> searchList = employeeDao.findAll();
		if (searchList == null) {
			throw new EmployeeNotFoundException("There is no employee on the list!");
		} else {
			return searchList;
		}
	}







	@Override
	public EmployeeEntity findEmployeeById(int idEmployee) {
		return employeeDao.findOne(idEmployee);
	}

}
