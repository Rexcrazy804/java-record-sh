package org.projects.prog3.pack;

public class Prime {
  public static boolean checkPrime(int num) {
    for (int i = 2; i <= num / 2; i++) {
      if (num % i == 0) {
        return false;
      }
    }

    return true;
  }
}
