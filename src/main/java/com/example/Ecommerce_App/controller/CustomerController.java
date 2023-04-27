package com.example.Ecommerce_App.controller;

import com.example.Ecommerce_App.authenticator.HeaderAuth;
import com.example.Ecommerce_App.model.Customer;
import com.example.Ecommerce_App.repository.CustomerRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.Optional;

@RestController
public class CustomerController {


    @Autowired(required = false)
    private CustomerRepository customerRepository;

   @Autowired
    private HeaderAuth headerAuth;

    @PostMapping("/customer/register")
    public ResponseEntity registerCustomer(@RequestBody String customer){

        return new ResponseEntity(customerRepository.save(customer), HttpStatus.ACCEPTED);
    }

    @GetMapping("/customer/getall")
    public ResponseEntity getAllCustomer(){
        return new ResponseEntity(customerRepository.findAll(),HttpStatus.CREATED);
    }

    @PutMapping("/customer/update")
    public ResponseEntity updateCustomer(@RequestBody String customer, @RequestParam int id){
        Optional optional=customerRepository.findById(id);
        if (optional.isPresent()){
        return new ResponseEntity(customerRepository.save(customer),HttpStatus.ACCEPTED);
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("customer/delete")
    public ResponseEntity deleleCustomer(@RequestParam int id){
        Optional optional=customerRepository.findById(id);
        if (optional.isPresent()) {
            customerRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    //------------------- Thirdparty APIs ------------------------------------


   // @GetMapping("/api/customer/fetchAll")
    public ResponseEntity<String> retriveCustomers(){


        String url1="https://www.boredapi.com/api/activity";
        String url="https://myecom-test.chargebee.com/api/v2/customers";

        String plainCreds = "test_fHO5Q5uFcuyPK93mD6vXcuJBM4psLTCTWv:";
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);
        HttpEntity<String> request = new HttpEntity<String>(headers);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);

        String a= response.getBody();
       // return response;
        return new ResponseEntity<>(a,HttpStatus.OK);
    }

//-----------------------------------------------------------------------------------------------------------

            //--- Api to fetch List of All Customers ---
    //@GetMapping("/api/customer/fetchAll")
    public ResponseEntity<String> ListAllCustomer(){
        String v2_url="https://myecom-test.chargebee.com/api/v2/customers";

       ResponseEntity<String> response=headerAuth.HeaderAuthorizer(v2_url);  //method used for authorization
        return response;
    }
//-----------------------------------------------------------------------------------------------------------

    @GetMapping("/api/customer/fetchAll")
    public ResponseEntity<String> ListAllCustomer1(){
        String v2_url="https://myecom-test.chargebee.com/api/v2/customers";

        HttpEntity<String> request=headerAuth.HeaderAuthorizer1(v2_url);

        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(v2_url, HttpMethod.GET, request, String.class);
        return response;
    }

/*.firstName("John")
	.lastName("Doe")
	.email("john@test.com")
	.locale("fr-CA")
	.billingAddressFirstName("John")
	.billingAddressLastName("Doe")
	.billingAddressLine1("PO Box 9999")
	.billingAddressCity("Walnut")
	.billingAddressState("California")
	.billingAddressZip("91789")
	.billingAddressCountry("US")
	.request();
    Customer customer = result.customer();
    Card card = result.card();*/
//-----------------------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------------------------------
   }

