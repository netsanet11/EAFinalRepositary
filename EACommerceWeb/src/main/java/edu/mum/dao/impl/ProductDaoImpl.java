package edu.mum.dao.impl;

import java.util.List;

import edu.mum.dao.ProductDao;
import edu.mum.domain.Product;
import edu.mum.domain.User;

public class ProductDaoImpl extends GenericDaoImpl<Product> implements ProductDao {

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
