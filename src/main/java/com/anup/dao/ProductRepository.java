package com.anup.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anup.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Modifying
	@Query("update Product p set p.name = ?1, p.description = ?2, p.price = ?3 where p.productId = ?4")
	void updateProduct(String name, String description, BigDecimal price, Integer id);

}
