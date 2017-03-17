package com.capgemini.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.dom4j.tree.AbstractEntity;

@Entity
@Table(name = "projects")
public class ProjectEntity extends AbstractEntity {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_project")
	private int idProject;
	@Column(name = "project_name", nullable = false)
	private int projectName;
	@OneToOne
	@JoinColumn (name="menager_id", referencedColumnName="id_employee")
	private EmployeeEntity employeeEntity;
	@ManyToOne
	@JoinColumn (name="id_project_type")
	private ProjectTypeEntity projectTypeEntity;
	
//	@Version
//	@Column(name = "version", columnDefinition = "int default 0")
//	private int version = 0;

	public int getIdProject() {
		return idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	public int getProjectName() {
		return projectName;
	}

	public void setProjectName(int projectName) {
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

//	public int getVersion() {
//		return version;
//	}
//
//	public void setVersion(int version) {
//		this.version = version;
//	}
}
