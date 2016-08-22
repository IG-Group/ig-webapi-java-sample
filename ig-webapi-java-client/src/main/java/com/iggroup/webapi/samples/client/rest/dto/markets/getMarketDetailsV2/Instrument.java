package com.iggroup.webapi.samples.client.rest.dto.markets.getMarketDetailsV2;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Instrument details
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Instrument {

/*
Instrument identifier
*/
private String epic;

/*
Expiry
*/
private String expiry;

/*
Name
*/
private String name;

/*
True if force open is allowed
*/
private Boolean forceOpenAllowed;

/*
True if stops and limits are allowed
*/
private Boolean stopsLimitsAllowed;

/*
Lot size
*/
private Double lotSize;

/*
Unit
*/
private InstrumentUnitType unit;

/*
Type
*/
private Type type;

/*
True if controlled risk trades are allowed
*/
private Boolean controlledRiskAllowed;

/*
True if streaming prices are available, i.e. the market is open and the client has appropriate permissions
*/
private Boolean streamingPricesAvailable;

/*
Market identifier
*/
private String marketId;

/*
Available currencies
*/
private java.util.List<CurrenciesItem> currencies;

/*
For sprint markets only, the minimum value to be specified as the expiry of a sprint markets trade
*/
private Integer sprintMarketsMinimumExpiryTime;

/*
For sprint markets only, the maximum value to be specified as the expiry of a sprint markets trade
*/
private Integer sprintMarketsMaximumExpiryTime;

/*
Margin deposit requirement bands
*/
private java.util.List<MarginDepositBandsItem> marginDepositBands;

/*
margin requirement factor
*/
private BigDecimal marginFactor;

/*
size unit for the margin requirements
*/
private MarginFactorUnit marginFactorUnit;

/*
Slippage factor
*/
private SlippageFactor slippageFactor;

/*
Opening hours
*/
private OpeningHours openingHours;

/*
Expiry details
*/
private ExpiryDetails expiryDetails;

/*
Rollover details
*/
private RolloverDetails rolloverDetails;

/*
Reuters news code
*/
private String newsCode;

/*
Chart code
*/
private String chartCode;

/*
Country
*/
private String country;

/*
Value of one pip
*/
private String valueOfOnePip;

/*
Meaning of one pip
*/
private String onePipMeans;

/*
Contract size
*/
private String contractSize;

/*
List of special information notices
*/
private java.util.List<String> specialInfo;

public String getEpic() { return epic; }
public void setEpic(String epic) { this.epic=epic; }
public String getExpiry() { return expiry; }
public void setExpiry(String expiry) { this.expiry=expiry; }
public String getName() { return name; }
public void setName(String name) { this.name=name; }
public Boolean getForceOpenAllowed() { return forceOpenAllowed; }
public void setForceOpenAllowed(Boolean forceOpenAllowed) { this.forceOpenAllowed=forceOpenAllowed; }
public Boolean getStopsLimitsAllowed() { return stopsLimitsAllowed; }
public void setStopsLimitsAllowed(Boolean stopsLimitsAllowed) { this.stopsLimitsAllowed=stopsLimitsAllowed; }
public Double getLotSize() { return lotSize; }
public void setLotSize(Double lotSize) { this.lotSize=lotSize; }
public InstrumentUnitType getUnit() { return unit; }
public void setUnit(InstrumentUnitType unit) { this.unit=unit; }
public Type getType() { return type; }
public void setType(Type type) { this.type=type; }
public Boolean getControlledRiskAllowed() { return controlledRiskAllowed; }
public void setControlledRiskAllowed(Boolean controlledRiskAllowed) { this.controlledRiskAllowed=controlledRiskAllowed; }
public Boolean getStreamingPricesAvailable() { return streamingPricesAvailable; }
public void setStreamingPricesAvailable(Boolean streamingPricesAvailable) { this.streamingPricesAvailable=streamingPricesAvailable; }
public String getMarketId() { return marketId; }
public void setMarketId(String marketId) { this.marketId=marketId; }
public java.util.List<CurrenciesItem> getCurrencies() { return currencies; }
public void setCurrencies(java.util.List<CurrenciesItem> currencies) { this.currencies=currencies; }
public Integer getSprintMarketsMinimumExpiryTime() { return sprintMarketsMinimumExpiryTime; }
public void setSprintMarketsMinimumExpiryTime(Integer sprintMarketsMinimumExpiryTime) { this.sprintMarketsMinimumExpiryTime=sprintMarketsMinimumExpiryTime; }
public Integer getSprintMarketsMaximumExpiryTime() { return sprintMarketsMaximumExpiryTime; }
public void setSprintMarketsMaximumExpiryTime(Integer sprintMarketsMaximumExpiryTime) { this.sprintMarketsMaximumExpiryTime=sprintMarketsMaximumExpiryTime; }
public java.util.List<MarginDepositBandsItem> getMarginDepositBands() { return marginDepositBands; }
public void setMarginDepositBands(java.util.List<MarginDepositBandsItem> marginDepositBands) { this.marginDepositBands=marginDepositBands; }
public BigDecimal getMarginFactor() { return marginFactor; }
public void setMarginFactor(BigDecimal marginFactor) { this.marginFactor=marginFactor; }
public MarginFactorUnit getMarginFactorUnit() { return marginFactorUnit; }
public void setMarginFactorUnit(MarginFactorUnit marginFactorUnit) { this.marginFactorUnit=marginFactorUnit; }
public SlippageFactor getSlippageFactor() { return slippageFactor; }
public void setSlippageFactor(SlippageFactor slippageFactor) { this.slippageFactor=slippageFactor; }
public OpeningHours getOpeningHours() { return openingHours; }
public void setOpeningHours(OpeningHours openingHours) { this.openingHours=openingHours; }
public ExpiryDetails getExpiryDetails() { return expiryDetails; }
public void setExpiryDetails(ExpiryDetails expiryDetails) { this.expiryDetails=expiryDetails; }
public RolloverDetails getRolloverDetails() { return rolloverDetails; }
public void setRolloverDetails(RolloverDetails rolloverDetails) { this.rolloverDetails=rolloverDetails; }
public String getNewsCode() { return newsCode; }
public void setNewsCode(String newsCode) { this.newsCode=newsCode; }
public String getChartCode() { return chartCode; }
public void setChartCode(String chartCode) { this.chartCode=chartCode; }
public String getCountry() { return country; }
public void setCountry(String country) { this.country=country; }
public String getValueOfOnePip() { return valueOfOnePip; }
public void setValueOfOnePip(String valueOfOnePip) { this.valueOfOnePip=valueOfOnePip; }
public String getOnePipMeans() { return onePipMeans; }
public void setOnePipMeans(String onePipMeans) { this.onePipMeans=onePipMeans; }
public String getContractSize() { return contractSize; }
public void setContractSize(String contractSize) { this.contractSize=contractSize; }
public java.util.List<String> getSpecialInfo() { return specialInfo; }
public void setSpecialInfo(java.util.List<String> specialInfo) { this.specialInfo=specialInfo; }
}
