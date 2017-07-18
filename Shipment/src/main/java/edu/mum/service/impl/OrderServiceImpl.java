package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.OrderDao;
import edu.mum.domain.SingleOrder;
import edu.mum.service.UserCredentialsService;

@Service
@Transactional 
public class OrderServiceImpl implements edu.mum.service.OrderService {
	
 	@Autowired
	private OrderDao orderDao;

 	@Autowired
 	UserCredentialsService credentialsService;

    public void save( SingleOrder order) {  		
		orderDao.save(order);
	}
	
 	
//    @Override
//   	public void saveFull( Order member) {  		
//  		credentialsService.save(member.getUserCredentials());
//  		memberDao.save(member);
//	}
  	
    @Override
    public void update(SingleOrder singleOrder) {
    	orderDao.update(singleOrder);
    	return;
    }
	public List<SingleOrder> findAll() {
		return (List<SingleOrder>)orderDao.findAll();
	}

 	public SingleOrder findOne(Long id) {
		return orderDao.findOne(id);
	}
	
 
}
