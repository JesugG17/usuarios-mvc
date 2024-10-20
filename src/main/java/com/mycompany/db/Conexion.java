package com.mycompany.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

  private static Connection connection;

  private Conexion() {
    try {
      String url = "jdbc:postgresql://junction.proxy.rlwy.net:17683/railway";
      connection = DriverManager.getConnection(
          url,
          "postgres",
          "pzqWVDsQmULgtAmlLxqeWULXDivscPvE");
      System.out.println("Conexion establecida con exito");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println("Error al conectar con la base de datos");
    }
  }

  public static Connection getConnection() {
    if (connection == null) {
      new Conexion();
    }
    return connection;
  }
}
