package com.capgemini.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.dom4j.tree.AbstractEntity;

@Entity
//@EntityListeners(TimeListener.class)
@Table(name = "project_type")
public class ProjectTypeEntity extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_project_type")
	private int idProjectType;
	@NotNull
	@Column(nullable = false, length = 35)
	private String name;

	public int getIdProjectType() {
		return idProjectType;
	}

	public void setIdProjectType(int idProjectType) {
		this.idProjectType = idProjectType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProjectTypeEntity() {
	}

	public ProjectTypeEntity(int idProjectType, String name) {
		super();
		this.idProjectType = idProjectType;
		this.name = name;
	}

}
