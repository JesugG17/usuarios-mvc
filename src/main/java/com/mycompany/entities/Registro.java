package com.mycompany.entities;

public class Registro {
    private String nombre, correo, password1, password2;
    public Registro(String nombre, String correo, String password1, String password2){
        this.nombre = nombre;
        this.correo = correo;
        this.password1 = password1;
        this.password2 = password2;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getPassword1() {
        return password1;
    }
    public void setPassword1(String password1) {
        this.password1 = password1;
    }
    public String getPassword2() {
        return password2;
    }
    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
