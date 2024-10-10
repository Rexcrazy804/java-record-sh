package org.projects.prog9;

import java.util.Random;

public class Multithread {
  public static int random = 0;

  public static Runnable threadMain =
      new Runnable() {
        public void run() {
          Random rand = new Random();
          for (int i = 0; i < 4; i++) {
            try {
              Thread.sleep(1000);
            } catch (Exception e) {
              // ignore
            }
            random = rand.nextInt(10);
            if (random % 2 == 0) {
              new Thread(threadEven).start();
            } else {
              new Thread(threadOdd).start();
            }
          }
        }
      };

  public static Runnable threadEven =
      new Runnable() {
        public void run() {
          System.out.println("Square: " + random * random);
        }
      };

  public static Runnable threadOdd =
      new Runnable() {
        public void run() {
          System.out.println("Cube: " + random * random * random);
        }
      };

  public static void main(String[] args) {
    new Thread(threadMain).start();
    /* alternative
      Thread th = new Thread(threadMain);
      th.start();
    */
  }
}
