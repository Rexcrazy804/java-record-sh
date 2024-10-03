package org.projects.prog11;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Swing {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Swing Example");
    frame.setLayout(new GridLayout(3, 2));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 130);

    JTextField phoneNum = new JTextField();
    frame.add(new JLabel("Phone"));
    frame.add(phoneNum);

    JTextField email = new JTextField();
    frame.add(new JLabel("Email"));
    frame.add(email);

    JButton submit = new JButton("Submit");
    JLabel result = new JLabel();
    result.setHorizontalAlignment(JLabel.CENTER);

    submit.addActionListener( new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String em = email.getText();
        String phone = phoneNum.getText();
        result.setText("invalid");

        if (em.isEmpty() || phone.isEmpty()) { return; }

        try {
          Long.parseLong(phone);
          if (phone.length() < 10) { return; }
        } catch (Exception error) { return; }

        if (!em.contains("@")) { return; }

        result.setText("Valid");
      }
    });

    frame.add(submit);
    frame.add(result);
    frame.setVisible(true);
  }
}

