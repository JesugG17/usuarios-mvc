package com.mycompany.db;

import com.mycompany.entities.Registro;
import com.mycompany.entities.Usuario;

public abstract class BaseDeDatos {

    public abstract int registrarUsuario(Registro registro);

    public abstract Usuario obtenerUsuarioPorCorreo(String correo);

    public abstract int actualizarIntentos(String correo);

    public abstract int actualizarFechaBloqueo(String correo);

    public abstract int iniciarSesion(String correo);

    public abstract int verificarCorreo(String correo);

    public abstract int cerrarSesion(String correo);

    public abstract int reiniciarIntentos(String correo);

    public abstract int reiniciarFechaBloqueo(String correo);
}
