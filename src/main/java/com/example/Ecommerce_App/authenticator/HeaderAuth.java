package com.example.Ecommerce_App.authenticator;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HeaderAuth {
    public ResponseEntity<String> HeaderAuthorizer(String url){
        /*String url1="https://www.boredapi.com/api/activity";
        String url="https://myecom-test.chargebee.com/api/v2/customers";
        */

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

        return new ResponseEntity<String>(a, HttpStatus.ACCEPTED);
    }

    //---
    public HttpEntity<String> HeaderAuthorizer1(String url){
        /*String url1="https://www.boredapi.com/api/activity";
        String url="https://myecom-test.chargebee.com/api/v2/customers";
        */

        String plainCreds = "test_fHO5Q5uFcuyPK93mD6vXcuJBM4psLTCTWv:";
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);
        HttpEntity<String> request = new HttpEntity<String>(headers);
        /*RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);*/

        //String a= response.getBody();

        //return new ResponseEntity<String>(a, HttpStatus.ACCEPTED);
        return request;
    }


}
