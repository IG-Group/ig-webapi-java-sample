package com.iggroup.webapi.samples.client.rest.dto.markets.navigation.getMarketNavigationNodeV1;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Market hierarchy node
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class NodesItem {

/*
Node identifier
*/
private String id;

/*
Node name
*/
private String name;

public String getId() { return id; }
public void setId(String id) { this.id=id; }
public String getName() { return name; }
public void setName(String name) { this.name=name; }
}
