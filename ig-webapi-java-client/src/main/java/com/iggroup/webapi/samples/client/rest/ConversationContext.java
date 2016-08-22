package com.iggroup.webapi.samples.client.rest;

public class ConversationContext {

	private String clientSecurityToken;
	private String accountSecurityToken;
	private String apiKey;

	public ConversationContext(String clientSecurityToken,
			String accountSecurityToken, String apiKey) {
		this.clientSecurityToken = clientSecurityToken;
		this.accountSecurityToken = accountSecurityToken;
		this.apiKey = apiKey;
	}

	public String getClientSecurityToken() {
		return clientSecurityToken;
	}

	public String getAccountSecurityToken() {
		return accountSecurityToken;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
}
