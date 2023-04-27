package com.example.Ecommerce_App.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private int userId;
    private String userName;
    private int UserAge;
    private String userEmail;
    private AddressFileds Address;
}
