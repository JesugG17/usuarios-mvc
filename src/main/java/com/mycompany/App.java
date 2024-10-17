package com.mycompany;
import com.mycompany.db.*;
public class App
{
    public static void main( String[] args )
    {
        Vista vista = new Vista();
        BaseDeDatos bd = new BaseDeDatos();
        Modelo modelo = new Modelo(bd);
        Controlador controlador = new Controlador(vista,modelo);
        vista.setControlador(controlador);
    }
}
