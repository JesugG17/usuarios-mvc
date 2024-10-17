package com.mycompany.db;

import com.mycompany.entities.Registro;
import com.mycompany.entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BaseDeDatos {
    private Connection conexion;

    public BaseDeDatos() {
        conexion = Conexion.getConnection();
    }

    public void registrarUsuario(Registro registro) {

    }

}