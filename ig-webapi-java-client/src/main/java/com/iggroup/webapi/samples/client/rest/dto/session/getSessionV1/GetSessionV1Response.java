package com.iggroup.webapi.samples.client.rest.dto.session.getSessionV1;

import lombok.Data;

@Data
public class GetSessionV1Response {
    private String clientId;
    private String accountId;
    private int timezoneOffset;
    private String locale;
    private String currency;
    private String lightstreamerEndpoint;
}
