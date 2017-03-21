package com.capgemini.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.dom4j.tree.AbstractEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "projects")
public class ProjectEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_project")
	private int idProject;
	@Column(name = "project_name", nullable = false)
	private String projectName;
	@OneToOne
	@JoinColumn (name="menager_id", referencedColumnName="id_employee")
	private EmployeeEntity employeeEntity;
	@ManyToOne
	@JoinColumn (name="id_project_type")
	private ProjectTypeEntity projectTypeEntity;
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

	public int getIdProject() {
		return idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public EmployeeEntity getEmployeeEntity() {
		return employeeEntity;
	}

	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
		this.employeeEntity = employeeEntity;
	}

	public ProjectTypeEntity getProjectTypeEntity() {
		return projectTypeEntity;
	}

	public void setProjectTypeEntity(ProjectTypeEntity projectTypeEntity) {
		this.projectTypeEntity = projectTypeEntity;
	}

	public int getModificationCounter() {
		return modificationCounter;
	}

	public void setModificationCounter(int modificationCounter) {
		this.modificationCounter = modificationCounter;
	}


}
