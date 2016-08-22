package com.iggroup.webapi.samples.client.rest.dto.markets.getMarketDetailsListV2;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Market snapshot data
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Snapshot {

/*
Market status
*/
private MarketStatus marketStatus;

/*
Net price change on the day
*/
private BigDecimal netChange;

/*
Percentage price change on the day
*/
private BigDecimal percentageChange;

/*
Time of last price update
*/
private String updateTime;

/*
Price delay
*/
private Integer delayTime;

/*
Bid price
*/
private BigDecimal bid;

/*
Offer price
*/
private BigDecimal offer;

/*
Highest price on the day
*/
private BigDecimal high;

/*
Lowest price on the day
*/
private BigDecimal low;

/*
Binary odds
*/
private BigDecimal binaryOdds;

/*
Number of decimal positions for market levels
*/
private Integer decimalPlacesFactor;

/*
Multiplying factor to determine actual pip value for the levels used by the instrument
*/
private Integer scalingFactor;

/*
the number of points to add on each side of the market as an additional spread when
 placing a guaranteed stop trade.
*/
private BigDecimal controlledRiskExtraSpread;

public MarketStatus getMarketStatus() { return marketStatus; }
public void setMarketStatus(MarketStatus marketStatus) { this.marketStatus=marketStatus; }
public BigDecimal getNetChange() { return netChange; }
public void setNetChange(BigDecimal netChange) { this.netChange=netChange; }
public BigDecimal getPercentageChange() { return percentageChange; }
public void setPercentageChange(BigDecimal percentageChange) { this.percentageChange=percentageChange; }
public String getUpdateTime() { return updateTime; }
public void setUpdateTime(String updateTime) { this.updateTime=updateTime; }
public Integer getDelayTime() { return delayTime; }
public void setDelayTime(Integer delayTime) { this.delayTime=delayTime; }
public BigDecimal getBid() { return bid; }
public void setBid(BigDecimal bid) { this.bid=bid; }
public BigDecimal getOffer() { return offer; }
public void setOffer(BigDecimal offer) { this.offer=offer; }
public BigDecimal getHigh() { return high; }
public void setHigh(BigDecimal high) { this.high=high; }
public BigDecimal getLow() { return low; }
public void setLow(BigDecimal low) { this.low=low; }
public BigDecimal getBinaryOdds() { return binaryOdds; }
public void setBinaryOdds(BigDecimal binaryOdds) { this.binaryOdds=binaryOdds; }
public Integer getDecimalPlacesFactor() { return decimalPlacesFactor; }
public void setDecimalPlacesFactor(Integer decimalPlacesFactor) { this.decimalPlacesFactor=decimalPlacesFactor; }
public Integer getScalingFactor() { return scalingFactor; }
public void setScalingFactor(Integer scalingFactor) { this.scalingFactor=scalingFactor; }
public BigDecimal getControlledRiskExtraSpread() { return controlledRiskExtraSpread; }
public void setControlledRiskExtraSpread(BigDecimal controlledRiskExtraSpread) { this.controlledRiskExtraSpread=controlledRiskExtraSpread; }
}
