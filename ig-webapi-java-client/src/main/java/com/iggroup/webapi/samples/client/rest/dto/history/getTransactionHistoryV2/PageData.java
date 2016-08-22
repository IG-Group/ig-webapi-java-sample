package com.iggroup.webapi.samples.client.rest.dto.history.getTransactionHistoryV2;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Paging metadata
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageData {

/*
Page size
*/
private int pageSize;

/*
Page number
*/
private int pageNumber;

/*
Total number of pages
*/
private int totalPages;

public int getPageSize() { return pageSize; }
public void setPageSize(int pageSize) { this.pageSize=pageSize; }
public int getPageNumber() { return pageNumber; }
public void setPageNumber(int pageNumber) { this.pageNumber=pageNumber; }
public int getTotalPages() { return totalPages; }
public void setTotalPages(int totalPages) { this.totalPages=totalPages; }
}
