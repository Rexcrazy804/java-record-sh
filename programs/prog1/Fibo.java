package org.projects.prog1;
import java.util.Scanner;

public class Fibo {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of terms");
    int limit = sc.nextInt();

    for (int i = 0; i < limit; i++) {
      System.out.print(fibo(i) + " ");
    }
  }

  static int fibo(int num) {
    return (num <= 1)? num : fibo(num - 1) + fibo (num - 2);
  }
}
