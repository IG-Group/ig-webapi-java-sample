package com.iggroup.webapi.samples.client.rest.dto.session.createSessionV2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Account details
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
Indicates whether this account is the client's preferred account
*/
private Boolean preferred;

/*
Account type
*/
private AccountType accountType;

public String getAccountId() { return accountId; }
public void setAccountId(String accountId) { this.accountId=accountId; }
public String getAccountName() { return accountName; }
public void setAccountName(String accountName) { this.accountName=accountName; }
public Boolean getPreferred() { return preferred; }
public void setPreferred(Boolean preferred) { this.preferred=preferred; }
public AccountType getAccountType() { return accountType; }
public void setAccountType(AccountType accountType) { this.accountType=accountType; }
}
