package com.iggroup.webapi.samples.client.rest.dto.history.getTransactionHistoryByTimeRangeV1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
List of transactions
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetTransactionHistoryByTimeRangeV1Response {

/*
List of transactions
*/
private java.util.List<TransactionsItem> transactions;

public java.util.List<TransactionsItem> getTransactions() { return transactions; }
public void setTransactions(java.util.List<TransactionsItem> transactions) { this.transactions=transactions; }
}
