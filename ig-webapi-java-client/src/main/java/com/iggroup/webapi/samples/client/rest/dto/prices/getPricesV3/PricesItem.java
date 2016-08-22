package com.iggroup.webapi.samples.client.rest.dto.prices.getPricesV3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Historical market price snapshot
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class PricesItem {

/*
Snapshot local time, format is yyyy/MM/dd hh:mm:ss
*/
private String snapshotTime;

/*
Snapshot time
*/
private String snapshotTimeUTC;

/*
Open price
*/
private OpenPrice openPrice;

/*
Close price
*/
private ClosePrice closePrice;

/*
High price
*/
private HighPrice highPrice;

/*
Low price
*/
private LowPrice lowPrice;

/*
Last traded volume. This will generally be null for non exchange-traded instruments
*/
private Long lastTradedVolume;

public String getSnapshotTime() { return snapshotTime; }
public void setSnapshotTime(String snapshotTime) { this.snapshotTime=snapshotTime; }
public String getSnapshotTimeUTC() { return snapshotTimeUTC; }
public void setSnapshotTimeUTC(String snapshotTimeUTC) { this.snapshotTimeUTC=snapshotTimeUTC; }
public OpenPrice getOpenPrice() { return openPrice; }
public void setOpenPrice(OpenPrice openPrice) { this.openPrice=openPrice; }
public ClosePrice getClosePrice() { return closePrice; }
public void setClosePrice(ClosePrice closePrice) { this.closePrice=closePrice; }
public HighPrice getHighPrice() { return highPrice; }
public void setHighPrice(HighPrice highPrice) { this.highPrice=highPrice; }
public LowPrice getLowPrice() { return lowPrice; }
public void setLowPrice(LowPrice lowPrice) { this.lowPrice=lowPrice; }
public Long getLastTradedVolume() { return lastTradedVolume; }
public void setLastTradedVolume(Long lastTradedVolume) { this.lastTradedVolume=lastTradedVolume; }
}
