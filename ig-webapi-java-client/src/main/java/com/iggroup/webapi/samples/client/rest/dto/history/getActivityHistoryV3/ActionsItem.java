package com.iggroup.webapi.samples.client.rest.dto.history.getActivityHistoryV3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Deal affected by an activity
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActionsItem {

/*
Action type
*/
private ActionType actionType;

/*
Affected deal id
*/
private String affectedDealId;

public ActionType getActionType() { return actionType; }
public void setActionType(ActionType actionType) { this.actionType=actionType; }
public String getAffectedDealId() { return affectedDealId; }
public void setAffectedDealId(String affectedDealId) { this.affectedDealId=affectedDealId; }
}
