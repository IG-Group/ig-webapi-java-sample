package com.iggroup.webapi.samples.client.rest.dto.workingorders.getWorkingOrdersV1;

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
private BigDecimal size;

/*
Price at which to execute the trade
*/
private BigDecimal level;

/*
Working order expiry date and time. If set, format is dd/MM/yy HH:mm
*/
private String goodTill;

/*
Date and time when the order was created. Format is yyyy/MM/dd kk:mm:ss:SSS
*/
private String createdDate;

/*
True if controlled risk
*/
private Boolean controlledRisk;

/*
Trailing trigger increment
*/
private BigDecimal trailingTriggerIncrement;

/*
Trailing stop distance
*/
private BigDecimal trailingTriggerDistance;

/*
Trailing stop distance
*/
private BigDecimal trailingStopDistance;

/*
Trailing stop increment
*/
private BigDecimal trailingStopIncrement;

/*
Request type
*/
private RequestType requestType;

/*
Stop level
*/
private BigDecimal contingentStop;

/*
Currency ISO code
*/
private String currencyCode;

/*
Limit level
*/
private BigDecimal contingentLimit;

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
public BigDecimal getSize() { return size; }
public void setSize(BigDecimal size) { this.size=size; }
public BigDecimal getLevel() { return level; }
public void setLevel(BigDecimal level) { this.level=level; }
public String getGoodTill() { return goodTill; }
public void setGoodTill(String goodTill) { this.goodTill=goodTill; }
public String getCreatedDate() { return createdDate; }
public void setCreatedDate(String createdDate) { this.createdDate=createdDate; }
public Boolean getControlledRisk() { return controlledRisk; }
public void setControlledRisk(Boolean controlledRisk) { this.controlledRisk=controlledRisk; }
public BigDecimal getTrailingTriggerIncrement() { return trailingTriggerIncrement; }
public void setTrailingTriggerIncrement(BigDecimal trailingTriggerIncrement) { this.trailingTriggerIncrement=trailingTriggerIncrement; }
public BigDecimal getTrailingTriggerDistance() { return trailingTriggerDistance; }
public void setTrailingTriggerDistance(BigDecimal trailingTriggerDistance) { this.trailingTriggerDistance=trailingTriggerDistance; }
public BigDecimal getTrailingStopDistance() { return trailingStopDistance; }
public void setTrailingStopDistance(BigDecimal trailingStopDistance) { this.trailingStopDistance=trailingStopDistance; }
public BigDecimal getTrailingStopIncrement() { return trailingStopIncrement; }
public void setTrailingStopIncrement(BigDecimal trailingStopIncrement) { this.trailingStopIncrement=trailingStopIncrement; }
public RequestType getRequestType() { return requestType; }
public void setRequestType(RequestType requestType) { this.requestType=requestType; }
public BigDecimal getContingentStop() { return contingentStop; }
public void setContingentStop(BigDecimal contingentStop) { this.contingentStop=contingentStop; }
public String getCurrencyCode() { return currencyCode; }
public void setCurrencyCode(String currencyCode) { this.currencyCode=currencyCode; }
public BigDecimal getContingentLimit() { return contingentLimit; }
public void setContingentLimit(BigDecimal contingentLimit) { this.contingentLimit=contingentLimit; }
public Boolean getDma() { return dma; }
public void setDma(Boolean dma) { this.dma=dma; }
}
