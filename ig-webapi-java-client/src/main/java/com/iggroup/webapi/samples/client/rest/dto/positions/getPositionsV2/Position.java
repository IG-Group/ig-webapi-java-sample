package com.iggroup.webapi.samples.client.rest.dto.positions.getPositionsV2;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Position data
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Position {

/*
Size of the contract
*/
private Float contractSize;

/*
Local date the position was opened
*/
private String createdDate;

/*
Date the position was opened
*/
private String createdDateUTC;

/*
Deal identifier
*/
private String dealId;

/*
Deal size
*/
private BigDecimal size;

/*
Deal direction
*/
private Direction direction;

/*
Limit level
*/
private BigDecimal limitLevel;

/*
Level at which the position was opened
*/
private BigDecimal level;

/*
Position currency ISO code
*/
private String currency;

/*
True if position is risk controlled
*/
private Boolean controlledRisk;

/*
Stop level
*/
private BigDecimal stopLevel;

/*
Trailing step size
*/
private BigDecimal trailingStep;

/*
Trailing stop distance
*/
private BigDecimal trailingStopDistance;

public Float getContractSize() { return contractSize; }
public void setContractSize(Float contractSize) { this.contractSize=contractSize; }
public String getCreatedDate() { return createdDate; }
public void setCreatedDate(String createdDate) { this.createdDate=createdDate; }
public String getCreatedDateUTC() { return createdDateUTC; }
public void setCreatedDateUTC(String createdDateUTC) { this.createdDateUTC=createdDateUTC; }
public String getDealId() { return dealId; }
public void setDealId(String dealId) { this.dealId=dealId; }
public BigDecimal getSize() { return size; }
public void setSize(BigDecimal size) { this.size=size; }
public Direction getDirection() { return direction; }
public void setDirection(Direction direction) { this.direction=direction; }
public BigDecimal getLimitLevel() { return limitLevel; }
public void setLimitLevel(BigDecimal limitLevel) { this.limitLevel=limitLevel; }
public BigDecimal getLevel() { return level; }
public void setLevel(BigDecimal level) { this.level=level; }
public String getCurrency() { return currency; }
public void setCurrency(String currency) { this.currency=currency; }
public Boolean getControlledRisk() { return controlledRisk; }
public void setControlledRisk(Boolean controlledRisk) { this.controlledRisk=controlledRisk; }
public BigDecimal getStopLevel() { return stopLevel; }
public void setStopLevel(BigDecimal stopLevel) { this.stopLevel=stopLevel; }
public BigDecimal getTrailingStep() { return trailingStep; }
public void setTrailingStep(BigDecimal trailingStep) { this.trailingStep=trailingStep; }
public BigDecimal getTrailingStopDistance() { return trailingStopDistance; }
public void setTrailingStopDistance(BigDecimal trailingStopDistance) { this.trailingStopDistance=trailingStopDistance; }
}
