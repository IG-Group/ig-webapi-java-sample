package com.iggroup.webapi.samples.client.rest.dto.watchlists.updateWatchlistMarketV1;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Add instrument to watchlist request
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateWatchlistMarketV1Request {

/*
Instrument epic identifier
*/
private String epic;

public String getEpic() { return epic; }
public void setEpic(String epic) { this.epic=epic; }
}
