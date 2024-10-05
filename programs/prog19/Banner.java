import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Banner extends Applet implements Runnable {
  String bannerText;
  Thread scroll;

  public void init() {
    bannerText = "REALLY COOL BANNER ";
    scroll = new Thread(this);
  }

  public void start() {
    scroll.start();
  }

  public void paint(Graphics g) {
    g.drawString(bannerText, 100, 100);
  }

  public void run() {
    try {
      while (true) {
        Thread.sleep(500);
        bannerText = bannerText.substring(1) + bannerText.charAt(0);
        repaint();
      }
    } catch (Exception e) {
    }
  }
}
