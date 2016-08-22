package com.iggroup.webapi.samples.client.streaming;


import com.lightstreamer.ls_client.ConnectionListener;
import com.lightstreamer.ls_client.PushConnException;
import com.lightstreamer.ls_client.PushServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionListenerAdapter implements ConnectionListener {

	private static final Logger LOG = LoggerFactory
			.getLogger(ConnectionListenerAdapter.class);

	@Override
	public void onConnectionEstablished() {
		LOG.debug("onConnectionEstablished");
	}

	@Override
	public void onSessionStarted(boolean b) {
		LOG.debug("onSessionStarted " + b);
	}

	@Override
	public void onNewBytes(long l) {
		LOG.debug("onNewBytes " + l);
	}

	@Override
	public void onDataError(PushServerException e) {
		LOG.debug("onDataError ", e);
	}

	@Override
	public void onActivityWarning(boolean b) {
		LOG.debug("onActivityWarning");
	}

	@Override
	public void onClose() {
		LOG.debug("onClose");
	}

	@Override
	public void onEnd(int i) {
		LOG.debug("onEnd " + i);
	}

	@Override
	public void onFailure(PushServerException e) {
		LOG.debug("onFailure", e);
		throw new RuntimeException("onFailure " + e);
	}

	@Override
	public void onFailure(PushConnException e) {
		LOG.debug("onFailure", e);
		throw new RuntimeException("onFailure " + e);
	}

}
