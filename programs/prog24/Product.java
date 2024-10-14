package org.projects.prog24;

import java.sql.*;
import java.util.Scanner;

public class Product {
  public static Scanner sc = new Scanner(System.in);

  public static void main(String args[]) {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      // NOTE: password maybe different
      String username = "root", password = "coolPass", dbname = "dbone";
      Connection cn =
          DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbname, username, password);

      boolean done = false;
      while (!done) {
        System.out.println("1 - add Product");
        System.out.println("2 - delete Product");
        System.out.println("3 - display");

        switch (sc.nextInt()) {
          case 1:
            addProduct(cn);
            break;
          case 2:
            deleteProduct(cn);
            break;
          case 3:
            displayProducts(cn);
            break;
          default:
            System.out.println("Invalid Choice");
            done = true;
            break;
        }
      }
      cn.close();
    } catch (Exception e) {
    }
  }

  public static void addProduct(Connection cn) {
    sc.nextLine(); // ignore garbage
    System.out.println("Enter Product name");
    String name = sc.nextLine();

    System.out.println("Enter product price");
    float price = sc.nextFloat();

    // to create the table use the following mysql code
    // create table products (
    //   id int unique AUTO_INCREMENT,
    //   name varchar(20) not null,
    //   price decimal(8, 2) not null,
    // );

    try {
      cn.createStatement()
          .execute(
              String.format("INSERT INTO products (name, price) VALUES ('%s', %f)", name, price));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void deleteProduct(Connection cn) {
    System.out.println("Enter and id to delete");
    int id = sc.nextInt();

    try {
      cn.createStatement().execute(String.format("DELETE FROM products WHERE id = %d", id));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void displayProducts(Connection cn) {
    try {
      ResultSet set = cn.createStatement().executeQuery("select * from products");
      while (set.next()) {
        System.out.printf(
            "id: %d, name: %s, cost: %f\n", set.getInt(1), set.getString(2), set.getFloat(3));
      }
    } catch (Exception e) {
      // ignore
    }
  }
}
