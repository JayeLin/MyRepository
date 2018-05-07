package com.tmall.bean;

public class OrderItem {

	private int number;
	/**
	 * @description more-to-one relationship between  orderItem and product
	 */
	private Product product;
	/**
	 * @description more-to-one relationship between  orderItem and order
	 */
	private Order order;
	/**
	 * @description more-to-one relationship between  orderItem and user
	 */
	private User user;
	private int id;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
