package com.iggroup.webapi.samples.client.rest.dto.session.updateActiveAccountV1;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Account switch request
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateActiveAccountV1Request {

/*
The identifier of the account being switched to
*/
private String accountId;

/*
True if the specified account is to be set as the new default account.
 Omitting this argument results in the default account not being changed
*/
private Boolean defaultAccount;

public String getAccountId() { return accountId; }
public void setAccountId(String accountId) { this.accountId=accountId; }
public Boolean getDefaultAccount() { return defaultAccount; }
public void setDefaultAccount(Boolean defaultAccount) { this.defaultAccount=defaultAccount; }
}
