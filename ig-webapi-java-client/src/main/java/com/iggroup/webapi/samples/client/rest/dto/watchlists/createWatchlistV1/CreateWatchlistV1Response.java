package com.iggroup.webapi.samples.client.rest.dto.watchlists.createWatchlistV1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Create watchlist response
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateWatchlistV1Response {

/*
Identifier of the watchlist just created, if successful
*/
private String watchlistId;

/*
Result status of the watchlist creation request
*/
private Status status;

public String getWatchlistId() { return watchlistId; }
public void setWatchlistId(String watchlistId) { this.watchlistId=watchlistId; }
public Status getStatus() { return status; }
public void setStatus(Status status) { this.status=status; }
}
