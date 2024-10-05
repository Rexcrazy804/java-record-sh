package org.projects.prog5;

abstract class Figure {
  int length, breadth, height;

  abstract int area();

  void display() {
    // similiar to printf in C <stdio.h>
    System.out.printf(
        "Length: %d, Breadth: %d, Height: %d\nArea: %d\n", length, breadth, height, area());
  }
}

class Rectangle extends Figure {
  public Rectangle(int length, int breadth) {
    this.length = length;
    this.breadth = breadth;
    height = 0;
  }

  int area() {
    return length * breadth;
  }
}

class Triangle extends Figure {
  public Triangle(int breadth, int height) {
    this.breadth = breadth;
    this.height = height;
    length = 0;
  }

  int area() {
    return (breadth * height) / 2;
  }
}

public class Main {
  public static void main(String args[]) {
    Rectangle rec = new Rectangle(2, 3);
    Triangle tri = new Triangle(2, 4);

    rec.display();
    tri.display();
  }
}
// OUTPUT
/*
Length: 2, Breadth: 3, Height: 0
Area: 6
Length: 0, Breadth: 2, Height: 4
Area: 4
*/
