package org.projects.prog10;

public class Errors {
  static void division() throws InterruptedException {
    Thread.sleep(100);
    throw new ArithmeticException("division by zero");
  }

  public static void main(String args[]) {
    try {
      division();
    } catch (InterruptedException e) {
      System.out.println(e.getMessage());
    } catch (ArithmeticException e) {
      System.out.println(e.getMessage());
    } finally {
      System.out.println("Hello Mars!");
    }
  }
}
// output
/*
division by zero
Hello Mars!
*/
