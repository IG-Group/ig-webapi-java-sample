package com.iggroup.webapi.samples.client.rest.dto.history.getActivityHistoryV3;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Paging metadata
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Paging {

/*
Page size
*/
private int size;

/*
Next page
*/
private String next;

public int getSize() { return size; }
public void setSize(int size) { this.size=size; }
public String getNext() { return next; }
public void setNext(String next) { this.next=next; }
}
