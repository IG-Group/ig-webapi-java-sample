package com.iggroup.webapi.samples.client.rest.dto.session.encryptionKey.getEncryptionKeySessionV1;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
The encryption key to use in order to send the user password in an encrypted form
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetEncryptionKeySessionV1Response {

/*
Encryption key in Base 64 format
*/
private String encryptionKey;

/*
Current timestamp in milliseconds since epoch
*/
private Long timeStamp;

public String getEncryptionKey() { return encryptionKey; }
public void setEncryptionKey(String encryptionKey) { this.encryptionKey=encryptionKey; }
public Long getTimeStamp() { return timeStamp; }
public void setTimeStamp(Long timeStamp) { this.timeStamp=timeStamp; }
}
