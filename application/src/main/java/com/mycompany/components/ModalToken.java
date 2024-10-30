package com.mycompany.components;

import javax.swing.*;

public class ModalToken extends JDialog {
  private JTextFieldLimited txtToken;
  private JButton btnIngresarToken;

  public ModalToken() {
    this.setTitle("Modal verificar token");
    this.setLayout(null);
    this.setSize(250, 250);
    this.setResizable(false);
    this.setLocationRelativeTo(null);
    txtToken = new JTextFieldLimited(5);
    btnIngresarToken = new JButton("Verificar token");
    JLabel lblIngresarToken = new JLabel("Ingresar token");
    {
      lblIngresarToken.setBounds(15, 30, 100, 20);
      txtToken.setBounds(15, 50, 200, 30);
      btnIngresarToken.setBounds(15, 100, 200, 40);
    }
    this.add(lblIngresarToken);
    this.add(txtToken);
    this.add(btnIngresarToken);
  }

  public JButton getButton() {
    return btnIngresarToken;
  }

  public String getToken() {
    return txtToken.getText();
  }
}
