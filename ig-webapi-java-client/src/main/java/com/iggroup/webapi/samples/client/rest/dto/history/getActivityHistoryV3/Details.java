package com.iggroup.webapi.samples.client.rest.dto.history.getActivityHistoryV3;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Activity details
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Details {

/*
Deal reference
*/
private String dealReference;

/*
Actions
*/
private java.util.List<ActionsItem> actions;

/*
Market name
*/
private String marketName;

/*
Good till date
*/
private String goodTillDate;

/*
Currency
*/
private String currency;

/*
Size
*/
private BigDecimal size;

/*
Direction
*/
private Direction direction;

/*
Level
*/
private BigDecimal level;

/*
Stop level
*/
private BigDecimal stopLevel;

/*
Stop distance
*/
private BigDecimal stopDistance;

/*
Guaranteed stop
*/
private boolean guaranteedStop;

/*
Trailing stop distance
*/
private BigDecimal trailingStopDistance;

/*
Trailing step size
*/
private BigDecimal trailingStep;

/*
Limit level
*/
private BigDecimal limitLevel;

/*
Limit distance
*/
private BigDecimal limitDistance;

public String getDealReference() { return dealReference; }
public void setDealReference(String dealReference) { this.dealReference=dealReference; }
public java.util.List<ActionsItem> getActions() { return actions; }
public void setActions(java.util.List<ActionsItem> actions) { this.actions=actions; }
public String getMarketName() { return marketName; }
public void setMarketName(String marketName) { this.marketName=marketName; }
public String getGoodTillDate() { return goodTillDate; }
public void setGoodTillDate(String goodTillDate) { this.goodTillDate=goodTillDate; }
public String getCurrency() { return currency; }
public void setCurrency(String currency) { this.currency=currency; }
public BigDecimal getSize() { return size; }
public void setSize(BigDecimal size) { this.size=size; }
public Direction getDirection() { return direction; }
public void setDirection(Direction direction) { this.direction=direction; }
public BigDecimal getLevel() { return level; }
public void setLevel(BigDecimal level) { this.level=level; }
public BigDecimal getStopLevel() { return stopLevel; }
public void setStopLevel(BigDecimal stopLevel) { this.stopLevel=stopLevel; }
public BigDecimal getStopDistance() { return stopDistance; }
public void setStopDistance(BigDecimal stopDistance) { this.stopDistance=stopDistance; }
public boolean getGuaranteedStop() { return guaranteedStop; }
public void setGuaranteedStop(boolean guaranteedStop) { this.guaranteedStop=guaranteedStop; }
public BigDecimal getTrailingStopDistance() { return trailingStopDistance; }
public void setTrailingStopDistance(BigDecimal trailingStopDistance) { this.trailingStopDistance=trailingStopDistance; }
public BigDecimal getTrailingStep() { return trailingStep; }
public void setTrailingStep(BigDecimal trailingStep) { this.trailingStep=trailingStep; }
public BigDecimal getLimitLevel() { return limitLevel; }
public void setLimitLevel(BigDecimal limitLevel) { this.limitLevel=limitLevel; }
public BigDecimal getLimitDistance() { return limitDistance; }
public void setLimitDistance(BigDecimal limitDistance) { this.limitDistance=limitDistance; }
}
