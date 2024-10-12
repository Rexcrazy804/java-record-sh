package org.projects.prog16;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dialog {
  public static void main(String args[]) {
    JFrame frame = new JFrame("cool frame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    frame.setLayout(new GridLayout(3, 1));

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(2, 2));
    panel.add(new JLabel("Num 1: "));
    JTextField num1 = new JTextField();
    panel.add(num1);
    panel.add(new JLabel("Num 2: "));
    JTextField num2 = new JTextField();
    panel.add(num2);
    frame.add(panel);

    JLabel result = new JLabel("Result =");
    result.setHorizontalAlignment(JLabel.CENTER);
    frame.add(result);

    JButton submit = new JButton("Submit");
    submit.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            JDialog dialog = new JDialog();
            dialog.setSize(300, 50);

            JLabel prompt = new JLabel();
            try {
              int n1 = Integer.parseInt(num1.getText());
              int n2 = Integer.parseInt(num2.getText());
              int quotient = n1 / n2;

              result.setText("Result = " + quotient);
              return;
            } catch (NumberFormatException _e) {
              prompt.setText("Invalid Number");
            } catch (ArithmeticException _e) {
              prompt.setText("Division by Zero");
            }

            dialog.add(prompt);
            dialog.setVisible(true);
          }
        });

    frame.add(submit);
    frame.setVisible(true);
  }
}
