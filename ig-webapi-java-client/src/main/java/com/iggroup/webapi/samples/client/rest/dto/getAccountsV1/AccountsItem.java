package com.iggroup.webapi.samples.client.rest.dto.getAccountsV1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Account data
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountsItem {

/*
Account identifier
*/
private String accountId;

/*
Account name
*/
private String accountName;

/*
Account alias
*/
private String accountAlias;

/*
Account status
*/
private Status status;

/*
Account type
*/
private AccountType accountType;

/*
True if this the default login account
*/
private Boolean preferred;

/*
Account balances
*/
private Balance balance;

/*
Account currency
*/
private String currency;

/*
True if account can be transferred to
*/
private Boolean canTransferFrom;

/*
True if account can be transferred from
*/
private Boolean canTransferTo;

public String getAccountId() { return accountId; }
public void setAccountId(String accountId) { this.accountId=accountId; }
public String getAccountName() { return accountName; }
public void setAccountName(String accountName) { this.accountName=accountName; }
public String getAccountAlias() { return accountAlias; }
public void setAccountAlias(String accountAlias) { this.accountAlias=accountAlias; }
public Status getStatus() { return status; }
public void setStatus(Status status) { this.status=status; }
public AccountType getAccountType() { return accountType; }
public void setAccountType(AccountType accountType) { this.accountType=accountType; }
public Boolean getPreferred() { return preferred; }
public void setPreferred(Boolean preferred) { this.preferred=preferred; }
public Balance getBalance() { return balance; }
public void setBalance(Balance balance) { this.balance=balance; }
public String getCurrency() { return currency; }
public void setCurrency(String currency) { this.currency=currency; }
public Boolean getCanTransferFrom() { return canTransferFrom; }
public void setCanTransferFrom(Boolean canTransferFrom) { this.canTransferFrom=canTransferFrom; }
public Boolean getCanTransferTo() { return canTransferTo; }
public void setCanTransferTo(Boolean canTransferTo) { this.canTransferTo=canTransferTo; }
}
