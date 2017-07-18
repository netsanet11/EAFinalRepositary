package edu.mum.dao.impl;

 

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.OrderDao;
import edu.mum.domain.SingleOrder;


@SuppressWarnings("unchecked")
@Repository
public class OrderDaoImpl extends GenericDaoImpl<SingleOrder> implements OrderDao {

	public OrderDaoImpl() {
		super.setDaoType(SingleOrder.class );
		}

 
 }