package com.capgemini.dao.impl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.BookEntity;
import com.capgemini.domain.EmployeeAndProjectEntity;
import com.capgemini.domain.EmployeeEntity;

@Repository
public class EmployeeDaoImpl extends AbstractDao<EmployeeEntity, Integer> implements EmployeeDao {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	

	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

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
		TypedQuery<EmployeeEntity> query = entityManager.createQuery("select ep from EmployeeAndprojectEntity ep where ep.employeeEntity.idDepartment = :idDepertment", EmployeeEntity.class);
		query.setParameter("id_department", idDepartment);
		return query.getResultList();
	}
	
	
	
	public List<EmployeeEntity> findActiveEmployeeByProjectId(int idProject) {
		TypedQuery<EmployeeEntity> query = entityManager.createQuery("select  employee from ProjectDataEntity project_data where id_project = :idProject and end_date = null )", EmployeeEntity.class);
		query.setParameter("idProject", idProject);
		return query.getResultList();
	}
	

	public List<EmployeeAndProjectEntity> findEmployeeWorkingLongerThan(int numberOfMonths) {
		TypedQuery<EmployeeAndProjectEntity> query = entityManager.createQuery("select  ",EmployeeAndProjectEntity.class);
			query.setParameter("numberOfMonths", numberOfMonths);
		return null;
	}
	
	////////////////zad h 
	public List<EmployeeEntity> findH1 (LocalDate dateFrom, LocalDate dateTo, int jobPositionId) {
		return null;
		
	}
}
