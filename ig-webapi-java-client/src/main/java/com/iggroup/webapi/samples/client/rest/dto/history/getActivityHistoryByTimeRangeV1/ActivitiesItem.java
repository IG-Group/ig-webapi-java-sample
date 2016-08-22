package com.iggroup.webapi.samples.client.rest.dto.history.getActivityHistoryByTimeRangeV1;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*

*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivitiesItem {

/*
Instrument epic identifier
*/
private String epic;

/*
Deal identifier
*/
private String dealId;

/*
Activity history identifier
*/
private String activityHistoryId;

/*
The date of the activity item in format DD/MM/YY for en_GB locale
*/
private String date;

/*
The time that the activity item occurred, in format hh:mm
*/
private String time;

/*
The high-level activity description, e.g. "Order"
*/
private String activity;

/*
The market name of the activity item, e.g. "FTSE 100"
 This will be much longer for a sprint market, e.g. "FTSE 100 to be below 6598.4 at 12:42:05 on 13/08/13"
*/
private String marketName;

/*
The period of the activity item, e.g. "DFB" or "02-SEP-11".
 This will be the expiry time/date for sprint markets, e.g. "13/08/13 12:42:05"
*/
private String period;

/*
The description of the result of the activity, e.g. "Guaranteed Position opened: KYG46BAQ"
*/
private String result;

/*
The channel the activity occurred on, e.g. "WEB" or "Mobile"
*/
private String channel;

/*
The currency, e.g. a pound symbol.
*/
private String currency;

/*
The size of the activity item, e.g. "+1" OR "-3.85".
 There will be no direction symbol if the activity is for a sprint market
*/
private String size;

/*
The market level that the activity item occurred at, e.g. "5253.5"
*/
private String level;

/*
The stop level of the activity item, if any, e.g. "5233.5" or "-"
*/
private String stop;

/*
The type of stop if applicable to the activity item, either "G" for guaranteed stop, or "N" for
 non-guaranteed stop, or T(50) for a trailing stop of step size 50
*/
private String stopType;

/*
The limit level of the activity item if any, e.g. "5233.5" or "-"
*/
private String limit;

/*
The action status of the activity item. The value of the action status can be any one of these.
 "ACCEPT"  - Manual accept or auto accept.
 "REJECT"  - Manual reject or declined.
 "MANUAL"  - Gone manual and in pending. Cannot determine if accepted or rejected.
 "NOT_SET" - Default value which should have been overwritten by more specific status. Possibly caused by an error in processing by order server.
*/
private String actionStatus;

public String getEpic() { return epic; }
public void setEpic(String epic) { this.epic=epic; }
public String getDealId() { return dealId; }
public void setDealId(String dealId) { this.dealId=dealId; }
public String getActivityHistoryId() { return activityHistoryId; }
public void setActivityHistoryId(String activityHistoryId) { this.activityHistoryId=activityHistoryId; }
public String getDate() { return date; }
public void setDate(String date) { this.date=date; }
public String getTime() { return time; }
public void setTime(String time) { this.time=time; }
public String getActivity() { return activity; }
public void setActivity(String activity) { this.activity=activity; }
public String getMarketName() { return marketName; }
public void setMarketName(String marketName) { this.marketName=marketName; }
public String getPeriod() { return period; }
public void setPeriod(String period) { this.period=period; }
public String getResult() { return result; }
public void setResult(String result) { this.result=result; }
public String getChannel() { return channel; }
public void setChannel(String channel) { this.channel=channel; }
public String getCurrency() { return currency; }
public void setCurrency(String currency) { this.currency=currency; }
public String getSize() { return size; }
public void setSize(String size) { this.size=size; }
public String getLevel() { return level; }
public void setLevel(String level) { this.level=level; }
public String getStop() { return stop; }
public void setStop(String stop) { this.stop=stop; }
public String getStopType() { return stopType; }
public void setStopType(String stopType) { this.stopType=stopType; }
public String getLimit() { return limit; }
public void setLimit(String limit) { this.limit=limit; }
public String getActionStatus() { return actionStatus; }
public void setActionStatus(String actionStatus) { this.actionStatus=actionStatus; }
}
