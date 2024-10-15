package com.mycompany;

import com.mycompany.entities.Usuario;
import java.awt.event.*;
import java.util.ArrayList;

public class Controlador implements ActionListener {

    private Vista vista;
    private Modelo modelo;

    public Controlador(Vista vista, Modelo modelo) {
        this.modelo = modelo;
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}