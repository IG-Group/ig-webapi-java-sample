package com.iggroup.webapi.samples.client.rest.dto.workingorders.getWorkingOrdersV2;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Working order data
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkingOrderData {

/*
Deal identifier
*/
private String dealId;

/*
Deal direction
*/
private Direction direction;

/*
Instrument epic identifier
*/
private String epic;

/*
Order size
*/
private BigDecimal orderSize;

/*
Price at which to execute the trade
*/
private BigDecimal orderLevel;

/*
Time in force for this order
*/
private TimeInForce timeInForce;

/*
The date and time the working order will be deleted if not triggered till then.
 Date format is yyyy/MM/dd hh:mm
*/
private String goodTillDate;

/*
The date and time the working order will be deleted if not triggered till then.
*/
private String goodTillDateISO;

/*
Local date and time when the order was created. Format is yyyy/MM/dd kk:mm:ss:SSS
*/
private String createdDate;

/*
Date and time when the order was created.
*/
private String createdDateUTC;

/*
True if controlled risk
*/
private Boolean guaranteedStop;

/*
Request type
*/
private OrderType orderType;

/*
Stop distance
*/
private BigDecimal stopDistance;

/*
Limit distance
*/
private BigDecimal limitDistance;

/*
Currency ISO code
*/
private String currencyCode;

/*
True if this is a DMA working order
*/
private Boolean dma;

public String getDealId() { return dealId; }
public void setDealId(String dealId) { this.dealId=dealId; }
public Direction getDirection() { return direction; }
public void setDirection(Direction direction) { this.direction=direction; }
public String getEpic() { return epic; }
public void setEpic(String epic) { this.epic=epic; }
public BigDecimal getOrderSize() { return orderSize; }
public void setOrderSize(BigDecimal orderSize) { this.orderSize=orderSize; }
public BigDecimal getOrderLevel() { return orderLevel; }
public void setOrderLevel(BigDecimal orderLevel) { this.orderLevel=orderLevel; }
public TimeInForce getTimeInForce() { return timeInForce; }
public void setTimeInForce(TimeInForce timeInForce) { this.timeInForce=timeInForce; }
public String getGoodTillDate() { return goodTillDate; }
public void setGoodTillDate(String goodTillDate) { this.goodTillDate=goodTillDate; }
public String getGoodTillDateISO() { return goodTillDateISO; }
public void setGoodTillDateISO(String goodTillDateISO) { this.goodTillDateISO=goodTillDateISO; }
public String getCreatedDate() { return createdDate; }
public void setCreatedDate(String createdDate) { this.createdDate=createdDate; }
public String getCreatedDateUTC() { return createdDateUTC; }
public void setCreatedDateUTC(String createdDateUTC) { this.createdDateUTC=createdDateUTC; }
public Boolean getGuaranteedStop() { return guaranteedStop; }
public void setGuaranteedStop(Boolean guaranteedStop) { this.guaranteedStop=guaranteedStop; }
public OrderType getOrderType() { return orderType; }
public void setOrderType(OrderType orderType) { this.orderType=orderType; }
public BigDecimal getStopDistance() { return stopDistance; }
public void setStopDistance(BigDecimal stopDistance) { this.stopDistance=stopDistance; }
public BigDecimal getLimitDistance() { return limitDistance; }
public void setLimitDistance(BigDecimal limitDistance) { this.limitDistance=limitDistance; }
public String getCurrencyCode() { return currencyCode; }
public void setCurrencyCode(String currencyCode) { this.currencyCode=currencyCode; }
public Boolean getDma() { return dma; }
public void setDma(Boolean dma) { this.dma=dma; }
}
