package com.fileRouge.customer.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoBearerTokenError extends ResponseStatusException {
  public NoBearerTokenError() {
    super(HttpStatus.UNAUTHORIZED, "no bearer token");
  }
}
