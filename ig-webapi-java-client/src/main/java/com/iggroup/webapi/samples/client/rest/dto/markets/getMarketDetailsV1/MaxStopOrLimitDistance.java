package com.iggroup.webapi.samples.client.rest.dto.markets.getMarketDetailsV1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Dealing rule
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MaxStopOrLimitDistance {

/*
Unit
*/
private DealingRuleUnit unit;

/*
Value
*/
private Double value;

public DealingRuleUnit getUnit() { return unit; }
public void setUnit(DealingRuleUnit unit) { this.unit=unit; }
public Double getValue() { return value; }
public void setValue(Double value) { this.value=value; }
}
