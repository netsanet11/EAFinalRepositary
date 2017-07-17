package edu.mum.dao;

import java.util.List;

import edu.mum.domain.Product;
import edu.mum.domain.User;

public interface ProductDao extends GenericDao<Product>{

	List<Product> findBySellerOrBuyer(Integer price, User buyer, User seller);

	List<Product> findByCategoryName(String categoryName);

	List<Product> findItemCriteria(Integer initialPrice, User buyer, User seller);

}
