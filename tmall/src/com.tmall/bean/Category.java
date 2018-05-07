package com.tmall.bean;

import java.util.List;

/**
 * @author Jaye
 */

public class Category {

	private String name;

	private int id;

	/**
	 * @description One-to-many relationship between category and products
	 */
	List<Product> products;

	/**
	 * @description One category corresponds to multiple List<Product>
	 */
	List<List<Product>> productsByRow;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + "]";
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<List<Product>> getProductsByRow() {
		return productsByRow;
	}

	public void setProductsByRow(List<List<Product>> productsByRow) {
		this.productsByRow = productsByRow;
	}

}
