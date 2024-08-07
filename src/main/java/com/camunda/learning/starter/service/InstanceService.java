package com.camunda.learning.starter.service;

import java.util.Map;

public interface InstanceService {
	public Map<String, String> startProcessInstance(Map<String, Object> variables);
}
