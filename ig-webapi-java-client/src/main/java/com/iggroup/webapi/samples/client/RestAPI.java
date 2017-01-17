package com.iggroup.webapi.samples.client;

import com.iggroup.webapi.samples.client.rest.*;
import com.iggroup.webapi.samples.client.rest.dto.application.disable.updateApplicationV1.UpdateApplicationV1Response;
import com.iggroup.webapi.samples.client.rest.dto.application.getApplicationsV1.GetApplicationsV1ResponseItem;
import com.iggroup.webapi.samples.client.rest.dto.application.updateApplicationV1.UpdateApplicationV1Request;
import com.iggroup.webapi.samples.client.rest.dto.clientsentiment.getClientSentimentV1.GetClientSentimentV1Response;
import com.iggroup.webapi.samples.client.rest.dto.clientsentiment.getRelatedClientSentimentV1.GetRelatedClientSentimentV1Response;
import com.iggroup.webapi.samples.client.rest.dto.getAccountsV1.GetAccountsV1Response;
import com.iggroup.webapi.samples.client.rest.dto.getDealConfirmationV1.GetDealConfirmationV1Response;
import com.iggroup.webapi.samples.client.rest.dto.history.getActivityHistoryByTimeRangeV1.GetActivityHistoryByTimeRangeV1Response;
import com.iggroup.webapi.samples.client.rest.dto.history.getActivityHistoryV1.GetActivityHistoryV1Response;
import com.iggroup.webapi.samples.client.rest.dto.history.getActivityHistoryV2.GetActivityHistoryV2Response;
import com.iggroup.webapi.samples.client.rest.dto.history.getActivityHistoryV3.GetActivityHistoryV3Response;
import com.iggroup.webapi.samples.client.rest.dto.history.getTransactionHistoryByTimeRangeV1.GetTransactionHistoryByTimeRangeV1Response;
import com.iggroup.webapi.samples.client.rest.dto.history.getTransactionHistoryV1.GetTransactionHistoryV1Response;
import com.iggroup.webapi.samples.client.rest.dto.history.getTransactionHistoryV2.GetTransactionHistoryV2Response;
import com.iggroup.webapi.samples.client.rest.dto.markets.getMarketDetailsBySearchTermV1.GetMarketDetailsBySearchTermV1Response;
import com.iggroup.webapi.samples.client.rest.dto.markets.getMarketDetailsListV1.GetMarketDetailsListV1Response;
import com.iggroup.webapi.samples.client.rest.dto.markets.getMarketDetailsListV2.GetMarketDetailsListV2Response;
import com.iggroup.webapi.samples.client.rest.dto.markets.getMarketDetailsV1.GetMarketDetailsV1Response;
import com.iggroup.webapi.samples.client.rest.dto.markets.getMarketDetailsV2.GetMarketDetailsV2Response;
import com.iggroup.webapi.samples.client.rest.dto.markets.getMarketDetailsV3.GetMarketDetailsV3Response;
import com.iggroup.webapi.samples.client.rest.dto.markets.navigation.getMarketNavigationNodeV1.GetMarketNavigationNodeV1Response;
import com.iggroup.webapi.samples.client.rest.dto.markets.navigation.getMarketNavigationRootV1.GetMarketNavigationRootV1Response;
import com.iggroup.webapi.samples.client.rest.dto.positions.getPositionByDealIdV1.GetPositionByDealIdV1Response;
import com.iggroup.webapi.samples.client.rest.dto.positions.getPositionByDealIdV2.GetPositionByDealIdV2Response;
import com.iggroup.webapi.samples.client.rest.dto.positions.getPositionsV1.GetPositionsV1Response;
import com.iggroup.webapi.samples.client.rest.dto.positions.getPositionsV2.GetPositionsV2Response;
import com.iggroup.webapi.samples.client.rest.dto.positions.otc.closeOTCPositionV1.CloseOTCPositionV1Request;
import com.iggroup.webapi.samples.client.rest.dto.positions.otc.closeOTCPositionV1.CloseOTCPositionV1Response;
import com.iggroup.webapi.samples.client.rest.dto.positions.otc.createOTCPositionV1.CreateOTCPositionV1Request;
import com.iggroup.webapi.samples.client.rest.dto.positions.otc.createOTCPositionV1.CreateOTCPositionV1Response;
import com.iggroup.webapi.samples.client.rest.dto.positions.otc.createOTCPositionV2.CreateOTCPositionV2Request;
import com.iggroup.webapi.samples.client.rest.dto.positions.otc.createOTCPositionV2.CreateOTCPositionV2Response;
import com.iggroup.webapi.samples.client.rest.dto.positions.otc.updateOTCPositionV1.UpdateOTCPositionV1Request;
import com.iggroup.webapi.samples.client.rest.dto.positions.otc.updateOTCPositionV1.UpdateOTCPositionV1Response;
import com.iggroup.webapi.samples.client.rest.dto.positions.otc.updateOTCPositionV2.UpdateOTCPositionV2Request;
import com.iggroup.webapi.samples.client.rest.dto.positions.otc.updateOTCPositionV2.UpdateOTCPositionV2Response;
import com.iggroup.webapi.samples.client.rest.dto.positions.sprintmarkets.createSprintMarketPositionV1.CreateSprintMarketPositionV1Request;
import com.iggroup.webapi.samples.client.rest.dto.positions.sprintmarkets.createSprintMarketPositionV1.CreateSprintMarketPositionV1Response;
import com.iggroup.webapi.samples.client.rest.dto.positions.sprintmarkets.getSprintMarketPositionsV1.GetSprintMarketPositionsV1Response;
import com.iggroup.webapi.samples.client.rest.dto.positions.sprintmarkets.getSprintMarketPositionsV2.GetSprintMarketPositionsV2Response;
import com.iggroup.webapi.samples.client.rest.dto.prices.getPricesByDateRangeV1.GetPricesByDateRangeV1Response;
import com.iggroup.webapi.samples.client.rest.dto.prices.getPricesByDateRangeV2.GetPricesByDateRangeV2Response;
import com.iggroup.webapi.samples.client.rest.dto.prices.getPricesByNumberOfPointsV1.GetPricesByNumberOfPointsV1Response;
import com.iggroup.webapi.samples.client.rest.dto.prices.getPricesByNumberOfPointsV2.GetPricesByNumberOfPointsV2Response;
import com.iggroup.webapi.samples.client.rest.dto.prices.getPricesV3.GetPricesV3Response;
import com.iggroup.webapi.samples.client.rest.dto.session.createSessionV1.CreateSessionV1Request;
import com.iggroup.webapi.samples.client.rest.dto.session.createSessionV1.CreateSessionV1Response;
import com.iggroup.webapi.samples.client.rest.dto.session.createSessionV2.CreateSessionV2Request;
import com.iggroup.webapi.samples.client.rest.dto.session.createSessionV2.CreateSessionV2Response;
import com.iggroup.webapi.samples.client.rest.dto.session.createSessionV3.AccessTokenResponse;
import com.iggroup.webapi.samples.client.rest.dto.session.createSessionV3.CreateSessionV3Request;
import com.iggroup.webapi.samples.client.rest.dto.session.encryptionKey.getEncryptionKeySessionV1.GetEncryptionKeySessionV1Response;
import com.iggroup.webapi.samples.client.rest.dto.session.getSessionV1.GetSessionV1Response;
import com.iggroup.webapi.samples.client.rest.dto.session.refreshSessionV1.RefreshSessionV1Request;
import com.iggroup.webapi.samples.client.rest.dto.session.updateActiveAccountV1.UpdateActiveAccountV1Request;
import com.iggroup.webapi.samples.client.rest.dto.session.updateActiveAccountV1.UpdateActiveAccountV1Response;
import com.iggroup.webapi.samples.client.rest.dto.watchlists.createWatchlistV1.CreateWatchlistV1Request;
import com.iggroup.webapi.samples.client.rest.dto.watchlists.createWatchlistV1.CreateWatchlistV1Response;
import com.iggroup.webapi.samples.client.rest.dto.watchlists.deleteWatchlistMarketV1.DeleteWatchlistMarketV1Response;
import com.iggroup.webapi.samples.client.rest.dto.watchlists.deleteWatchlistV1.DeleteWatchlistV1Response;
import com.iggroup.webapi.samples.client.rest.dto.watchlists.getWatchlistByWatchlistIdV1.GetWatchlistByWatchlistIdV1Response;
import com.iggroup.webapi.samples.client.rest.dto.watchlists.getWatchlistsV1.GetWatchlistsV1Response;
import com.iggroup.webapi.samples.client.rest.dto.watchlists.updateWatchlistMarketV1.UpdateWatchlistMarketV1Request;
import com.iggroup.webapi.samples.client.rest.dto.watchlists.updateWatchlistMarketV1.UpdateWatchlistMarketV1Response;
import com.iggroup.webapi.samples.client.rest.dto.workingorders.getWorkingOrdersV1.GetWorkingOrdersV1Response;
import com.iggroup.webapi.samples.client.rest.dto.workingorders.getWorkingOrdersV2.GetWorkingOrdersV2Response;
import com.iggroup.webapi.samples.client.rest.dto.workingorders.otc.createOTCWorkingOrderV1.CreateOTCWorkingOrderV1Request;
import com.iggroup.webapi.samples.client.rest.dto.workingorders.otc.createOTCWorkingOrderV1.CreateOTCWorkingOrderV1Response;
import com.iggroup.webapi.samples.client.rest.dto.workingorders.otc.createOTCWorkingOrderV2.CreateOTCWorkingOrderV2Request;
import com.iggroup.webapi.samples.client.rest.dto.workingorders.otc.createOTCWorkingOrderV2.CreateOTCWorkingOrderV2Response;
import com.iggroup.webapi.samples.client.rest.dto.workingorders.otc.deleteOTCWorkingOrderV1.DeleteOTCWorkingOrderV1Request;
import com.iggroup.webapi.samples.client.rest.dto.workingorders.otc.deleteOTCWorkingOrderV1.DeleteOTCWorkingOrderV1Response;
import com.iggroup.webapi.samples.client.rest.dto.workingorders.otc.deleteOTCWorkingOrderV2.DeleteOTCWorkingOrderV2Response;
import com.iggroup.webapi.samples.client.rest.dto.workingorders.otc.updateOTCWorkingOrderV1.UpdateOTCWorkingOrderV1Request;
import com.iggroup.webapi.samples.client.rest.dto.workingorders.otc.updateOTCWorkingOrderV1.UpdateOTCWorkingOrderV1Response;
import com.iggroup.webapi.samples.client.rest.dto.workingorders.otc.updateOTCWorkingOrderV2.UpdateOTCWorkingOrderV2Request;
import com.iggroup.webapi.samples.client.rest.dto.workingorders.otc.updateOTCWorkingOrderV2.UpdateOTCWorkingOrderV2Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.apache.http.HttpResponse;
import java.util.Arrays;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class RestAPI extends AbstractService {

@Autowired
AuthenticationService authenticationService;

public AuthenticationResponseAndConversationContext createSession(CreateSessionV2Request authenticationRequest, String apiKey, boolean encrypted) {
  return authenticationService.createSession(authenticationRequest, apiKey, encrypted);
}

  public AuthenticationResponseAndConversationContext createSessionV3(CreateSessionV3Request authenticationRequest, String apiKey) {
    return authenticationService.createSessionV3(authenticationRequest, apiKey);
  }

/*
Returns a deal confirmation for the given deal reference.
*/
public GetDealConfirmationV1Response getDealConfirmationV1(ConversationContext conversationContext, String dealReference) throws Exception {
  String uri = "/confirms/{dealReference}";
  uri = uri.replace("{dealReference}", dealReference==null?"":dealReference);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<GetDealConfirmationV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetDealConfirmationV1Response.class);
  return response.getBody();
}

