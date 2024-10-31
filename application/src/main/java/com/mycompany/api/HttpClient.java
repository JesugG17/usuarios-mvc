package com.mycompany.api;

import com.mycompany.models.Response;

public abstract class HttpClient {
  
  public abstract boolean enviarCorreo(String correo);

  public abstract Response verificarToken(String token, String correo); 
  
}
