package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.BookEntity;
import com.capgemini.domain.EmployeeEntity;

@Repository
public class EmployeeDaoImpl extends AbstractDao<EmployeeEntity, Integer> implements EmployeeDao {

	@Override
	public List<EmployeeEntity> findByNameAndSurname(String name, String surname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeEntity> findByName(String name) {
		TypedQuery<EmployeeEntity> query = entityManager.createQuery("select employee from EmployeeEntity employee where upper(lastName) like concat(upper(:lastName),'%')", EmployeeEntity.class);
		query.setParameter("name", name);
		return query.getResultList();
	}

	
	@Override
	public List<EmployeeEntity> findBySurname(String surname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeEntity> findByDepartmentId(int idDepartment) {
		// TODO Auto-generated method stub
		return null;
	}

}
