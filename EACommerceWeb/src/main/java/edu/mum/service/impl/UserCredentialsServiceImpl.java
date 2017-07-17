package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.UserCredentialDao;
import edu.mum.domain.UserCredential;
import edu.mum.service.UserCredentialsService;

@Service
@Transactional 
public class UserCredentialsServiceImpl implements UserCredentialsService {
	
 	@Autowired
	private UserCredentialDao userCredentialsDao;

 	
     public void save( UserCredential userCredentials) {  		
  		userCredentialsDao.save(userCredentials);
 	}
  	
  	
	public List<UserCredential> findAll() {
		return (List<UserCredential>)userCredentialsDao.findAll();
	}

	public UserCredential findByUserName(String userName) {
		return userCredentialsDao.findByUserName(userName);
	}


	@Override
	public UserCredential update(UserCredential userCredentials) {
		return userCredentialsDao.update(userCredentials);
	
	}

}
