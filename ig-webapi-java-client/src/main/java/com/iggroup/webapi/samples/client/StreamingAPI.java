package com.iggroup.webapi.samples.client;


import com.iggroup.webapi.samples.client.rest.*;
import com.iggroup.webapi.samples.client.rest.dto.session.getSessionV1.GetSessionV1Response;
import com.iggroup.webapi.samples.client.streaming.ConnectionListenerAdapter;
import com.iggroup.webapi.samples.client.streaming.HandyTableListenerAdapter;
import com.lightstreamer.ls_client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class StreamingAPI {

	private static final String TRADE_PATTERN = "TRADE:{accountId}";
	private static final String ACCOUNT_BALANCE_INFO_PATTERN = "ACCOUNT:{accountId}";
	private static final String MARKET_L1_PATTERN = "MARKET:{epic}";
	private static final String SPRINT_MARKET_PATTERN = "MARKET:{epic}";
	private static final String CHART_TICK_PATTERN = "CHART:{epic}:TICK";
	private static final String CHART_CANDLE_PATTERN = "CHART:{epic}:{scale}";

	private LSClient lsClient;
	private final RestAPI restAPI;

	private enum PasswordStrategy {
		CLIENT("CST-"),
		VENDOR("B2B-");

		String token;
		static RestAPI restAPI;

		PasswordStrategy(String token) {
			this.token = token;
		}

		String get(ConversationContext conversationContext) throws Exception {
			ConversationContextV2 contextV2;
			if(conversationContext instanceof ConversationContextV3) {
				// Fetch V2 security tokens
				ResponseEntity<GetSessionV1Response> sessionV1Response = restAPI.getSessionV1(conversationContext, true);
				contextV2 = new ConversationContextV2(
						sessionV1Response.getHeaders().getFirst(Constants.CLIENT_SSO_TOKEN_NAME),
						sessionV1Response.getHeaders().getFirst(Constants.ACCOUNT_SSO_TOKEN_NAME),
						conversationContext.getApiKey());
			} else {
				contextV2 = (ConversationContextV2) conversationContext;
			}
			StringBuilder password = new StringBuilder();
			if (contextV2.getClientSecurityToken() != null
					&& !contextV2.getAccountSecurityToken().isEmpty()) {
				password.append(token).append(contextV2.getClientSecurityToken());
			}
			if (contextV2.getClientSecurityToken() != null
					&& !contextV2.getClientSecurityToken().isEmpty()
					&& contextV2.getAccountSecurityToken() != null
					&& !contextV2.getAccountSecurityToken().isEmpty()) {
				password.append("|");
			}
			if (!contextV2.getAccountSecurityToken().isEmpty()) {
				password.append("XST-").append(contextV2.getAccountSecurityToken());
			}
			return password.toString();
		}
	}

	@Autowired
	public StreamingAPI(RestAPI restAPI) {
		this.restAPI = restAPI;
		PasswordStrategy.restAPI = restAPI;
	}

	public ConnectionListener connect(String username,
												 ConversationContext conversationContext,
												 String lightstreamerEndpoint) throws Exception {
		return connect(username, conversationContext, PasswordStrategy.CLIENT, lightstreamerEndpoint);
	}

	public ConnectionListener connectVendor(String username,
												 ConversationContext conversationContext,
												 String lightstreamerEndpoint) throws Exception {
		return connect(username, conversationContext, PasswordStrategy.VENDOR, lightstreamerEndpoint);
	}

	private ConnectionListener connect(String username,
												 ConversationContext conversationContext,
												 PasswordStrategy passwordStrategy,
												 String lightstreamerEndpoint) throws Exception {

		lsClient = new LSClient();
		ConnectionInfo connectionInfo = new ConnectionInfo();
		connectionInfo.user = username;
		connectionInfo.password = passwordStrategy.get(conversationContext);
		connectionInfo.pushServerUrl = lightstreamerEndpoint;

		final ConnectionListenerAdapter adapter = new ConnectionListenerAdapter();

		lsClient.openConnection(connectionInfo, adapter);

		return adapter;
	}

	public void disconnect() {
		if(lsClient != null) {
			lsClient.closeConnection();
		}
	}

	public void unsubscribe(SubscribedTableKey key) throws Exception {
		if(lsClient != null) {
			lsClient.forceUnsubscribeTable(key);
		}
	}

	public HandyTableListenerAdapter subscribe(HandyTableListenerAdapter adapter, String[] items, String mode, String[] fields) throws Exception {
		ExtendedTableInfo extendedTableInfo = new ExtendedTableInfo(items, mode, fields, false);
		adapter.setSubscribedTableKey(lsClient.subscribeTable(extendedTableInfo, adapter, false));
		return adapter;
	}

	public HandyTableListenerAdapter subscribeForConfirms(String accountId,
			HandyTableListenerAdapter adapter) throws Exception {
		String tradeKey = TRADE_PATTERN.replace("{accountId}", accountId);

		ExtendedTableInfo extendedTableInfo = new ExtendedTableInfo(
				new String[]{tradeKey}, "DISTINCT", new String[]{"CONFIRMS"},
				false);

		final SubscribedTableKey subscribedTableKey = lsClient.subscribeTable(
				extendedTableInfo, adapter, false);
		adapter.setSubscribedTableKey(subscribedTableKey);
		return adapter;
	}

	public HandyTableListenerAdapter subscribeForAccountBalanceInfo(
			String accountId, HandyTableListenerAdapter adapter)
			throws Exception {
		String subscriptionKey = ACCOUNT_BALANCE_INFO_PATTERN.replace(
				"{accountId}", accountId);

		ExtendedTableInfo extendedTableInfo = new ExtendedTableInfo(
				new String[]{subscriptionKey}, "MERGE", new String[]{"PNL",
						"DEPOSIT", "USED_MARGIN", "AMOUNT_DUE",
						"AVAILABLE_CASH"}, true);

		final SubscribedTableKey subscribedTableKey = lsClient.subscribeTable(
				extendedTableInfo, adapter, false);
		adapter.setSubscribedTableKey(subscribedTableKey);
		return adapter;
	}

	public HandyTableListenerAdapter subscribeForMarket(String epic,
			HandyTableListenerAdapter adapter) throws Exception {
		String subscriptionKey = MARKET_L1_PATTERN.replace("{epic}", epic);

		ExtendedTableInfo extendedTableInfo = new ExtendedTableInfo(
				new String[]{subscriptionKey}, "MERGE", new String[]{"BID",
						"OFFER", "MARKET_STATE"}, true);

		final SubscribedTableKey subscribedTableKey = lsClient.subscribeTable(
				extendedTableInfo, adapter, false);
		adapter.setSubscribedTableKey(subscribedTableKey);
		return adapter;
	}

	public HandyTableListenerAdapter subscribeForMarket(String epic, HandyTableListenerAdapter adapter, String... fields) throws Exception {
		String subscriptionKey = MARKET_L1_PATTERN.replace("{epic}", epic);

		ExtendedTableInfo extendedTableInfo = new ExtendedTableInfo(new String[] { subscriptionKey }, "MERGE", fields, true);

		final SubscribedTableKey subscribedTableKey = lsClient.subscribeTable(extendedTableInfo, adapter, false);
		adapter.setSubscribedTableKey(subscribedTableKey);
		return adapter;
	}

	public HandyTableListenerAdapter subscribeForB2CSprintMarket(String epic,
			HandyTableListenerAdapter adapter) throws Exception {
		String subscriptionKey = SPRINT_MARKET_PATTERN.replace("{epic}", epic);

		ExtendedTableInfo extendedTableInfo = new ExtendedTableInfo(
				new String[]{subscriptionKey}, "MERGE", new String[]{"STRIKE_PRICE", "MARKET_STATE", "ODDS"}, true);

		final SubscribedTableKey subscribedTableKey = lsClient.subscribeTable(
				extendedTableInfo, adapter, false);
		adapter.setSubscribedTableKey(subscribedTableKey);
		return adapter;
	}

   public HandyTableListenerAdapter subscribeForB2BSprintMarket(String epic,
                                                             HandyTableListenerAdapter adapter) throws Exception {
      String subscriptionKey = SPRINT_MARKET_PATTERN.replace("{epic}", epic);

      ExtendedTableInfo extendedTableInfo = new ExtendedTableInfo(
            new String[]{subscriptionKey}, "MERGE", new String[]{"STRIKE_PRICE", "SETTLEMENT_PRICE", "MARKET_STATE", "ODDS"}, true);

      final SubscribedTableKey subscribedTableKey = lsClient.subscribeTable(
            extendedTableInfo, adapter, false);
      adapter.setSubscribedTableKey(subscribedTableKey);
      return adapter;
   }


	public HandyTableListenerAdapter subscribeForOPUs(String accountId,
			HandyTableListenerAdapter adapter) throws Exception {
		String tradeKey = TRADE_PATTERN.replace("{accountId}", accountId);

		ExtendedTableInfo extendedTableInfo = new ExtendedTableInfo(
				new String[]{tradeKey}, "DISTINCT", new String[]{"OPU"}, false);

		final SubscribedTableKey subscribedTableKey = lsClient.subscribeTable(
				extendedTableInfo, adapter, false);
		adapter.setSubscribedTableKey(subscribedTableKey);
		return adapter;
	}

	public HandyTableListenerAdapter subscribeForWOUs(String accountId,
			HandyTableListenerAdapter adapter) throws Exception {
		String tradeKey = TRADE_PATTERN.replace("{accountId}", accountId);

		ExtendedTableInfo extendedTableInfo = new ExtendedTableInfo(
				new String[]{tradeKey}, "DISTINCT", new String[]{"WOU"}, false);

		final SubscribedTableKey subscribedTableKey = lsClient.subscribeTable(
				extendedTableInfo, adapter, false);
		adapter.setSubscribedTableKey(subscribedTableKey);
		return adapter;
	}

	public HandyTableListenerAdapter subscribeForChartTicks(String epic,
			HandyTableListenerAdapter adapter) throws Exception {
		String subscriptionKey = CHART_TICK_PATTERN.replace("{epic}", epic);

		ExtendedTableInfo extendedTableInfo = new ExtendedTableInfo(
				new String[]{subscriptionKey}, "DISTINCT", new String[]{"BID",
						"OFR", "LTP", "LTV", "UTM", "DAY_OPEN_MID",
						"DAY_PERC_CHG_MID", "DAY_HIGH", "DAY_LOW"}, true);

		final SubscribedTableKey subscribedTableKey = lsClient.subscribeTable(
				extendedTableInfo, adapter, false);
		adapter.setSubscribedTableKey(subscribedTableKey);
		return adapter;
	}

	public HandyTableListenerAdapter subscribeForChartCandles(String epic,
			String scale, HandyTableListenerAdapter adapter) throws Exception {
		String subscriptionKey = CHART_CANDLE_PATTERN.replace("{epic}", epic);
		subscriptionKey = subscriptionKey.replace("{scale}", scale);

		ExtendedTableInfo extendedTableInfo = new ExtendedTableInfo(
				new String[]{subscriptionKey}, "MERGE", new String[]{"LTV",
				"TTV", "UTM", "DAY_OPEN_MID","DAY_NET_CHG_MID",
				"DAY_PERC_CHG_MID", "DAY_HIGH", "DAY_LOW", "OFR_OPEN",
				"OFR_HIGH", "OFR_LOW", "OFR_CLOSE", "BID_OPEN",
				"BID_HIGH", "BID_LOW", "BID_CLOSE", "LTP_OPEN",
				"LTP_HIGH", "LTP_LOW", "LTP_CLOSE", "CONS_END",
				"CONS_TICK_COUNT"}, true);

		final SubscribedTableKey subscribedTableKey = lsClient.subscribeTable(
				extendedTableInfo, adapter, false);
		adapter.setSubscribedTableKey(subscribedTableKey);
		return adapter;
	}

}
