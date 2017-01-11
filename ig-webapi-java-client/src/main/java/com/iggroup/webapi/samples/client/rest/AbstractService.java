package com.iggroup.webapi.samples.client.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iggroup.webapi.samples.client.rest.dto.session.createSessionV2.CreateSessionV2Response;
import com.iggroup.webapi.samples.client.rest.dto.session.createSessionV2.CreateSessionV2Request;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public abstract class AbstractService {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractService.class);

	@Autowired
	protected ObjectMapper objectMapper;

	@Autowired
	protected RestTemplate restTemplate;

	@Autowired
	protected HttpClient httpClient;

	@Value("${ig.api.domain.URL}")
	private String igApiDomainURL;

	@Value("${ig.api.dark.cluster:false}")
	private boolean igApiDarkCluster;

	@Value("${ig.api.dark.cluster.query.parameter:deal_cluster}")
	private String igApiDarkClusterQueryParameter;

	public String getIGApiDomainURL() {
		return igApiDomainURL;
	}

	public String addIGApiLightDarkCluster(String url) {
		if(igApiDarkCluster) {
			url = url + (url.indexOf('?') >= 0 ? "&" : "?") + igApiDarkClusterQueryParameter + "=dark";
		}
		return url;
	}

	protected HttpEntity<?> buildHttpEntity(
			ConversationContext conversationContext) {
		return buildHttpEntity(conversationContext, null, null);
	}

	protected HttpEntity<?> buildHttpEntity(
			ConversationContext conversationContext, Object request) {
		return buildHttpEntity(conversationContext, request, null);
	}

	@SuppressWarnings("unchecked")
	protected HttpEntity buildHttpEntity(
			ConversationContext conversationContext, Object request,
			String version) {
		HttpEntity<?> requestEntity;

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		if (conversationContext != null && conversationContext instanceof ConversationContextV2) {
			setAuthHeaders((ConversationContextV2) conversationContext, requestHeaders);
			requestHeaders.set(Constants.APPLICATION_KEY, conversationContext.getApiKey());
		}
		if (conversationContext != null && conversationContext instanceof ConversationContextV3) {
			setAuthHeaders((ConversationContextV3) conversationContext, requestHeaders);
			requestHeaders.set(Constants.APPLICATION_KEY, conversationContext.getApiKey());
		}
		if (StringUtils.isNotBlank(version)) {
			requestHeaders.set(Constants.VERSION, version);
		}

		if (request != null) {
			requestEntity = new HttpEntity(request, requestHeaders);
		} else {
			requestEntity = new HttpEntity(requestHeaders);
		}

		return requestEntity;
	}

	private void setAuthHeaders(ConversationContextV2 conversationContext, HttpHeaders requestHeaders) {
		if (conversationContext.getAccountSecurityToken() != null) {
			requestHeaders.set(Constants.ACCOUNT_SSO_TOKEN_NAME,
					conversationContext.getAccountSecurityToken());
		}
		if (conversationContext.getClientSecurityToken() != null) {
			requestHeaders.set(Constants.CLIENT_SSO_TOKEN_NAME,
					conversationContext.getClientSecurityToken());
		}
	}

	private void setAuthHeaders(ConversationContextV3 conversationContext, HttpHeaders requestHeaders) {
		if (conversationContext.getAccessToken() != null) {
			requestHeaders.set(Constants.AUTHORIZATION_HEADER, "Bearer " + conversationContext.getAccessToken());
		}
		if (conversationContext.getAccountId() != null) {
			requestHeaders.set(Constants.ACCOUNT_ID_HEADER,	conversationContext.getAccountId());
		}
	}

	protected void bindToConversionForDelete(
			ConversationContext conversationContext,
			HttpDeleteWithBody deleteWithBody, Object requestObject,
			String version) throws Exception {

		String jsonBody = "{}";
		if (requestObject != null) {
			jsonBody = objectMapper.writeValueAsString(requestObject);
		}
		LOG.debug("json body: " + jsonBody);
		deleteWithBody.setEntity(new StringEntity(jsonBody));
		deleteWithBody.addHeader(Constants._METHOD, "DELETE");
		deleteWithBody.addHeader(new BasicHeader("Content-Type",
				"application/json"));
		if (StringUtils.isNotBlank(version)) {
			deleteWithBody.addHeader(Constants.VERSION, version);
		}

		if (conversationContext != null) {
			LOG.debug("conversation context was provided");
			if (conversationContext.getApiKey() != null) {
				deleteWithBody.addHeader(new BasicHeader(
						Constants.APPLICATION_KEY, conversationContext
								.getApiKey()));
			}
			if(conversationContext instanceof ConversationContextV2) {
				ConversationContextV2 contextV2 = (ConversationContextV2) conversationContext;
				if (contextV2.getAccountSecurityToken() != null) {
					deleteWithBody.addHeader(new BasicHeader(Constants.ACCOUNT_SSO_TOKEN_NAME, contextV2.getAccountSecurityToken()));
				}
				if (StringUtils.isNotBlank(contextV2.getClientSecurityToken())) {
					deleteWithBody.addHeader(new BasicHeader(Constants.CLIENT_SSO_TOKEN_NAME, contextV2.getClientSecurityToken()));
				}
			}
			if(conversationContext instanceof ConversationContextV3) {
				ConversationContextV3 context = (ConversationContextV3) conversationContext;
				if (context.getAccessToken() != null) {
					deleteWithBody.addHeader(new BasicHeader(Constants.AUTHORIZATION_HEADER, "Bearer " + context.getAccessToken()));
				}
				if (StringUtils.isNotBlank(context.getAccountId())) {
					deleteWithBody.addHeader(new BasicHeader(Constants.ACCOUNT_ID_HEADER, context.getAccountId()));
				}
			}
		}
	}

	public AuthenticationResponseAndConversationContext createSession(
			CreateSessionV2Request authenticationRequest, String apiKey) {
		String serviceURL = getIGApiDomainURL() + addIGApiLightDarkCluster("/session");

		ConversationContext conversationContext = new ConversationContextV2(null,	null, apiKey);
		final HttpEntity httpEntity = buildHttpEntity(conversationContext,
				authenticationRequest, "2");
		ResponseEntity<CreateSessionV2Response> responseEntity = restTemplate
				.exchange(serviceURL, HttpMethod.POST, httpEntity,
						CreateSessionV2Response.class);
		CreateSessionV2Response body = responseEntity.getBody();
		return new AuthenticationResponseAndConversationContext(
				new ConversationContextV2(responseEntity.getHeaders().getFirst(
						Constants.CLIENT_SSO_TOKEN_NAME), responseEntity
						.getHeaders()
						.getFirst(Constants.ACCOUNT_SSO_TOKEN_NAME), apiKey), body.getCurrentAccountId(), body.getLightstreamerEndpoint()
				);
	}

}
