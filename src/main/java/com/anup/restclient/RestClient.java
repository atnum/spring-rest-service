package com.anup.restclient;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.anup.model.Product;

public class RestClient {

	public static void getProducts() {

		final String uri = "http://localhost:8080/products";

		RestTemplate restTemplate = new RestTemplate();

		Product[] result = restTemplate.getForObject(uri, Product[].class);

		for (Product p : result)
			System.out.println(p);
	}

	public static void createProduct() {

		final String uri = "http://localhost:8080/products";

		RestTemplate restTemplate = new RestTemplate();

		Product p = new Product();
		p.setName("Nokia");
		p.setDescription("New Nokia 6 Mobile");
		p.setPrice(new BigDecimal(30000));

		restTemplate.postForObject(uri, p, Product.class);

		System.out.println(p.getName() + " " + "created successfully");
	}

	public static void updateProduct() {
		final String uri = "http://localhost:8080/products/{id}";

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "5");

		Product updatedProduct = new Product("HP", "HP 700", new BigDecimal(20000));

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(uri, updatedProduct, params);

		System.out.println("Product Updated Successfully!");
	}

	public static void deleteProduct() {
		final String uri = "http://localhost:8080/products/{id}";

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "5");

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, params);

		System.out.println("Product Deleted Successfully!");

	}

}
