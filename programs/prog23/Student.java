package org.projects.prog23;

import java.sql.*;
import java.util.Scanner;

public class Student {
  public static Scanner sc = new Scanner(System.in);

  public static void main(String args[]) {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String username = "root", password = "coolPass", dbname = "dbone";
      Connection cn =
          DriverManager.getConnection(
              // "jdbc:mysql://localhost:3306/dbone", "root", "coolPass"
              "jdbc:mysql://localhost:3306/" + dbname, username, password);
      System.out.println("1 - add Student");
      System.out.println("2 - update Student");

      switch (sc.nextInt()) {
        case 1:
          addStudent(cn);
          break;
        case 2:
          updateStudent(cn);
          break;
        default:
          System.out.println("Invalid Choice");
          break;
      }

      displayStudents(cn);
      cn.close();
    } catch (Exception e) {
    }
  }

  public static void addStudent(Connection cn) {
    sc.nextLine(); // ignore garbage
    System.out.println("Enter name");
    String name = sc.nextLine();

    System.out.println("Enter roll number, age");
    int roll = sc.nextInt(), age = sc.nextInt();

    System.out.println("Enter Grade");
    char grade = sc.next().charAt(0);

    // to create the table use the following mysql code
    // create table students (
    //   roll int unique not null,
    //   name varchar(20) not null,
    //   age int not null,
    //   grade char(1) not null
    // );

    try {
      cn.createStatement()
          .execute(
              String.format(
                  "INSERT INTO students VALUES (%d, '%s', %d, '%c')", roll, name, age, grade));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void updateStudent(Connection cn) {
    System.out.println("Enter roll number to update");
    int roll = sc.nextInt();

    System.out.println("Enter new age");
    int age = sc.nextInt();

    System.out.println("Enter new grade");
    char grade = sc.next().charAt(0);

    try {
      cn.createStatement()
          .executeUpdate(
              String.format(
                  "UPDATE students SET age = %d, grade = '%c' WHERE roll = %d", age, grade, roll));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void displayStudents(Connection cn) {
    try {
      ResultSet set = cn.createStatement().executeQuery("select * from students");
      while (set.next()) {
        System.out.printf(
            "roll: %d, name: %s, age: %d, grade: %s\n",
            set.getInt(1), set.getString(2), set.getInt(3), set.getString(4));
      }
    } catch (Exception e) {
    }
  }
}
