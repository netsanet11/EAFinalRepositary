package edu.mum.dao.impl;

 

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.MemberDao;
import edu.mum.domain.SingleOrder;


@SuppressWarnings("unchecked")
@Repository
public class MemberDaoImpl extends GenericDaoImpl<SingleOrder> implements MemberDao {

	public MemberDaoImpl() {
		super.setDaoType(SingleOrder.class );
		}

 
 }