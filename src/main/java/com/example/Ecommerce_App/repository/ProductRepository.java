package com.example.Ecommerce_App.repository;

import com.example.Ecommerce_App.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
