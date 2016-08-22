package com.iggroup.webapi.samples.client.rest.dto.positions.otc.closeOTCPositionV1;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Close position request data
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class CloseOTCPositionV1Request {

/*
Deal identifier
*/
private String dealId;

/*
Instrument epic identifier
*/
private String epic;

/*
Instrument expiry
*/
private String expiry;

/*
Deal direction
*/
private Direction direction;

/*
Deal size
*/
private BigDecimal size;

/*
Closing deal level
*/
private BigDecimal level;

/*
Order type
*/
private OrderType orderType;

/*
Time in force - defaults to Fill or Kill
*/
private TimeInForce timeInForce;

/*
Lightstreamer price quote identifier
*/
private String quoteId;

public String getDealId() { return dealId; }
public void setDealId(String dealId) { this.dealId=dealId; }
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
public OrderType getOrderType() { return orderType; }
public void setOrderType(OrderType orderType) { this.orderType=orderType; }
public TimeInForce getTimeInForce() { return timeInForce; }
public void setTimeInForce(TimeInForce timeInForce) { this.timeInForce=timeInForce; }
public String getQuoteId() { return quoteId; }
public void setQuoteId(String quoteId) { this.quoteId=quoteId; }
}
