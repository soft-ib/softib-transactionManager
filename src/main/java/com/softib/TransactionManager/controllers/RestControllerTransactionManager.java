package com.softib.TransactionManager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.ribbon.proxy.annotation.Http;
import com.softib.TransactionManager.entity.Transaction;
import com.softib.TransactionManager.services.ITransactionService;
import com.softib.TransactionManager.services.TransactionServiceImpl;
import com.softib.TransactionManager.util.IUserService;

@RestController
public class RestControllerTransactionManager {

	@Autowired
	IUserService userService;
	@Autowired
	ITransactionService transactionService;

	@Autowired
	private EurekaClient eurekaClient;

	private String coreServiceId ="core-service";

	@GetMapping(value = "transaction")
	@ResponseBody
	String showTestTransaction() {
		return "Hello, Transaction Manager is working !!!!" + " User and roles : " + userService.getCurrentUserName() + " "
				+ userService.getCurrentUserRole();
	}
	
	@PostMapping("/addTransaction")
	public ResponseEntity<Object> save(@RequestBody Transaction transaction) {
//		if ( transaction.getAmount()<0)
		transactionService.addTransaction(transaction);
		return ResponseEntity.ok("Transaction added successfully");
	}
	
	
	@PutMapping("/updateTransaction")
	public void update(@RequestBody Transaction transaction) {
		transactionService.updateTransaction(transaction);
	}
	
	
	@GetMapping("/getAllTransaction")
	public List<Transaction> getAllTransactions() {
		return transactionService.getAllTransactions();
	}
	
	
	
	
	
	
	@GetMapping(value = "/from-core/users")
	@ResponseBody
	Object fromCore(@RequestHeader("Authorization") String token) {
		Application application = eurekaClient.getApplication(coreServiceId);
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/users";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", token);
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		return restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
	}
}
