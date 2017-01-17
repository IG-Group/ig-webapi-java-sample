package com.iggroup.webapi.samples;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iggroup.webapi.samples.client.RestAPI;
import com.iggroup.webapi.samples.client.StreamingAPI;
import com.iggroup.webapi.samples.client.rest.AuthenticationResponseAndConversationContext;
import com.iggroup.webapi.samples.client.rest.dto.markets.getMarketDetailsV2.CurrenciesItem;
import com.iggroup.webapi.samples.client.rest.dto.markets.getMarketDetailsV2.GetMarketDetailsV2Response;
import com.iggroup.webapi.samples.client.rest.dto.markets.getMarketDetailsV2.MarketOrderPreference;
import com.iggroup.webapi.samples.client.rest.dto.positions.getPositionsV2.GetPositionsV2Response;
import com.iggroup.webapi.samples.client.rest.dto.positions.getPositionsV2.PositionsItem;
import com.iggroup.webapi.samples.client.rest.dto.positions.otc.closeOTCPositionV1.CloseOTCPositionV1Request;
import com.iggroup.webapi.samples.client.rest.dto.positions.otc.closeOTCPositionV1.TimeInForce;
import com.iggroup.webapi.samples.client.rest.dto.positions.otc.createOTCPositionV1.CreateOTCPositionV1Request;
import com.iggroup.webapi.samples.client.rest.dto.positions.otc.createOTCPositionV1.Direction;
import com.iggroup.webapi.samples.client.rest.dto.positions.otc.createOTCPositionV1.OrderType;
import com.iggroup.webapi.samples.client.rest.dto.session.createSessionV2.CreateSessionV2Request;
import com.iggroup.webapi.samples.client.rest.dto.watchlists.getWatchlistByWatchlistIdV1.GetWatchlistByWatchlistIdV1Response;
import com.iggroup.webapi.samples.client.rest.dto.watchlists.getWatchlistByWatchlistIdV1.MarketStatus;
import com.iggroup.webapi.samples.client.rest.dto.watchlists.getWatchlistByWatchlistIdV1.MarketsItem;
import com.iggroup.webapi.samples.client.rest.dto.watchlists.getWatchlistsV1.GetWatchlistsV1Response;
import com.iggroup.webapi.samples.client.rest.dto.watchlists.getWatchlistsV1.WatchlistsItem;
import com.iggroup.webapi.samples.client.streaming.HandyTableListenerAdapter;
import com.lightstreamer.ls_client.UpdateInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;


