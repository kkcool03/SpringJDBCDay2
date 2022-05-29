package com.sky.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.model.Product;

import ch.qos.logback.core.joran.conditional.Condition;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
	private static List<Product> products = new ArrayList<Product>();

	@Override
	public void addProduct(Product product) {
		System.out.println("in repository");
		products.add(product);
	}

	@Override
	public List<Product> getProducts() {
		return products;
	}

	@Override
	public Product getProductById(String id) {
		for (Product product : products) {
			if(product.getProductId().equals(id))
				return product;
		}
		return null;
	}

//	@Override
//	public Product deleteById(String id) {
//		int i = 0;
//		for (Product product : products) {
//			if(product.getProductId().equals(id)) {
//				products.remove(i);
//				return product;
//			}
//			i=i+1;	
//		}
//		return null;
//	
//	}
	
	@Override
	public Product deleteById(String id) {
		int index=0;
		for(Product del: products) {
		if(del.getProductId().equals(id)) {
			products.remove(index);  
			return del;
		}
		index=index +1;
	}
		return null;
	}

	@Override
	public Product updateById(Product newproduct) {
  int index=0;
		for (Product product : products) {
			if(product.getProductId().equals(newproduct.getProductId()))
			{
				products.set(index, newproduct);
				return newproduct;
			}
			index++;
			
		}
		return null;
	}
}