/*
Returns a list of historical prices for the given epic, resolution and date range.
*/
public GetPricesByDateRangeV2Response getPricesByDateRangeV2(ConversationContext conversationContext, String endDate, String epic, String resolution, String startDate) throws Exception {
  String uri = "/prices/{epic}/{resolution}/{startDate}/{endDate}";
  uri = uri.replace("{endDate}", endDate==null?"":endDate);
  uri = uri.replace("{epic}", epic==null?"":epic);
  uri = uri.replace("{resolution}", resolution==null?"":resolution);
  uri = uri.replace("{startDate}", startDate==null?"":startDate);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "2");
  ResponseEntity<GetPricesByDateRangeV2Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetPricesByDateRangeV2Response.class);
  return response.getBody();
}

/*
Returns a list of historical prices for the given epic, resolution and number of data points
*/
public GetPricesByNumberOfPointsV2Response getPricesByNumberOfPointsV2(ConversationContext conversationContext, String numPoints, String epic, String resolution) throws Exception {
  String uri = "/prices/{epic}/{resolution}/{numPoints}";
  uri = uri.replace("{numPoints}", numPoints==null?"":numPoints);
  uri = uri.replace("{epic}", epic==null?"":epic);
  uri = uri.replace("{resolution}", resolution==null?"":resolution);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "2");
  ResponseEntity<GetPricesByNumberOfPointsV2Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetPricesByNumberOfPointsV2Response.class);
  return response.getBody();
}

