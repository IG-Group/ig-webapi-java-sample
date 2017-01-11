package com.iggroup.webapi.samples.client.rest.dto.session.createSessionV3;

import lombok.Data;

@Data
public class AccessTokenResponse {
    private String access_token;
    private String refresh_token;
    private String scope;
    private String token_type;
    private String expires_in;
}
