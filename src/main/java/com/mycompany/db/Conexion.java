package com.mycompany.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static Connection connection;

    private Conexion() {

    }

    public static Connection getConnection() {
        if (connection == null) {
            new Conexion();
        }
        return connection;
    }

}