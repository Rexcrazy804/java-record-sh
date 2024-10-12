package org.projects.prog12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Swing {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Swing Example");
    frame.setLayout(new GridLayout(3, 1));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 400);

    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new GridLayout(1, 2));
    JTextField number = new JTextField();
    inputPanel.add(new JLabel("Number: "));
    inputPanel.add(number);
    frame.add(inputPanel);

    JPanel listPanel = new JPanel();
    listPanel.setLayout(new GridLayout(2, 2));
    final DefaultListModel<String> dl1 = new DefaultListModel<>();
    final JList<String> list1 = new JList<>(dl1);
    final DefaultListModel<String> dl2 = new DefaultListModel<>();
    final JList<String> list2 = new JList<>(dl2);
    listPanel.add(new JLabel("List 1"));
    listPanel.add(new JLabel("List 2"));
    listPanel.add(list1);
    listPanel.add(list2);
    frame.add(listPanel);

    JButton submit = new JButton("Submit");
    submit.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent e) throws NumberFormatException {
            String num = number.getText();
            if (Integer.parseInt(num) % 2 == 0) {
              dl1.addElement(num);
            } else {
              dl2.addElement(num);
            }
            number.setText("");
          }
        });
    frame.add(submit);
    frame.setVisible(true);
  }
}
