package com.nss.assignment.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class EmailPojo {
	
	private String sender;
	private String receiver;
	@Id
	@Lob
	private String body;

	public String getSender() {
		return sender;
	}

	public void setSender(String name) {
		this.sender = name;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String rec) {
		this.receiver = rec;
	}
}
