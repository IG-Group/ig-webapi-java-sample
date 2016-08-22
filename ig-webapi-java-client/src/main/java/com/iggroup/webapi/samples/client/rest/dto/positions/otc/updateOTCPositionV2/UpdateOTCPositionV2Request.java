package com.iggroup.webapi.samples.client.rest.dto.positions.otc.updateOTCPositionV2;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Edit position request data
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateOTCPositionV2Request {

/*
Stop level
*/
private BigDecimal stopLevel;

/*
Limit level
*/
private BigDecimal limitLevel;

/*
Trailing stop
*/
private Boolean trailingStop;

/*
Trailing stop distance
*/
private BigDecimal trailingStopDistance;

/*
Trailing stop step increment
*/
private BigDecimal trailingStopIncrement;

public BigDecimal getStopLevel() { return stopLevel; }
public void setStopLevel(BigDecimal stopLevel) { this.stopLevel=stopLevel; }
public BigDecimal getLimitLevel() { return limitLevel; }
public void setLimitLevel(BigDecimal limitLevel) { this.limitLevel=limitLevel; }
public Boolean getTrailingStop() { return trailingStop; }
public void setTrailingStop(Boolean trailingStop) { this.trailingStop=trailingStop; }
public BigDecimal getTrailingStopDistance() { return trailingStopDistance; }
public void setTrailingStopDistance(BigDecimal trailingStopDistance) { this.trailingStopDistance=trailingStopDistance; }
public BigDecimal getTrailingStopIncrement() { return trailingStopIncrement; }
public void setTrailingStopIncrement(BigDecimal trailingStopIncrement) { this.trailingStopIncrement=trailingStopIncrement; }
}
