package com.iggroup.webapi.samples.client.rest.dto.prices.getPricesByDateRangeV2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
List of prices
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetPricesByDateRangeV2Response {

/*
Price list
*/
private java.util.List<PricesItem> prices;

/*
the instrument type of this instrument
*/
private InstrumentType instrumentType;

/*
Historical price data allowance
*/
private Allowance allowance;

public java.util.List<PricesItem> getPrices() { return prices; }
public void setPrices(java.util.List<PricesItem> prices) { this.prices=prices; }
public InstrumentType getInstrumentType() { return instrumentType; }
public void setInstrumentType(InstrumentType instrumentType) { this.instrumentType=instrumentType; }
public Allowance getAllowance() { return allowance; }
public void setAllowance(Allowance allowance) { this.allowance=allowance; }
}
