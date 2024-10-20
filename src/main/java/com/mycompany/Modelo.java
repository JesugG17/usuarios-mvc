package com.mycompany;

import com.mycompany.db.BaseDeDatos;
import com.mycompany.entities.Registro;
import com.mycompany.entities.Usuario;

public class Modelo {

  private BaseDeDatos bd;

  public Modelo(BaseDeDatos bd) {
    this.bd = bd;
  }

  public void validarIngreso(Usuario usuario) {
    Usuario usuarioBD = bd.obtenerUsuarioPorCorreo(usuario.getCorreo());

    if (usuarioBD == null) {
      System.out.println("Usuario no existe");
      return;
    }

    if (usuarioBD.isActivo()) {
      return;
    }

    if (!PasswordEncryption.isPasswordMatch(
        usuario.getNip(),
        usuarioBD.getNip())) {
      System.out.println("Contraseña incorrecta o usuario incorrecto");
      bd.actualizarIntentos(usuario.getCorreo());
    }

    if (usuarioBD.getNum_intentos() == 3) {
      System.out.println("Usuario bloqueado");
      return;
    }
  }

  public boolean registrarUsuario(Registro registro) {
    if (!validaciones(registro))
      return false;
    registro.setPassword1(
        PasswordEncryption.encryptPassword(registro.getPassword1()));
    bd.registrarUsuario(registro);
    return true;
  }

  private boolean validaciones(Registro registro) {
    if (!registro
        .getCorreo()
        .matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
      System.out.println("Correo no valido");
      return false;
    }

    if (registro.getPassword1().matches("^\\d{4}$") != registro.getPassword2().matches("^\\d{4}$")) {
      System.out.println(
          "Contraseña no valida, solo numeros de 4 digitos");
      return false;
    }
    if (!registro.getPassword1().equals(registro.getPassword2())) {
      System.out.println("Contraseñas no coinciden");
      return false;
    }
    return true;
  }

  public void cerrarSeccion() {
  }
}
