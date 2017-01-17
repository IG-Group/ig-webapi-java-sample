package com.iggroup.webapi.samples.client.rest;


import com.iggroup.webapi.samples.client.RestAPI;
import com.iggroup.webapi.samples.client.rest.dto.session.createSessionV1.CreateSessionV1Request;
import com.iggroup.webapi.samples.client.rest.dto.session.createSessionV2.CreateSessionV2Request;
import com.iggroup.webapi.samples.client.rest.dto.session.createSessionV2.CreateSessionV2Response;
import com.iggroup.webapi.samples.client.rest.dto.session.createSessionV3.CreateSessionV3Request;
import com.iggroup.webapi.samples.client.rest.dto.session.createSessionV3.CreateSessionV3Response;
import com.iggroup.webapi.samples.client.rest.dto.session.encryptionKey.getEncryptionKeySessionV1.GetEncryptionKeySessionV1Response;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

@Service
public class AuthenticationService extends AbstractService {

   public static final Charset CHARSET = Charset.forName("UTF-8");
   public static final String PKCS1_PADDING_TRANSFORMATION = "RSA/ECB/PKCS1Padding";
   public static final String RSA_ALGORITHM = "RSA";

   @Autowired
   private RestAPI restApi;


   public AuthenticationResponseAndConversationContext createSession(CreateSessionV1Request authenticationRequest, String apiKey) {
      final ResponseEntity<CreateSessionV2Response> responseEntity = authenticate(authenticationRequest, apiKey);
      CreateSessionV2Response body = responseEntity.getBody();
      return new AuthenticationResponseAndConversationContext(
            new ConversationContextV2(
                  responseEntity.getHeaders().getFirst(Constants.CLIENT_SSO_TOKEN_NAME),
                  responseEntity.getHeaders().getFirst(Constants.ACCOUNT_SSO_TOKEN_NAME),
                  apiKey
            ), body.getCurrentAccountId(), body.getLightstreamerEndpoint()
      );
   }

   public AuthenticationResponseAndConversationContext createSession(CreateSessionV2Request authenticationRequest, String apiKey, boolean encrypted) {
      final ResponseEntity<CreateSessionV2Response> responseEntity = authenticate(authenticationRequest, apiKey, encrypted);
      CreateSessionV2Response body = responseEntity.getBody();
      return new AuthenticationResponseAndConversationContext(
            new ConversationContextV2(
                  responseEntity.getHeaders().getFirst(Constants.CLIENT_SSO_TOKEN_NAME),
                  responseEntity.getHeaders().getFirst(Constants.ACCOUNT_SSO_TOKEN_NAME),
                  apiKey
            ), body.getCurrentAccountId(), body.getLightstreamerEndpoint()
      );
   }

   public AuthenticationResponseAndConversationContext createSessionV3(CreateSessionV3Request authenticationRequest, String apiKey) {
      final ResponseEntity<CreateSessionV3Response> responseEntity = authenticateV3(authenticationRequest, apiKey);
      CreateSessionV3Response body = responseEntity.getBody();
      return AuthenticationResponseAndConversationContext.builder()
              .conversationContext(new ConversationContextV3(
                      body.getOauthToken(),
                      body.getAccountId(),
                      apiKey))
              .accountId(body.getAccountId())
              .lightstreamerEndpoint(body.getLightstreamerEndpoint()).build();
   }

   protected ResponseEntity<CreateSessionV2Response> authenticate(CreateSessionV1Request request, String apiKey) {
      ConversationContext conversationContext = new ConversationContextV2(null, null, apiKey);
      String uri = "/session";
      HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, request, "1");
      return restTemplate.exchange(getIGApiDomainURL() + "/" + addIGApiLightDarkCluster(uri), HttpMethod.POST, requestEntity, CreateSessionV2Response.class);
   }

   protected ResponseEntity<CreateSessionV2Response> authenticate(CreateSessionV2Request request, String apiKey, boolean encrypted) {
      ConversationContext conversationContext = new ConversationContextV2(null, null, apiKey);
      if (encrypted) {
         final GetEncryptionKeySessionV1Response encryptionKeySessionV1Response;
         try {
            encryptionKeySessionV1Response = restApi.getEncryptionKeySessionV1(conversationContext);
         } catch (Exception e) {
            throw new RuntimeException(e);
         }
         request.setPassword(encryptPassword(encryptionKeySessionV1Response.getEncryptionKey(), encryptionKeySessionV1Response.getTimeStamp(), request.getPassword()));
      }
      String uri = "/session";
      HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, request, "2");
      return restTemplate.exchange(getIGApiDomainURL() + "/" + addIGApiLightDarkCluster(uri), HttpMethod.POST, requestEntity, CreateSessionV2Response.class);
   }

   protected ResponseEntity<CreateSessionV3Response> authenticateV3(CreateSessionV3Request request, String apiKey) {
      ConversationContext conversationContext = new ConversationContextV3(null, null, apiKey);
      String uri = "/session";
      HttpEntity<?> requestEntity = buildHttpEntity(conversationContext, request, "3");
      return restTemplate.exchange(getIGApiDomainURL() + "/" + addIGApiLightDarkCluster(uri), HttpMethod.POST, requestEntity, CreateSessionV3Response.class);
   }

   public String encryptPassword(String encryptionKey, Long timestamp, String password) {
      try {
         byte[] input = stringToBytes(password + "|" + timestamp);
         input = Base64.encodeBase64(input);

         KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
         PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(Base64.decodeBase64(stringToBytes(encryptionKey))));

         Cipher cipher = Cipher.getInstance(PKCS1_PADDING_TRANSFORMATION);
         cipher.init(Cipher.ENCRYPT_MODE, publicKey);
         byte[] output = cipher.doFinal(input);

         output = Base64.encodeBase64(output);
         return bytesToString(output);
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }

   public byte[] stringToBytes(String string) {
      return string.getBytes(CHARSET);
   }

   public String bytesToString(byte[] bytes) {
      return new String(bytes, CHARSET);
   }

}
