package com.capgemini.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.dom4j.tree.AbstractEntity;

@Entity
@Table(name = "project_type")
public class ProjectTypeEntity extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	// @NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_project_type")
	private int idProjectType;
	@Column(nullable = false, length = 35)
	private String name;
	@Version
	@Column(name = "version", columnDefinition = "int default 0")
	private int version = 0;

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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}



	
}
