package com.mycompany.models;

public class Response {

    private boolean isValid;
    private String message;
    private boolean verificarUsuario, restaurarSesion;
    private String userEmail;

    public Response(boolean isValid, String message, String userEmail) {
        this.isValid = isValid;
        this.message = message;
        this.userEmail = userEmail;
    }

    public Response(boolean isValid, String message) {
        this(isValid, message, "");
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

    public boolean restaurarSesion() {
      return this.restaurarSesion;
    }

    public boolean verificarUsuario() {
      return this.verificarUsuario;
    }

    public Response withTokenRestaurarSesion() {
      this.restaurarSesion = true;
      return this;
    }

    public Response withTokenVerificarUsuario() {
      this.verificarUsuario = true;
      return this;
    }
}
