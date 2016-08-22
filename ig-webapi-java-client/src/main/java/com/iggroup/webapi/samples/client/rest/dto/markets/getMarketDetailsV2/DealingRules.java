package com.iggroup.webapi.samples.client.rest.dto.markets.getMarketDetailsV2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Dealing rules
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class DealingRules {

/*
Minimum step distance
*/
private MinStepDistance minStepDistance;

/*
Minimum deal size
*/
private MinDealSize minDealSize;

/*
Minimum controlled risk stop distance
*/
private MinControlledRiskStopDistance minControlledRiskStopDistance;

/*
Minimum stop or limit distance
*/
private MinNormalStopOrLimitDistance minNormalStopOrLimitDistance;

/*
Maximum stop or limit distance
*/
private MaxStopOrLimitDistance maxStopOrLimitDistance;

/*
The client's market order preference for creating or closing positions.
 This should be ignored when editing positions and when creating, editing and deleting working orders.
*/
private MarketOrderPreference marketOrderPreference;

/*
determines whether the user is allowed to set trailing stops for this particular market
*/
private TrailingStopsPreference trailingStopsPreference;

public MinStepDistance getMinStepDistance() { return minStepDistance; }
public void setMinStepDistance(MinStepDistance minStepDistance) { this.minStepDistance=minStepDistance; }
public MinDealSize getMinDealSize() { return minDealSize; }
public void setMinDealSize(MinDealSize minDealSize) { this.minDealSize=minDealSize; }
public MinControlledRiskStopDistance getMinControlledRiskStopDistance() { return minControlledRiskStopDistance; }
public void setMinControlledRiskStopDistance(MinControlledRiskStopDistance minControlledRiskStopDistance) { this.minControlledRiskStopDistance=minControlledRiskStopDistance; }
public MinNormalStopOrLimitDistance getMinNormalStopOrLimitDistance() { return minNormalStopOrLimitDistance; }
public void setMinNormalStopOrLimitDistance(MinNormalStopOrLimitDistance minNormalStopOrLimitDistance) { this.minNormalStopOrLimitDistance=minNormalStopOrLimitDistance; }
public MaxStopOrLimitDistance getMaxStopOrLimitDistance() { return maxStopOrLimitDistance; }
public void setMaxStopOrLimitDistance(MaxStopOrLimitDistance maxStopOrLimitDistance) { this.maxStopOrLimitDistance=maxStopOrLimitDistance; }
public MarketOrderPreference getMarketOrderPreference() { return marketOrderPreference; }
public void setMarketOrderPreference(MarketOrderPreference marketOrderPreference) { this.marketOrderPreference=marketOrderPreference; }
public TrailingStopsPreference getTrailingStopsPreference() { return trailingStopsPreference; }
public void setTrailingStopsPreference(TrailingStopsPreference trailingStopsPreference) { this.trailingStopsPreference=trailingStopsPreference; }
}
