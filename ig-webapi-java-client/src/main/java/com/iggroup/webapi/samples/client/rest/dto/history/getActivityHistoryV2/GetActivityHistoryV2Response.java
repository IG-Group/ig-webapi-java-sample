package com.iggroup.webapi.samples.client.rest.dto.history.getActivityHistoryV2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*

*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetActivityHistoryV2Response {

/*
List of activities
*/
private java.util.List<ActivitiesItem> activities;

/*
Metadata
*/
private Metadata metadata;

public java.util.List<ActivitiesItem> getActivities() { return activities; }
public void setActivities(java.util.List<ActivitiesItem> activities) { this.activities=activities; }
public Metadata getMetadata() { return metadata; }
public void setMetadata(Metadata metadata) { this.metadata=metadata; }
}
