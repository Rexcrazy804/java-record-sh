package org.projects.prog14;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Tables extends Applet implements ActionListener {
  TextField t1;
  Button t2;
  String[] result;

  public void init() {
    t1 = new TextField(5);
    t2 = new Button("Submit");
    t2.addActionListener(this);

    result = new String[10];

    add(new Label("Enter a number"));
    add(t1);
    add(t2);
  }

  public void paint(Graphics g) {
    for (int i = 0; i < 10; i++) {
      g.drawString(result[i], 20, 40 + 20 * i);
    }
  }

  public void actionPerformed(ActionEvent e) {
    int number = Integer.parseInt(t1.getText());
    for (int i = 1; i <= 10; i++) {
      result[i - 1] = number + " x " + i + " = " + i * number;
    }
  }
}
