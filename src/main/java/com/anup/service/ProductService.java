package com.anup.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anup.dao.ProductRepository;
import com.anup.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

	public void saveProduct(Product product) {
		productRepository.save(product);
	}

	@Transactional
	public void updateProduct(Product product, Integer id) {
		productRepository.updateProduct(product.getName(), product.getDescription(), product.getPrice(), id);
	}

	@Transactional
	public void delete(Integer id) {
		productRepository.delete(id);
	}

}
