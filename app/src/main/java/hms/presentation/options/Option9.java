/**
 * @author Vishvesh Bharatbhai Naik
 * @description Option 9 Presentation Layer
 */
package hms.presentation.options;

import hms.database.classes.revenue.revenuepersistence.RevenuePersistence;
import hms.database.interfaces.revenue.revenuepersistence.IRevenuePersistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import static hms.constants.CallableStatements.PADDED_SPACE;

public class Option9 {

  private Scanner scanner;
  private Connection connection;
  private IRevenuePersistence iRevenuePersistence;

  public Option9(Scanner scanner, Connection connection) throws SQLException {

    this.scanner = scanner;
    this.connection = connection;
    iRevenuePersistence = new RevenuePersistence();

    Boolean running = true;
    int num = 0;
    presentOption();
    while ((num = scanner.nextInt()) > 0) {
      switch (num) {
        case 1:
          module1();
          break;
        default:
          presentOption();
      }
      presentOption();
    }
  }

  private void presentOption() {
    System.out.println("You selected - Revenue");
    System.out.println("-----------------------------------");
    System.out.println("1. Revenue History");
    System.out.println("0. Back");
    System.out.println("-----------------------------------");
    System.out.println("Please choose an option (enter no.):");
  }

  /**
   * Module1 will call all the Revenue from the database
   * @throws SQLException SQL exceptions are handled here
   */
  private void module1() throws SQLException {
    IRevenuePersistence iRevenue = new RevenuePersistence();
    System.out.println("You selected - Revenue History");
    System.out.println("-----------------------------------");
    ResultSet rs = iRevenue.getAllRevenue(connection);
    ResultSetMetaData resultSetMetaData = rs.getMetaData();
    int columnsNumber = resultSetMetaData.getColumnCount();
    for (int i = 1; i <= columnsNumber; i++) {
      System.out.printf(PADDED_SPACE, resultSetMetaData.getColumnName(i));
    }
    System.out.println("");
    while (rs.next()) {
      for (int i = 1; i <= columnsNumber; i++) {
        String columnValue = rs.getString(i);
        System.out.printf(PADDED_SPACE, columnValue);
      }
      System.out.println("");
    }
    System.out.println("-----------------------------------");
    System.out.println("Enter any number to continue.");
    scanner.nextInt();
  }
}