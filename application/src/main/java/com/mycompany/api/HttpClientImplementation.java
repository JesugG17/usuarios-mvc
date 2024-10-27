package com.mycompany.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import okhttp3.FormBody;
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

  public void enviarCorreo(String email) {
    try {
            
      String json = "{\"email\":" + email + "}";
  
      Request request = new Request.Builder()
        .url(this.url + "/send-token")
        .post(RequestBody.create(JSON, json))
        .build();
  
      Response response = this.httpClient.newCall(request).execute();
      ObjectMapper mapper = new ObjectMapper();
      ApiResponse apiResponse = mapper.readValue(response.body().byteStream(), ApiResponse.class);
      System.out.println(apiResponse);
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Algo salió mal");
    }
  }

}
