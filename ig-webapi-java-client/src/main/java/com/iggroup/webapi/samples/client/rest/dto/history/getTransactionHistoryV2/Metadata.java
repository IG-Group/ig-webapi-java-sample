package com.iggroup.webapi.samples.client.rest.dto.history.getTransactionHistoryV2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Paging metadata
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Metadata {

/*
Size
*/
private int size;

/*
Page data
*/
private PageData pageData;

public int getSize() { return size; }
public void setSize(int size) { this.size=size; }
public PageData getPageData() { return pageData; }
public void setPageData(PageData pageData) { this.pageData=pageData; }
}
