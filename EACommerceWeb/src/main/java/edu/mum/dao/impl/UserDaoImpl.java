package edu.mum.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		setDaoType(User.class);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUsername(String name) {
		Query query = this.entityManager.createQuery("Select u FROM User u where u.userCredentials.username = :name");
		return (User) query.setParameter("name", name).getSingleResult();
	}

}
