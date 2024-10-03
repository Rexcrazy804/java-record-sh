package org.projects.prog15;

//15. Write a Java program to define Account class. Derive Saving_Account class
//from Account class. Define appropriate constructors for both classes. Define
//the following methods in the Saving_Account class: 
//  Display( ): To display account details including account number and balance in
//  the account.  
//  Deposit( ): To deposit money in an account. 

class Account {
  public String accName;
  public long accNumber;

  Account (String name, long number) {
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
