package org.projects.prog8;

interface Shape {
  abstract int area();

  abstract int volume();
}

class Cube implements Shape {
  private int side;

  public Cube(int side) {
    this.side = side;
  }

  public int area() {
    return 6 * side * side;
  }

  public int volume() {
    return side * side * side;
  }
}

class Cuboid implements Shape {
  private int lenght, breadth, height;

  public Cuboid(int lenght, int breadth, int height) {
    this.lenght = lenght;
    this.breadth = breadth;
    this.height = height;
  }

  public int area() {
    return 2 * ((lenght * breadth) + (breadth * height) + (height * lenght));
  }

  public int volume() {
    return lenght * breadth * height;
  }
}

public class Interface {
  public static void main(String args[]) {
    Cube cube = new Cube(2);
    Cuboid cuboid = new Cuboid(2, 3, 2);
    Shape[] shapes = {cube, cuboid};
    for (Shape shape : shapes) {
      System.out.println("Area: " + shape.area());
      System.out.println("Volume: " + shape.volume());
    }
  }
}
