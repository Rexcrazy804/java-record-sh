package org.projects.prog12;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Swing {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Swing Example");
    frame.setLayout(new GridLayout(4, 2));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 130);

    JTextField number = new JTextField();
    frame.add(new JLabel("Number: "));
    frame.add(number);

    JLabel list1 = new JLabel();
    list1.setHorizontalAlignment(JLabel.CENTER);
    frame.add(new JLabel("List 1"));
    frame.add(list1);

    JLabel list2 = new JLabel();
    list2.setHorizontalAlignment(JLabel.CENTER);
    frame.add(new JLabel("List 2"));
    frame.add(list2);

    JButton submit = new JButton("Submit");

    submit.addActionListener( new ActionListener() {
      public void actionPerformed(ActionEvent e) throws NumberFormatException {
        int num = Integer.parseInt(number.getText());
        number.setText("");
        if (num % 2 == 0) {
          list1.setText(list1.getText() + " " + num);
        } else {
          list2.setText(list2.getText() + " " + num);
        }
      }
    });

    frame.add(submit);
    frame.setVisible(true);
  }
}

