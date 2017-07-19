package edu.mum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.mum.dao.ProductDao;
import edu.mum.domain.OrderItem;
import edu.mum.domain.Product;
import edu.mum.domain.User;
@Repository
public class ProductDaoImpl extends GenericDaoImpl<Product> implements ProductDao {

	
	public ProductDaoImpl(){
		setDaoType(Product.class);
	}
	@Override
	public List<Product> findBySellerOrBuyer(Integer price, User buyer, User seller) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByCategoryName(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findItemCriteria(Integer initialPrice, User buyer, User seller) {
		// TODO Auto-generated method stub
		return null;
	}


}
