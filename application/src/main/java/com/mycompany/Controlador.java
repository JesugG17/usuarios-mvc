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

            if (response.restaurarSesion()) {
              vista.mostarMensaje(response.getMessage());
              vista.mostrarModalTokenRestaurarSesion();
              return;
            }

            if (response.verificarUsuario()) {
              vista.mostarMensaje(response.getMessage());
              vista.mostrarModalTokenVerificarUsuario();
              return;
            }

            if (!response.isValid()) {
                vista.mostarMensaje(response.getMessage());
                return;
            }
            vista.setCorreoLogin(response.getUserEmail());
            vista.limpiarInicioSesion();
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
            vista.mostrarModalTokenVerificarUsuario();
            return;
        }

        if (e.getSource() == vista.getButtonModalTokenRestaurarSesion()) {
          String correoUsuario = vista.getUsuario().getCorreo();
          Response response = modelo.restaurarSession(vista.getTokenRestaurarSesion(), correoUsuario);

          vista.mostarMensaje(response.getMessage());

          if (!response.isValid()) {
            return;
          }

          vista.cerrarModalTokenRestaurarSesion();
        }

        if (e.getSource() == vista.getButtonModalTokenVerificarUsuario()) {
          String correoUsuario = vista.getRegistro().getCorreo();

          if (correoUsuario.length() == 0) {
            correoUsuario = vista.getUsuario().getCorreo();
          }

          System.out.println(vista.getRegistro().getCorreo());
          Response response = modelo.verificarUsuario(vista.getTokenVerificarUsuario(), correoUsuario);

          vista.mostarMensaje(response.getMessage());

          if (!response.isValid()) {
            return;
          }

          vista.cerrarModalTokenVerificarUsuario();
          vista.mostrarRegistro(false);
          vista.limpiarRegistro();
        }

        // if (e.getSource() == vista.getBtnIngresarToken()) {


        //   String correoUsuario = vista.getUsuario().getCorreo();
        //   Response response = vista.modalRegistroAbierto()
        //     ? modelo.verificarUsuario(vista.getToken(), correoUsuario)
        //     : modelo.restaurarSession(vista.getToken(), correoUsuario);

        //   vista.mostarMensaje(response.getMessage());

        //   if (!response.isValid()) {
        //     return;
        //   }
          
        //   vista.cerrarModalToken();
        //   return;
        // }

        if (e.getSource() == vista.getBtnCerrarSesion()) {
            modelo.cerrarSesion(vista.getCorreoLogin());
            vista.mostrarPrincipal(false);
            return;
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        vista.mostrarPantallaPrincipal(); 
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
