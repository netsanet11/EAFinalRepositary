package edu.mum.dao.impl;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.domain.SingleOrder;
import edu.mum.domain.Orders;

import edu.mum.dao.ProductDao;

	@Repository
	public class ProductDaoImpl extends GenericDaoImpl<Orders> implements ProductDao
	{
		
		public ProductDaoImpl() {
			super.setDaoType(Orders.class );
			}


  
	}

