package com.iggroup.webapi.samples.client.rest.dto.markets.getMarketDetailsListV2;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Market expiry details
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExpiryDetails {

/*
Last dealing date
*/
private String lastDealingDate;

/*
Settlement information
*/
private String settlementInfo;

public String getLastDealingDate() { return lastDealingDate; }
public void setLastDealingDate(String lastDealingDate) { this.lastDealingDate=lastDealingDate; }
public String getSettlementInfo() { return settlementInfo; }
public void setSettlementInfo(String settlementInfo) { this.settlementInfo=settlementInfo; }
}
