package com.iggroup.webapi.samples.client.rest.dto.positions.otc.createOTCPositionV2;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Create position response
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateOTCPositionV2Response {

/*
Deal reference of the transaction
*/
private String dealReference;

public String getDealReference() { return dealReference; }
public void setDealReference(String dealReference) { this.dealReference=dealReference; }
}
