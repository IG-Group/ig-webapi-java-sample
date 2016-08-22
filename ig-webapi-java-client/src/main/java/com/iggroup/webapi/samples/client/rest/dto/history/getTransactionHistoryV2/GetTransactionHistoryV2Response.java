package com.iggroup.webapi.samples.client.rest.dto.history.getTransactionHistoryV2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
List of transactions
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetTransactionHistoryV2Response {

/*
List of transactions
*/
private java.util.List<TransactionsItem> transactions;

/*
Metadata
*/
private Metadata metadata;

public java.util.List<TransactionsItem> getTransactions() { return transactions; }
public void setTransactions(java.util.List<TransactionsItem> transactions) { this.transactions=transactions; }
public Metadata getMetadata() { return metadata; }
public void setMetadata(Metadata metadata) { this.metadata=metadata; }
}
