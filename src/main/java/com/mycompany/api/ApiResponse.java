package com.mycompany.api;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponse {

  public final boolean ok;
  public final String message;

  public ApiResponse(
    @JsonProperty("ok") boolean ok,
    @JsonProperty("message") String message
  ) {
    this.ok = ok;
    this.message = message;
  }
  
  public String toString() {
    return "ok: " + this.ok + ", message: " + this.message;
  }
}
