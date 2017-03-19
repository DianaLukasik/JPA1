package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.ProjectDao;
import com.capgemini.domain.ProjectEntity;

@Repository
public class ProjectDaoImpl extends AbstractDao<ProjectEntity, Integer> implements ProjectDao {

	@Override
	public List<ProjectEntity> findProjectById(int idProject) {
		TypedQuery<ProjectEntity> query = entityManager.createQuery(
				"select project from ProjectEntity project where project.idProject = :idProject", ProjectEntity.class);
		query.setParameter("idProject", idProject);
		return query.getResultList();
	}

	@Override
	public List<ProjectEntity> findProjectByManagerId(int idEmpoyee) {
		try {
			TypedQuery<ProjectEntity> query = entityManager.createQuery(
					"select project from ProjectEntity project where project.idEmployee = :idEmpoyee",
					ProjectEntity.class);
			query.setParameter("idEmpoyee", idEmpoyee);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
}
