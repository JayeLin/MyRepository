package com.tmall.bean;
/**
 * @author Jaye
 */
public class Property {

	private String name;
	/**
	 * @description more-to-one relationship between  property and category
	 */
	private Category category;
	private int id;

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
