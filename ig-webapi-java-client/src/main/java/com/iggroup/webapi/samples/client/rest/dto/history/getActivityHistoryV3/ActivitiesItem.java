package com.iggroup.webapi.samples.client.rest.dto.history.getActivityHistoryV3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*

*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivitiesItem {

/*
The date of the activity item
*/
private String date;

/*
Instrument epic identifier
*/
private String epic;

/*
The period of the activity item, e.g. "DFB" or "02-SEP-11".
 This will be the expiry time/date for sprint markets, e.g. "2015-10-13T12:42:05"
*/
private String period;

/*
Deal identifier
*/
private String dealId;

/*
Channel
*/
private Channel channel;

/*
Activity type
*/
private Type type;

/*
Activity status
*/
private Status status;

/*
Activity description
*/
private String description;

/*
Activity details.
 This will be null if query parameter detailed=false.
*/
private Details details;

public String getDate() { return date; }
public void setDate(String date) { this.date=date; }
public String getEpic() { return epic; }
public void setEpic(String epic) { this.epic=epic; }
public String getPeriod() { return period; }
public void setPeriod(String period) { this.period=period; }
public String getDealId() { return dealId; }
public void setDealId(String dealId) { this.dealId=dealId; }
public Channel getChannel() { return channel; }
public void setChannel(Channel channel) { this.channel=channel; }
public Type getType() { return type; }
public void setType(Type type) { this.type=type; }
public Status getStatus() { return status; }
public void setStatus(Status status) { this.status=status; }
public String getDescription() { return description; }
public void setDescription(String description) { this.description=description; }
public Details getDetails() { return details; }
public void setDetails(Details details) { this.details=details; }
}
