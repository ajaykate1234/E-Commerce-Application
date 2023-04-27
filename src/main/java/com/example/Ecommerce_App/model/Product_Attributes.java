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
@Entity(name = "product_attributes_info")
@SQLDelete(sql = "UPDATE product_attributes_info SET deleted=true WHERE product_attribute_id=?")
@Where(clause = "deleted=false")
public class Product_Attributes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productAttributeId;
    private String productColour;
    private String productBrand;
    private String manufacturingDate;
    private boolean deleted=Boolean.FALSE;

}
