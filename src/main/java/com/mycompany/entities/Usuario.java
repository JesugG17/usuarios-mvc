package com.mycompany.entities;

public class Usuario {

    private String correo, nip;

    public Usuario(
            String correo,
            String nip)
    {
        this.correo = correo;
        this.nip = nip;
    }

    public String getCorreo() { return correo; }

    public void setCorreo(String correo) { this.correo = correo; }

    public String getNip() { return nip; }

    public void setNip(String nip) { this.nip = nip;}
}