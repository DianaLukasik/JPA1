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
		try {
			TypedQuery<EmployeeAndProjectEntity> query = entityManager.createQuery(
					"SELECT employee FROM EmployeeProjectEntity employee WHERE (employee.employeeEntity.id_employee = :id_employee and employee.projectEntity.id_project = :id_project)",
					EmployeeAndProjectEntity.class);
			query.setParameter("id_project", idProject).setParameter("id_employee", idEmployee);
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	} 

//	@Override
//	public List<EmployeeProjectEntity> findByProjectNameAndEmployeeId(String projectName, int employeeId) {
//		try {
//			TypedQuery<EmployeeProjectEntity> query = entityManager.createQuery(
//					"select ep from EmployeeProjectEntity ep where (ep.employeeEntity.employeeId = :employeeId and upper(ep.projectEntity.projectName) like concat(upper(:projectName), '%'))",
//					EmployeeProjectEntity.class);
//			query.setParameter("projectName", projectName);
//			query.setParameter("employeeId", employeeId);
//			return query.getResultList();
//		} catch (Exception e) {
//			return null;
//		}
//	}

@Override
public List<EmployeeAndProjectEntity> findProjectByEmployeeId(int idEmployee) {
	TypedQuery<EmployeeAndProjectEntity> query = entityManager.createQuery("select ep from EmployeeAndProjectEntity ep where ep.employeeEntity.idEmployee = :idEmployee)", EmployeeAndProjectEntity.class);
	query.setParameter("idEmployee", idEmployee);
	return query.getResultList();
}


@Override
public List<EmployeeAndProjectEntity> findEmployeeWorkingLongerThan(int numberOfMonths) {
	TypedQuery<EmployeeAndProjectEntity> query = entityManager.createQuery("select ep.employeeEntity.idEmployee FROM EmployeeAndProjectEntity ep where DATEDIFF(month,dateFrom,dateTo)>:numberOfMonths",EmployeeAndProjectEntity.class);
	query.setParameter("numberOfMonths", numberOfMonths);
	return null;
}
}



	
 
	
	
