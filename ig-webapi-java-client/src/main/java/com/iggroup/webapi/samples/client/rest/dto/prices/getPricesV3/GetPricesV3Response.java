package com.iggroup.webapi.samples.client.rest.dto.prices.getPricesV3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
List of prices
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetPricesV3Response {

/*
Price list
*/
private java.util.List<PricesItem> prices;

/*
the instrument type of this instrument
*/
private InstrumentType instrumentType;

/*
Metadata
*/
private Metadata metadata;

public java.util.List<PricesItem> getPrices() { return prices; }
public void setPrices(java.util.List<PricesItem> prices) { this.prices=prices; }
public InstrumentType getInstrumentType() { return instrumentType; }
public void setInstrumentType(InstrumentType instrumentType) { this.instrumentType=instrumentType; }
public Metadata getMetadata() { return metadata; }
public void setMetadata(Metadata metadata) { this.metadata=metadata; }
}
