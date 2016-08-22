package com.iggroup.webapi.samples.client.rest.dto.getDealConfirmationV1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Affected deal
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class AffectedDealsItem {

/*
Deal identifier
*/
private String dealId;

/*
Deal status
*/
private AffectedDealStatus status;

public String getDealId() { return dealId; }
public void setDealId(String dealId) { this.dealId=dealId; }
public AffectedDealStatus getStatus() { return status; }
public void setStatus(AffectedDealStatus status) { this.status=status; }
}
