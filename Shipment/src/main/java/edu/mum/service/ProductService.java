package edu.mum.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.mum.domain.Orders;

public interface ProductService {

	List<Orders> getAllProducts();

  	void save(Orders product);

	Orders findOne(long id);
 
 

}
