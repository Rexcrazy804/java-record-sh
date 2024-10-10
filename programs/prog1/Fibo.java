package org.projects.prog1;

public class Fibo {
  public static void main(String args[]) {
    int limit = Integer.parseInt(args[0]);
    for (int i = 0; i < limit; i++) {
      System.out.print(fibo(i) + " ");
    }
  }

  static int fibo(int num) {
    return (num <= 1) ? num : fibo(num - 1) + fibo(num - 2);
  }
}
