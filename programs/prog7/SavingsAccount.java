package org.projects.prog7;

abstract class Account {
  String holder_name;
  long number;
  float balance;

  Account(String name, long num) {
    balance = 0;
    holder_name = name;
    number = num;
  }

  public void deposit(int amount) {
    balance += amount;
    System.out.println("Amount deposited");
  }

  abstract void withdraw(int amount);
}

public class SavingsAccount extends Account {
  public SavingsAccount(String name, long num) {
    super(name, num);
  }

  void withdraw(int amount) {
    if (balance < amount) {
      System.out.println("insufficient balance");
      return;
    }
    balance -= amount;
    System.out.println("Amount withdrawn");
  }

  public static void main(String args[]) {
    SavingsAccount acc = new SavingsAccount("Raphael Leywin", 180239182);
    acc.deposit(10000);
    acc.withdraw(500);
  }
}
