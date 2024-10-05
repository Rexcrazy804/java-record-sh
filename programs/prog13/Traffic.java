package org.projects.prog13;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Traffic {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Traffic");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(2, 1));
    frame.setSize(300, 130);

    JLabel sign = new JLabel();
    sign.setHorizontalAlignment(JLabel.CENTER);
    frame.add(sign);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(1, 3));

    JButton red = new JButton("STOP");
    red.setBackground(Color.RED);
    panel.add(red);

    JButton yellow = new JButton("READY");
    yellow.setBackground(Color.YELLOW);
    panel.add(yellow);

    JButton green = new JButton("GO");
    green.setBackground(Color.GREEN);
    panel.add(green);

    ActionListener on_click =
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            sign.setText(((JButton) e.getSource()).getText());
          }
        };

    red.addActionListener(on_click);
    yellow.addActionListener(on_click);
    green.addActionListener(on_click);

    frame.add(panel);
    frame.setVisible(true);
  }
}
