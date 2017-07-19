package edu.mum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.mum.dao.AutorityDao;
import edu.mum.domain.Address;
import edu.mum.domain.Authority;
@Repository
public class AuthorityDaoImpl extends GenericDaoImpl<Authority> implements AutorityDao {
	public AuthorityDaoImpl(){
		setDaoType(Authority.class);
	}

}
