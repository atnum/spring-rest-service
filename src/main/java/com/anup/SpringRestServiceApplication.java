package com.anup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anup.restclient.RestClient;

@SpringBootApplication
public class SpringRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestServiceApplication.class, args);

		// Getting Products from Service
		 RestClient.getProducts();

		// Posting products
		// RestClient.createProduct();

		// Updating products
		// RestClient.updateProduct();

		// Deleting products
		// RestClient.deleteProduct();
	}

}
