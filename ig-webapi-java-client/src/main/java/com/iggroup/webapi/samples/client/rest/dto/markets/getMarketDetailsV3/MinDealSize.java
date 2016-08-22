package com.iggroup.webapi.samples.client.rest.dto.markets.getMarketDetailsV3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Dealing rule
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MinDealSize {

/*
Unit
*/
private Unit unit;

/*
Value
*/
private Double value;

public Unit getUnit() { return unit; }
public void setUnit(Unit unit) { this.unit=unit; }
public Double getValue() { return value; }
public void setValue(Double value) { this.value=value; }
}
