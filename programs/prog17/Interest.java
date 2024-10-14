package org.projects.prog17;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Interest extends Applet implements ActionListener {
  TextField principle, rate, duration;
  Label result;
  Button submit;

  public void init() {
    principle = new TextField("principle");
    rate = new TextField("rate%");
    duration = new TextField("duration");

    setLayout(new GridLayout(3, 1));
    add(new Label("Fill the following"));

    Panel pane = new Panel();
    pane.setLayout(new GridLayout(2, 2));
    submit = new Button("Submit");
    submit.addActionListener(this);

    pane.add(principle);
    pane.add(rate);
    pane.add(duration);
    pane.add(submit);
    add(pane);

    result = new Label();
    result.setAlignment(Label.CENTER);
    add(result);
  }

  public void actionPerformed(ActionEvent e) {
    int p = Integer.parseInt(principle.getText());
    int r = Integer.parseInt(rate.getText());
    int n = Integer.parseInt(duration.getText());

    float si = (p * r * n) / 100;
    result.setText("Simple Interest = " + si);

    repaint();
  }
}
