package com.iggroup.webapi.samples.client.rest.dto.session.createSessionV3;

import com.iggroup.webapi.samples.client.rest.dto.session.createSessionV2.AccountType;
import lombok.Data;

@Data
public class CreateSessionV3Response {
private AccountType accountType;
    private String clientId;
    private String accountId;
    private int timezoneOffset;
    private String lightstreamerEndpoint;
    private AccessTokenResponse oauthToken;
}
