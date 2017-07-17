package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.ProductDao;
import edu.mum.domain.Product;
import edu.mum.domain.User;
import edu.mum.service.ProductService;


@Service
@Transactional 
public class ProductServiceImpl implements ProductService {
	
	
 	@Autowired
	private ProductDao productDao;

    public void save( Product product) {  		
		productDao.save(product);
	}
	
	
    public Product update(Product product) {  		
		return productDao.update(product);
	}
	
	
	public List<Product> findAll() {
		return (List<Product>)productDao.findAll();
	}

 	public Product findOne(Long id) {
		return productDao.findOne(id);
	}


	@Override
	public List<Product> findBySellerOrBuyer(Integer price, User buyer, User seller) {
		 
		return productDao.findBySellerOrBuyer(price, buyer, seller);
	}

	public List<Product> findByCategoryName(String categoryName) {
		return productDao.findByCategoryName(categoryName);
	}
	
	public List<Product> findItemCriteria(Integer initialPrice, User buyer, User seller) {
		return productDao.findItemCriteria(initialPrice,buyer,seller);
	}
}
