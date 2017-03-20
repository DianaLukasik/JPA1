package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.ProjectEntity;

public interface ProjectDao extends Dao<ProjectEntity, Integer> {
	List<ProjectEntity> findProjectById(int idProject);

	List<ProjectEntity> findProjectByManagerId(int idEmployee);
}