/*
Returns a list of historical prices for the given epic, resolution and date range.
*/
public GetPricesByDateRangeV1Response getPricesByDateRangeV1(ConversationContext conversationContext, String enddate, String epic, String startdate, String resolution, String request) throws Exception {
  String uri = "/prices/{epic}/{resolution}?startdate={startdate}&enddate={enddate}";
  uri = uri.replace("{enddate}", enddate==null?"":enddate);
  uri = uri.replace("{epic}", epic==null?"":epic);
  uri = uri.replace("{startdate}", startdate==null?"":startdate);
  uri = uri.replace("{resolution}", resolution==null?"":resolution);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<GetPricesByDateRangeV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetPricesByDateRangeV1Response.class);
  return response.getBody();
}

/*
Returns a list of historical prices for the given epic, resolution and number of data points
*/
public GetPricesByNumberOfPointsV1Response getPricesByNumberOfPointsV1(ConversationContext conversationContext, String numPoints, String epic, String resolution) throws Exception {
  String uri = "/prices/{epic}/{resolution}/{numPoints}";
  uri = uri.replace("{numPoints}", numPoints==null?"":numPoints);
  uri = uri.replace("{epic}", epic==null?"":epic);
  uri = uri.replace("{resolution}", resolution==null?"":resolution);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<GetPricesByNumberOfPointsV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetPricesByNumberOfPointsV1Response.class);
  return response.getBody();
}

/*
Returns historical prices for a particular instrument.
 By default returns the minute prices within the last 10 minutes.
*/
public GetPricesV3Response getPricesV3(ConversationContext conversationContext, String pageNumber, String max, String pageSize, String epic, String from, String to, String resolution) throws Exception {
  String uri = "/prices/{epic}";
  uri = uri + (pageNumber != null ? (uri.contains("?") ? "&" : "?") + "pageNumber=" + pageNumber : "");
  uri = uri + (max != null ? (uri.contains("?") ? "&" : "?") + "max=" + max : "");
  uri = uri + (pageSize != null ? (uri.contains("?") ? "&" : "?") + "pageSize=" + pageSize : "");
  uri = uri.replace("{epic}", epic==null?"":epic);
  uri = uri + (from != null ? (uri.contains("?") ? "&" : "?") + "from=" + from : "");
  uri = uri + (to != null ? (uri.contains("?") ? "&" : "?") + "to=" + to : "");
  uri = uri + (resolution != null ? (uri.contains("?") ? "&" : "?") + "resolution=" + resolution : "");
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "3");
  ResponseEntity<GetPricesV3Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetPricesV3Response.class);
  return response.getBody();
}

