package com.iggroup.webapi.samples.client.rest.dto.workingorders.otc.updateOTCWorkingOrderV1;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Edit working order response
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateOTCWorkingOrderV1Response {

/*
Deal reference of the transaction
*/
private String dealReference;

public String getDealReference() { return dealReference; }
public void setDealReference(String dealReference) { this.dealReference=dealReference; }
}
