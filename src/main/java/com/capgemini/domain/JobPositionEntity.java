package com.capgemini.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
@Table(name = "job_position")
public class JobPositionEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_job_position")
	private int idJobposition;
	@NotNull
	@Column(name = "job_position_name", nullable = false)
	private String jobPositionName;
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
	
	public int getIdJobposition() {
		return idJobposition;
	}
	public void setIdJobposition(int idJobposition) {
		this.idJobposition = idJobposition;
	}
	public String getJobPositionName() {
		return jobPositionName;
	}
	public void setJobPositionName(String jobPositionName) {
		this.jobPositionName = jobPositionName;
	}
	public int getModificationCounter() {
		return modificationCounter;
	}
	public void setModificationCounter(int modificationCounter) {
		this.modificationCounter = modificationCounter;
	}


	
}