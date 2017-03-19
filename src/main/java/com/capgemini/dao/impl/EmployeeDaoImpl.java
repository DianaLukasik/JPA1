package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.BookEntity;
import com.capgemini.domain.EmployeeAndProjectEntity;
import com.capgemini.domain.EmployeeEntity;

@Repository
public class EmployeeDaoImpl extends AbstractDao<EmployeeEntity, Integer> implements EmployeeDao {

	@Override
	public List<EmployeeEntity> findByNameAndSurname(String name, String surname) {
		TypedQuery<EmployeeEntity> query = entityManager.createQuery(
				"SELECT employee FROM EmployeeEntity employee WHERE UPPER(name) LIKE CONCAT(UPPER(:name), '%') AND UPPER(surname) LIKE CONCAT(UPPER(:surname), '%')",
				EmployeeEntity.class);
		query.setParameter("name", name).setParameter("surname", surname);
		return query.getResultList();
	} 

	@Override
	public List<EmployeeEntity> findByName(String name) {
		TypedQuery<EmployeeEntity> query = entityManager.createQuery("select employee from EmployeeEntity employee where upper(name) like concat(upper(:name),'%')", EmployeeEntity.class);
		query.setParameter("name", name);
		return query.getResultList();
	}

	
	@Override
	public List<EmployeeEntity> findBySurname(String surname) {
		TypedQuery<EmployeeEntity> query = entityManager.createQuery("select employee from EmployeeEntity employee where upper(surname) like concat(upper(:surname),'%')", EmployeeEntity.class);
		query.setParameter("surname", surname);
		return query.getResultList();
	}

	@Override
	public List<EmployeeEntity> findByDepartmentId(int idDepartment) {
		TypedQuery<EmployeeEntity> query = entityManager.createQuery("select employee from EmployeeEntity employee where employee.employeeEntity.idDepartment = :idDepertment", EmployeeEntity.class);
		query.setParameter("id_department", idDepartment);
		return query.getResultList();
	}
	
	
	
	
//////////////////////	
	
	public List<EmployeeEntity> findActiveEmployeeByProjectId(int idProject) {
		TypedQuery<EmployeeEntity> query = entityManager.createQuery("select employee from EmployeeEntity e  JOIN e.idEmployee ep where (ep.end_date is null and ep.idProject=:idProject)", EmployeeEntity.class);
		query.setParameter("idProject", idProject);
		return query.getResultList();
	}
	

	public List<EmployeeAndProjectEntity> findEmployeeWorkingLongerThan(int numberOfMonths) {
		TypedQuery<EmployeeAndProjectEntity> query = entityManager.createQuery("select  ",EmployeeAndProjectEntity.class);
			query.setParameter("numberOfMonths", numberOfMonths);
		return null;
	}
}
