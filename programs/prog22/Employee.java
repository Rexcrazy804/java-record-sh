package org.projects.prog22;
import java.sql.*;

public class Employee {
  public static void main(String args[]) {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String username = "root", password = "coolPass", dbname = "dbone";
      Connection cn = DriverManager.getConnection(
        //"jdbc:mysql://localhost:3306/dbone", "root", "coolPass"
        "jdbc:mysql://localhost:3306/" + dbname, username, password
      );

      Statement state = cn.createStatement();
      ResultSet rs = state.executeQuery("select * from employee");

      while (rs.next()) {
        System.out.println("Id: " + rs.getInt(1));
        System.out.println("Name: " + rs.getString(2));
        System.out.println("Designation: " + rs.getString(3));
        System.out.println();
      }

      cn.close();
    } catch (Exception e) {}
  }
}
