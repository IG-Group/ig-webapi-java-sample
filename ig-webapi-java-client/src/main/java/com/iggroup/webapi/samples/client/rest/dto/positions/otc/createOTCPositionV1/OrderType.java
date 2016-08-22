package com.iggroup.webapi.samples.client.rest.dto.positions.otc.createOTCPositionV1;
/*
Describes the order level model to be used for a position operation
*/
public enum OrderType {

/*
Limit orders get executed at the price seen by IG at the moment of booking a trade. A limit determines the level
 at which the order or the remainder of the order will be rejected.
*/
LIMIT,
/*
Market orders get executed at the price seen by the IG at the time of booking the trade.
 A level cannot be specified. Not applicable to BINARY instruments
*/
MARKET,
/*
Quote orders get executed at the specified level.
 The level has to be accompanied by a valid quote id. This type is only available subject to agreement with IG.
*/
QUOTE
}
