package org.projects.prog6;

class Rectangle {
  int length, breadth;

  public Rectangle(int length, int breadth) {
    this.length = length;
    this.breadth = breadth;
  }

  public int area() {
    return length * breadth;
  }
}

public class Box extends Rectangle {
  int height;

  public Box(int length, int breadth, int height) {
    super(length, breadth);
    this.height = height;
  }

  public int area() {
    return 2 * ((length * breadth) + (breadth * height) + (height * length));
  }

  public int volume() {
    return length * breadth * height;
  }

  public static void main(String args[]) {
    Rectangle rec = new Rectangle(2, 3);
    System.out.println("Area of Rectangle: " + rec.area());

    Box box = new Box(2, 3, 2);
    System.out.printf("Area of Box: %d\nVolume of Box: %d\n", box.area(), box.volume());
  }
}
// OUTPUT
/*
Area of Rectangle: 6
Area of Box: 32
Volume of Box: 12
*/
