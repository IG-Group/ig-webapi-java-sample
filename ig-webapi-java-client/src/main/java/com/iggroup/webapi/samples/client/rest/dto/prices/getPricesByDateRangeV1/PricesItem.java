package com.iggroup.webapi.samples.client.rest.dto.prices.getPricesByDateRangeV1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Historical market price snapshot
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class PricesItem {

/*
Snapshot time
*/
private String snapshotTime;

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
Last traded volume. This will generally be 0 for non exchange-traded instruments
*/
private Long lastTradedVolume;

public String getSnapshotTime() { return snapshotTime; }
public void setSnapshotTime(String snapshotTime) { this.snapshotTime=snapshotTime; }
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
