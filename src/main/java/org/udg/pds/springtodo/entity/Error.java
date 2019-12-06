package org.udg.pds.springtodo.entity;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Data
public class Error {
  @NonNull private String timestamp;
  @NonNull private Integer status;
  @NonNull private String error;
  @NonNull private String message;
  String path;

  public Error(String timestamp, Integer status, String error, String message) {
    this.timestamp = timestamp;
    this.status = status;
    this.error = error;
    this.message = message;
  }
}
