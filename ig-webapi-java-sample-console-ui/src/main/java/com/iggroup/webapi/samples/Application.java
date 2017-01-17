package com.iggroup.webapi.samples;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iggroup.webapi.samples.client.RestAPI;
import com.iggroup.webapi.samples.client.StreamingAPI;
import com.iggroup.webapi.samples.client.rest.AuthenticationResponseAndConversationContext;
import com.iggroup.webapi.samples.client.rest.ConversationContextV3;
import com.iggroup.webapi.samples.client.rest.dto.markets.getMarketDetailsV2.CurrenciesItem;
import com.iggroup.webapi.samples.client.rest.dto.markets.getMarketDetailsV2.GetMarketDetailsV2Response;
import com.iggroup.webapi.samples.client.rest.dto.markets.getMarketDetailsV2.MarketOrderPreference;
import com.iggroup.webapi.samples.client.rest.dto.markets.getMarketDetailsV3.Snapshot;
import com.iggroup.webapi.samples.client.rest.dto.positions.getPositionsV2.GetPositionsV2Response;
import com.iggroup.webapi.samples.client.rest.dto.positions.otc.createOTCPositionV1.CreateOTCPositionV1Request;
import com.iggroup.webapi.samples.client.rest.dto.positions.otc.createOTCPositionV1.Direction;
import com.iggroup.webapi.samples.client.rest.dto.positions.otc.createOTCPositionV1.OrderType;
import com.iggroup.webapi.samples.client.rest.dto.session.createSessionV3.CreateSessionV3Request;
import com.iggroup.webapi.samples.client.rest.dto.session.refreshSessionV1.RefreshSessionV1Request;
import com.iggroup.webapi.samples.client.rest.dto.watchlists.getWatchlistByWatchlistIdV1.GetWatchlistByWatchlistIdV1Response;
import com.iggroup.webapi.samples.client.rest.dto.watchlists.getWatchlistByWatchlistIdV1.MarketStatus;
import com.iggroup.webapi.samples.client.rest.dto.watchlists.getWatchlistByWatchlistIdV1.MarketsItem;
import com.iggroup.webapi.samples.client.rest.dto.watchlists.getWatchlistsV1.GetWatchlistsV1Response;
import com.iggroup.webapi.samples.client.rest.dto.watchlists.getWatchlistsV1.WatchlistsItem;
import com.iggroup.webapi.samples.client.streaming.HandyTableListenerAdapter;
import com.lightstreamer.ls_client.UpdateInfo;
import org.apache.commons.lang.StringUtils;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.HttpClientErrorException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.fusesource.jansi.Ansi.ansi;


