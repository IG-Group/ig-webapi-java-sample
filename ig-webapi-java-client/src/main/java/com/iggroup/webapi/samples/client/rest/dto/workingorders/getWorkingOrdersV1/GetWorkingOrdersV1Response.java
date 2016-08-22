package com.iggroup.webapi.samples.client.rest.dto.workingorders.getWorkingOrdersV1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
List working orders response
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetWorkingOrdersV1Response {

/*
List of working orders
*/
private java.util.List<WorkingOrdersItem> workingOrders;

public java.util.List<WorkingOrdersItem> getWorkingOrders() { return workingOrders; }
public void setWorkingOrders(java.util.List<WorkingOrdersItem> workingOrders) { this.workingOrders=workingOrders; }
}
