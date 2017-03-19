package com.capgemini.dao.impl;

import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.dao.ProjectEmployeeDao;
import com.capgemini.domain.EmployeeAndProjectEntity;
import com.capgemini.domain.EmployeeEntity;


@Repository
public class ProjectEmployeeDaoImpl extends AbstractDao<EmployeeAndProjectEntity, Integer> implements ProjectEmployeeDao{

	
	

	@Override
	public List<EmployeeAndProjectEntity> findActiveEmployeeByProjectId(int idProject) {
		TypedQuery<EmployeeAndProjectEntity> query = entityManager.createQuery("select ep.idEmployee from EmployeeProjectEntity ep where (ep.endDate is null and ep.employeeAndProjectEntity.idProject = :idProject)", EmployeeAndProjectEntity.class);
		query.setParameter("idProject", idProject);
		return query.getResultList();
	}

	@Override
	public EmployeeAndProjectEntity findActiveEmployeeByProjectIdAndEmployeeId(int idProject, int idEmployee) {
		// TODO Auto-generated method stub
		return null;
	}
}

//	@Override
//	public List<EmployeeAndProjectEntity> findEmployeeWorkingLongerThan(int numberOfMonths) {
//		TypedQuery<EmployeeAndProjectEntity> query = entityManager.createQuery
//	("select ep FROM EmployeeAndProjectEntity",EmployeeAndProjectEntity.class);
//			query.setParameter("numberOfMonths", numberOfMonths);
//		return null;
//	}

	
 
	
	
