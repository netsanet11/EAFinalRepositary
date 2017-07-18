package edu.mum.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.domain.UserCredential;
@Repository

public class UserCredentialDao extends GenericDaoImpl<UserCredential> implements edu.mum.dao.UserCredentialDao {

	@Override
	public UserCredential findByUserName(String username) {
		
		Query createNamedQuery = entityManager.createNamedQuery("findUserCredential");
		createNamedQuery.setParameter("username", username);
		
		return (UserCredential)createNamedQuery.getSingleResult();
	}

	

}
