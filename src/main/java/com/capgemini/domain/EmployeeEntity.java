package com.capgemini.domain;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.dom4j.tree.AbstractEntity;

@Entity
//@EntityListeners(TimeListener.class)
@Table(name = "employee")
public class EmployeeEntity extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	
	
	
	public EmployeeEntity() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_employee")
	private int idEmployee;
	@NotNull
	@Column
	private String name;
	@NotNull
	@Column
	private String surname;
	@Column
//	@Size(max=11)
	private String pesel;
	@Column(name = "birth_date")
	private Date birthDate;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (name="id_department")
	private DepartmentEntity departmentEntity;

	@Embedded
	private Contact contact;

	// @Version
	// @Column(name = "version", columnDefinition = "int default 0")
	// private int version = 0;
	//

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public DepartmentEntity getDepartmentEntity() {
		return departmentEntity;
	}

	public void setDepartmentEntity(DepartmentEntity departmentEntity) {
		this.departmentEntity = departmentEntity;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	// public int getVersion() {
	// return version;
	// }
	//
	// public void setVersion(int version) {
	// this.version = version;
	// }

}