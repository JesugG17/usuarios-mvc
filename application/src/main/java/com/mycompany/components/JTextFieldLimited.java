package com.mycompany.components;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class JTextFieldLimited extends JTextField implements KeyListener {
  
  private int limit;

  public JTextFieldLimited(int limit) {
    super();
    this.limit = limit;
    this.addKeyListener(this);
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
   
  }

  @Override
  public void keyReleased(KeyEvent e) {
    if (this.getText().length() <= this.limit){ 
      return;
    }

    this.setText(this.getText().substring(0, this.limit));
  }

 
}
