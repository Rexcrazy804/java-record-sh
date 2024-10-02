package org.projects.prog20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GridLay {
  public static void main(String args[]) {
    JFrame frame = new JFrame("Simple Grid");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    frame.setLayout(new GridLayout(3, 1));

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(1, 2));
    panel.add(new JLabel("Enter Name"));

    JTextField name = new JTextField();
    panel.add(name);

    frame.add(panel);

    JButton submit = new JButton("Submit");
    JLabel hello = new JLabel();

    submit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        hello.setText("Hello " + name.getText() + "!!");
      }
    });
    frame.add(submit);
    
    frame.add(hello);

    frame.setVisible(true);
  }
}
