package com.iggroup.webapi.samples.client.rest.dto.watchlists.createWatchlistV1;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Create watchlist request
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateWatchlistV1Request {

/*
Watchlist name
*/
private String name;

/*
List of market epics to be associated to this new watchlist
*/
private java.util.Set<String> epics;

public String getName() { return name; }
public void setName(String name) { this.name=name; }
public java.util.Set<String> getEpics() { return epics; }
public void setEpics(java.util.Set<String> epics) { this.epics=epics; }
}
