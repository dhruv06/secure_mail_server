package com.nss.assignment.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.nss.assignment.pojo.EmailPojo;
import com.nss.assignment.pojo.KeyServerPojo;

@Repository
public class KeyServerDao extends AbstractDao {

	// select according to email
	private static String select_email = "select k from KeyServerPojo k where email=:email";

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void insert(KeyServerPojo k) {
		em.persist(k);
	}

	@Transactional
	public void insertMail(EmailPojo e)
	{
		em.persist(e);
	}
	public KeyServerPojo selectByEmail(String email) {
		TypedQuery<KeyServerPojo> query = getQuery(select_email, KeyServerPojo.class);
		query.setParameter("email", email);
		return getSingle(query);
	}
	
	
	

}
