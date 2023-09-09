package com.ht.library.handlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
  public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
    Map<String, Object> map = new HashMap<String, Object>();
    try {
      map.put("message", message);
      map.put("status", status.value());
      if (responseObj != null) {
        map.put("data", responseObj);
      }
      return new ResponseEntity<Object>(map, status);
    } catch (Exception e) {
      map.clear();
      map.put("message", e.getMessage());
      map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
      return new ResponseEntity<Object>(map,status);
    }
  }
}