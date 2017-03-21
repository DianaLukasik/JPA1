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
		TypedQuery<EmployeeAndProjectEntity> query = entityManager.createQuery("select ep from EmployeeAndProjectEntity ep where id_project = :idProject and date_to = null)", EmployeeAndProjectEntity.class);
		query.setParameter("idProject", idProject);
		return query.getResultList();
	}

	
	@Override
	public EmployeeAndProjectEntity findActiveEmployeeByProjectIdAndEmployeeId(int idProject, int idEmployee) {
	
			TypedQuery<EmployeeAndProjectEntity> query = entityManager.createQuery(
					"select ep from EmployeeAndProjectEntity ep where ep.employeeEntity.idEmployee = :idEmployee and ep.projectEntity.idProject = :idProject", EmployeeAndProjectEntity.class);	
			query.setParameter("idProject", idProject).setParameter("idEmployee", idEmployee);
			return query.getSingleResult();

		}


@Override
public List<EmployeeAndProjectEntity> findProjectByEmployeeId(int idEmployee) {
	TypedQuery<EmployeeAndProjectEntity> query = entityManager.createQuery("select ep from EmployeeAndProjectEntity ep where ep.employeeEntity.idEmployee = :idEmployee)", EmployeeAndProjectEntity.class);
	query.setParameter("idEmployee", idEmployee);
	return query.getResultList();
}

@Override
public List<EmployeeAndProjectEntity> findEmployeeAndProjectByProjectId(int idProject) {
	TypedQuery<EmployeeAndProjectEntity> query = entityManager.createQuery("select ep from EmployeeAndProjectEntity ep where ep.projectEntity.idProject = :idProject)", EmployeeAndProjectEntity.class);
	query.setParameter("idProject", idProject);
	return query.getResultList();
}

@Override
public List<EmployeeAndProjectEntity> findEmployeeWorkingLongerThan(int numberOfMonths) {
	TypedQuery<EmployeeAndProjectEntity> query = entityManager.createQuery("select ep.employeeEntity.idEmployee FROM EmployeeAndProjectEntity ep where DATEDIFF(month,dateFrom,dateTo)>:numberOfMonths",EmployeeAndProjectEntity.class);
	query.setParameter("numberOfMonths", numberOfMonths);
	return null;
}
}



	
 
	
	
