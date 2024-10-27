package com.mycompany;

import com.mycompany.api.HttpClientImplementation;
import com.mycompany.db.BaseDeDatosImplementation;

public class App {
  public static void main(String[] args) {
    Vista vista = new Vista();
    BaseDeDatosImplementation bd = new BaseDeDatosImplementation();
    HttpClientImplementation httpClient = new HttpClientImplementation("http://localhost:3000/api/emails");
    Modelo modelo = new Modelo(bd, httpClient);
    Controlador controlador = new Controlador(vista, modelo);
    vista.setControlador(controlador);
  }
}
