package org.projects.prog18;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class MouseProg extends Applet implements MouseMotionListener {
  int x, y;

  public void init() {
    x = 0;
    y = 0;

    addMouseMotionListener(this);
  }

  public void paint(Graphics g) {
    g.drawString("x = " + x + " y = " + y, 20, 20);
  }

  public void mouseMoved(MouseEvent e) {
    x = e.getX();
    y = e.getY();
    repaint();
  }

  public void mouseDragged(MouseEvent e) {}
}
