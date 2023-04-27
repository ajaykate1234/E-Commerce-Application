package com.example.Ecommerce_App.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "product_info")
@SQLDelete(sql = "UPDATE product_info SET deleted=true WHERE product_id=?")
@Where(clause = "deleted=false")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String productName;
    private double productPrice;
    private String productStatus;
    private boolean deleted=Boolean.FALSE;
}
