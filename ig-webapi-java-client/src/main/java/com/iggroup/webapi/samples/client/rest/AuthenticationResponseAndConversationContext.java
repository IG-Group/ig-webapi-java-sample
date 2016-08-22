package com.iggroup.webapi.samples.client.rest;


import com.iggroup.webapi.samples.client.rest.dto.session.createSessionV2.CreateSessionV2Response;

public class AuthenticationResponseAndConversationContext {

	private ConversationContext conversationContext;

	private CreateSessionV2Response createSessionResponse;

	public AuthenticationResponseAndConversationContext(
			ConversationContext conversationContext,
         CreateSessionV2Response postSessionResponse) {
		this.conversationContext = conversationContext;
		this.createSessionResponse = postSessionResponse;
	}

	public ConversationContext getConversationContext() {
		return conversationContext;
	}

	public CreateSessionV2Response getCreateSessionResponse() {
		return createSessionResponse;
	}

}
