package com.example.Ecommerce_App.controller;

import com.example.Ecommerce_App.model.Product_Attributes;
import com.example.Ecommerce_App.repository.ProductAttributesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductAttributesController {
    @Autowired(required = false)
    private ProductAttributesRepository productAttributesRepository;

    @PostMapping("/product_attributes/create")
    public ResponseEntity createProductAttributes(@RequestBody Product_Attributes product_attributes){

        return new ResponseEntity(productAttributesRepository.save(product_attributes), HttpStatus.ACCEPTED);
    }

    @GetMapping("/product_attributes/getall")
    public ResponseEntity getAllProductAttributes(){
        return new ResponseEntity(productAttributesRepository.findAll(),HttpStatus.CREATED);
    }

    @PutMapping("/product_attributes/update")
    public ResponseEntity updateProductAttributes(@RequestBody Product_Attributes product_attributes,@RequestParam int id){
        Optional optional=productAttributesRepository.findById(id);
        if (optional.isPresent()){
            return new ResponseEntity(productAttributesRepository.save(product_attributes),HttpStatus.ACCEPTED);
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("product_attributes/delete")
    public ResponseEntity deleleProductAttributes(@RequestParam int id){
        Optional optional=productAttributesRepository.findById(id);
        if (optional.isPresent()) {
            productAttributesRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
