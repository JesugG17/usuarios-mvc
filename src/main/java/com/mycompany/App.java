package com.mycompany;

import com.mycompany.db.BaseDeDatosImplementation;

public class App {
  public static void main(String[] args) {
    Vista vista = new Vista();
    BaseDeDatosImplementation bd = new BaseDeDatosImplementation();
    Modelo modelo = new Modelo(bd);
    Controlador controlador = new Controlador(vista, modelo);
    vista.setControlador(controlador);
  }
}
