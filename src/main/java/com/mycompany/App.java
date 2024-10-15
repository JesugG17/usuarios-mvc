package com.mycompany;
import com.mycompany.db.*;

public class App
{
    public static void main( String[] args )
    {
        Vista vista = new Vista();
        Modelo modelo = new Modelo();
        Controlador controlador = new Controlador(vista,modelo);
        vista.setControlador(controlador);
    }
}
