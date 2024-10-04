package org.projects.prog4;
import java.util.Scanner;

public class Solid {
  int length, breadth, height;

  public Solid (int side) {
		length = side;
		breadth = side;
		height = side;
  }

  public Solid (int side, int height) {
		length = side;
		breadth = side;
		this.height = height;
  }

  public Solid (int length, int breadth, int height) {
    // its really easy to mispell length/breadth/height and get into odd errors ideally during
    // exams I recommend shortening these to just l, b, h;
		this.length = length;
		this.breadth = breadth;
		this.height = height;
  }

  int area() { return 2 * ((length * breadth) + (breadth*height) + (height*length)); }
  int volume() { return length * breadth * height; }

  void display() {
    System.out.println(String.format("Area: %d\nVolume: %d", area(), volume()));
  }

  public static void main(String args[]) {
    Solid 
      cube = new Solid(2),
      sPrism = new Solid(2, 3),
      cuboid = new Solid(2, 3, 4);

    cube.display();
    sPrism.display();
    cuboid.display();
  }
}

// OUTPUT
/*
Area: 24
Volume: 8
Area: 32
Volume: 12
Area: 52
Volume: 24
*/
