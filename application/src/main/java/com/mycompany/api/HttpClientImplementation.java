package com.mycompany.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpClientImplementation extends HttpClient {
  
  private OkHttpClient httpClient;
  private final String url;
  public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

  public HttpClientImplementation(String url) {
    this.url = url;
    this.httpClient = new OkHttpClient();
  }

  @Override
  public boolean enviarCorreo(String email) {
    try {
      
      String jsonData = "{ \"email\": " + "\"" + email + "\"" + "}";
      MediaType contentType = MediaType.get("application/json");
      RequestBody body = RequestBody.create(jsonData, contentType);

      Request request = new Request.Builder()
        .url(this.url + "/send-token")
        .post(body)
        .build();

      Response response = this.httpClient.newCall(request).execute();
      ObjectMapper mapper = new ObjectMapper();
      ApiResponse apiResponse = mapper.readValue(response.body().byteStream(), ApiResponse.class);
      return apiResponse.ok;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public com.mycompany.models.Response validarToken(String token, String correo) {
    try {
      
      String jsonData = "{ \"email\": \"" + correo + "\", \"token\": \"" + token + "\" }";
      MediaType contentType = MediaType.get("application/json");
      RequestBody body = RequestBody.create(jsonData, contentType);

      Request request = new Request.Builder()
        .url(this.url + "/verify-token")
        .post(body)
        .build();

      Response response = this.httpClient.newCall(request).execute();
      ObjectMapper mapper = new ObjectMapper();
      ApiResponse apiResponse = mapper.readValue(response.body().byteStream(), ApiResponse.class);
      return new com.mycompany.models.Response(apiResponse.ok, apiResponse.message);
    } catch (Exception e) {
      e.printStackTrace();
      return new com.mycompany.models.Response(false, "Algo ha salido mal al enviar el token");
    }
  }

}
