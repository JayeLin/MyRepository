package com.tmall.bean;
/**
 * @author Jaye
 */
public class ProductImage {
	
	private String type;
	/**
	 * @description more-to-one relationship between  productImages and product
	 */
	private Product product;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
