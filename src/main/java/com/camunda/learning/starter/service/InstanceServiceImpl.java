package com.camunda.learning.starter.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.impl.oauth.OAuthCredentialsProvider;
import io.camunda.zeebe.client.impl.oauth.OAuthCredentialsProviderBuilder;

@Service
public class InstanceServiceImpl implements InstanceService {

	// Zeebe Client Credentials
	private static final String ZEEBE_ADDRESS = "[zeebe_address]";
	private static final String ZEEBE_CLIENT_ID = "[zeebe-clientid]";
	private static final String ZEEBE_CLIENT_SECRET = "[zeebe-client-secret]";
	private static final String ZEEBE_AUTHORIZATION_SERVER_URL = "[zeebe-login-url]";
	private static final String ZEEBE_TOKEN_AUDIENCE = "[zeebe-audience-token]";

	@Override
	public Map<String, String> startProcessInstance(Map<String, Object> variables) {
		final OAuthCredentialsProvider credentialsProvider = new OAuthCredentialsProviderBuilder()
				.authorizationServerUrl(ZEEBE_AUTHORIZATION_SERVER_URL).audience(ZEEBE_TOKEN_AUDIENCE)
				.clientId(ZEEBE_CLIENT_ID).clientSecret(ZEEBE_CLIENT_SECRET).build();

		try (final ZeebeClient client = ZeebeClient.newClientBuilder().gatewayAddress(ZEEBE_ADDRESS)
				.credentialsProvider(credentialsProvider).build()) {

			// Request the Cluster Topology
			System.out.println("Connected to: " + client.newTopologyRequest().send().join());

			// Launch the Process Instance
			client.newCreateInstanceCommand().bpmnProcessId("Process_14soru2").latestVersion().variables(variables)
					.send().join();
			Map<String, String> result = new HashMap<>();
			result.put("Instance_Status", "Success");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, String> result = new HashMap<>();
		result.put("Instance_Status", "Failed");
		return result;
	}

}
