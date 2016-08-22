package com.iggroup.webapi.samples.client.rest.dto.workingorders.otc.createOTCWorkingOrderV2;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Create working order request
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateOTCWorkingOrderV2Request {

/*
A user-defined reference identifying the submission of the order
*/
private String dealReference;

/*
Instrument epic
*/
private String epic;

/*
Expiry
*/
private String expiry;

/*
Deal direction
*/
private Direction direction;

/*
Order size
*/
private BigDecimal size;

/*
Deal level
*/
private BigDecimal level;

/*
Deal type
*/
private Type type;

/*
Currency.  Restricted to available instrument currencies
*/
private String currencyCode;

/*
Time in force type
*/
private TimeInForce timeInForce;

/*
Good till date - This accepts two possible formats either yyyy/mm/dd hh:mm:ss in UTC Time or Unix Timestamp in milliseconds
*/
private String goodTillDate;

/*
Guaranteed stop
*/
private Boolean guaranteedStop;

/*
Force open
*/
private Boolean forceOpen;

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

public String getDealReference() { return dealReference; }
public void setDealReference(String dealReference) { this.dealReference=dealReference; }
public String getEpic() { return epic; }
public void setEpic(String epic) { this.epic=epic; }
public String getExpiry() { return expiry; }
public void setExpiry(String expiry) { this.expiry=expiry; }
public Direction getDirection() { return direction; }
public void setDirection(Direction direction) { this.direction=direction; }
public BigDecimal getSize() { return size; }
public void setSize(BigDecimal size) { this.size=size; }
public BigDecimal getLevel() { return level; }
public void setLevel(BigDecimal level) { this.level=level; }
public Type getType() { return type; }
public void setType(Type type) { this.type=type; }
public String getCurrencyCode() { return currencyCode; }
public void setCurrencyCode(String currencyCode) { this.currencyCode=currencyCode; }
public TimeInForce getTimeInForce() { return timeInForce; }
public void setTimeInForce(TimeInForce timeInForce) { this.timeInForce=timeInForce; }
public String getGoodTillDate() { return goodTillDate; }
public void setGoodTillDate(String goodTillDate) { this.goodTillDate=goodTillDate; }
public Boolean getGuaranteedStop() { return guaranteedStop; }
public void setGuaranteedStop(Boolean guaranteedStop) { this.guaranteedStop=guaranteedStop; }
public Boolean getForceOpen() { return forceOpen; }
public void setForceOpen(Boolean forceOpen) { this.forceOpen=forceOpen; }
public BigDecimal getStopLevel() { return stopLevel; }
public void setStopLevel(BigDecimal stopLevel) { this.stopLevel=stopLevel; }
public BigDecimal getStopDistance() { return stopDistance; }
public void setStopDistance(BigDecimal stopDistance) { this.stopDistance=stopDistance; }
public BigDecimal getLimitLevel() { return limitLevel; }
public void setLimitLevel(BigDecimal limitLevel) { this.limitLevel=limitLevel; }
public BigDecimal getLimitDistance() { return limitDistance; }
public void setLimitDistance(BigDecimal limitDistance) { this.limitDistance=limitDistance; }
}
