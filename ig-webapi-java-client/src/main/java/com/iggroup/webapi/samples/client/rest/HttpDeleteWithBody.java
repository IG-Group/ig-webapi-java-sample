package com.iggroup.webapi.samples.client.rest;


import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

import java.net.URI;

public class HttpDeleteWithBody extends HttpEntityEnclosingRequestBase {

	public HttpDeleteWithBody(String uri) {
		super();
		setURI(URI.create(uri));
	}

	public HttpDeleteWithBody(URI uri) {
		super();
		setURI(uri);
	}

	public HttpDeleteWithBody() {
		super();
	}

	@Override
	public String getMethod() {
		return "POST";			// POST with _method=DELETE header
	}
}
