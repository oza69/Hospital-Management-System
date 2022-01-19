/**
 * @author Vishvesh Bharatbhai Naik
 * @description Option 4 Presentation Layer
 */
package hms.presentation.options;

import hms.database.classes.payment.fianlamountpersistence.FinalAmountPersistence;
import hms.database.classes.payment.paymentpersistence.PaymentPersistence;
import hms.database.interfaces.payment.finalamountpersistence.IFinalAmountPersistence;
import hms.database.interfaces.payment.paymentpersistence.IPaymentPersistence;
import hms.models.classes.payment.finalamount.FinalAmount;
import hms.models.interfaces.payment.finalamount.IFinalAmount;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import static hms.constants.CallableStatements.PADDED_SPACE;

public class Option4 {

  private Scanner scanner;
  private Connection connection;
  private IPaymentPersistence iPaymentPersistence;

  public Option4(Scanner scanner, Connection connection) throws SQLException {

    this.scanner = scanner;
    this.connection = connection;
    this.iPaymentPersistence = new PaymentPersistence();

    Boolean running = true;
    int num = 0;
    presentOption();
    while ((num = scanner.nextInt()) > 0) {
      switch (num) {
        case 1:
          module1();
          break;
        case 2:
          module2();
          break;
        case 3:
          module3();
          break;
        default:
          presentOption();
      }
      presentOption();
    }
  }

  private void presentOption() {
    System.out.println("You selected - Payment");
    System.out.println("-----------------------------------");
    System.out.println("1. View All Payments");
    System.out.println("2. View Payment Details");
    System.out.println("3. View Final Amount");
    System.out.println("0. Back");
    System.out.println("-----------------------------------");
    System.out.println("Please choose an option (enter no.):");

  }

  /**
   * Module1 will call all the payment from the database
   * @throws SQLException SQL exceptions are handled here
   */
  private void module1() throws SQLException {
    IPaymentPersistence iPayment = new PaymentPersistence();
    System.out.println("You selected - View All Payments");
    System.out.println("-----------------------------------");
    ResultSet rs = iPayment.getAllPayment(connection);
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

  /**
   * Module2 will call specific Payment id from the database
   * @throws SQLException SQL exceptions are handled here
   */
  private void module2() throws SQLException {
    int paymentId;
    IFinalAmountPersistence iPayment = new FinalAmountPersistence();
    System.out.println("1. Please enter Payment ID: ");
    scanner.nextLine();
    paymentId = scanner.nextInt();
    ResultSet rs = iPayment.viewPayment(paymentId);
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

  /**
   * Module3 will perform calculation of final amount and
   * update to the database
   * @throws SQLException SQL exceptions are handled here
   */
  private void module3() throws SQLException {
    int patientId;
    IFinalAmount iFinalAmount = new FinalAmount();
    System.out.println("1. Please enter Patient ID: ");
    scanner.nextLine();
    patientId = scanner.nextInt();
    double rs = iFinalAmount.finalAmount(patientId);
    System.out.println("The Final Amount: " + rs);
    System.out.println("-----------------------------------");
    System.out.println("Enter any number to continue.");
    scanner.nextInt();
  }
}