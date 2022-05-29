package com.sky.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sky.model.Product;

@Repository("ProductRepositoryDBImpl")
public class ProductRepositoryDBImpl implements ProductRepository{
	
	private static String INSERT_PRODUCT_SQL ="insert into product(PRODUCT_ID,PRODUCT_NAME,PRODUCT_PRICE) values (?,?,?)";
	private static String ALL_PRODUCT_SQL = "select PRODUCT_ID,PRODUCT_NAME,PRODUCT_PRICE from product";
	private static String GET_PRODUCT_BY_ID_SQL = "select * FROM product where PRODUCT_ID = ?";
	private static String DELETE_PRODUCT_BY_ID = "delete from product where PRODUCT_ID = ?";
	private static String UPDATE_BY_ID ="update product set PRODUCT_NAME =?,PRODUCT_PRICE=? where PRODUCT_ID=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addProduct(Product product) {
		jdbcTemplate.update(INSERT_PRODUCT_SQL,product.getProductId(),product.getProductName(),product.getPrice());
	}

	@Override
	public List<Product> getProducts() {
		return this.jdbcTemplate.query(ALL_PRODUCT_SQL, new ProductRowMappper());
	}
	
	@Override
	public Product getProductById(String id) {
//		return this.jdbcTemplate.queryForObject(GET_PRODUCT_BY_ID_SQL,PRODUCT_ID, new ProductRowMappper());
		return this.jdbcTemplate.queryForObject(GET_PRODUCT_BY_ID_SQL, new Object[]{id}, new ProductRowMappper());
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update(DELETE_PRODUCT_BY_ID, id);
	}

	@Override
	public void updateById(Product newProduct) {
		jdbcTemplate.update(UPDATE_BY_ID, new Object[] {newProduct.getProductName(),newProduct.getPrice(),newProduct.getProductId()});
	}
	private static final class ProductRowMappper implements RowMapper<Product>{
		public  Product mapRow(ResultSet rs, int rownum) throws SQLException{
			Product product = new Product();
			product.setProductId(rs.getString("PRODUCT_ID"));
			product.setProductName(rs.getString("PRODUCT_NAME"));
			product.setPrice(rs.getInt("PRODUCT_PRICE"));
			return product;
		}
	}

}

