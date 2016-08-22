package com.iggroup.webapi.samples.client.rest.dto.watchlists.getWatchlistByWatchlistIdV1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
List watchlists response
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetWatchlistByWatchlistIdV1Response {

/*
List of watchlist markets
*/
private java.util.List<MarketsItem> markets;

public java.util.List<MarketsItem> getMarkets() { return markets; }
public void setMarkets(java.util.List<MarketsItem> markets) { this.markets=markets; }
}
