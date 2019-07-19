package com.example.microservice.web.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="g", path="/api")
public interface GatewayFeignClientProxy {
	@GetMapping("/test-gateway")
	public ResponseEntity<String> testGateway();
}
