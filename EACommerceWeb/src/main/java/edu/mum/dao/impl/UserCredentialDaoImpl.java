package edu.mum.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.domain.Product;
import edu.mum.domain.UserCredential;
@Repository

public class UserCredentialDaoImpl extends GenericDaoImpl<UserCredential> implements edu.mum.dao.UserCredentialDao {

	public UserCredentialDaoImpl(){
		setDaoType(UserCredential.class);
	}
	@Override
	public UserCredential findByUserName(String username) {
		
		Query createNamedQuery = entityManager.createNamedQuery("findUserCredential");
		createNamedQuery.setParameter("username", username);
		
		return (UserCredential)createNamedQuery.getSingleResult();
	}

	

}
