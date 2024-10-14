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

    JButton red = new JButton();
    red.setBackground(Color.RED);
    red.setOpaque(true);
    red.setBorderPainted(false);
    panel.add(red);

    JButton yellow = new JButton();
    yellow.setBackground(Color.YELLOW);
    yellow.setOpaque(true);
    yellow.setBorderPainted(false);
    panel.add(yellow);

    JButton green = new JButton();
    green.setBackground(Color.GREEN);
    green.setOpaque(true);
    green.setBorderPainted(false);
    panel.add(green);

    ActionListener on_click =
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            String text;
            Color bg_color = ((JButton) e.getSource()).getBackground();
            if (bg_color == Color.RED) {
              text = "STOP";
            } else if (bg_color == Color.YELLOW) {
              text = "WAIT";
            } else {
              text = "GO";
            }
            sign.setText(text);
          }
        };

    red.addActionListener(on_click);
    yellow.addActionListener(on_click);
    green.addActionListener(on_click);

    frame.add(panel);
    frame.setVisible(true);
  }
}
