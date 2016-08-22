package com.iggroup.webapi.samples.client.rest.dto.session.createSessionV2;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Client login credentials
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateSessionV2Request {

/*
Client login identifier
*/
private String identifier;

/*
Client login password
*/
private String password;

/*
Whether the password has been sent encrypted.
*/
private Boolean encryptedPassword;

public String getIdentifier() { return identifier; }
public void setIdentifier(String identifier) { this.identifier=identifier; }
public String getPassword() { return password; }
public void setPassword(String password) { this.password=password; }
public Boolean getEncryptedPassword() { return encryptedPassword; }
public void setEncryptedPassword(Boolean encryptedPassword) { this.encryptedPassword=encryptedPassword; }
}
