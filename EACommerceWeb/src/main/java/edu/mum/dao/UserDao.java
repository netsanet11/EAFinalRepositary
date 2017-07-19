package edu.mum.dao;

import edu.mum.domain.User;

public interface UserDao extends GenericDao<User> {

	User findByEmail(String email);

	User findByUsername(String name);

}
