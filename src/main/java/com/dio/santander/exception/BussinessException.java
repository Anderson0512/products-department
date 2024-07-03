package com.dio.santander.exception;

public class BussinessException extends Exception{

  public BussinessException(String msg) {
    super(msg);
  }

  public BussinessException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
