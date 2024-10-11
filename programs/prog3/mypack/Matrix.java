package org.projects.prog3.mypack;

import java.util.Scanner;
import org.projects.prog3.pack.Prime;

public class Matrix {
  public static final int size = 3;
  public int matrix[][] = new int[size][size];

  public void accept() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter " + size * size + " matrix elements");
    int diagSum = 0;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        matrix[i][j] = sc.nextInt();
      }
    }
  }

  public void display() {
    System.out.println("Given Matrix:");
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  public int diagSum() {
    int sum = 0;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (i == j || size - (i + 1) == j) {
          sum += matrix[i][j];
        }
      }
    }
    return sum;
  }

  public static void main(String args[]) {
    Matrix mat = new Matrix();
    mat.accept();
    mat.display();

    if (Prime.checkPrime(mat.diagSum())) {
      System.out.println("Diagonal is prime");
    } else {
      System.out.println("Diagonal is not prime");
    }
  }
}
