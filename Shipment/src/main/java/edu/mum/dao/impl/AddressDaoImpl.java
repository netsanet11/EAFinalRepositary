package edu.mum.dao.impl;

 

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.AddressDao;
import edu.mum.domain.UserInfo;


@SuppressWarnings("unchecked")
@Repository
public class AddressDaoImpl extends GenericDaoImpl<UserInfo> implements AddressDao {

	public AddressDaoImpl() {
		super.setDaoType(UserInfo.class );
		}

 
 }