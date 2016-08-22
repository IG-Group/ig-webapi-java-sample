package com.iggroup.webapi.samples.client.rest.dto.prices.getPricesV3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Response metadata data.
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Metadata {

/*
Historical price data allowance
*/
private Allowance allowance;

public Allowance getAllowance() { return allowance; }
public void setAllowance(Allowance allowance) { this.allowance=allowance; }
}
