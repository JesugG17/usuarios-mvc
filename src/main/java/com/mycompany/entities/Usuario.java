package com.mycompany.entities;
import java.util.Date;

public class Usuario {

    private String correo, nip, nombre;
    private boolean activo;
    private int num_intentos;
    private Date fecha_bloqueado;


    public Usuario(String correo, String password ) {
        this(correo, password, "", false, 0, null);
    }

    public Usuario(
            String correo,
            String nip,
            String nombre,
            boolean activo,
            int num_intentos,
            Date fecha_bloqueado
            )
    {
        this.correo = correo;
        this.nip = nip;
        this.nombre = nombre;
        this.activo = activo;
        this.num_intentos = num_intentos;
        this.fecha_bloqueado = fecha_bloqueado;
    }

    public String getCorreo() { return correo; }

    public void setCorreo(String correo) { this.correo = correo; }

    public String getNip() { return nip; }

    public void setNip(String nip) { this.nip = nip;}

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public boolean isActivo() { return activo; }

    public void setActivo(boolean activo) { this.activo = activo; }

    public int getNum_intentos() { return num_intentos; }

    public void setNum_intentos(int num_intentos) { this.num_intentos = num_intentos; }

    public Date getFecha_bloqueado() { return fecha_bloqueado; }

    public void setFecha_bloqueado(Date fecha_bloqueado) { this.fecha_bloqueado = fecha_bloqueado; }

    @Override
    public String toString() {
        return "Usuario{" +
                "correo='" + correo + '\'' +
                ", nip='" + nip + '\'' +
                ", nombre='" + nombre + '\'' +
                ", activo=" + activo +
                ", num_intentos=" + num_intentos +
                ", fecha_bloqueado=" + fecha_bloqueado +
                '}';
    }

}