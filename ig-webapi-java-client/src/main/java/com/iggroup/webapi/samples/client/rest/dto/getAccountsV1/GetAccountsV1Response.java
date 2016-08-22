package com.iggroup.webapi.samples.client.rest.dto.getAccountsV1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*

*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAccountsV1Response {

/*
List of client accounts
*/
private java.util.List<AccountsItem> accounts;

public java.util.List<AccountsItem> getAccounts() { return accounts; }
public void setAccounts(java.util.List<AccountsItem> accounts) { this.accounts=accounts; }
}
