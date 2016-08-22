package com.iggroup.webapi.samples.client.rest.dto.watchlists.getWatchlistsV1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
List watchlists response
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetWatchlistsV1Response {

/*
List of watchlists
*/
private java.util.List<WatchlistsItem> watchlists;

public java.util.List<WatchlistsItem> getWatchlists() { return watchlists; }
public void setWatchlists(java.util.List<WatchlistsItem> watchlists) { this.watchlists=watchlists; }
}
