package com.iggroup.webapi.samples.client.rest.dto.history.getActivityHistoryV3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Paging metadata
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Metadata {

/*
Paging data
*/
private Paging paging;

public Paging getPaging() { return paging; }
public void setPaging(Paging paging) { this.paging=paging; }
}
