package com.iggroup.webapi.samples;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = "application-spring-context.xml")
public class BeanConfiguration {

   @Bean
   public HttpClient httpClient() {
      return HttpClients.createDefault();
   }

   @Bean
   @Qualifier(value = "ig.api.domain.URL")
   public String igApiDomainURL() {
      return PropertiesUtil.getProperty("environment.URL");
   }

}
