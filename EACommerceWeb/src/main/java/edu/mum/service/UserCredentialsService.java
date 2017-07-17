package edu.mum.service;

import java.util.List;

import edu.mum.domain.UserCredential;
 
public interface UserCredentialsService {

	public void save(UserCredential userCredentials);
	public UserCredential update(UserCredential userCredentials);
	public List<UserCredential> findAll();
	public UserCredential findByUserName(String userName);
 }
