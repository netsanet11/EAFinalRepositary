package edu.mum.service;

import java.util.List;

import edu.mum.domain.User;

public interface UserService {

	void saveFull(User user);

	User findOne(Long id);

	List<User> findAll();
	

}
