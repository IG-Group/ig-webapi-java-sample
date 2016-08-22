package com.iggroup.webapi.samples.client.rest.dto.getDealConfirmationV1;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Deal confirmation
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetDealConfirmationV1Response {

/*
Position status
*/
private PositionStatus status;

/*
Reason message
*/
private Reason reason;

/*
Deal status
*/
private DealStatus dealStatus;

/*
Instrument epic identifier
*/
private String epic;

/*
Instrument expiry
*/
private String expiry;

/*
Deal reference
*/
private String dealReference;

/*
Deal identifier
*/
private String dealId;

/*
List of affected deals
*/
private java.util.List<AffectedDealsItem> affectedDeals;

/*
Level
*/
private Float level;

/*
Size
*/
private Float size;

/*
Direction
*/
private Direction direction;

/*
Stop level
*/
private Float stopLevel;

/*
Limit level
*/
private Float limitLevel;

/*
Stop distance
*/
private Float stopDistance;

/*
Limit distance
*/
private Float limitDistance;

/*
True if guaranteed stop
*/
private Boolean guaranteedStop;

/*
True if trailing stop
*/
private Boolean trailingStop;

/*
Profit
*/
private BigDecimal profit;

/*
Profit currency
*/
private String profitCurrency;

public PositionStatus getStatus() { return status; }
public void setStatus(PositionStatus status) { this.status=status; }
public Reason getReason() { return reason; }
public void setReason(Reason reason) { this.reason=reason; }
public DealStatus getDealStatus() { return dealStatus; }
public void setDealStatus(DealStatus dealStatus) { this.dealStatus=dealStatus; }
public String getEpic() { return epic; }
public void setEpic(String epic) { this.epic=epic; }
public String getExpiry() { return expiry; }
public void setExpiry(String expiry) { this.expiry=expiry; }
public String getDealReference() { return dealReference; }
public void setDealReference(String dealReference) { this.dealReference=dealReference; }
public String getDealId() { return dealId; }
public void setDealId(String dealId) { this.dealId=dealId; }
public java.util.List<AffectedDealsItem> getAffectedDeals() { return affectedDeals; }
public void setAffectedDeals(java.util.List<AffectedDealsItem> affectedDeals) { this.affectedDeals=affectedDeals; }
public Float getLevel() { return level; }
public void setLevel(Float level) { this.level=level; }
public Float getSize() { return size; }
public void setSize(Float size) { this.size=size; }
public Direction getDirection() { return direction; }
public void setDirection(Direction direction) { this.direction=direction; }
public Float getStopLevel() { return stopLevel; }
public void setStopLevel(Float stopLevel) { this.stopLevel=stopLevel; }
public Float getLimitLevel() { return limitLevel; }
public void setLimitLevel(Float limitLevel) { this.limitLevel=limitLevel; }
public Float getStopDistance() { return stopDistance; }
public void setStopDistance(Float stopDistance) { this.stopDistance=stopDistance; }
public Float getLimitDistance() { return limitDistance; }
public void setLimitDistance(Float limitDistance) { this.limitDistance=limitDistance; }
public Boolean getGuaranteedStop() { return guaranteedStop; }
public void setGuaranteedStop(Boolean guaranteedStop) { this.guaranteedStop=guaranteedStop; }
public Boolean getTrailingStop() { return trailingStop; }
public void setTrailingStop(Boolean trailingStop) { this.trailingStop=trailingStop; }
public BigDecimal getProfit() { return profit; }
public void setProfit(BigDecimal profit) { this.profit=profit; }
public String getProfitCurrency() { return profitCurrency; }
public void setProfitCurrency(String profitCurrency) { this.profitCurrency=profitCurrency; }
}
