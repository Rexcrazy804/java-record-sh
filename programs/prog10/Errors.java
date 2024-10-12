package org.projects.prog10;

public class Errors {
  static void division() throws ArithmeticException {
    throw new ArithmeticException("/ by zero");
  }

  public static void main(String args[]) {
    try {
      division();
    } catch (ArithmeticException e) {
      System.out.println(e.getMessage());
    } finally {
      System.out.println("Hello Mars!");
    }
  }
}
