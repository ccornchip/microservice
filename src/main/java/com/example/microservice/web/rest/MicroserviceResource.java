package com.example.microservice.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MicroserviceResource {
	private final GatewayFeignClientProxy feignClient;
	
	public MicroserviceResource(GatewayFeignClientProxy feignClient) {
		this.feignClient = feignClient;
	}

	@GetMapping("/test")
	public ResponseEntity<String> test() {
		return ResponseEntity.ok("OK");
	}

	@GetMapping("/test-microservice")
	public ResponseEntity<String> testMicroservice() {
		String response = feignClient.testGateway().getBody();
		return ResponseEntity.ok(" Gateway returned " + response);
	}

}
