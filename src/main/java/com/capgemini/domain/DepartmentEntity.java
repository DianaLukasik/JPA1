package com.capgemini.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.dom4j.tree.AbstractEntity;

@Entity
@Table(name = "department")
public class DepartmentEntity extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_department")
	private int idDepartment;
	@NotNull
	@Column(name = "name")
	private String nameDepartment;

	@Embedded
	private Contact contact;

	public int getIdDepartment() {
		return idDepartment;
	}

	public void setIdDepartment(int idDepartment) {
		this.idDepartment = idDepartment;
	}

	public String getNameDepartment() {
		return nameDepartment;
	}

	public void setNameDepartment(String nameDepartment) {
		this.nameDepartment = nameDepartment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}


}
