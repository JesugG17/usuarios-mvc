package com.mycompany;

import com.mycompany.models.Response;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador implements ActionListener, WindowListener {

    private Vista vista;
    private Modelo modelo;

    public Controlador(Vista vista, Modelo modelo) {
        this.modelo = modelo;
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnIngresar()) {
            Response response = modelo.validarIngreso(vista.getUsuario());

            if (!response.isValid()) {
                vista.mostarMensaje(response.getMessage());
                return;
            }
            vista.setCorreoLogin(response.getUserEmail());
            vista.mostrarPrincipal(true);
            return;
        }
        if (e.getSource() == vista.getBtnRegistrar()) {
            vista.mostrarRegistro(true);
            return;
        }
        if (e.getSource() == vista.getBtnRegistrarUsuario()) {
            Response response = modelo.registrarUsuario(vista.getRegistro());

            if (!response.isValid()) {
                vista.mostarMensaje(response.getMessage());
                return;
            }

            vista.mostarMensaje(response.getMessage());
            vista.mostrarRegistro(false);
            vista.limpiarRegistro();
            return;
        }

        if (e.getSource() == vista.getBtnCerrarSeccion()) {
            modelo.cerrarSesion(vista.getCorreoLogin());
            vista.mostrarPrincipal(false);
            return;
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        vista.setVisible(true); // al cerrar el panel de registro o principal vuelve a mostrar el inicio de
        // seccion
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}

    @Override
    public void windowOpened(WindowEvent e) {}
}
