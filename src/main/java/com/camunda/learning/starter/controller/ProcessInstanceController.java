package com.camunda.learning.starter.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.camunda.learning.starter.service.InstanceService;

@RestController

public class ProcessInstanceController {

	@Autowired
	private InstanceService instanceService;

	@PostMapping("/start-instance")
	public ResponseEntity<Object> startProcessInstance(@RequestBody Map<String, Object> variables) {
		try {
			return ResponseEntity.ok().body(instanceService.startProcessInstance(variables));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
