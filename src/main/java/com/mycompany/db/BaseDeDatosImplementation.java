package com.mycompany.db;

import com.mycompany.entities.Registro;
import com.mycompany.entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDeDatosImplementation extends BaseDeDatos {

    private Connection conexion;

    public BaseDeDatosImplementation() {
        conexion = Conexion.getConnection();
    }

    @Override
    public int registrarUsuario(Registro registro) {
        int resultado = 0;
        String sql =
            "INSERT INTO usuarios (correo, nip, nombre, activo, num_intentos) VALUES (?, ?, ?, false, 0)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, registro.getCorreo());
            ps.setString(2, registro.getPassword1());
            ps.setString(3, registro.getNombre());
            resultado = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public Usuario obtenerUsuarioPorCorreo(String correo) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE correo = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario(
                    rs.getString("correo"),
                    rs.getString("nip"),
                    rs.getString("nombre"),
                    rs.getBoolean("activo"),
                    rs.getInt("num_intentos"),
                    rs.getTimestamp("fecha_bloqueado")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public int actualizarIntentos(String correo) {
        int resultado = 0;
        String sql =
            "UPDATE usuarios SET num_intentos = num_intentos + 1 WHERE correo = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, correo);
            resultado = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public int actualizarActivo(String correo) {
        int resultado = 0;
        System.out.println("se actualiza activo");
        String sql = "UPDATE usuarios SET activo = NOT activo WHERE correo = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, correo);
            resultado = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("resultado: " + resultado);
        return resultado;
    }

    @Override
    public int actualizarFechaBloqueo(String correo) {
        int resultado = 0;
        String sql =
            "UPDATE usuarios SET fecha_bloqueado = CURRENT_TIMESTAMP + INTERVAL '1 minutes' WHERE correo = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, correo);
            resultado = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public int reiniciarIntentos(String correo) {
        int resultado = 0;
        String sql = "UPDATE usuarios SET num_intentos = 0 WHERE correo = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, correo);
            resultado = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public int reiniciarFechaBloqueo(String correo) {
        int resultado = 0;
        String sql =
            "UPDATE usuarios SET fecha_bloqueado = NULL WHERE correo = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, correo);
            resultado = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
