package com.iggroup.webapi.samples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

   private static final Logger LOG = LoggerFactory.getLogger(PropertiesUtil.class);

   private static final String PROPERTY_FILENAME = "environment.properties";

   private static Properties theProperties;

   public static Properties getProperties() throws RuntimeException {
      if (theProperties == null) {
         theProperties = new Properties();

         String filename = PROPERTY_FILENAME;
         LOG.debug("filename: " + filename);

         try {
            theProperties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(filename));
         } catch (IOException e) {
            throw new RuntimeException("Unable to load properties file: " + filename);
         }

         // additional local property file
         filename = "local.properties";
         InputStream resourceAsStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(filename);

         if (resourceAsStream != null) {
            LOG.debug("Properties file found");
            try {
               theProperties.load(resourceAsStream);
            } catch (IOException e) {
               throw new RuntimeException("Unable to load properties file: " + filename);
            }
         }
      }

      return theProperties;
   }

   public static String getProperty(String key) {
      return getProperties().getProperty(key);
   }

}
