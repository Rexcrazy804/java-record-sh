package org.projects.prog5;

import java.util.Scanner;

abstract class Figure {
  int length, breadth, height;

  abstract int area();

  void accept() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter length, breadth, height");
    length = sc.nextInt();
    breadth = sc.nextInt();
    height = sc.nextInt();
  }

  void display() {
    System.out.printf(
        "Length: %d Breadth: %d Height: %d Area: %d", length, breadth, height, area());
  }
}

class Rectangle extends Figure {
  int area() {
    return length * breadth;
  }
}

class Triangle extends Figure {
  int area() {
    return (breadth * height) / 2;
  }
}

public class Main {
  public static void main(String args[]) {
    Rectangle rec = new Rectangle();
    Triangle tri = new Triangle();
    System.out.println("Rectangle");
    rec.accept();
    rec.display();
    System.out.println("Triangle");
    tri.accept();
    tri.display();
  }
}
