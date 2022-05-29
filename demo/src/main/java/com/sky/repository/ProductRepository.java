package com.sky.repository;

import java.util.List;

import com.sky.model.Product;

public interface ProductRepository {
	public void addProduct(Product product);
	public List<Product> getProducts();
	public Product getProductById(String id);
	public void deleteById(String id);
	public void updateById(Product newProduct);
}
