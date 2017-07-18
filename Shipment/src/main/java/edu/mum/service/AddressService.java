package edu.mum.service;

import java.util.List;

import edu.mum.domain.UserInfo;
 
public interface AddressService {

	public void save(UserInfo address);
	public void update(UserInfo address);
	public List<UserInfo> findAll();
 
	public UserInfo findOne(Long id);

}
