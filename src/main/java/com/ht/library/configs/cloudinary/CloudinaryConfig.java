package com.ht.library.configs.cloudinary;

import com.cloudinary.Cloudinary;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
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
  private static String FOLDER_NAME;
  public static Integer SMALL_WIDTH = 200;
  public static Integer MEDIUM_WIDTH = 400;
  public static Integer LARGE_WIDTH = 800;

  public enum FOLDER {
    books,
    authors,
    users
  }

  public static Converter<String, String> convertPublicIdToUrl(Integer size) {
    return new AbstractConverter<>() {
      @Override
      protected String convert(String url) {
        return getImageUrl(url, "", size);
      }
    };
  }

  @Value("${cloudinary.cloudName}")
  public void setCloudName(String cloudName) {
    CLOUD_NAME = cloudName;
  }

  @Value("${cloudinary.folderName}")
  public void setFolderName(String folderName) {
    FOLDER_NAME = folderName;
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

  public static String getImageUrl(String id, String path, Integer size){
    return RES_CLOUDINARY_URL + CLOUD_NAME + "/image/upload/" + "w_" + size + "/" + FOLDER_NAME + "/" + path + "/" + id;
  }

}