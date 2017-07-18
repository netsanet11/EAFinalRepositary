package edu.mum.service;

import java.util.List;
import java.util.Set;

import edu.mum.domain.SingleOrder;
 
public interface OrderService {

	public void update(SingleOrder singleOrder);
//    	public void saveFull( Order member);  		
	public List<SingleOrder> findAll();
 	public SingleOrder findOne(Long id);
 		
}
