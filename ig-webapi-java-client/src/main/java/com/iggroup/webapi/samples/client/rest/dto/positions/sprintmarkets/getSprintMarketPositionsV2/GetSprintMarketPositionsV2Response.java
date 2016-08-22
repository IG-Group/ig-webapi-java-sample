package com.iggroup.webapi.samples.client.rest.dto.positions.sprintmarkets.getSprintMarketPositionsV2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
A list of sprint market positions
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetSprintMarketPositionsV2Response {

/*
Sprint market positions
*/
private java.util.List<SprintMarketPositionsItem> sprintMarketPositions;

public java.util.List<SprintMarketPositionsItem> getSprintMarketPositions() { return sprintMarketPositions; }
public void setSprintMarketPositions(java.util.List<SprintMarketPositionsItem> sprintMarketPositions) { this.sprintMarketPositions=sprintMarketPositions; }
}
