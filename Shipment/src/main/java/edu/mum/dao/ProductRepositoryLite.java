package edu.mum.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.mum.domain.Orders;

 

public interface ProductRepositoryLite {

	List <Orders> getAllProducts();
	
	Orders getProductById(String key);
	
	List<Orders> getProductsByCategory(String category);

	Set<Orders> getProductsByFilter(Map<String, List<String>> filterParams);
	
	void addProduct(Orders product);		
}
