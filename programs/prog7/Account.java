package org.projects.prog7;

// this program does not require a main function
// since abstract classes can not be instantiated
public abstract class Account {
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
  }

  abstract void withdraw(int amount);
}
