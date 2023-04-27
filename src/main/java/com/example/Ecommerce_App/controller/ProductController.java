package com.example.Ecommerce_App.controller;

import com.example.Ecommerce_App.model.Product;
import com.example.Ecommerce_App.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductController {

    @Autowired(required = false)
    private ProductRepository productRepository;

    @PostMapping("/product/create")
    public ResponseEntity createProduct(@RequestBody Product product){

        return new ResponseEntity(productRepository.save(product), HttpStatus.ACCEPTED);
    }

    @GetMapping("/product/getall")
    public ResponseEntity getAllProduct(){
        return new ResponseEntity(productRepository.findAll(),HttpStatus.CREATED);
    }

    @PutMapping("/product/update")
    public ResponseEntity updateProduct(@RequestBody Product product,@RequestParam int id){
        Optional optional=productRepository.findById(id);
        if (optional.isPresent()){
            return new ResponseEntity(productRepository.save(product),HttpStatus.ACCEPTED);
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("product/delete")
    public ResponseEntity deleleProduct(@RequestParam int id){
        Optional optional=productRepository.findById(id);
        if (optional.isPresent()) {
            productRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
