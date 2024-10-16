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
        
    }

    public boolean registrarUsuario(Registro registro) {
        if(!validaciones(registro))
            return false;
        bd.registrarUsuario(registro);
        return true;
    }

    private boolean validaciones(Registro registro) {
        return true;
    }

    public void cerrarSeccion() {
    }
}