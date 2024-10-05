package org.projects.prog8;

class Employee {
  String name, code;
  public int basicPay;

  public Employee(String name, String code, int basicPay) {
    this.name = name;
    this.code = code;
    this.basicPay = basicPay;
  }

  public void display() {
    System.out.println("Name: " + name);
    System.out.println("Code: " + code);
    System.out.println("Basic Pay: " + basicPay);
  }
}

interface Salary {
  public abstract int calculate();
}

public class SallarySlip extends Employee implements Salary {
  int allowances, bonuses, deductions;

  public SallarySlip(
      String name, String code, int basicPay, int allowances, int bonuses, int deductions) {
    super(name, code, basicPay);
    this.allowances = allowances;
    this.bonuses = bonuses;
    this.deductions = deductions;
  }

  public int calculate() {
    return basicPay + allowances + bonuses - deductions;
  }

  public void display() {
    System.out.printf("Employee: %s\nCode: %s\nFinal Sallary: %d\n", name, code, calculate());
  }

  public static void main(String args[]) {
    SallarySlip slip = new SallarySlip("Bob Rose", "001", 10000, 4000, 3000, 1500);
    slip.display();
  }
}

// OUTPUT
/*
Employee: Bob Rose
Code: 001
Final Sallary: 15500
*/
