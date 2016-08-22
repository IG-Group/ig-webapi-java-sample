package com.iggroup.webapi.samples.client.rest.dto.positions.otc.updateOTCPositionV1;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Edit position request data
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateOTCPositionV1Request {

/*
Stop level
*/
private BigDecimal stopLevel;

/*
Limit level
*/
private BigDecimal limitLevel;

public BigDecimal getStopLevel() { return stopLevel; }
public void setStopLevel(BigDecimal stopLevel) { this.stopLevel=stopLevel; }
public BigDecimal getLimitLevel() { return limitLevel; }
public void setLimitLevel(BigDecimal limitLevel) { this.limitLevel=limitLevel; }
}
