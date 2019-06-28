package com.products.Products.controller;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.products.Products.model.Customer;


@RestController
@RequestMapping("/restTemplate")
public class FindCustomers {
	
	@GetMapping("/customer")
	public String getCustomerDetails() {
		RestTemplate restTemplate=new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<>(headers);
	    		  
	      
		return	restTemplate.exchange("http://localhost:9099/searchCustomer?id=2", HttpMethod.GET, entity, String.class).getBody();

	      
	}
	
	@PostMapping("/customer")
	public ResponseEntity<String> postCustomerDetails() {
		RestTemplate restTemplate=new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<>(headers);
	    		   Customer custmomer=new Customer();
	    		   custmomer.setCustomername("sai");
	    		   custmomer.setPhoneno(999999L);
	    		   custmomer.setRole("role");
	    		   custmomer.setId(1);


	      return restTemplate.postForEntity("http://localhost:9099/addcustomer", custmomer, String.class);

	      
	}
	
	@DeleteMapping("/customer/{id}")
	public void deleteCustomerDetails(@PathVariable("id") String id) {
		RestTemplate restTemplate=new RestTemplate();

	    		      restTemplate.delete("http://localhost:9099/deleteCustomer/"+id);

	      
	}

	@PutMapping("/customer")
	public void updateCustomerDetails(@RequestBody Customer customer) {
		RestTemplate restTemplate=new RestTemplate();
		
		/*
		 * HttpHeaders headers = new HttpHeaders();
		 * headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON)); HttpEntity
		 * <String> entity = new HttpEntity<>(headers);
		 */
		
	    		   Customer custmomer=new Customer();
	    		   custmomer.setCustomername("sai");
	    		   custmomer.setPhoneno(999999L);
	    		   custmomer.setRole("role");
	    		   custmomer.setId(1);

	    		   restTemplate.put("http://localhost:9099/updateCustomer\r\n" + 
	    		   		"", custmomer);

	      
	}
}
