package com.capgemini.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.dom4j.tree.AbstractEntity;

@Entity
@Table(name = "department")
public class DepartmentEntity extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	// @NotNull (nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_department")
	private int idDepartment;
	@Column(name = "name")
	private String nameDepartment;


	// czy tu powinna byc i jaka adnotacja @Embeddable
	private Contact contact;

	
//	@Version
//	@Column(name = "version", columnDefinition = "int default 0")
//	private int version = 0;

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

//	public int getVersion() {
//		return version;
//	}
//
//	public void setVersion(int version) {
//		this.version = version;
//	}

}
