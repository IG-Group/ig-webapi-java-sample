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
		if (conversationContext != null) {
			if (conversationContext.getAccountSecurityToken() != null) {
				requestHeaders.set(Constants.ACCOUNT_SSO_TOKEN_NAME,
						conversationContext.getAccountSecurityToken());
			}
			if (conversationContext.getClientSecurityToken() != null) {
				requestHeaders.set(Constants.CLIENT_SSO_TOKEN_NAME,
						conversationContext.getClientSecurityToken());
			}
			requestHeaders.set(Constants.APPLICATION_KEY, conversationContext
					.getApiKey());
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

	protected void bindToConversionForDeleteNoBody(
			ConversationContext conversationContext, HttpDelete delete,
			String version) throws Exception {

		delete.addHeader(new BasicHeader("Content-Type", "application/json"));

		if (StringUtils.isNotBlank(version)) {
			delete.addHeader(Constants.VERSION, version);
		}

		if (conversationContext != null) {
			LOG.debug("conversation context was provided");
			if (conversationContext.getApiKey() != null) {
				delete.addHeader(new BasicHeader(Constants.APPLICATION_KEY,
						conversationContext.getApiKey()));
			}
			if (conversationContext.getAccountSecurityToken() != null) {
				delete.addHeader(new BasicHeader(
						Constants.ACCOUNT_SSO_TOKEN_NAME, conversationContext
								.getAccountSecurityToken()));
			}
			if (StringUtils.isNotBlank(conversationContext
					.getClientSecurityToken())) {
				delete.addHeader(new BasicHeader(
						Constants.CLIENT_SSO_TOKEN_NAME, conversationContext
								.getClientSecurityToken()));
			}
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
			if (conversationContext.getAccountSecurityToken() != null) {
				deleteWithBody.addHeader(new BasicHeader(
						Constants.ACCOUNT_SSO_TOKEN_NAME, conversationContext
								.getAccountSecurityToken()));
			}
			if (StringUtils.isNotBlank(conversationContext
					.getClientSecurityToken())) {
				deleteWithBody.addHeader(new BasicHeader(
						Constants.CLIENT_SSO_TOKEN_NAME, conversationContext
								.getClientSecurityToken()));
			}
		}
	}

	public AuthenticationResponseAndConversationContext createSession(
			CreateSessionV2Request authenticationRequest, String apiKey) {
		String serviceURL = getIGApiDomainURL() + addIGApiLightDarkCluster("/session");

		ConversationContext conversationContext = new ConversationContext(null,
				null, apiKey);
		final HttpEntity httpEntity = buildHttpEntity(conversationContext,
				authenticationRequest, "2");
		ResponseEntity<CreateSessionV2Response> responseEntity = restTemplate
				.exchange(serviceURL, HttpMethod.POST, httpEntity,
						CreateSessionV2Response.class);
		return new AuthenticationResponseAndConversationContext(
				new ConversationContext(responseEntity.getHeaders().getFirst(
						Constants.CLIENT_SSO_TOKEN_NAME), responseEntity
						.getHeaders()
						.getFirst(Constants.ACCOUNT_SSO_TOKEN_NAME), apiKey),
				responseEntity.getBody());
	}

}