/**
 * IG Web Trading API Sample Java application
 * <p/>
 * Usage:- Application identifier password apikey
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

   private static final Logger LOG = LoggerFactory.getLogger(Application.class);

   private final ObjectMapper objectMapper;
   private final RestAPI restApi;
   private final StreamingAPI streamingAPI;

   private AuthenticationResponseAndConversationContext authenticationContext = null;
   private ArrayList<HandyTableListenerAdapter> listeners = new ArrayList<>();

   private String tradeableEpic = null;
   private double marketHigh = 0.0;
   private double marketLow = 0.0;
   private double marketOffer = 0.0;
   private long initialTime = 0;
   private long currentTime = 0;
   private long lastTradedTime = 0;

   @Autowired
   public Application(RestAPI restApi, ObjectMapper objectMapper, StreamingAPI streamingAPI) {
      this.restApi = restApi;
      this.objectMapper = objectMapper;
      this.streamingAPI = streamingAPI;
   }

   @Override
   public void run(String... args) throws Exception {
         if (args.length < 3) {
            LOG.error("Usage:- Application identifier password apikey [epic]");
            System.exit(-1);
         }
         String identifier = args[0];
         String password = args[1];
         String apiKey = args[2];
         String epic = args.length > 3 ? args[3] : null;

         ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-spring-context.xml");
         Application app = (Application) applicationContext.getBean("application");
         System.exit(SpringApplication.exit(applicationContext, () -> app.run(identifier, password, apiKey, epic) ? 0 : 1));
   }

   private boolean run(final String user, final String password, final String apiKey, final String epic) {
      InputStreamReader reader = new InputStreamReader(System.in);
      try(BufferedReader in = new BufferedReader(reader)) {
         AnsiConsole.systemInstall();
         System.out.println(ansi().eraseScreen());

         connect(user, password, apiKey);

         if(StringUtils.isNotBlank(epic)) {
            tradeableEpic = getTradeableEpic(epic);
         } else {
            tradeableEpic = getTradableEpicFromWatchlist();
         }

         subscribeToLighstreamerAccountUpdates();
         subscribeToLighstreamerHeartbeat();
         subscribeToLighstreamerPriceUpdates();
         subscribeToLighstreamerTradeUpdates();

         logStatusMessage("Press ENTER to BUY");
         ConversationContextV3 contextV3 = (ConversationContextV3) authenticationContext.getConversationContext();
         while(true) {
            if(new Date().getTime() + 5000 > contextV3.getAccessTokenExpiry()) {    // Refresh the access token 5 seconds before expiry
               logStatusMessage("Refreshing access token");
               contextV3 = refreshAccessToken(contextV3);
            }
            Thread.sleep(20);
            if (in.ready()) {
               in.readLine();
               createPosition();
            }
         }
      } catch (Exception e) {
         logStatusMessage("Failure: " + e.getMessage());
         return false;
      } finally {
         disconnect();
         AnsiConsole.systemUninstall();
      }
   }

   public static void main(String args[]) {
      SpringApplication.run(Application.class, args);
   }

   private void disconnect() {
      unsubscribeAllLightstreamerListeners();
      streamingAPI.disconnect();
   }

   private void connect(String identifier, String password, String apiKey) throws Exception {
      logStatusMessage("Connecting as " + identifier);

      CreateSessionV3Request authRequest = new CreateSessionV3Request();
      authRequest.setIdentifier(identifier);
      authRequest.setPassword(password);
      authenticationContext = restApi.createSessionV3(authRequest, apiKey);
      streamingAPI.connect(authenticationContext.getAccountId(), authenticationContext.getConversationContext(), authenticationContext.getLightstreamerEndpoint());
   }

   private ConversationContextV3 refreshAccessToken(final ConversationContextV3 contextV3) throws Exception {
      logStatusMessage("Refreshing access token");
      ConversationContextV3 newContextV3 = new ConversationContextV3(restApi.refreshSessionV1(contextV3, RefreshSessionV1Request.builder().refresh_token(contextV3.getRefreshToken()).build()), contextV3.getAccountId(), contextV3.getApiKey());
      authenticationContext.setConversationContext(newContextV3);
      return newContextV3;
   }

   private int getOpenPositionCount() {
      GetPositionsV2Response positionsResponse = null;
      try {
         positionsResponse = restApi.getPositionsV2(authenticationContext.getConversationContext());
      } catch (Exception e) {
         logStatusMessage("Failed to get positions: " + e.getMessage());
      }
      return Optional.ofNullable(positionsResponse).map(positions -> positions.getPositions().size()).orElse(0);
   }

   private String getTradeableEpic(String epic) throws Exception {
      Snapshot snapshot = restApi.getMarketDetailsV3(authenticationContext.getConversationContext(), epic).getSnapshot();
      marketHigh = snapshot.getHigh().doubleValue();
      marketLow = snapshot.getLow().doubleValue();
      return epic;
   }

   private String getTradableEpicFromWatchlist() throws Exception {
      GetWatchlistsV1Response watchlistsResponse = restApi.getWatchlistsV1(authenticationContext.getConversationContext());
      for (WatchlistsItem watchlist : watchlistsResponse.getWatchlists()) {
         GetWatchlistByWatchlistIdV1Response watchlistInstrumentsResponse = restApi.getWatchlistByWatchlistIdV1(authenticationContext.getConversationContext(), watchlist.getId());
         for (MarketsItem market : watchlistInstrumentsResponse.getMarkets()) {
            if (market.getStreamingPricesAvailable() && market.getMarketStatus() == MarketStatus.TRADEABLE) {
               marketHigh = market.getHigh();
               marketLow = market.getLow();
               return market.getEpic();
            }
         }
      }
      return null;
   }

   private void createPosition() throws Exception {

      if (tradeableEpic != null) {
         GetMarketDetailsV2Response marketDetails = restApi.getMarketDetailsV2(authenticationContext.getConversationContext(), tradeableEpic);

         CreateOTCPositionV1Request createPositionRequest = new CreateOTCPositionV1Request();
         createPositionRequest.setEpic(tradeableEpic);
         createPositionRequest.setExpiry(marketDetails.getInstrument().getExpiry());
         createPositionRequest.setDirection(Direction.BUY);
         if(marketDetails.getDealingRules().getMarketOrderPreference() != MarketOrderPreference.NOT_AVAILABLE) {
            createPositionRequest.setOrderType(OrderType.MARKET);
         } else {
            createPositionRequest.setOrderType(OrderType.LIMIT);
            createPositionRequest.setLevel(marketDetails.getSnapshot().getOffer());
         }
         List<CurrenciesItem> currencies = marketDetails.getInstrument().getCurrencies();
         createPositionRequest.setCurrencyCode(currencies.size() > 0 ? currencies.get(0).getCode() : "GBP");
         createPositionRequest.setSize(BigDecimal.valueOf(marketDetails.getDealingRules().getMinDealSize().getValue()));
         createPositionRequest.setGuaranteedStop(false);
         createPositionRequest.setForceOpen(true);

         logStatusMessage(String.format("Creating long position epic=%s, expiry=%s size=%s orderType=%s level=%s currency=%s", tradeableEpic, createPositionRequest.getExpiry(), createPositionRequest.getSize(), createPositionRequest.getOrderType(), createPositionRequest.getLevel(), createPositionRequest.getCurrencyCode()));
         try {
            restApi.createOTCPositionV1(authenticationContext.getConversationContext(), createPositionRequest);
         } catch (HttpClientErrorException e) {
            logStatusMessage(String.format("Failed to create position: status=%s message=%s", e.getStatusCode().value(), e.getMessage()));
         }
      }

   }

   private JsonNode getExecutionReport(UpdateInfo updateInfo) {
      if(updateInfo.getNumFields() == 0) {
         throw new RuntimeException("Missing execution report data");
      }
      try {
         JsonNode content = objectMapper.readTree(updateInfo.toString());
         if(content.isArray()) {
            content = content.get(0);
         }
         return content;
      } catch (Exception e) {
         e.printStackTrace();
         throw new RuntimeException(e);
      }
   }

   private boolean isOrderAccepted(JsonNode content) {
      String dealStatus = content.get("dealStatus").asText();
      String dealId = content.get("dealId").asText();
      logStatusMessage(String.format("Deal dealId=%s has been %s", dealId, dealStatus));
      return content.get("dealStatus").asText().equals("ACCEPTED") && content.get("status").asText().equals("OPEN");
   }

   private void subscribeToLighstreamerAccountUpdates() throws Exception {

      logStatusMessage("Subscribing to Lightstreamer account updates");
      listeners.add(streamingAPI.subscribeForAccountBalanceInfo(authenticationContext.getAccountId(), new HandyTableListenerAdapter() {
         @Override
         public void onUpdate(int i, String s, UpdateInfo updateInfo) {
            double profitAndLoss = Double.valueOf(updateInfo.getNewValue("PNL"));
            logMessage(1, 1, "P&L:  " + profitAndLoss);
         }
      }));

   }

   private void subscribeToLighstreamerHeartbeat() throws Exception {
      logStatusMessage("Subscribing to Lightstreamer heartbeat");
      listeners.add(streamingAPI.subscribe(new HandyTableListenerAdapter() {
         @Override
         public void onUpdate(int i, String s, UpdateInfo updateInfo) {
            currentTime = Long.valueOf(updateInfo.getNewValue("HEARTBEAT"));
            if(initialTime == 0) {
               initialTime = currentTime;
            }
            logMessage(1, 2, "Time: " + currentTime);
            if(currentTime != lastTradedTime) {
               drawChartBar(marketOffer);
            }
         }
      }, new String[]{"TRADE:HB.U.HEARTBEAT.IP"}, "MERGE", new String[]{"HEARTBEAT"}));
   }

   private void subscribeToLighstreamerPriceUpdates() throws Exception {

      if (tradeableEpic != null) {
         logStatusMessage(String.format("Subscribing to Lightstreamer price updates for market: %s ", tradeableEpic));
         listeners.add(streamingAPI.subscribeForMarket(tradeableEpic, new HandyTableListenerAdapter() {
            @Override
            public void onUpdate(int i, String s, UpdateInfo updateInfo) {
               marketOffer = Double.valueOf(updateInfo.getNewValue("OFFER"));
               logMessage(1, 3, "EPIC: " + tradeableEpic + "    Offer price: " + marketOffer);
               if(currentTime != lastTradedTime) {
                  drawChartBar(marketOffer);
               }
            }
         }, "OFFER"));
      }
   }

   private void subscribeToLighstreamerTradeUpdates() throws Exception {
      logStatusMessage("Subscribing to Lightstreamer trade updates");
      listeners.add(streamingAPI.subscribeForOPUs(authenticationContext.getAccountId(), new HandyTableListenerAdapter() {
         @Override
         public void onUpdate(int i, String s, UpdateInfo updateInfo) {
            logMessage(1, 4, "Open positions: " + getOpenPositionCount());
         }
      }));
      listeners.add(streamingAPI.subscribeForConfirms(authenticationContext.getAccountId(), new HandyTableListenerAdapter() {
         @Override
         public void onUpdate(int i, String s, UpdateInfo updateInfo) {
            if (updateInfo.getNewValue("CONFIRMS") != null) {
               JsonNode content = getExecutionReport(updateInfo);
               double level = content.get("level").asDouble();
               if(!isOrderAccepted(content) && level <= 0) {
                  level = marketOffer;
               }
               drawChartBar(level, isOrderAccepted(content) ? Ansi.Color.GREEN : Ansi.Color.RED);
               lastTradedTime = currentTime;
            }
         }
      }));
   }

   private void unsubscribeAllLightstreamerListeners() {
      for (HandyTableListenerAdapter listener : listeners) {
         try {
            streamingAPI.unsubscribe(listener.getSubscribedTableKey());
         } catch (Exception e) {
            logStatusMessage("Failed to unsubscribe Lightstreamer listener");
         }
      }
   }


   private void logStatusMessage(String message) {
      logMessage(1, 50, message, Ansi.Color.CYAN, Ansi.Color.DEFAULT, Ansi.Attribute.NEGATIVE_ON, Ansi.Attribute.UNDERLINE);
   }

   private void logMessage(int x, int y, String message) {
      logMessage(x, y, message, Ansi.Color.DEFAULT, null);
   }

   private void logMessage(int x, int y, String message, Ansi.Color fgColor, Ansi.Color bgColor, Ansi.Attribute... attributes) {
      message = message.substring(0, Math.min(message.length(), 120));
      Ansi ansi = ansi().cursor(y, x).eraseLine();
      if(attributes != null) {
         for (Ansi.Attribute attribute : attributes) {
            ansi = ansi.a(attribute);
         }
      }
      ansi = ansi.fg(fgColor != null ? fgColor : Ansi.Color.DEFAULT);
      ansi = ansi.bg(bgColor != null ? bgColor : Ansi.Color.DEFAULT);
      System.out.println(ansi.a(message).reset());
   }

   private void drawChartBar(double value) {
      drawChartBar(value, Ansi.Color.CYAN);
   }

   private void drawChartBar(double value, Ansi.Color color) {
      if(value <= 0) {
         return;
      }
      int maxHeight = 40;
      int maxWidth = 120;
      int yLow = 47;
      int yHigh = yLow - maxHeight;
      int x = (int) (currentTime - initialTime + 1);
      if(x > maxWidth) {
         initialTime = currentTime;
         System.out.println(ansi().eraseScreen().reset());
      }

      double dHighLow = marketHigh - marketLow;
      int lines = (int) Math.round (maxHeight / dHighLow * (value - marketLow));
      System.out.println(ansi().cursor(yLow + 1, x).eraseLine().a("-").reset());
      System.out.println(ansi().cursor(yHigh - 1, x).eraseLine().a("-").reset());
      for(int y=yLow,count=lines; count > 0; y--, count--) {
         System.out.println(ansi().cursor(y, x).eraseLine().bg(color).a(" ").reset());
      }
      System.out.println(ansi().cursor(yLow - lines + 1, x + 1).eraseLine().a(marketOffer).reset());
      for(int y=yLow - lines; y >= yHigh; y--) {
         System.out.println(ansi().cursor(y, x).eraseLine().reset());
      }
      System.out.println(ansi().cursor(yLow + 1, x + 1).eraseLine().a(marketLow + " (low)").reset());
      System.out.println(ansi().cursor(yHigh - 1, x + 1).eraseLine().a(marketHigh + " (high)").reset());
   }
}