/**
 * IG Web Trading API Sample Java application
 * <p/>
 * Usage:- Application identifier password apikey
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

   private static final Logger LOG = LoggerFactory.getLogger(Application.class);

   @Autowired
   protected ObjectMapper objectMapper;

   @Autowired
   private RestAPI restApi;

   @Autowired
   private StreamingAPI streamingAPI;

   private AuthenticationResponseAndConversationContext authenticationContext = null;
   private ArrayList<HandyTableListenerAdapter> listeners = new ArrayList<HandyTableListenerAdapter>();

   private String tradeableEpic = null;

   private AtomicBoolean receivedConfirm = new AtomicBoolean(false);
   private AtomicBoolean receivedOPU = new AtomicBoolean(false);

   @Override
   public void run(String... args) throws Exception {
         if (args.length < 2) {
            LOG.error("Usage:- Application identifier password apikey");
            System.exit(-1);
         }
         String identifier = args[0];
         String password = args[1];
         String apiKey = args[2];
         ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-spring-context.xml");
         Application app = (Application) applicationContext.getBean("application");
         System.exit(SpringApplication.exit(applicationContext, () -> app.run(identifier, password, apiKey) ? 0 : 1));
   }

   public boolean run(final String user, final String password, final String apiKey) {
      try {
         connect(user, password, apiKey);
         listOpenPositions();
         listWatchlists();
         subscribeToLighstreamerAccountUpdates();
         subscribeToLighstreamerHeartbeat();
         subscribeToLighstreamerPriceUpdates();
         subscribeToLighstreamerChartUpdates();
         subscribeToLighstreamerTradeUpdates();
         createPosition();

         LOG.info("Waiting 15 seconds...");
         Thread.sleep(15000); // to let the streaming run a while

         disconnect();
         LOG.info("Done");

         return receivedConfirm.get() && receivedOPU.get();
      } catch (Exception e) {
         LOG.error("Unexpected error:", e);
         return false;
      }
   }

   public static void main(String args[]) {
      SpringApplication.run(Application.class, args);
   }

   private void disconnect() throws Exception {
      unsubscribeAllLightstreamerListeners();
     streamingAPI.disconnect();
   }

   private void connect(String identifier, String password, String apiKey) throws Exception {
      LOG.info("Connecting as {}", identifier);

      boolean encrypt = Boolean.TRUE;

      CreateSessionV2Request authRequest = new CreateSessionV2Request();
      authRequest.setIdentifier(identifier);
      authRequest.setPassword(password);
      authRequest.setEncryptedPassword(encrypt);
      authenticationContext = restApi.createSession(authRequest, apiKey, encrypt);
      streamingAPI.connect(authenticationContext.getAccountId(), authenticationContext.getConversationContext(), authenticationContext.getLightstreamerEndpoint());
   }

   private void listOpenPositions() throws Exception {

      GetPositionsV2Response positionsResponse = restApi.getPositionsV2(authenticationContext.getConversationContext());
      LOG.info("Open positions: {}", positionsResponse.getPositions().size());
      for (PositionsItem position : positionsResponse.getPositions()) {
         LOG.info(position.getMarket().getEpic() + ", " + position.getMarket().getExpiry() + ", " + position.getPosition().getDirection() + ", " + position.getPosition().getSize());
      }

   }

   private void listWatchlists() throws Exception {

      GetWatchlistsV1Response watchlistsResponse = restApi.getWatchlistsV1(authenticationContext.getConversationContext());
      LOG.info("Watchlists: {}", watchlistsResponse.getWatchlists().size());
      for (WatchlistsItem watchlist : watchlistsResponse.getWatchlists()) {
         LOG.info(watchlist.getName() + " : ");
         GetWatchlistByWatchlistIdV1Response watchlistInstrumentsResponse = restApi.getWatchlistByWatchlistIdV1(authenticationContext.getConversationContext(), watchlist.getId());
         for (MarketsItem market : watchlistInstrumentsResponse.getMarkets()) {
            LOG.info(market.getEpic());
            if (market.getStreamingPricesAvailable() && market.getMarketStatus() == MarketStatus.TRADEABLE) {
               tradeableEpic = market.getEpic();
            }
         }
      }
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

         LOG.info(">>> Creating long position epic={}, expiry={} size={} orderType={} level={} currency={}", tradeableEpic, createPositionRequest.getExpiry(),
                 createPositionRequest.getSize(), createPositionRequest.getOrderType(), createPositionRequest.getLevel(), createPositionRequest.getCurrencyCode());
         restApi.createOTCPositionV1(authenticationContext.getConversationContext(), createPositionRequest);
      }

   }

   private void closePositionIfCreated(UpdateInfo updateInfo) {
      if(updateInfo.getNumFields() == 0) {
         return;
      }
      try {
         JsonNode content = objectMapper.readTree(updateInfo.toString());
         if(content.isArray()) {
            content = content.get(0);
         }
         String dealStatus = content.get("dealStatus").asText();
         String dealId = content.get("dealId").asText();
         LOG.info("Deal dealId={} has been {}", dealId, dealStatus);
         if(content.get("dealStatus").asText().equals("ACCEPTED") && content.get("status").asText().equals("OPEN")) {
            closeOpenPosition(
                    content.get("affectedDeals").get(0).get("dealId").asText(),
                    content.get("direction").asText().equals("BUY") ? "SELL" : "BUY",
                    new BigDecimal(content.get("size").asText()),
                    content.get("expiry").asText());
         }
      } catch (Exception e) {
         e.printStackTrace();
         throw new RuntimeException(e);
      }
   }

   private void closeOpenPosition(String dealId, String direction, BigDecimal size, String expiry) throws Exception {
      GetMarketDetailsV2Response marketDetails = restApi.getMarketDetailsV2(authenticationContext.getConversationContext(), tradeableEpic);
      CloseOTCPositionV1Request closePositionRequest = new CloseOTCPositionV1Request();
      closePositionRequest.setDealId(dealId);
      closePositionRequest.setDirection(com.iggroup.webapi.samples.client.rest.dto.positions.otc.closeOTCPositionV1.Direction.valueOf(direction));
      closePositionRequest.setSize(size);
      closePositionRequest.setExpiry(expiry);
      if(marketDetails.getDealingRules().getMarketOrderPreference() != MarketOrderPreference.NOT_AVAILABLE) {
         closePositionRequest.setOrderType(com.iggroup.webapi.samples.client.rest.dto.positions.otc.closeOTCPositionV1.OrderType.MARKET);
      } else {
         closePositionRequest.setOrderType(com.iggroup.webapi.samples.client.rest.dto.positions.otc.closeOTCPositionV1.OrderType.LIMIT);
         closePositionRequest.setLevel(marketDetails.getSnapshot().getBid());
      }
      closePositionRequest.setTimeInForce(TimeInForce.FILL_OR_KILL);

      LOG.info("<<< Closing position: dealId={} direction={} size={} expiry={} orderType={} level={}", dealId, direction, size, expiry,
              closePositionRequest.getOrderType(), closePositionRequest.getLevel());
      restApi.closeOTCPositionV1(authenticationContext.getConversationContext(), closePositionRequest);
   }

   private void subscribeToLighstreamerAccountUpdates() throws Exception {

      LOG.info("Subscribing to Lightstreamer account updates");
      listeners.add(streamingAPI.subscribeForAccountBalanceInfo(authenticationContext.getAccountId(), new HandyTableListenerAdapter() {
         @Override
         public void onUpdate(int i, String s, UpdateInfo updateInfo) {
            LOG.info("Account balance info = " + updateInfo);
         }
      }));

   }

   private void subscribeToLighstreamerHeartbeat() throws Exception {
      LOG.info("Subscribing to Lightstreamer heartbeat");
      listeners.add(streamingAPI.subscribe(new HandyTableListenerAdapter() {
         @Override
         public void onUpdate(int i, String s, UpdateInfo updateInfo) {
            LOG.info("Heartbeat = " + updateInfo);
         }
      }, new String[]{"TRADE:HB.U.HEARTBEAT.IP"}, "MERGE", new String[]{"HEARTBEAT"}));
   }

   private void subscribeToLighstreamerPriceUpdates() throws Exception {

      if (tradeableEpic != null) {
         LOG.info("Subscribing to Lightstreamer price updates for market: {} ", tradeableEpic);
         listeners.add(streamingAPI.subscribeForMarket(tradeableEpic, new HandyTableListenerAdapter() {
            @Override
            public void onUpdate(int i, String s, UpdateInfo updateInfo) {
               LOG.info("Market i {} s {} data {}", i, s, updateInfo);
            }
         }));
      }
   }

   private void subscribeToLighstreamerChartUpdates() throws Exception {

      if (tradeableEpic != null) {
         LOG.info("Subscribing to Lightstreamer chart updates for market: {} ", tradeableEpic);
         listeners.add(streamingAPI.subscribeForChartTicks(tradeableEpic, new HandyTableListenerAdapter() {
            @Override
            public void onUpdate(int i, String s, UpdateInfo updateInfo) {
               LOG.info("Chart i {} s {} data {}", i, s, updateInfo);
            }
         }));
      }
   }

   private void subscribeToLighstreamerTradeUpdates() throws Exception {

      LOG.info("Subscribing to Lightstreamer trade updates");
      listeners.add(streamingAPI.subscribeForOPUs(authenticationContext.getAccountId(), new HandyTableListenerAdapter() {
         @Override
         public void onUpdate(int i, String s, UpdateInfo updateInfo) {
            if (updateInfo.getNewValue("OPU") != null) {
               LOG.info("Position update i {} s {} data {}", i, s, updateInfo);
               receivedOPU.set(true);
            }
         }
      }));
      listeners.add(streamingAPI.subscribeForWOUs(authenticationContext.getAccountId(), new HandyTableListenerAdapter() {
         @Override
         public void onUpdate(int i, String s, UpdateInfo updateInfo) {
            if (updateInfo.getNewValue("WOU") != null) {
               LOG.info("Working order update i {} s {} data {}", i, s, updateInfo);
            }
         }
      }));
      listeners.add(streamingAPI.subscribeForConfirms(authenticationContext.getAccountId(), new HandyTableListenerAdapter() {
         @Override
         public void onUpdate(int i, String s, UpdateInfo updateInfo) {
            if (updateInfo.getNewValue("CONFIRMS") != null) {
               LOG.info("Trade confirm update i {} s {} data {}", i, s, updateInfo);
               receivedConfirm.set(true);
               closePositionIfCreated(updateInfo);
            }
         }
      }));
   }

   private void unsubscribeAllLightstreamerListeners() throws Exception {

      for (HandyTableListenerAdapter listener : listeners) {
         streamingAPI.unsubscribe(listener.getSubscribedTableKey());
      }
   }
}