/*
Returns data.
*/
public ObjectNode getDataByIdV1(ConversationContext conversationContext, String id) throws Exception {
  String uri = "/data/{id}";
  uri = uri.replace("{id}", id==null?"":id);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<ObjectNode> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, ObjectNode.class);
  return response.getBody();
}

/*
Switches active accounts, optionally setting the default account
*/
public UpdateActiveAccountV1Response updateActiveAccountV1(ConversationContext conversationContext, UpdateActiveAccountV1Request request) throws Exception {
  String uri = "/session";
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, request, "1");
  ResponseEntity<UpdateActiveAccountV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.PUT, requestEntity, UpdateActiveAccountV1Response.class);
  return response.getBody();
}

/*
Creates an OTC position.
*/
public CreateOTCPositionV1Response createOTCPositionV1(ConversationContext conversationContext, CreateOTCPositionV1Request request) throws Exception {
  String uri = "/positions/otc";
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, request, "1");
  ResponseEntity<CreateOTCPositionV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.POST, requestEntity, CreateOTCPositionV1Response.class);
  return response.getBody();
}

/*
Creates an OTC position.
*/
public CreateOTCPositionV2Response createOTCPositionV2(ConversationContext conversationContext, CreateOTCPositionV2Request request) throws Exception {
  String uri = "/positions/otc";
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, request, "2");
  ResponseEntity<CreateOTCPositionV2Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.POST, requestEntity, CreateOTCPositionV2Response.class);
  return response.getBody();
}

/*
Updates an OTC position.
*/
public UpdateOTCPositionV1Response updateOTCPositionV1(ConversationContext conversationContext, String dealId, UpdateOTCPositionV1Request request) throws Exception {
  String uri = "/positions/otc/{dealId}";
  uri = uri.replace("{dealId}", dealId==null?"":dealId);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, request, "1");
  ResponseEntity<UpdateOTCPositionV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.PUT, requestEntity, UpdateOTCPositionV1Response.class);
  return response.getBody();
}

/*
Updates an OTC position.
*/
public UpdateOTCPositionV2Response updateOTCPositionV2(ConversationContext conversationContext, String dealId, UpdateOTCPositionV2Request request) throws Exception {
  String uri = "/positions/otc/{dealId}";
  uri = uri.replace("{dealId}", dealId==null?"":dealId);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, request, "2");
  ResponseEntity<UpdateOTCPositionV2Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.PUT, requestEntity, UpdateOTCPositionV2Response.class);
  return response.getBody();
}

/*
Closes one or more OTC positions
*/
public CloseOTCPositionV1Response closeOTCPositionV1(ConversationContext conversationContext, CloseOTCPositionV1Request request) throws Exception {
  String uri = "/positions/otc";
  HttpDeleteWithBody deleteWithBody = new HttpDeleteWithBody(getIGApiDomainURL() +  addIGApiLightDarkCluster(uri));
  bindToConversionForDelete(conversationContext, deleteWithBody, request, "1");
  HttpResponse httpResponse = httpClient.execute(deleteWithBody);
  if (HttpStatus.OK.value() == httpResponse.getStatusLine().getStatusCode()) {
    return objectMapper.readValue(httpResponse.getEntity().getContent(), CloseOTCPositionV1Response.class);
  }
  throw new RuntimeException("Delete failed: " + httpResponse.getStatusLine());
}

/*
Creates a sprint market position.
*/
public CreateSprintMarketPositionV1Response createSprintMarketPositionV1(ConversationContext conversationContext, CreateSprintMarketPositionV1Request request) throws Exception {
  String uri = "/positions/sprintmarkets";
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, request, "1");
  ResponseEntity<CreateSprintMarketPositionV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.POST, requestEntity, CreateSprintMarketPositionV1Response.class);
  return response.getBody();
}

/*
Returns all open sprint market positions for the active account.
*/
public GetSprintMarketPositionsV1Response getSprintMarketPositionsV1(ConversationContext conversationContext) throws Exception {
  String uri = "/positions/sprintmarkets";
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<GetSprintMarketPositionsV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetSprintMarketPositionsV1Response.class);
  return response.getBody();
}

/*
Returns all open sprint market positions for the active account.
*/
public GetSprintMarketPositionsV2Response getSprintMarketPositionsV2(ConversationContext conversationContext) throws Exception {
  String uri = "/positions/sprintmarkets";
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "2");
  ResponseEntity<GetSprintMarketPositionsV2Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetSprintMarketPositionsV2Response.class);
  return response.getBody();
}

/*
Returns all open positions for the active account.
*/
public GetPositionsV1Response getPositionsV1(ConversationContext conversationContext) throws Exception {
  String uri = "/positions";
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<GetPositionsV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetPositionsV1Response.class);
  return response.getBody();
}

/*
Returns all open positions for the active account.
*/
public GetPositionsV2Response getPositionsV2(ConversationContext conversationContext) throws Exception {
  String uri = "/positions";
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "2");
  ResponseEntity<GetPositionsV2Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetPositionsV2Response.class);
  return response.getBody();
}

/*
Returns an open position for the active account by deal identifier.
*/
public GetPositionByDealIdV1Response getPositionByDealIdV1(ConversationContext conversationContext, String dealId) throws Exception {
  String uri = "/positions/{dealId}";
  uri = uri.replace("{dealId}", dealId==null?"":dealId);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<GetPositionByDealIdV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetPositionByDealIdV1Response.class);
  return response.getBody();
}

