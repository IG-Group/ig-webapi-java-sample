package com.iggroup.webapi.samples.client.rest.dto.markets.getMarketDetailsV2;
/*
Client's market order trading preference
*/
public enum MarketOrderPreference {

/*
Market orders are allowed for the account type and instrument, and the user has enabled market orders in their preferences but decided the default state is off.
*/
AVAILABLE_DEFAULT_OFF,
/*
Market orders are allowed for the account type and instrument, and the user has enabled market orders in their preferences and has decided the default state is on.
*/
AVAILABLE_DEFAULT_ON,
/*
Market orders are not allowed for the current site and/or instrument
*/
NOT_AVAILABLE
}
