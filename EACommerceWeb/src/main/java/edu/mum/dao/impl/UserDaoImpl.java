package edu.mum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;
import edu.mum.domain.UserCredential;
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public UserDaoImpl(){
		setDaoType(User.class);
	}
	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}


}
