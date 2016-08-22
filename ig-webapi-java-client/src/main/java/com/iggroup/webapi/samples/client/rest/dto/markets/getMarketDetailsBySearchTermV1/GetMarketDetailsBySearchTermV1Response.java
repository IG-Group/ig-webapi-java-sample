package com.iggroup.webapi.samples.client.rest.dto.markets.getMarketDetailsBySearchTermV1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Search markets response
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetMarketDetailsBySearchTermV1Response {

/*
List of markets
*/
private java.util.List<MarketsItem> markets;

public java.util.List<MarketsItem> getMarkets() { return markets; }
public void setMarkets(java.util.List<MarketsItem> markets) { this.markets=markets; }
}
