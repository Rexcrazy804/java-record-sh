package org.projects.prog15;

class Account {
  public String accName;
  public long accNumber;

  Account(String name, long number) {
    accName = name;
    accNumber = number;
  }
}

public class SavingsAccount extends Account {
  private int accBalance;

  SavingsAccount(String name, long number) {
    super(name, number);
    accBalance = 0;
  }

  public void display() {
    System.out.println("Account: " + accName);
    System.out.println("No: " + accNumber);
    System.out.println("Balance: " + accBalance);
  }

  public void deposit(int ammount) {
    accBalance += ammount;
  }

  public static void main(String args[]) {
    SavingsAccount account = new SavingsAccount("Bijo", 1239812398);
    account.deposit(1000);
    account.display();
  }
}
