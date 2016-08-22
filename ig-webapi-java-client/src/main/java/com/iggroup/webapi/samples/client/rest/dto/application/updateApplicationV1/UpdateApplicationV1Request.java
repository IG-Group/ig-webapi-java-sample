package com.iggroup.webapi.samples.client.rest.dto.application.updateApplicationV1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*

*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateApplicationV1Request {

/*

*/
private String apiKey;

/*

*/
private Status status;

/*

*/
private Integer allowanceAccountTrading;

/*

*/
private Integer allowanceAccountOverall;

public String getApiKey() { return apiKey; }
public void setApiKey(String apiKey) { this.apiKey=apiKey; }
public Status getStatus() { return status; }
public void setStatus(Status status) { this.status=status; }
public Integer getAllowanceAccountTrading() { return allowanceAccountTrading; }
public void setAllowanceAccountTrading(Integer allowanceAccountTrading) { this.allowanceAccountTrading=allowanceAccountTrading; }
public Integer getAllowanceAccountOverall() { return allowanceAccountOverall; }
public void setAllowanceAccountOverall(Integer allowanceAccountOverall) { this.allowanceAccountOverall=allowanceAccountOverall; }
}
