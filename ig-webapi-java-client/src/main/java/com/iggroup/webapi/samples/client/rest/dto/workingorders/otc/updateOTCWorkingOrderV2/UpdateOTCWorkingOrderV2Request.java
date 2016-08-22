package com.iggroup.webapi.samples.client.rest.dto.workingorders.otc.updateOTCWorkingOrderV2;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Edit working order request
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateOTCWorkingOrderV2Request {

/*
Time in force type
*/
private TimeInForce timeInForce;

/*
Good till date - This accepts two possible formats either yyyy/mm/dd hh:mm:ss in UTC Time or Unix Timestamp in milliseconds
*/
private String goodTillDate;

/*
Stop level
*/
private BigDecimal stopLevel;

/*
Stop distance
*/
private BigDecimal stopDistance;

/*
Limit level
*/
private BigDecimal limitLevel;

/*
Limit distance
*/
private BigDecimal limitDistance;

/*
Deal type
*/
private Type type;

/*
Limit level
*/
private BigDecimal level;

public TimeInForce getTimeInForce() { return timeInForce; }
public void setTimeInForce(TimeInForce timeInForce) { this.timeInForce=timeInForce; }
public String getGoodTillDate() { return goodTillDate; }
public void setGoodTillDate(String goodTillDate) { this.goodTillDate=goodTillDate; }
public BigDecimal getStopLevel() { return stopLevel; }
public void setStopLevel(BigDecimal stopLevel) { this.stopLevel=stopLevel; }
public BigDecimal getStopDistance() { return stopDistance; }
public void setStopDistance(BigDecimal stopDistance) { this.stopDistance=stopDistance; }
public BigDecimal getLimitLevel() { return limitLevel; }
public void setLimitLevel(BigDecimal limitLevel) { this.limitLevel=limitLevel; }
public BigDecimal getLimitDistance() { return limitDistance; }
public void setLimitDistance(BigDecimal limitDistance) { this.limitDistance=limitDistance; }
public Type getType() { return type; }
public void setType(Type type) { this.type=type; }
public BigDecimal getLevel() { return level; }
public void setLevel(BigDecimal level) { this.level=level; }
}
