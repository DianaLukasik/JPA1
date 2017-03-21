package com.capgemini.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.dom4j.tree.AbstractEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
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
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_date")
	private Date modifyDate;
	@Version
	@Column(name = "version", columnDefinition = "int default 0")
	protected int modificationCounter;
	
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

	public int getModificationCounter() {
		return modificationCounter;
	}

	public void setModificationCounter(int modificationCounter) {
		this.modificationCounter = modificationCounter;
	}

}
