package org.projects.prog2;

public class Complex {
  int real, img;

  Complex(int real, int img) {
    this.real = real;
    this.img = img;
  }

  void display() {
    // formatting for correctly displaying complex numbers
    System.out.printf("%d %si\n", real, (img > 0) ? "+ " + img : "- " + -img);
  }

  static Complex add(Complex n1, Complex n2) {
    int real = n1.real + n2.real;
    int img = n1.img + n2.img;
    return new Complex(real, img);
  }

  static Complex multiply(Complex n1, Complex n2) {
    int real = (n1.real * n2.real) - (n1.img * n2.img);
    int img = (n1.real * n2.img) + (n1.img * n2.real);
    return new Complex(real, img); // result = (ac - bd) + (ad + bc)i
  }

  static void cmp(Complex n1, Complex n2) {
    if (n1.real == n2.real && n1.img == n2.img) {
      System.out.println("The complex numbers are equal");
    } else {
      System.out.println("The complex numbers are not equal");
    }
  }

  public static void main(String args[]) {
    Complex c1 = new Complex(2, 3),
        c2 = new Complex(1, -2),
        c3 = add(c1, c2),
        c4 = multiply(c1, c2);

    c1.display();
    c2.display();
    c3.display();
    c4.display();
    cmp(c1, c2);
    cmp(c1, c1);
  }
}
