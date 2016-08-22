package com.iggroup.webapi.samples.client.rest.dto.application.getApplicationsV1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Client application
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetApplicationsV1ResponseItem {

/*
Application name
*/
private String name;

/*
API key
*/
private String apiKey;

/*
Application status
*/
private Status status;

/*
Overall request per minute allowance
*/
private Integer allowanceApplicationOverall;

/*
Per account trading request per minute allowance
*/
private Integer allowanceAccountTrading;

/*
Per account request per minute allowance
*/
private Integer allowanceAccountOverall;

/*
Historical price data data points per minute allowance
*/
private Integer allowanceAccountHistoricalData;

/*
Concurrent subscription limit per lightstreamer connection
*/
private Integer concurrentSubscriptionsLimit;

/*
True if access to equity prices is permitted
*/
private Boolean allowEquities;

/*
True if quote orders are permitted
*/
private Boolean allowQuoteOrders;

/*
Application creation date
*/
private String createdDate;

public String getName() { return name; }
public void setName(String name) { this.name=name; }
public String getApiKey() { return apiKey; }
public void setApiKey(String apiKey) { this.apiKey=apiKey; }
public Status getStatus() { return status; }
public void setStatus(Status status) { this.status=status; }
public Integer getAllowanceApplicationOverall() { return allowanceApplicationOverall; }
public void setAllowanceApplicationOverall(Integer allowanceApplicationOverall) { this.allowanceApplicationOverall=allowanceApplicationOverall; }
public Integer getAllowanceAccountTrading() { return allowanceAccountTrading; }
public void setAllowanceAccountTrading(Integer allowanceAccountTrading) { this.allowanceAccountTrading=allowanceAccountTrading; }
public Integer getAllowanceAccountOverall() { return allowanceAccountOverall; }
public void setAllowanceAccountOverall(Integer allowanceAccountOverall) { this.allowanceAccountOverall=allowanceAccountOverall; }
public Integer getAllowanceAccountHistoricalData() { return allowanceAccountHistoricalData; }
public void setAllowanceAccountHistoricalData(Integer allowanceAccountHistoricalData) { this.allowanceAccountHistoricalData=allowanceAccountHistoricalData; }
public Integer getConcurrentSubscriptionsLimit() { return concurrentSubscriptionsLimit; }
public void setConcurrentSubscriptionsLimit(Integer concurrentSubscriptionsLimit) { this.concurrentSubscriptionsLimit=concurrentSubscriptionsLimit; }
public Boolean getAllowEquities() { return allowEquities; }
public void setAllowEquities(Boolean allowEquities) { this.allowEquities=allowEquities; }
public Boolean getAllowQuoteOrders() { return allowQuoteOrders; }
public void setAllowQuoteOrders(Boolean allowQuoteOrders) { this.allowQuoteOrders=allowQuoteOrders; }
public String getCreatedDate() { return createdDate; }
public void setCreatedDate(String createdDate) { this.createdDate=createdDate; }
}
