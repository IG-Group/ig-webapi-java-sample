package com.iggroup.webapi.samples.client.rest.dto.positions.sprintmarkets.getSprintMarketPositionsV2;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Sprint market position
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class SprintMarketPositionsItem {

/*
Deal identifier
*/
private String dealId;

/*
Instrument epic identifier
*/
private String epic;

/*
Instrument name
*/
private String instrumentName;

/*
Description
*/
private String description;

/*
Market status
*/
private MarketStatus marketStatus;

/*
Date the position was opened
*/
private String createdDate;

/*
Expiry time
*/
private String expiryTime;

/*
Direction
*/
private Direction direction;

/*
Strike price
*/
private BigDecimal strikeLevel;

/*
Size
*/
private BigDecimal size;

/*
Payout amount
*/
private BigDecimal payoutAmount;

/*
Currency of the payout
*/
private String currency;

public String getDealId() { return dealId; }
public void setDealId(String dealId) { this.dealId=dealId; }
public String getEpic() { return epic; }
public void setEpic(String epic) { this.epic=epic; }
public String getInstrumentName() { return instrumentName; }
public void setInstrumentName(String instrumentName) { this.instrumentName=instrumentName; }
public String getDescription() { return description; }
public void setDescription(String description) { this.description=description; }
public MarketStatus getMarketStatus() { return marketStatus; }
public void setMarketStatus(MarketStatus marketStatus) { this.marketStatus=marketStatus; }
public String getCreatedDate() { return createdDate; }
public void setCreatedDate(String createdDate) { this.createdDate=createdDate; }
public String getExpiryTime() { return expiryTime; }
public void setExpiryTime(String expiryTime) { this.expiryTime=expiryTime; }
public Direction getDirection() { return direction; }
public void setDirection(Direction direction) { this.direction=direction; }
public BigDecimal getStrikeLevel() { return strikeLevel; }
public void setStrikeLevel(BigDecimal strikeLevel) { this.strikeLevel=strikeLevel; }
public BigDecimal getSize() { return size; }
public void setSize(BigDecimal size) { this.size=size; }
public BigDecimal getPayoutAmount() { return payoutAmount; }
public void setPayoutAmount(BigDecimal payoutAmount) { this.payoutAmount=payoutAmount; }
public String getCurrency() { return currency; }
public void setCurrency(String currency) { this.currency=currency; }
}
