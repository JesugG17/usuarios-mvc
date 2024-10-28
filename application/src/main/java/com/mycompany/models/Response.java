package com.mycompany.models;

public class Response {

    private boolean isValid;
    private String message;
    private boolean putToken;
    private String userEmail;

    public Response(boolean isValid, String message, String userEmail) {
        this.isValid = isValid;
        this.message = message;
        this.userEmail = userEmail;
    }

    public Response(boolean isValid, String message) {
        this(isValid, message, "");
    }

    public Response(boolean isValid, String message, boolean putToken) {
      this(isValid, message, "");
      this.putToken = putToken;
    }

    public Response(boolean isValid) {
        this(isValid, "");
    }

    public boolean isValid() {
        return this.isValid;
    }

    public String getMessage() {
        return this.message;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public boolean getPutToken() {
      return this.putToken;
    }
}
