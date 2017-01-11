package com.iggroup.webapi.samples.client.rest;

public class ConversationContextV2 extends ConversationContext {

	private String clientSecurityToken;
	private String accountSecurityToken;

	public ConversationContextV2(String clientSecurityToken,
                                 String accountSecurityToken, String apiKey) {
		super(apiKey);
		this.clientSecurityToken = clientSecurityToken;
		this.accountSecurityToken = accountSecurityToken;
	}

	public String getClientSecurityToken() {
		return clientSecurityToken;
	}

	public String getAccountSecurityToken() {
		return accountSecurityToken;
	}
}
