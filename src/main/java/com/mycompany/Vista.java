package com.mycompany;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mycompany.entities.Registro;
import com.mycompany.entities.Usuario;

public class Vista extends JFrame {
  private JTextField txtCorreoLogin, txtNombreRegistro, txtCorreoRegistro;
  private JPasswordField txtPasswordLogin, txtPasswordRegistro1, txtPasswordRegistro2;
  private JButton btnIngresar, btnRegistrar, btnRegistrarUsuario, btnCerrarSeccion;
  private JDialog modalRegistarUsuario, modalPanelPrincipal;

  public Vista() {
    super("Inicio de seccion");
    hazInterfaz();
  }

  private void hazInterfaz() {
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(500, 400);
    setResizable(false);
    setLocationRelativeTo(null);
    JLabel titulobl = new JLabel("Inicio de seccion");
    JLabel lblCorreo = new JLabel("Ingresa tu correo:");
    JLabel lblPassword = new JLabel("Ingresa la Contraseña:");
    txtCorreoLogin = new JTextField(20);
    txtPasswordLogin = new JPasswordField(20);
    btnIngresar = new JButton("Ingresar");
    btnRegistrar = new JButton("Registrarse");
    btnRegistrarUsuario = new JButton("Registrar Usuario");
    {
      titulobl.setBounds((getWidth() / 2) - 75, 20, 250, 30);
      lblCorreo.setBounds(30, 70, 200, 25);
      txtCorreoLogin.setBounds(30, 100, 430, 30);

      lblPassword.setBounds(30, 160, 200, 25);
      txtPasswordLogin.setBounds(30, 190, 430, 30);

      btnIngresar.setBounds(30, 265, 180, 40);
      btnRegistrar.setBounds(280, 265, 180, 40);
    }

    modalRegistarUsuario = new JDialog(this, "Registro de usuarios", true);
    modalRegistarUsuario.setLayout(null);
    modalRegistarUsuario.setSize(500, 450);
    modalRegistarUsuario.setResizable(false);
    modalRegistarUsuario.setLocationRelativeTo(null);
    JLabel nombreRegistroLabel = new JLabel("Ingresa tu nombre:");
    txtNombreRegistro = new JTextField(20);
    JLabel correoRegistroLabel = new JLabel("Ingresa tu correo:");
    txtCorreoRegistro = new JTextField(20);
    JLabel passwordRegistroLabel1 = new JLabel("Ingresa la Contraseña:");
    txtPasswordRegistro1 = new JPasswordField(20);
    JLabel passwordRegistroLabel2 = new JLabel("Confirmar la Contraseña:");
    txtPasswordRegistro2 = new JPasswordField(20);
    {
      nombreRegistroLabel.setBounds(30, 30, 200, 25);
      txtNombreRegistro.setBounds(30, 60, 430, 30);

      correoRegistroLabel.setBounds(30, 100, 200, 25);
      txtCorreoRegistro.setBounds(30, 130, 430, 30);

      passwordRegistroLabel1.setBounds(30, 170, 200, 25);
      txtPasswordRegistro1.setBounds(30, 200, 430, 30);

      passwordRegistroLabel2.setBounds(30, 240, 200, 25);
      txtPasswordRegistro2.setBounds(30, 270, 430, 30);

      btnRegistrarUsuario.setBounds((getWidth() / 2) - 100, 330, 200, 40);
    }
    modalPanelPrincipal = new JDialog(this, true);
    modalPanelPrincipal.setLayout(null);
    modalPanelPrincipal.setSize(600, 600);
    modalPanelPrincipal.setResizable(false);
    modalPanelPrincipal.setLocationRelativeTo(null);
    btnCerrarSeccion = new JButton("Cerrar seccion");
    btnCerrarSeccion.setBounds(200, 200, 200, 30);
    modalPanelPrincipal.add(btnCerrarSeccion);

    Font fuente1 = new Font("Arial", 1, 19);
    Font fuente2 = new Font("Arial", 1, 16);
    titulobl.setFont(fuente1);
    lblCorreo.setFont(fuente2);
    txtCorreoLogin.setFont(fuente2);
    lblPassword.setFont(fuente2);
    txtPasswordLogin.setFont(fuente2);
    btnIngresar.setFont(fuente2);
    btnRegistrar.setFont(fuente2);
    nombreRegistroLabel.setFont(fuente2);
    txtNombreRegistro.setFont(fuente2);
    correoRegistroLabel.setFont(fuente2);
    txtCorreoRegistro.setFont(fuente2);
    passwordRegistroLabel1.setFont(fuente2);
    txtPasswordRegistro1.setFont(fuente2);
    passwordRegistroLabel2.setFont(fuente2);
    txtPasswordRegistro2.setFont(fuente2);
    btnRegistrarUsuario.setFont(fuente2);
    add(titulobl);
    add(lblCorreo);
    add(txtCorreoLogin);
    add(lblPassword);
    add(txtPasswordLogin);
    add(btnIngresar);
    add(btnRegistrar);
    modalRegistarUsuario.add(nombreRegistroLabel);
    modalRegistarUsuario.add(txtNombreRegistro);
    modalRegistarUsuario.add(correoRegistroLabel);
    modalRegistarUsuario.add(txtCorreoRegistro);
    modalRegistarUsuario.add(passwordRegistroLabel1);
    modalRegistarUsuario.add(txtPasswordRegistro1);
    modalRegistarUsuario.add(passwordRegistroLabel2);
    modalRegistarUsuario.add(txtPasswordRegistro2);
    modalRegistarUsuario.add(btnRegistrarUsuario);
    setVisible(true);
  }

  public void mostrarRegistro(boolean mostrar) {// muestra o oculta el panel de registro
    setVisible(!mostrar);
    modalRegistarUsuario.setVisible(mostrar);
  }

  public void limpiarRegistro() {
    txtNombreRegistro.setText("");
    txtCorreoRegistro.setText("");
    txtPasswordRegistro1.setText("");
    txtPasswordRegistro2.setText("");
  }

  public void mostrarPrincipal(boolean mostrar) {// muestra o oculta el panel principal
    setVisible(!mostrar);
    modalPanelPrincipal.setVisible(mostrar);
  }

  public void setControlador(Controlador controlador) {
    btnIngresar.addActionListener(controlador);
    btnRegistrar.addActionListener(controlador);
    btnRegistrarUsuario.addActionListener(controlador);
    btnCerrarSeccion.addActionListener(controlador);
    modalPanelPrincipal.addWindowListener(controlador);
    modalRegistarUsuario.addWindowListener(controlador);
  }

  public void mostarMensaje(String mensaje) {
    JOptionPane.showMessageDialog(this, mensaje);
  }

  public Usuario getUsuario() {
    return new Usuario(txtCorreoLogin.getText(), txtPasswordLogin.getText());
  }

  public Registro getRegistro() {
    return new Registro(
        txtNombreRegistro.getText(),
        txtCorreoRegistro.getText(),
        txtPasswordRegistro1.getText(),
        txtPasswordRegistro2.getText());
  }

  public JButton getBtnIngresar() {
    return btnIngresar;
  }

  public JButton getBtnRegistrar() {
    return btnRegistrar;
  }

  public JButton getBtnRegistrarUsuario() {
    return btnRegistrarUsuario;
  }

  public JButton getBtnCerrarSeccion() {
    return btnCerrarSeccion;
  }
}