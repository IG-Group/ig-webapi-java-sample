package com.iggroup.webapi.samples.client.rest.dto.positions.sprintmarkets.createSprintMarketPositionV1;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Create sprint market position request.
 A request will be executed as a market order based on the current trade odds and strike level.
 An indicative payout amount (payout = premium / odds) can be evaluated by obtaining the binary odds ratio
 from the market details endpoint prior to placing an order.
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateSprintMarketPositionV1Request {

/*
A user-defined reference identifying the submission of the order
*/
private String dealReference;

/*
Instrument epic identifier
*/
private String epic;

/*
Deal direction
*/
private Direction direction;

/*
Deal size
*/
private BigDecimal size;

/*
Expiry period
*/
private ExpiryPeriod expiryPeriod;

public String getDealReference() { return dealReference; }
public void setDealReference(String dealReference) { this.dealReference=dealReference; }
public String getEpic() { return epic; }
public void setEpic(String epic) { this.epic=epic; }
public Direction getDirection() { return direction; }
public void setDirection(Direction direction) { this.direction=direction; }
public BigDecimal getSize() { return size; }
public void setSize(BigDecimal size) { this.size=size; }
public ExpiryPeriod getExpiryPeriod() { return expiryPeriod; }
public void setExpiryPeriod(ExpiryPeriod expiryPeriod) { this.expiryPeriod=expiryPeriod; }
}
