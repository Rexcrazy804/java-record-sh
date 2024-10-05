package org.projects.prog3.mypack;

import java.util.Scanner;
import org.projects.prog3.pack.Prime;

public class Matrix {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int size = 3;
    int matrix[][] = new int[size][size];

    System.out.println("Enter " + size * size + " matrix elements");
    String output = "";
    int diagSum = 0;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        int input = sc.nextInt();
        matrix[i][j] = input;
        // I don't want to write another nested for loop to print this matrix
        // so we neatly store the matrix in an output string variable and print
        // it out later :)
        output += input + " ";

        // ez math for finding the diagonal elements also lazy to make another
        // loop for this so we're doing it all in one neat for loop
        // here size is the number of rows and columns of our square matrix
        if (i == j || size - (i + 1) == j) {
          diagSum += input;
        }
      }
      output += "\n";
    }

    System.out.println("Given Matrix:\n" + output);
    if (Prime.checkPrime(diagSum)) {
      System.out.println("Diagonal is prime");
    } else {
      System.out.println("Diagonal is not prime");
    }
  }
}

// OUTPUT
/*
  Enter 9 matrix elements
  1 2 3
  0 1 0
  0 1 2
  Given Matrix:
  1 2 3
  0 1 0
  0 1 2
*/
