package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.GenericDao;
import edu.mum.dao.AddressDao;
import edu.mum.domain.UserInfo;

@Service
@Transactional 
public class AddressServiceImpl implements edu.mum.service.AddressService {
	
	
 	@Autowired
	private AddressDao memberDao;

    public void save( UserInfo address) {  		
		memberDao.save(address);
	}
	
	
    public void update( UserInfo address) {  		
		memberDao.update(address);
	}
	
	
	public List<UserInfo> findAll() {
		return (List<UserInfo>)memberDao.findAll();
	}

 	public UserInfo findOne(Long id) {
		return memberDao.findOne(id);
	}


	
 
}
