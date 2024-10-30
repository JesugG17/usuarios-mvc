package com.mycompany.api;

import com.mycompany.models.Response;

public abstract class HttpClient {
  
  public abstract boolean enviarCorreo(String correo);

  public abstract Response restaurarSesion(String token, String correo);

  public abstract Response verificarCorreo(String token, String correo);
}
