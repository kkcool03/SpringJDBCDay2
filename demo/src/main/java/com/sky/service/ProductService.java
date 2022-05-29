package com.sky.service;

import java.util.List;

import com.sky.model.Product;

public interface ProductService {
	public void addProduct(Product product);
	public List<Product> getProducts();
	public Product getProductById(String id);
	public void deleteById(String id);
	public void updateById(Product newProduct);
}
