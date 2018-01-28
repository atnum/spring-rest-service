package com.anup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anup.model.Product;
import com.anup.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(path = "/products", method = RequestMethod.GET)
	public List<Product> getProducts() {
		return productService.getAllProducts();
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<String> createProduct(@RequestBody Product product) {

		productService.saveProduct(product);

		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Product> updateEmployee(@PathVariable("id") int id, @RequestBody Product product) {

		productService.updateProduct(product, id);

		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Product> updateEmployee(@PathVariable("id") int id) {

		productService.delete(id);

		return new ResponseEntity<Product>(HttpStatus.OK);
	}

}