/*
Returns an open position for the active account by deal identifier.
*/
public GetPositionByDealIdV2Response getPositionByDealIdV2(ConversationContext conversationContext, String dealId) throws Exception {
  String uri = "/positions/{dealId}";
  uri = uri.replace("{dealId}", dealId==null?"":dealId);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "2");
  ResponseEntity<GetPositionByDealIdV2Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetPositionByDealIdV2Response.class);
  return response.getBody();
}

/*
Returns all watchlists belonging to the active account.
*/
public GetWatchlistsV1Response getWatchlistsV1(ConversationContext conversationContext) throws Exception {
  String uri = "/watchlists";
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<GetWatchlistsV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetWatchlistsV1Response.class);
  return response.getBody();
}

/*
Returns a watchlist.
*/
public GetWatchlistByWatchlistIdV1Response getWatchlistByWatchlistIdV1(ConversationContext conversationContext, String watchlistId) throws Exception {
  String uri = "/watchlists/{watchlistId}";
  uri = uri.replace("{watchlistId}", watchlistId==null?"":watchlistId);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<GetWatchlistByWatchlistIdV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetWatchlistByWatchlistIdV1Response.class);
  return response.getBody();
}

/*
Deletes a watchlist.
*/
public DeleteWatchlistV1Response deleteWatchlistV1(ConversationContext conversationContext, String watchlistId) throws Exception {
  String uri = "/watchlists/{watchlistId}";
  uri = uri.replace("{watchlistId}", watchlistId==null?"":watchlistId);
  HttpEntity<?> httpEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<DeleteWatchlistV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.DELETE, httpEntity, DeleteWatchlistV1Response.class);
  return response.getBody();
}

/*
Creates a watchlist.
*/
public CreateWatchlistV1Response createWatchlistV1(ConversationContext conversationContext, CreateWatchlistV1Request request) throws Exception {
  String uri = "/watchlists";
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, request, "1");
  ResponseEntity<CreateWatchlistV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.POST, requestEntity, CreateWatchlistV1Response.class);
  return response.getBody();
}

/*
Add a market to a watchlist.
*/
public UpdateWatchlistMarketV1Response updateWatchlistMarketV1(ConversationContext conversationContext, String watchlistId, UpdateWatchlistMarketV1Request request) throws Exception {
  String uri = "/watchlists/{watchlistId}";
  uri = uri.replace("{watchlistId}", watchlistId==null?"":watchlistId);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, request, "1");
  ResponseEntity<UpdateWatchlistMarketV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.PUT, requestEntity, UpdateWatchlistMarketV1Response.class);
  return response.getBody();
}

/*
Remove a market from a watchlist.
*/
public DeleteWatchlistMarketV1Response deleteWatchlistMarketV1(ConversationContext conversationContext, String watchlistId, String epic) throws Exception {
  String uri = "/watchlists/{watchlistId}/{epic}";
  uri = uri.replace("{watchlistId}", watchlistId==null?"":watchlistId);
  uri = uri.replace("{epic}", epic==null?"":epic);
  HttpEntity<?> httpEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<DeleteWatchlistMarketV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.DELETE, httpEntity, DeleteWatchlistMarketV1Response.class);
  return response.getBody();
}

/*
Returns all open working orders for the active account.
*/
public GetWorkingOrdersV1Response getWorkingOrdersV1(ConversationContext conversationContext) throws Exception {
  String uri = "/workingorders";
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<GetWorkingOrdersV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetWorkingOrdersV1Response.class);
  return response.getBody();
}

/*
Returns all open working orders for the active account.
*/
public GetWorkingOrdersV2Response getWorkingOrdersV2(ConversationContext conversationContext) throws Exception {
  String uri = "/workingorders";
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "2");
  ResponseEntity<GetWorkingOrdersV2Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetWorkingOrdersV2Response.class);
  return response.getBody();
}

/*
Creates an OTC working order.
*/
public CreateOTCWorkingOrderV1Response createOTCWorkingOrderV1(ConversationContext conversationContext, CreateOTCWorkingOrderV1Request request) throws Exception {
  String uri = "/workingorders/otc";
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, request, "1");
  ResponseEntity<CreateOTCWorkingOrderV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.POST, requestEntity, CreateOTCWorkingOrderV1Response.class);
  return response.getBody();
}

/*
Creates an OTC working order.
*/
public CreateOTCWorkingOrderV2Response createOTCWorkingOrderV2(ConversationContext conversationContext, CreateOTCWorkingOrderV2Request request) throws Exception {
  String uri = "/workingorders/otc";
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, request, "2");
  ResponseEntity<CreateOTCWorkingOrderV2Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.POST, requestEntity, CreateOTCWorkingOrderV2Response.class);
  return response.getBody();
}

/*
Updates an OTC working order.
*/
public UpdateOTCWorkingOrderV1Response updateOTCWorkingOrderV1(ConversationContext conversationContext, String dealId, UpdateOTCWorkingOrderV1Request request) throws Exception {
  String uri = "/workingorders/otc/{dealId}";
  uri = uri.replace("{dealId}", dealId==null?"":dealId);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, request, "1");
  ResponseEntity<UpdateOTCWorkingOrderV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.PUT, requestEntity, UpdateOTCWorkingOrderV1Response.class);
  return response.getBody();
}

