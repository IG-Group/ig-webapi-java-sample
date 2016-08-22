package com.iggroup.webapi.samples.client.rest.dto.markets.getMarketDetailsListV1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*

*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketDetailsItem {

/*
Instrument data
*/
private Instrument instrument;

/*
Dealing rule data
*/
private DealingRules dealingRules;

/*
Market snapshot data
*/
private Snapshot snapshot;

public Instrument getInstrument() { return instrument; }
public void setInstrument(Instrument instrument) { this.instrument=instrument; }
public DealingRules getDealingRules() { return dealingRules; }
public void setDealingRules(DealingRules dealingRules) { this.dealingRules=dealingRules; }
public Snapshot getSnapshot() { return snapshot; }
public void setSnapshot(Snapshot snapshot) { this.snapshot=snapshot; }
}
