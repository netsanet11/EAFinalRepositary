package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;
import edu.mum.service.UserCredentialsService;
import edu.mum.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserCredentialsService credentialsService;

	public void save(User user) {
		this.userDao.save(user);
	}

	@Override
	public void saveFull(User user) {
		this.credentialsService.save(user.getUserCredentials());
		this.userDao.save(user);
	}

	@Override
	public List<User> findAll() {
		return this.userDao.findAll();
	}

	public User findByEmail(String email) {
		return this.userDao.findByEmail(email);
	}

	public User update(User user) {
		return this.userDao.update(user);

	}

	@Override
	public User findOne(Long id) {

		return this.userDao.findOne(id);
	}

	@Override
	public User findByUsername(String name) {
		User user = this.userDao.findByUsername(name);
		return user;
	}

}
