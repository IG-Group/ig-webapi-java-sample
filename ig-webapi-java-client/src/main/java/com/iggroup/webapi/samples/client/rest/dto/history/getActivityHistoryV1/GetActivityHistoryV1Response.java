package com.iggroup.webapi.samples.client.rest.dto.history.getActivityHistoryV1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*

*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetActivityHistoryV1Response {

/*
List of activities
*/
private java.util.List<ActivitiesItem> activities;

public java.util.List<ActivitiesItem> getActivities() { return activities; }
public void setActivities(java.util.List<ActivitiesItem> activities) { this.activities=activities; }
}
