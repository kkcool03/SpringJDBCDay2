package com.sky.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sky.model.Product;
import com.sky.service.ProductService;


@Controller
@RequestMapping("/products")
public class ProductContoller {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/product", method = RequestMethod.GET,consumes = "application/json", produces ="application/json")
	public @ResponseBody List<Product> getProducts(){
		return productService.getProducts();
	}
	
	@RequestMapping(value = "/product",method = RequestMethod.POST,consumes = "application/json", produces ="application/json")
	public @ResponseBody Product addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		System.out.println(product);
		return product;
	}
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public @ResponseBody Product getProductById (@PathVariable("id") String id) {
		return productService.getProductById(id);
	}
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
	public  @ResponseBody /* Product */void deleteById (@PathVariable("id") String id) {
	/*	return */ productService.deleteById(id);
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.PUT)
	public @ResponseBody /*Product*/ void updateById (@RequestBody Product product) {
		/*return*/ productService.updateById(product);
	}
	
	
}
