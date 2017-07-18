package edu.mum.service;

import java.util.List;
import java.util.Set;

import edu.mum.domain.SingleOrder;
 
public interface MemberService {

	public void save(SingleOrder member);
//    	public void saveFull( Order member);  		

	public List<SingleOrder> findAll();
 	public SingleOrder findOne(Long id);
 		
}
