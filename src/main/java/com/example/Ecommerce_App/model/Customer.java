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
@Entity(name = "customer_info")
@SQLDelete(sql = "UPDATE customer_info SET deleted=true WHERE customer_info=?")
@Where(clause = "deleted=false")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    private String customerName;
    private String customerEmail;
    private String customerAddress;
    private String customerMobile;
    private String CustomerGender;
    private boolean deleted=Boolean.FALSE;
}
