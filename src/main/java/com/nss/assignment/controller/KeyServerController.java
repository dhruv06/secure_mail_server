package com.nss.assignment.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nss.assignment.model.EmailForm;
import com.nss.assignment.model.GetKeyForm;
import com.nss.assignment.model.KeyForm;
import com.nss.assignment.pojo.EmailPojo;
import com.nss.assignment.pojo.KeyServerPojo;
import com.nss.assignment.service.ApiException;
import com.nss.assignment.service.KeyServerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
public class KeyServerController {
	@Autowired
	private KeyServerService service;

	// CRUD operations for brand

	@ApiOperation(value = "Adds key")
	@RequestMapping(path = "/api/keyserver", method = RequestMethod.POST)
	public void add(@RequestBody KeyForm form) throws ApiException {
		KeyServerPojo p = convert(form);
		System.out.println("1");
		service.add(p);
		System.out.println("2");
	}
	
	@ApiOperation(value = "Send Mail")
	@RequestMapping(path = "/api/sendMail", method = RequestMethod.POST)
	public void sendMail(@RequestBody EmailForm form) throws ApiException {
		EmailPojo e=convert1(form);
		service.addmail(e);
	}
	@ApiOperation(value = "Gets key")
	@RequestMapping(path = "/api/getkeyserver", method = RequestMethod.POST)
	public KeyServerPojo get(@RequestBody GetKeyForm form) throws ApiException {
		return service.getCheck(form.getEmail());
	}
	

	private KeyServerPojo convert(KeyForm form) {
		KeyServerPojo k=new KeyServerPojo();
		k.setEmail(form.getEmail());
		k.setName(form.getName());
		k.setPublic_key(form.getPublic_key());
		return k;
	}
	
	private EmailPojo convert1(EmailForm form) {
		EmailPojo e=new EmailPojo();
		e.setSender(form.getSender());
		e.setReceiver(form.getReceiver());
		e.setBody(form.getBody());
		return e;
	}
}