/*
Updates an OTC working order.
*/
public UpdateOTCWorkingOrderV2Response updateOTCWorkingOrderV2(ConversationContext conversationContext, String dealId, UpdateOTCWorkingOrderV2Request request) throws Exception {
  String uri = "/workingorders/otc/{dealId}";
  uri = uri.replace("{dealId}", dealId==null?"":dealId);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, request, "2");
  ResponseEntity<UpdateOTCWorkingOrderV2Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.PUT, requestEntity, UpdateOTCWorkingOrderV2Response.class);
  return response.getBody();
}

/*
Deletes an OTC working order.
*/
public DeleteOTCWorkingOrderV1Response deleteOTCWorkingOrderV1(ConversationContext conversationContext, String dealId, DeleteOTCWorkingOrderV1Request request) throws Exception {
  String uri = "/workingorders/otc/{dealId}";
  uri = uri.replace("{dealId}", dealId==null?"":dealId);
  HttpDeleteWithBody deleteWithBody = new HttpDeleteWithBody(getIGApiDomainURL() +  addIGApiLightDarkCluster(uri));
  bindToConversionForDelete(conversationContext, deleteWithBody, request, "1");
  HttpResponse httpResponse = httpClient.execute(deleteWithBody);
  if (HttpStatus.OK.value() == httpResponse.getStatusLine().getStatusCode()) {
    return objectMapper.readValue(httpResponse.getEntity().getContent(), DeleteOTCWorkingOrderV1Response.class);
  }
  throw new RuntimeException("Delete failed: " + httpResponse.getStatusLine());
}

/*
Deletes an OTC working order.
*/
public DeleteOTCWorkingOrderV2Response deleteOTCWorkingOrderV2(ConversationContext conversationContext, String dealId) throws Exception {
  String uri = "/workingorders/otc/{dealId}";
  uri = uri.replace("{dealId}", dealId==null?"":dealId);
  HttpEntity<?> httpEntity = buildHttpEntity(conversationContext, null, "2");
  ResponseEntity<DeleteOTCWorkingOrderV2Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.DELETE, httpEntity, DeleteOTCWorkingOrderV2Response.class);
  return response.getBody();
}

/*
Returns the transaction history.
 By default returns the minute prices within the last 10 minutes.
*/
public GetTransactionHistoryV2Response getTransactionHistoryV2(ConversationContext conversationContext, String pageNumber, String maxSpanSeconds, String pageSize, String from, String to, String type) throws Exception {
  String uri = "/history/transactions";
  uri = uri + (pageNumber != null ? (uri.contains("?") ? "&" : "?") + "pageNumber=" + pageNumber : "");
  uri = uri + (maxSpanSeconds != null ? (uri.contains("?") ? "&" : "?") + "maxSpanSeconds=" + maxSpanSeconds : "");
  uri = uri + (pageSize != null ? (uri.contains("?") ? "&" : "?") + "pageSize=" + pageSize : "");
  uri = uri + (from != null ? (uri.contains("?") ? "&" : "?") + "from=" + from : "");
  uri = uri + (to != null ? (uri.contains("?") ? "&" : "?") + "to=" + to : "");
  uri = uri + (type != null ? (uri.contains("?") ? "&" : "?") + "type=" + type : "");
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "2");
  ResponseEntity<GetTransactionHistoryV2Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetTransactionHistoryV2Response.class);
  return response.getBody();
}

/*
Returns the transaction history for the specified transaction type and period.
*/
public GetTransactionHistoryV1Response getTransactionHistoryV1(ConversationContext conversationContext, String transactionType, String lastPeriod) throws Exception {
  String uri = "/history/transactions/{transactionType}/{lastPeriod}";
  uri = uri.replace("{transactionType}", transactionType==null?"":transactionType);
  uri = uri.replace("{lastPeriod}", lastPeriod==null?"":lastPeriod);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<GetTransactionHistoryV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetTransactionHistoryV1Response.class);
  return response.getBody();
}

/*
Returns the transaction history for the specified transaction type and given date range.
*/
public GetTransactionHistoryByTimeRangeV1Response getTransactionHistoryByTimeRangeV1(ConversationContext conversationContext, String transactionType, String fromDate, String toDate) throws Exception {
  String uri = "/history/transactions/{transactionType}/{fromDate}/{toDate}";
  uri = uri.replace("{transactionType}", transactionType==null?"":transactionType);
  uri = uri.replace("{fromDate}", fromDate==null?"":fromDate);
  uri = uri.replace("{toDate}", toDate==null?"":toDate);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<GetTransactionHistoryByTimeRangeV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetTransactionHistoryByTimeRangeV1Response.class);
  return response.getBody();
}

/*
Returns the account activity history.
*/
public GetActivityHistoryV2Response getActivityHistoryV2(ConversationContext conversationContext, String pageNumber, String maxSpanSeconds, String pageSize, String from, String to) throws Exception {
  String uri = "/history/activity";
  uri = uri + (pageNumber != null ? (uri.contains("?") ? "&" : "?") + "pageNumber=" + pageNumber : "");
  uri = uri + (maxSpanSeconds != null ? (uri.contains("?") ? "&" : "?") + "maxSpanSeconds=" + maxSpanSeconds : "");
  uri = uri + (pageSize != null ? (uri.contains("?") ? "&" : "?") + "pageSize=" + pageSize : "");
  uri = uri + (from != null ? (uri.contains("?") ? "&" : "?") + "from=" + from : "");
  uri = uri + (to != null ? (uri.contains("?") ? "&" : "?") + "to=" + to : "");
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "2");
  ResponseEntity<GetActivityHistoryV2Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetActivityHistoryV2Response.class);
  return response.getBody();
}

