package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.AccountModel;
import com.example.demo.service.AccountService;

/**
 * This controller is used to fetch all customers available in customer-service
 * application.
 *
 */
@RestController
public class AccountCustomerCommunicationController {

	@Autowired
	DiscoveryClient discoveryClient;

	@Autowired
	AccountService accountService;

	/**
	 * This method will consume all customer availables in customer application
	 * through eureka server.
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/consumeAllCustomers", method = RequestMethod.GET)
	public ResponseEntity<?> saveUser() throws Exception {

		List<ServiceInstance> instances = discoveryClient.getInstances("customer-service");
		ServiceInstance serviceInstance = instances.get(0);

		String baseUrl = serviceInstance.getUri().toString();

		baseUrl = baseUrl + "/customerListServiceUrl";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.POST, getHeaders(), Object.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return ResponseEntity.ok(response.getBody());
	}

	/**
	 * Method will fetch all related headers for the service request.
	 * 
	 * @return
	 * @throws IOException
	 */
	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}

	/**
	 * Create account for customer.
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody AccountModel user) throws Exception {
		accountService.save(user);
		return ResponseEntity.ok(user);
	}
}
