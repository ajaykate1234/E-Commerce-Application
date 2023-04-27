package com.example.Ecommerce_App.repository;

import com.example.Ecommerce_App.model.Product;
import com.example.Ecommerce_App.model.Product_Attributes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductAttributesRepository extends JpaRepository<Product_Attributes,Integer> {
}
