package edu.mum.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "purchaseOrder")
public class Order implements Serializable {

	private static final long serialVersionUID = -3039679880818308042L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id = null;
	@Version
	@Column(name = "version")
	private int version = 0;

	@Column
	private String orderNumber;

	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<OrderItem> items = new HashSet<OrderItem>();

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	@Column
	private OrderStatus status;

	public OrderStatus getStatus() {
		return this.status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Set<OrderItem> getItems() {
		return this.items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}

}
