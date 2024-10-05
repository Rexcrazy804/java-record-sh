package org.projects.prog17;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Interest extends Applet implements ActionListener {
  TextField principle, rate, time;
  Label result;
  Button submit;

  public void init() {
    principle = new TextField("principle");
    rate = new TextField("rate%");
    time = new TextField("time");

    add(new Label("Fill the following"));
    add(principle);
    add(rate);
    add(time);

    submit = new Button("Submit");
    submit.addActionListener(this);
    add(submit);

    result = new Label();
    add(result);
  }

  public void actionPerformed(ActionEvent e) {
    int p = Integer.parseInt(principle.getText());
    int r = Integer.parseInt(rate.getText());
    int n = Integer.parseInt(time.getText());

    float si = (p * r * n) / 100;
    result.setText("" + si);
  }
}
