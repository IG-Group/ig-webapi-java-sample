package com.iggroup.webapi.samples.client.rest.dto.session.createSessionV1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Summary of client account information returned on successful client login. <br/>
 <br/>
 Two security access tokens are returned in the response header, and are
 required to be submitted via the header in future API requests:
 <ul>
 <li>CST - Client session security access token</li>
 <li>X-SECURITY-TOKEN - Account session security access token</li>
 </ul>

 This is used by the v1 Authentication PAPI endpoint
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateSessionV1Response {

/*
Account type
*/
private AccountType accountType;

/*
Active account summary
*/
private AccountInfo accountInfo;

/*
Account currency
*/
private String currencyIsoCode;

/*
Account currency symbol
*/
private String currencySymbol;

/*
Active account identifier
*/
private String currentAccountId;

/*
Lightstreamer endpoint for subscribing to account and price updates
*/
private String lightstreamerEndpoint;

/*
Client account summaries
*/
private java.util.List<AccountsItem> accounts;

/*
Client identifier
*/
private String clientId;

/*
Client account timezone offset relative to UTC, expressed in hours
*/
private int timezoneOffset;

/*
Whether the Client has active demo accounts.
*/
private Boolean hasActiveDemoAccounts;

/*
Whether the Client has active live accounts.
*/
private Boolean hasActiveLiveAccounts;

/*
Whether the account is allowed to set trailing stops on his trades
*/
private Boolean trailingStopsEnabled;

/*
If specified, indicates that the authentication process requires the client to switch to a different URL in order to complete the login.
 <p/>
 If null, no rerouting has to take place and the authentication process is complete.
 <p/>
 This is expected for any DEMO clients, where the authentication process is initiated against the production servers (i.e. https://api.ig.com/gateway/deal )
 whereas all subsequent requests have to be issued against the DEMO servers (i.e. https://demo-api.ig.com/gateway/deal )
 <p/>
 Please also note that when rerouting to DEMO it is also required to invoke to "silent login" endpoint in DEMO with the CST token
 obtained by the preceding LIVE authentication endpoint invocation.
 <p/>
 Please consult the http://labs.ig.com site for more details about the login rerouting details.
*/
private ReroutingEnvironment reroutingEnvironment;

/*
Whether the account is enabled for placing trading orders
*/
private Boolean dealingEnabled;

/*
The ig company that this client belongs to
*/
private String igCompany;

/*
Flag indicating if the request was marked as being encrypted
*/
private boolean encrypted;

/*
List of forms details
*/
private java.util.List<FormDetailsItem> formDetails;

/*
Authentication status
*/
private AuthenticationStatus authenticationStatus;

public AccountType getAccountType() { return accountType; }
public void setAccountType(AccountType accountType) { this.accountType=accountType; }
public AccountInfo getAccountInfo() { return accountInfo; }
public void setAccountInfo(AccountInfo accountInfo) { this.accountInfo=accountInfo; }
public String getCurrencyIsoCode() { return currencyIsoCode; }
public void setCurrencyIsoCode(String currencyIsoCode) { this.currencyIsoCode=currencyIsoCode; }
public String getCurrencySymbol() { return currencySymbol; }
public void setCurrencySymbol(String currencySymbol) { this.currencySymbol=currencySymbol; }
public String getCurrentAccountId() { return currentAccountId; }
public void setCurrentAccountId(String currentAccountId) { this.currentAccountId=currentAccountId; }
public String getLightstreamerEndpoint() { return lightstreamerEndpoint; }
public void setLightstreamerEndpoint(String lightstreamerEndpoint) { this.lightstreamerEndpoint=lightstreamerEndpoint; }
public java.util.List<AccountsItem> getAccounts() { return accounts; }
public void setAccounts(java.util.List<AccountsItem> accounts) { this.accounts=accounts; }
public String getClientId() { return clientId; }
public void setClientId(String clientId) { this.clientId=clientId; }
public int getTimezoneOffset() { return timezoneOffset; }
public void setTimezoneOffset(int timezoneOffset) { this.timezoneOffset=timezoneOffset; }
public Boolean getHasActiveDemoAccounts() { return hasActiveDemoAccounts; }
public void setHasActiveDemoAccounts(Boolean hasActiveDemoAccounts) { this.hasActiveDemoAccounts=hasActiveDemoAccounts; }
public Boolean getHasActiveLiveAccounts() { return hasActiveLiveAccounts; }
public void setHasActiveLiveAccounts(Boolean hasActiveLiveAccounts) { this.hasActiveLiveAccounts=hasActiveLiveAccounts; }
public Boolean getTrailingStopsEnabled() { return trailingStopsEnabled; }
public void setTrailingStopsEnabled(Boolean trailingStopsEnabled) { this.trailingStopsEnabled=trailingStopsEnabled; }
public ReroutingEnvironment getReroutingEnvironment() { return reroutingEnvironment; }
public void setReroutingEnvironment(ReroutingEnvironment reroutingEnvironment) { this.reroutingEnvironment=reroutingEnvironment; }
public Boolean getDealingEnabled() { return dealingEnabled; }
public void setDealingEnabled(Boolean dealingEnabled) { this.dealingEnabled=dealingEnabled; }
public String getIgCompany() { return igCompany; }
public void setIgCompany(String igCompany) { this.igCompany=igCompany; }
public boolean getEncrypted() { return encrypted; }
public void setEncrypted(boolean encrypted) { this.encrypted=encrypted; }
public java.util.List<FormDetailsItem> getFormDetails() { return formDetails; }
public void setFormDetails(java.util.List<FormDetailsItem> formDetails) { this.formDetails=formDetails; }
public AuthenticationStatus getAuthenticationStatus() { return authenticationStatus; }
public void setAuthenticationStatus(AuthenticationStatus authenticationStatus) { this.authenticationStatus=authenticationStatus; }
}
