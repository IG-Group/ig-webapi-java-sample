package com.iggroup.webapi.samples.client.rest.dto.session.createSessionV1;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Account financial data
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountInfo {

/*
Balance of funds in the account
*/
private Float balance;

/*
Minimum deposit amount required for margins
*/
private Float deposit;

/*
Account profit and loss amount
*/
private Float profitLoss;

/*
Account funds available for trading amount
*/
private Float available;

public Float getBalance() { return balance; }
public void setBalance(Float balance) { this.balance=balance; }
public Float getDeposit() { return deposit; }
public void setDeposit(Float deposit) { this.deposit=deposit; }
public Float getProfitLoss() { return profitLoss; }
public void setProfitLoss(Float profitLoss) { this.profitLoss=profitLoss; }
public Float getAvailable() { return available; }
public void setAvailable(Float available) { this.available=available; }
}