/*
Returns the account activity history for the last specified period.
*/
public GetActivityHistoryV1Response getActivityHistoryV1(ConversationContext conversationContext, String lastPeriod) throws Exception {
  String uri = "/history/activity/{lastPeriod}";
  uri = uri.replace("{lastPeriod}", lastPeriod==null?"":lastPeriod);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<GetActivityHistoryV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetActivityHistoryV1Response.class);
  return response.getBody();
}

/*
Returns the account activity history for the given date range.
*/
public GetActivityHistoryByTimeRangeV1Response getActivityHistoryByTimeRangeV1(ConversationContext conversationContext, String fromDate, String toDate) throws Exception {
  String uri = "/history/activity/{fromDate}/{toDate}";
  uri = uri.replace("{fromDate}", fromDate==null?"":fromDate);
  uri = uri.replace("{toDate}", toDate==null?"":toDate);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<GetActivityHistoryByTimeRangeV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetActivityHistoryByTimeRangeV1Response.class);
  return response.getBody();
}

/*
Returns the account activity history.
*/
public GetActivityHistoryV3Response getActivityHistoryV3(ConversationContext conversationContext, String filter, String detailed, String dealId, String pageSize, String from, String to) throws Exception {
  String uri = "/history/activity";
  uri = uri + (filter != null ? (uri.contains("?") ? "&" : "?") + "filter=" + filter : "");
  uri = uri + (detailed != null ? (uri.contains("?") ? "&" : "?") + "detailed=" + detailed : "");
  uri = uri + (dealId != null ? (uri.contains("?") ? "&" : "?") + "dealId=" + dealId : "");
  uri = uri + (pageSize != null ? (uri.contains("?") ? "&" : "?") + "pageSize=" + pageSize : "");
  uri = uri + (from != null ? (uri.contains("?") ? "&" : "?") + "from=" + from : "");
  uri = uri + (to != null ? (uri.contains("?") ? "&" : "?") + "to=" + to : "");
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "3");
  ResponseEntity<GetActivityHistoryV3Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetActivityHistoryV3Response.class);
  return response.getBody();
}

/*
Returns all top-level nodes (market categories) in the market navigation hierarchy.
*/
public GetMarketNavigationRootV1Response getMarketNavigationRootV1(ConversationContext conversationContext) throws Exception {
  String uri = "/marketnavigation";
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<GetMarketNavigationRootV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetMarketNavigationRootV1Response.class);
  return response.getBody();
}

/*
Returns all sub-nodes of the given node in the market navigation hierarchy.
*/
public GetMarketNavigationNodeV1Response getMarketNavigationNodeV1(ConversationContext conversationContext, String nodeId) throws Exception {
  String uri = "/marketnavigation/{nodeId}";
  uri = uri.replace("{nodeId}", nodeId==null?"":nodeId);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<GetMarketNavigationNodeV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetMarketNavigationNodeV1Response.class);
  return response.getBody();
}

/*
Alters the details of a given user application
*/
public com.iggroup.webapi.samples.client.rest.dto.application.updateApplicationV1.UpdateApplicationV1Response updateApplicationV1(ConversationContext conversationContext, UpdateApplicationV1Request request) throws Exception {
  String uri = "/operations/application";
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, request, "1");
  ResponseEntity<com.iggroup.webapi.samples.client.rest.dto.application.updateApplicationV1.UpdateApplicationV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.PUT, requestEntity, com.iggroup.webapi.samples.client.rest.dto.application.updateApplicationV1.UpdateApplicationV1Response.class);
  return response.getBody();
}

/*
Disables the current application key from processing further requests.  Disabled keys may be reenabled via the My Account section on our web dealing platform.
*/
public UpdateApplicationV1Response updateApplicationV1(ConversationContext conversationContext) throws Exception {
  String uri = "/operations/application/disable";
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<UpdateApplicationV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.PUT, requestEntity, UpdateApplicationV1Response.class);
  return response.getBody();
}

/*
Returns a list of client-owned applications
*/
public java.util.List<GetApplicationsV1ResponseItem> getApplicationsV1(ConversationContext conversationContext) throws Exception {
  String uri = "/operations/application";
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<GetApplicationsV1ResponseItem[]> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetApplicationsV1ResponseItem[].class);
  return Arrays.asList(response.getBody());
}

/*
Returns the client sentiment for the given instrument's market
*/
public GetClientSentimentV1Response getClientSentimentV1(ConversationContext conversationContext, String marketId) throws Exception {
  String uri = "/clientsentiment/{marketId}";
  uri = uri.replace("{marketId}", marketId==null?"":marketId);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<GetClientSentimentV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetClientSentimentV1Response.class);
  return response.getBody();
}

/*
Returns a list of related (what others have traded) client sentiment for the given instrument's market
*/
public GetRelatedClientSentimentV1Response getRelatedClientSentimentV1(ConversationContext conversationContext, String marketId) throws Exception {
  String uri = "/clientsentiment/related/{marketId}";
  uri = uri.replace("{marketId}", marketId==null?"":marketId);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<GetRelatedClientSentimentV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetRelatedClientSentimentV1Response.class);
  return response.getBody();
}

