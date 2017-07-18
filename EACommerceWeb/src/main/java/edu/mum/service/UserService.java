package edu.mum.service;

import edu.mum.domain.User;

public interface UserService {

	void saveFull(User user);

	User findOne(Long id);
	

}
