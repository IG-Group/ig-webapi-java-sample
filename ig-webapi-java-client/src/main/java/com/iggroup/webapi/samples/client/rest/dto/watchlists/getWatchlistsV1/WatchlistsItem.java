package com.iggroup.webapi.samples.client.rest.dto.watchlists.getWatchlistsV1;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Watchlist data
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WatchlistsItem {

/*
Watchlist indentifier
*/
private String id;

/*
Watchlist name
*/
private String name;

/*
True if this watchlist can be altered by the user
*/
private Boolean editable;

/*
True if this watchlist can be deleted by the user
*/
private Boolean deleteable;

/*
True if this watchlist doesn't belong to the user, but rather is a system
 predefined one
*/
private Boolean defaultSystemWatchlist;

public String getId() { return id; }
public void setId(String id) { this.id=id; }
public String getName() { return name; }
public void setName(String name) { this.name=name; }
public Boolean getEditable() { return editable; }
public void setEditable(Boolean editable) { this.editable=editable; }
public Boolean getDeleteable() { return deleteable; }
public void setDeleteable(Boolean deleteable) { this.deleteable=deleteable; }
public Boolean getDefaultSystemWatchlist() { return defaultSystemWatchlist; }
public void setDefaultSystemWatchlist(Boolean defaultSystemWatchlist) { this.defaultSystemWatchlist=defaultSystemWatchlist; }
}