/*
Returns the details of the given market
*/
public GetMarketDetailsV1Response getMarketDetailsV1(ConversationContext conversationContext, String epic) throws Exception {
  String uri = "/markets/{epic}";
  uri = uri.replace("{epic}", epic==null?"":epic);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<GetMarketDetailsV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetMarketDetailsV1Response.class);
  return response.getBody();
}

/*
Returns the details of the given market.
*/
public GetMarketDetailsV2Response getMarketDetailsV2(ConversationContext conversationContext, String epic) throws Exception {
  String uri = "/markets/{epic}";
  uri = uri.replace("{epic}", epic==null?"":epic);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "2");
  ResponseEntity<GetMarketDetailsV2Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetMarketDetailsV2Response.class);
  return response.getBody();
}

/*
Returns the details of the given market.
*/
public GetMarketDetailsV3Response getMarketDetailsV3(ConversationContext conversationContext, String epic) throws Exception {
  String uri = "/markets/{epic}";
  uri = uri.replace("{epic}", epic==null?"":epic);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "3");
  ResponseEntity<GetMarketDetailsV3Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetMarketDetailsV3Response.class);
  return response.getBody();
}

/*
Returns the details of the given markets.
*/
public GetMarketDetailsListV1Response getMarketDetailsListV1(ConversationContext conversationContext, String epics) throws Exception {
  String uri = "/markets";
  uri = uri + (epics != null ? (uri.contains("?") ? "&" : "?") + "epics=" + epics : "");
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<GetMarketDetailsListV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetMarketDetailsListV1Response.class);
  return response.getBody();
}

/*
Returns the details of the given markets.
*/
public GetMarketDetailsListV2Response getMarketDetailsListV2(ConversationContext conversationContext, String filter, String epics) throws Exception {
  String uri = "/markets";
  uri = uri + (filter != null ? (uri.contains("?") ? "&" : "?") + "filter=" + filter : "");
  uri = uri + (epics != null ? (uri.contains("?") ? "&" : "?") + "epics=" + epics : "");
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "2");
  ResponseEntity<GetMarketDetailsListV2Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetMarketDetailsListV2Response.class);
  return response.getBody();
}

/*
Returns a list of accounts belonging to the logged-in client.
*/
public GetAccountsV1Response getAccountsV1(ConversationContext conversationContext) throws Exception {
  String uri = "/accounts";
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<GetAccountsV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetAccountsV1Response.class);
  return response.getBody();
}

/*
Creates a trading session, obtaining session tokens for subsequent API access.
 <p>
    Please note that region-specific <a href=/loginrestrictions>login restrictions</a> may apply.
 </p>
*/
public CreateSessionV1Response createSessionV1(ConversationContext conversationContext, CreateSessionV1Request request) throws Exception {
  String uri = "/session";
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, request, "1");
  ResponseEntity<CreateSessionV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.POST, requestEntity, CreateSessionV1Response.class);
  return response.getBody();
}

/*
Creates a trading session, obtaining session tokens for subsequent API access.
 <p>
    Please note that region-specific <a href=/loginrestrictions>login restrictions</a> may apply.
 </p>
*/
public CreateSessionV2Response createSessionV2(ConversationContext conversationContext, CreateSessionV2Request request) throws Exception {
  String uri = "/session";
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, request, "2");
  ResponseEntity<CreateSessionV2Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.POST, requestEntity, CreateSessionV2Response.class);
  return response.getBody();
}

/*
Refresh an access token
*/
public AccessTokenResponse refreshSessionV1(ConversationContext conversationContext, RefreshSessionV1Request request) throws Exception {
  String uri = "/session/refresh-token";
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, request, "1");
  ResponseEntity<AccessTokenResponse> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.POST, requestEntity, AccessTokenResponse.class);
  return response.getBody();
}

/*
Obtains session information
*/
public ResponseEntity<GetSessionV1Response> getSessionV1(ConversationContext conversationContext, boolean fetchSessionTokens) throws Exception {
  String uri = "/session?fetchSessionTokens=" + (fetchSessionTokens ? "true" : "false");
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  return restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetSessionV1Response.class);
}

/*
Creates a trading session, obtaining session tokens for subsequent API access
*/
public GetEncryptionKeySessionV1Response getEncryptionKeySessionV1(ConversationContext conversationContext) throws Exception {
  String uri = "/session/encryptionKey";
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<GetEncryptionKeySessionV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetEncryptionKeySessionV1Response.class);
  return response.getBody();
}

/*
Log out of the current session
*/
public void deleteSessionV1(ConversationContext conversationContext) throws Exception {
  String uri = "/session";
  HttpEntity<?> httpEntity = buildHttpEntity(conversationContext, null, "1");
  restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.DELETE, httpEntity, String.class);
}

/*
Returns all markets matching the search term.
*/
public GetMarketDetailsBySearchTermV1Response getMarketDetailsBySearchTermV1(ConversationContext conversationContext, String searchTerm) throws Exception {
  String uri = "/markets?searchTerm={searchTerm}";
  uri = uri.replace("{searchTerm}", searchTerm==null?"":searchTerm);
  HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, null, "1");
  ResponseEntity<GetMarketDetailsBySearchTermV1Response> response = restTemplate.exchange(getIGApiDomainURL() + addIGApiLightDarkCluster(uri), HttpMethod.GET, requestEntity, GetMarketDetailsBySearchTermV1Response.class);
  return response.getBody();
}
}
