package com.nss.assignment.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nss.assignment.dao.KeyServerDao;
import com.nss.assignment.pojo.EmailPojo;
import com.nss.assignment.pojo.KeyServerPojo;

@Service
public class KeyServerService {
	@Autowired
	private KeyServerDao dao;

	public void add(KeyServerPojo p) throws ApiException {
		System.out.println("10"+p.getEmail());

		KeyServerPojo k = dao.selectByEmail(p.getEmail());
		System.out.println("3");

		if (k == null) {
			System.out.println("4");
			dao.insert(p);
		} else {
			throw new ApiException("Given Email id has already a public key !!!");
		}
		System.out.println("5");

	}
	
	
	public void addmail(EmailPojo e) throws ApiException{
		dao.insertMail(e);
	}
	
	
	

	@Transactional
	public KeyServerPojo getCheck(String email) throws ApiException {
		KeyServerPojo p = dao.selectByEmail(email);
		if (p == null) {
			throw new ApiException("User with email : " + email + " is not on server");
		}
		return p;
	}

}
