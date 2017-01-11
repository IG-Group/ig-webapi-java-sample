package com.iggroup.webapi.samples.client.rest;

import com.iggroup.webapi.samples.client.rest.dto.session.createSessionV3.AccessTokenResponse;

import java.util.Date;
import java.util.Optional;

public class ConversationContextV3 extends ConversationContext {

	private String accessToken;
	private long accessTokenExpiry;
	private String refreshToken;
	private String accountId;

	public ConversationContextV3(AccessTokenResponse accessTokenResponse, String accountId, String apiKey) {
		super(apiKey);
		this.accessToken = Optional.ofNullable(accessTokenResponse).map(AccessTokenResponse::getAccess_token).orElse(null);
		this.accessTokenExpiry = Optional.ofNullable(accessTokenResponse).map(r -> (new Date()).getTime() + Long.valueOf(r.getExpires_in()) * 1000).orElse(0L);
		this.refreshToken = Optional.ofNullable(accessTokenResponse).map(AccessTokenResponse::getRefresh_token).orElse(null);
		this.accountId = accountId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public long getAccessTokenExpiry() {
		return accessTokenExpiry;
	}

	public String getAccountId() {
		return accountId;
	}
}
