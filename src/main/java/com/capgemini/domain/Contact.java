package com.capgemini.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Contact {

	@Column(length = 60)
	private String email;
	@Column(name = "mobile_phone", length = 15)
	private int phoneMobile;
	@Column(name = "home_phone", length = 15)
	private int phoneHome;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhoneMobile() {
		return phoneMobile;
	}
	public void setPhoneMobile(int phoneMobile) {
		this.phoneMobile = phoneMobile;
	}
	public int getPhoneHome() {
		return phoneHome;
	}
	public void setPhoneHome(int phoneHome) {
		this.phoneHome = phoneHome;
	}

}
