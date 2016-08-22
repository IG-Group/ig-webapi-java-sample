package com.iggroup.webapi.samples.client.rest.dto.history.getTransactionHistoryV1;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Transaction data
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionsItem {

/*
Transaction date, format dd-MMM-yyyy
*/
private String date;

/*
Instrument name
*/
private String instrumentName;

/*
Period in milliseconds
*/
private String period;

/*
Profit and loss
*/
private String profitAndLoss;

/*
Transaction type
*/
private String transactionType;

/*
Reference
*/
private String reference;

/*
Level at which the order was opened
*/
private String openLevel;

/*
Level at which the order was closed
*/
private String closeLevel;

/*
Formatted order size, including the direction (+ for buy, - for sell)
*/
private String size;

/*
Order currency
*/
private String currency;

/*
True if this was a cash transaction
*/
private Boolean cashTransaction;

public String getDate() { return date; }
public void setDate(String date) { this.date=date; }
public String getInstrumentName() { return instrumentName; }
public void setInstrumentName(String instrumentName) { this.instrumentName=instrumentName; }
public String getPeriod() { return period; }
public void setPeriod(String period) { this.period=period; }
public String getProfitAndLoss() { return profitAndLoss; }
public void setProfitAndLoss(String profitAndLoss) { this.profitAndLoss=profitAndLoss; }
public String getTransactionType() { return transactionType; }
public void setTransactionType(String transactionType) { this.transactionType=transactionType; }
public String getReference() { return reference; }
public void setReference(String reference) { this.reference=reference; }
public String getOpenLevel() { return openLevel; }
public void setOpenLevel(String openLevel) { this.openLevel=openLevel; }
public String getCloseLevel() { return closeLevel; }
public void setCloseLevel(String closeLevel) { this.closeLevel=closeLevel; }
public String getSize() { return size; }
public void setSize(String size) { this.size=size; }
public String getCurrency() { return currency; }
public void setCurrency(String currency) { this.currency=currency; }
public Boolean getCashTransaction() { return cashTransaction; }
public void setCashTransaction(Boolean cashTransaction) { this.cashTransaction=cashTransaction; }
}
