package com.dio.santander.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DefaultExceptionHandler {

  @ExceptionHandler(Throwable.class)
  public ResponseEntity<String> handler(BussinessException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
  }
 }
