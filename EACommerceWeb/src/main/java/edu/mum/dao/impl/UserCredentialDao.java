package edu.mum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.mum.domain.UserCredential;
@Repository
public class UserCredentialDao extends GenericDaoImpl<UserCredential> implements edu.mum.dao.UserCredentialDao {

	@Override
	public UserCredential findByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
