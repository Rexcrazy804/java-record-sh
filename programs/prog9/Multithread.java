package org.projects.prog9;

public class Multithread {

  public static boolean even = false;
  public static boolean odd = false;
  public static boolean terminate = false;

  public static int random = 0;

  public static Runnable threadMain = new Runnable() {
    public void run() {
      int i = 1, max = 4;
      while (i++ < max) {
        try {
          Thread.sleep(1000);
        } catch (Exception e) {}
        random = (int) ((Math.random() * 18) % 10);
        if (random % 2 == 0) {
          even = true;
        } else {
          odd = true;
        }
        try {
          notify(); // Notify the waiting threads
        } catch (Exception e) {}
      }
      terminate = true;
      try {
        notify();
      } catch (Exception e) {}
    }
  };

  public static Runnable threadEven = new Runnable() {
    public void run() {
      while (!terminate) {
        while (!even && !terminate) {
          try {
            wait(); // Wait until the even flag is set
          } catch (Exception e) {}
        }
        if (!terminate) {
          System.out.println("Square: " + random * random);
          even = false;
          try {
            notify(); // Notify the main thread
          } catch (Exception e) {}
        }
      }
    }
  };

  public static Runnable threadOdd = new Runnable() {
    public void run() {
      while (!terminate) {
        while (!odd && !terminate) {
          try {
            wait(); // Wait until the odd flag is set
          } catch (Exception e) {}
        }
        if (!terminate) {
          System.out.println("Cube: " + random * random * random);
          odd = false;
          try {
            notify(); // Notify the main thread
          } catch (Exception e) {}
        }
      }
    }
  };

  public static void main(String[] args) {
    // prolly the most complex program of the rooster ideally wrap everything
    // inside a try catch block and hope everything works :)
    Thread t1 = new Thread(threadMain);
    Thread t2 = new Thread(threadEven);
    Thread t3 = new Thread(threadOdd);

    t1.start();
    t2.start();
    t3.start();
  }
}
