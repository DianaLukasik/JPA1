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
@Table(name = "job_position")
public class JobPositionEntity extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_job_position")
	private int idJobposition;
	@NotNull
	@Column(name = "job_position_name", nullable = false)
	private String jobPositionName;

	
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


	
}