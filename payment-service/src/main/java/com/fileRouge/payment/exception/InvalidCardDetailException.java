package com.fileRouge.payment.exception;

public class InvalidCardDetailException extends RuntimeException {
  public InvalidCardDetailException() {
    super("invalid card details");
  }
}
