package com.iggroup.webapi.samples.client.rest.dto.session.updateActiveAccountV1;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Switch account response
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateActiveAccountV1Response {

/*
Whether the account is allowed to set trailing stops on his trades
*/
private Boolean trailingStopsEnabled;

/*

*/
private Boolean dealingEnabled;

/*

*/
private Boolean hasActiveDemoAccounts;

/*

*/
private Boolean hasActiveLiveAccounts;

public Boolean getTrailingStopsEnabled() { return trailingStopsEnabled; }
public void setTrailingStopsEnabled(Boolean trailingStopsEnabled) { this.trailingStopsEnabled=trailingStopsEnabled; }
public Boolean getDealingEnabled() { return dealingEnabled; }
public void setDealingEnabled(Boolean dealingEnabled) { this.dealingEnabled=dealingEnabled; }
public Boolean getHasActiveDemoAccounts() { return hasActiveDemoAccounts; }
public void setHasActiveDemoAccounts(Boolean hasActiveDemoAccounts) { this.hasActiveDemoAccounts=hasActiveDemoAccounts; }
public Boolean getHasActiveLiveAccounts() { return hasActiveLiveAccounts; }
public void setHasActiveLiveAccounts(Boolean hasActiveLiveAccounts) { this.hasActiveLiveAccounts=hasActiveLiveAccounts; }
}
