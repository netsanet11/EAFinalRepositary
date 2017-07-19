package edu.mum.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 5784L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String description;
	private String productId;
	private float price;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	/*
	 * public Category getCategory() { return category; } public void
	 * setCategory(Category category) { this.category = category; }
	 */

	// public List<Category> getCategories() {
	// return categories;
	// }
	// public void setCategories(List<Category> categories) {
	// this.categories = categories;
	// }
	// public void addCategory(Category category) {
	// this.categories.add(category);
	//// category.getProducts().add(this);
	// }

}
