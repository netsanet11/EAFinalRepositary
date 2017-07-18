package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.MemberDao;
import edu.mum.domain.SingleOrder;
import edu.mum.service.UserCredentialsService;

@Service
@Transactional 
public class MemberServiceImpl implements edu.mum.service.MemberService {
	
 	@Autowired
	private MemberDao memberDao;

 	@Autowired
 	UserCredentialsService credentialsService;

    public void save( SingleOrder member) {  		
		memberDao.save(member);
	}
	
 	
//    @Override
//   	public void saveFull( Order member) {  		
//  		credentialsService.save(member.getUserCredentials());
//  		memberDao.save(member);
//	}
  	

	public List<SingleOrder> findAll() {
		return (List<SingleOrder>)memberDao.findAll();
	}

 	public SingleOrder findOne(Long id) {
		return memberDao.findOne(id);
	}
	
 
}
