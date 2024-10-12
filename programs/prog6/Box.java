package org.projects.prog6;

class Rectangle {
  int length, breadth, area;

  public Rectangle(int length, int breadth) {
    this.length = length;
    this.breadth = breadth;
  }

  public int area() {
    area = length * breadth;
    return area;
  }
}

public class Box extends Rectangle {
  int height, volume;

  public Box(int length, int breadth, int height) {
    super(length, breadth);
    this.height = height;
  }

  public int area() {
    area = 2 * ((length * breadth) + (breadth * height) + (height * length));
    return area;
  }

  public int volume() {
    volume = length * breadth * height;
    return volume;
  }

  public static void main(String args[]) {
    Rectangle rec = new Rectangle(2, 3);
    System.out.println("Area of Rectangle: " + rec.area());

    Box box = new Box(2, 3, 2);
    System.out.printf("Area of Box: %d\nVolume of Box: %d\n", box.area(), box.volume());
  }
}
