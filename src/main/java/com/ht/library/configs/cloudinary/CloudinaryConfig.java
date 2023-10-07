package com.ht.library.configs.cloudinary;

import com.cloudinary.Cloudinary;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {
  private static String RES_CLOUDINARY_URL = "https://res.cloudinary.com/";
  private static String CLOUD_NAME;
  private static String API_KEY;
  private static String API_SECRET;

  @Value("${cloudinary.cloudName}")
  public void setCloudName(String cloudName) {
    CLOUD_NAME = cloudName;
  }

  @Value("${cloudinary.apiKey}")
  public void setApiKey(String apiKey) {
    API_KEY = apiKey;
  }

  @Value("${cloudinary.apiSecret}")
  public void setApiSecret(String apiSecret) {
    API_SECRET = apiSecret;
  }

  @Bean
  public Cloudinary cloudinary(){
    Map<String, String> config = new HashMap<>();
    config.put("cloud_name",CLOUD_NAME);
    config.put("api_key",API_KEY);
    config.put("api_secret",API_SECRET);
    return new Cloudinary(config);
  }

  public static String getImageUrl(String publicId){
    return RES_CLOUDINARY_URL + CLOUD_NAME + "/image/upload/" + publicId;
  }

  public static AbstractConverter<String, String> convertPublicIdToUrl =
          new AbstractConverter<>() {
            @Override
            protected String convert(String src) {
              return getImageUrl(src);
            }
          };
}