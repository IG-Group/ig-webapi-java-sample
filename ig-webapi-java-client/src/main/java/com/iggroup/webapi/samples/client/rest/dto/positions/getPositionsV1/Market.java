package com.iggroup.webapi.samples.client.rest.dto.positions.getPositionsV1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Market data
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Market {

/*
Instrument name
*/
private String instrumentName;

/*
Instrument expiry period
*/
private String expiry;

/*
Instrument epic identifier
*/
private String epic;

/*
Instrument type
*/
private InstrumentType instrumentType;

/*
Instrument lot size
*/
private Float lotSize;

/*
High price
*/
private Float high;

/*
Low price
*/
private Float low;

/*
Price percentage change
*/
private Float percentageChange;

/*
Price net change
*/
private Float netChange;

/*
Bid
*/
private Float bid;

/*
Offer
*/
private Float offer;

/*
Last instrument price update time
*/
private String updateTime;

/*
Instrument price delay (minutes)
*/
private Integer delayTime;

/*
True if streaming prices are available, i.e. the market is tradeable and the client has appropriate permissions
*/
private Boolean streamingPricesAvailable;

/*
Market status
*/
private MarketStatus marketStatus;

/*
multiplying factor to determine actual pip value for the levels used by the instrument
*/
private Integer scalingFactor;

public String getInstrumentName() { return instrumentName; }
public void setInstrumentName(String instrumentName) { this.instrumentName=instrumentName; }
public String getExpiry() { return expiry; }
public void setExpiry(String expiry) { this.expiry=expiry; }
public String getEpic() { return epic; }
public void setEpic(String epic) { this.epic=epic; }
public InstrumentType getInstrumentType() { return instrumentType; }
public void setInstrumentType(InstrumentType instrumentType) { this.instrumentType=instrumentType; }
public Float getLotSize() { return lotSize; }
public void setLotSize(Float lotSize) { this.lotSize=lotSize; }
public Float getHigh() { return high; }
public void setHigh(Float high) { this.high=high; }
public Float getLow() { return low; }
public void setLow(Float low) { this.low=low; }
public Float getPercentageChange() { return percentageChange; }
public void setPercentageChange(Float percentageChange) { this.percentageChange=percentageChange; }
public Float getNetChange() { return netChange; }
public void setNetChange(Float netChange) { this.netChange=netChange; }
public Float getBid() { return bid; }
public void setBid(Float bid) { this.bid=bid; }
public Float getOffer() { return offer; }
public void setOffer(Float offer) { this.offer=offer; }
public String getUpdateTime() { return updateTime; }
public void setUpdateTime(String updateTime) { this.updateTime=updateTime; }
public Integer getDelayTime() { return delayTime; }
public void setDelayTime(Integer delayTime) { this.delayTime=delayTime; }
public Boolean getStreamingPricesAvailable() { return streamingPricesAvailable; }
public void setStreamingPricesAvailable(Boolean streamingPricesAvailable) { this.streamingPricesAvailable=streamingPricesAvailable; }
public MarketStatus getMarketStatus() { return marketStatus; }
public void setMarketStatus(MarketStatus marketStatus) { this.marketStatus=marketStatus; }
public Integer getScalingFactor() { return scalingFactor; }
public void setScalingFactor(Integer scalingFactor) { this.scalingFactor=scalingFactor; }
}
