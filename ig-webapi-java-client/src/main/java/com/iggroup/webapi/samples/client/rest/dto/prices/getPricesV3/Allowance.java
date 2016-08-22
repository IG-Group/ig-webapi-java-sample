package com.iggroup.webapi.samples.client.rest.dto.prices.getPricesV3;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Historical price data allowance
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Allowance {

/*
The number of data points still available to fetch within the current allowance period
*/
private Integer remainingAllowance;

/*
The number of data points the API key and account combination is allowed to fetch in any given allowance period
*/
private Integer totalAllowance;

/*
The number of seconds till the current allowance period will end and the remaining allowance field is reset
*/
private Integer allowanceExpiry;

public Integer getRemainingAllowance() { return remainingAllowance; }
public void setRemainingAllowance(Integer remainingAllowance) { this.remainingAllowance=remainingAllowance; }
public Integer getTotalAllowance() { return totalAllowance; }
public void setTotalAllowance(Integer totalAllowance) { this.totalAllowance=totalAllowance; }
public Integer getAllowanceExpiry() { return allowanceExpiry; }
public void setAllowanceExpiry(Integer allowanceExpiry) { this.allowanceExpiry=allowanceExpiry; }
}
