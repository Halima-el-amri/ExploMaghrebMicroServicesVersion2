package com.fileRouge.Guide.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class ApiError {

  private int status;

  private String message;

  private Map<String, String> validationErrors;

  public ApiError(int status, String message) {
    super();

    this.status = status;
    this.message = message;
  }

}
