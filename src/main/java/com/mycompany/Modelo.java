package com.mycompany;

import com.mycompany.db.BaseDeDatos;
import com.mycompany.entities.Registro;
import com.mycompany.entities.Usuario;
import com.mycompany.models.Response;
import com.mycompany.utils.Encrypter;

public class Modelo {

    private BaseDeDatos bd;

    public Modelo(BaseDeDatos bd) {
        this.bd = bd;
    }

    public Response validarIngreso(Usuario usuario) {
        Usuario usuarioBD = bd.obtenerUsuarioPorCorreo(usuario.getCorreo());

        if (usuarioBD == null) {
            return new Response(false, "El usuario no existe");
        }

        if (usuarioBD.isActivo()) {
            return new Response(false, "Ya hay una sesión activa");
        }

        if (usuarioBD.getNum_intentos() >= 3) {
            bd.actualizarFechaBloqueo(usuario.getCorreo());
            return new Response(
                false,
                "Numero de intentos maximo alcanzado, se ha bloqueado su cuenta por 30m"
            );
        }

        if (!Encrypter.matchPasswords(usuario.getNip(), usuarioBD.getNip())) {
            bd.actualizarIntentos(usuario.getCorreo());
            return new Response(false, "Contrase o usuario incorrecto");
        }

        bd.actualizarActivo(usuario.getCorreo());
        return new Response(
            true,
            "Inicio de sesión exitoso",
            usuario.getCorreo()
        );
    }

    public Response registrarUsuario(Registro registro) {
        Response validaciones = validaciones(registro);
        if (!validaciones.isValid()) return validaciones;

        Usuario usuarioBd = bd.obtenerUsuarioPorCorreo(registro.getCorreo());

        if (usuarioBd != null) {
            return new Response(false, "Este usuario ya existe");
        }

        registro.setPassword1(Encrypter.hashPassword(registro.getPassword1()));
        bd.registrarUsuario(registro);
        return new Response(true, "Usuario registrado exitosamente");
    }

    private Response validaciones(Registro registro) {
        if (
            !registro
                .getCorreo()
                .matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")
        ) {
            System.out.println("Correo no valido");
            return new Response(false, "Correo no valido");
        }

        if (!registro.getPassword1().equals(registro.getPassword2())) {
            System.out.println("Contraseñas no coinciden");
            return new Response(false, "Las contraseñas no coinciden");
        }

        if (!registro.getPassword1().matches("^\\d{4}$")) {
            System.out.println(
                "Contraseña no valida, solo numeros de 4 digitos"
            );
            return new Response(
                false,
                "Contraseña no valida, solo numeros de 4 digitos"
            );
        }
        return new Response(true);
    }

    public void cerrarSesion(String correoLogin) {
        bd.actualizarActivo(correoLogin);
    }
}
