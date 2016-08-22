package com.iggroup.webapi.samples.client.rest.dto.clientsentiment.getRelatedClientSentimentV1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
List of client sentiments
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetRelatedClientSentimentV1Response {

/*
Client sentiment list
*/
private java.util.List<ClientSentimentsItem> clientSentiments;

public java.util.List<ClientSentimentsItem> getClientSentiments() { return clientSentiments; }
public void setClientSentiments(java.util.List<ClientSentimentsItem> clientSentiments) { this.clientSentiments=clientSentiments; }
}
