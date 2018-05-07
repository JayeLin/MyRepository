package com.tmall.comparator;

import com.tmall.bean.Product;

import java.util.Comparator;

/**
 * @author Jaye
 */
public class ProductSaleCountComparator implements Comparator<Product> {

	@Override
	public int compare(Product p1, Product p2) {
		return p2.getSaleCount()-p1.getSaleCount();
	}

}
