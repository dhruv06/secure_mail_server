package com.nss.assignment.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class KeyServerPojo {

	@Id
	private String email;
	private String name;
	@Lob
	private String public_key;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublic_key() {
		return public_key;
	}

	public void setPublic_key(String public_key) {
		this.public_key = public_key;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
