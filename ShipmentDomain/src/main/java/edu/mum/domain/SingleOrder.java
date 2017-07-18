package edu.mum.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

//import edu.mum.validation.EmptyOrSize;
//import edu.mum.validation.NullMinNumber;


@Entity 
public class SingleOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private long id;
	
	@Column(length = 16)
	private String status;
	
	@Column(length = 16)
	@NotEmpty
	private String productName;
	@Column
	private Integer quantity;
 	
//	private UserInfo userInfo;
//
// 	public UserInfo getUserInfo() {
//		return userInfo;
//	}
//	public void setUserInfo(UserInfo userInfo) {
//		this.userInfo = userInfo;
//	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
  }
