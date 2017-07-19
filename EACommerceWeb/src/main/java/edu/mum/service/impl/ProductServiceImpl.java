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

	@Override
	public void save(Product product) {
		this.productDao.save(product);
	}

	@Override
	public Product update(Product product) {
		return this.productDao.update(product);
	}

	@Override
	public List<Product> findAll() {
		return this.productDao.findAll();
	}

	@Override
	public Product findOne(Long id) {
		return this.productDao.findOne(id);
	}

	@Override
	public List<Product> findBySellerOrBuyer(Integer price, User buyer, User seller) {

		return this.productDao.findBySellerOrBuyer(price, buyer, seller);
	}

	@Override
	public List<Product> findByCategoryName(String categoryName) {
		return this.productDao.findByCategoryName(categoryName);
	}

	@Override
	public List<Product> findItemCriteria(Integer initialPrice, User buyer, User seller) {
		return this.productDao.findItemCriteria(initialPrice, buyer, seller);
	}

	@Override
	public void remove(Long id) {
		this.productDao.delete(id);
	}
}
