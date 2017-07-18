package edu.mum.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Orders;
import edu.mum.dao.ProductDao;
import edu.mum.service.ProductService;

@Service
@Transactional 
public class ProductServiceImpl implements ProductService{
	
 	@Autowired
	private ProductDao productDao;

	public List<Orders> getAllProducts() {
		return productDao.findAll();
	}

 
 	public void save(Orders product) {
		   productDao.save(product);
	}
	
	public Orders findOne(long productID) {
		return productDao.findOne(productID);
	}

 
 


}
