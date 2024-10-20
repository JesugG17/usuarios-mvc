package com.mycompany;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.mycompany.db.BaseDeDatosImplementation;

public class Controlador implements ActionListener, WindowListener {

    private Vista vista;
    private Modelo modelo;
    private BaseDeDatosImplementation db = new BaseDeDatosImplementation();

    public Controlador(Vista vista, Modelo modelo) {
        this.modelo = modelo;
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnIngresar()) {
            modelo.validarIngreso(vista.getUsuario());
            vista.mostrarPrincipal(true);
            db.actualizarIntentos("citlaly_ame@hotmail.com");
            return;
        }
        if (e.getSource() == vista.getBtnRegistrar()) {
            vista.mostrarRegistro(true);
            return;
        }
        if (e.getSource() == vista.getBtnRegistrarUsuario()) {
            if(modelo.registrarUsuario(vista.getRegistro())){
                vista.mostarMensaje("Usuario Registrado Correctamente");
                vista.mostrarRegistro(false);
                return;
            }
            vista.mostarMensaje("Algo fallo al registrar usuario");
            return;
        }
        if (e.getSource() == vista.getBtnCerrarSeccion()) {
            modelo.cerrarSeccion();
            vista.mostrarPrincipal(false);
            return;
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        vista.setVisible(true);//al cerrar el panel de registro o  principal vuelve a mostrar el inicio de seccion
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }
}