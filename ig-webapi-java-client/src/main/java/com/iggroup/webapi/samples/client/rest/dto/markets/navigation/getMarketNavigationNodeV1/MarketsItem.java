package com.iggroup.webapi.samples.client.rest.dto.markets.navigation.getMarketNavigationNodeV1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Market data
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketsItem {

/*
Price delay time in minutes
*/
private Integer delayTime;

/*
Instrument epic identifier
*/
private String epic;

/*
Price net change
*/
private Float netChange;

/*
Instrument lot size
*/
private Integer lotSize;

/*
Instrument expiry period
*/
private String expiry;

/*
Instrument type
*/
private InstrumentType instrumentType;

/*
Instrument name
*/
private String instrumentName;

/*
Highest price of the day
*/
private Float high;

/*
Lowest price of the day
*/
private Float low;

/*
Percentage price change on the day
*/
private Float percentageChange;

/*
Local time of last price update (milliseconds since epoch)
*/
private String updateTime;

/*
Time of last price update
*/
private String updateTimeUTC;

/*
Bid price
*/
private Float bid;

/*
Offer price
*/
private Float offer;

/*
True if OTC tradeable
*/
private Boolean otcTradeable;

/*
True if streaming prices are available, i.e. the market is tradeable and the client holds the necessary access permissions
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

public Integer getDelayTime() { return delayTime; }
public void setDelayTime(Integer delayTime) { this.delayTime=delayTime; }
public String getEpic() { return epic; }
public void setEpic(String epic) { this.epic=epic; }
public Float getNetChange() { return netChange; }
public void setNetChange(Float netChange) { this.netChange=netChange; }
public Integer getLotSize() { return lotSize; }
public void setLotSize(Integer lotSize) { this.lotSize=lotSize; }
public String getExpiry() { return expiry; }
public void setExpiry(String expiry) { this.expiry=expiry; }
public InstrumentType getInstrumentType() { return instrumentType; }
public void setInstrumentType(InstrumentType instrumentType) { this.instrumentType=instrumentType; }
public String getInstrumentName() { return instrumentName; }
public void setInstrumentName(String instrumentName) { this.instrumentName=instrumentName; }
public Float getHigh() { return high; }
public void setHigh(Float high) { this.high=high; }
public Float getLow() { return low; }
public void setLow(Float low) { this.low=low; }
public Float getPercentageChange() { return percentageChange; }
public void setPercentageChange(Float percentageChange) { this.percentageChange=percentageChange; }
public String getUpdateTime() { return updateTime; }
public void setUpdateTime(String updateTime) { this.updateTime=updateTime; }
public String getUpdateTimeUTC() { return updateTimeUTC; }
public void setUpdateTimeUTC(String updateTimeUTC) { this.updateTimeUTC=updateTimeUTC; }
public Float getBid() { return bid; }
public void setBid(Float bid) { this.bid=bid; }
public Float getOffer() { return offer; }
public void setOffer(Float offer) { this.offer=offer; }
public Boolean getOtcTradeable() { return otcTradeable; }
public void setOtcTradeable(Boolean otcTradeable) { this.otcTradeable=otcTradeable; }
public Boolean getStreamingPricesAvailable() { return streamingPricesAvailable; }
public void setStreamingPricesAvailable(Boolean streamingPricesAvailable) { this.streamingPricesAvailable=streamingPricesAvailable; }
public MarketStatus getMarketStatus() { return marketStatus; }
public void setMarketStatus(MarketStatus marketStatus) { this.marketStatus=marketStatus; }
public Integer getScalingFactor() { return scalingFactor; }
public void setScalingFactor(Integer scalingFactor) { this.scalingFactor=scalingFactor; }
}
