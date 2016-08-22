package com.iggroup.webapi.samples.client.rest.dto.getAccountsV1;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Account balances
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Balance {

/*
Balance of funds in the account
*/
private Float balance;

/*
Minimum deposit amount required for margins
*/
private Float deposit;

/*
Profit and loss amount
*/
private Float profitLoss;

/*
Amount available for trading
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
