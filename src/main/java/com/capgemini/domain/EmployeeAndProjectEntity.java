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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
//@EntityListeners(TimeListener.class)
@Table(name = "employee_and_project")
public class EmployeeAndProjectEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idProjectEmployee;

	@ManyToOne
	@JoinColumn (name="id_employee")
	private EmployeeEntity employeeEntity;

	@NotNull
	@ManyToOne
	@JoinColumn (name="id_project")
	private ProjectEntity projectEntity;

	@ManyToOne
	@JoinColumn (name="id_job_position")
	private JobPositionEntity jobPositionEntity;

	@Column(name = "date_from")
	private Date dateFrom;

	@Column(name = "date_to")
	private Date dateTo;

	@Column
	private double salary;
	
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
	private int version = 0;



	public int getIdProjectEmployee() {
		return idProjectEmployee;
	}

	public void setIdProjectEmployee(int idProjectEmployee) {
		this.idProjectEmployee = idProjectEmployee;
	}



	public EmployeeEntity getEmployeeEntity() {
		return employeeEntity;
	}

	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
		this.employeeEntity = employeeEntity;
	}

	public ProjectEntity getProjectEntity() {
		return projectEntity;
	}

	public void setProjectEntity(ProjectEntity projectEntity) {
		this.projectEntity = projectEntity;
	}

	public JobPositionEntity getJobPositionEntity() {
		return jobPositionEntity;
	}

	public void setJobPositionEntity(JobPositionEntity jobPositionEntity) {
		this.jobPositionEntity = jobPositionEntity;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
