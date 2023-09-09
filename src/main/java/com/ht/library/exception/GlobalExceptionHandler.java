package com.ht.library.exception;

import com.ht.library.handlers.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = ResourceNotFoundException.class)
  public ResponseEntity<Object> handlerResourceNotFoundException(ResourceNotFoundException ex) {
    return ResponseHandler.generateResponse(ex.getMessage(), HttpStatus.NOT_FOUND, null);
  }


  @ExceptionHandler(BindException.class)
  @ResponseBody
  public ResponseEntity<Object> handleBindException(BindException e) {
    String messageError = "";
    if (e.getBindingResult().hasErrors()) {
      for (ObjectError error : e.getBindingResult().getAllErrors()) {
        messageError += error.getObjectName() + " " + error.getDefaultMessage() + ", ";
      }
    }
    return ResponseHandler.generateResponse(messageError, HttpStatus.BAD_REQUEST, null);
  }
}
