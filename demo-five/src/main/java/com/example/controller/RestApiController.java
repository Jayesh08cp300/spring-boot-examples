package com.example.controller;

import com.example.model.Operation;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class RestApiController {

	@GetMapping("/")
	public Operation doOperation() {
		return new Operation(1, 1, 1 / 1);
	}

	@GetMapping("/{a}/{b}")
	public Operation performOperation(@PathVariable String a, @PathVariable String b) {
		return new Operation(Float.valueOf(a), Float.valueOf(b), Float.valueOf(a) / Float.valueOf(b));
	}
}
