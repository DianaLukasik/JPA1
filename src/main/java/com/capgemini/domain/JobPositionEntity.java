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
@Table(name = "job_position")
public class JobPositionEntity extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	// @NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_job_position")
	private int idJobposition;
	@Column(name = "job_position_name", nullable = false)
	private String jobPositionName;
	@Version
	@Column(name = "version", columnDefinition = "int default 0")
	private int version = 0;
	
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
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}

	
}