package org.projects.prog21;

public class Threading {
  public static Runnable simple_runnable = new Runnable() {
    public void run() {
      String name = Thread.currentThread().getName();
      for (int i = 0; i < 10; i++) {
        System.out.println(name + " " + i);
      }
    }
  };

  public static void main (String args[]) {
    Thread th0 = new Thread(simple_runnable), th1 = new Thread(simple_runnable);

    th0.setPriority(Thread.MIN_PRIORITY);
    th1.setPriority(Thread.MAX_PRIORITY);

    th0.start();
    th1.start();
  }
}
