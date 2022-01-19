/**
 * @author Eklavya Nautiyal
 * @description Presentation Layer For Payroll
 */
package hms.presentation.options;

import hms.database.classes.payroll.payrollpersistence.PayrollPersistence;
import hms.database.interfaces.payroll.payrollpersistence.IPayrollPersistence;
import hms.models.classes.payroll.incentives.IncentiveBasedPay;
import hms.models.classes.payroll.payroll.Payroll;
import hms.models.classes.payroll.totalamounts.TotalAmount;
import hms.models.interfaces.payroll.incentives.IIncentiveBasedPay;
import hms.models.interfaces.payroll.payroll.IPayroll;
import hms.models.interfaces.payroll.totalamounts.ITotalAmount;

import static hms.constants.CallableStatements.PADDED_SPACE;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class Option8 {

  private Scanner scanner;
  private Connection connection;
  IPayroll newPayee;

  public Option8(Scanner scanner, Connection connection) throws SQLException {

    this.scanner = scanner;
    this.connection = connection;
    newPayee = new Payroll();

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
        case 4:
          module4();
          break;
        default:
          presentOption();
      }
      presentOption();
    }
  }

  private void presentOption() {
    System.out.println("You selected - Payroll");
    System.out.println("-----------------------------------");
    System.out.println("1. Add Payroll Details For A Doctor");
    System.out.println("2. View Payroll Details For All Doctors");
    System.out.println("3. View Payroll Details For Single Doctor");
    System.out.println("4. View Final Salary Amount Of A Doctor");
    System.out.println("0. Back");
    System.out.println("-----------------------------------");
    System.out.println("Please choose an option (enter no.):");
  }

  private void module1() {
    // Declaring private variables
    int doctorID;
    Double amount;
    int age;
    Double attendance;
    Double pendingAmount;
    Double overtimeAmount;
    Double profitIncentive;
    Double taxDeducted;
    Double totalAmount;
    IPayrollPersistence savePay = new PayrollPersistence();
    System.out.println("You Selected: 1. Add Payroll Details For A Doctor ");

    System.out.println("-----------------------------------");
    System.out.println("1. Doctor ID:");
    scanner.nextLine();
    doctorID = scanner.nextInt();
    newPayee.setDoctorID(doctorID);

    System.out.println("-----------------------------------");
    System.out.println("2. Doctor Base Salary Amount:");
    scanner.nextLine();
    amount = scanner.nextDouble();
    newPayee.setAmount(amount);

    System.out.println("-----------------------------------");
    System.out.println("3. Doctor Age:");
    scanner.nextLine();
    age = scanner.nextInt();
    newPayee.setAge(age);

    System.out.println("-----------------------------------");
    System.out.println("4. Doctor Attendance:");
    scanner.nextLine();
    attendance = scanner.nextDouble();
    newPayee.setAttendence(attendance);

    System.out.println("-----------------------------------");
    System.out.println("5. Doctor Pending Amount:");
    scanner.nextLine();
    pendingAmount = scanner.nextDouble();
    newPayee.setPendingAmount(pendingAmount);

    System.out.println("-----------------------------------");
    System.out.println("6. Doctor Overtime Amount:");
    scanner.nextLine();
    overtimeAmount = scanner.nextDouble();
    newPayee.setOvertimeAmount(overtimeAmount);

    System.out.println("-----------------------------------");
    System.out.println("7. Doctor Profit Incentive:");
    scanner.nextLine();
    profitIncentive = scanner.nextDouble();
    newPayee.setProfitIncentive(profitIncentive);

    System.out.println("-----------------------------------");
    System.out.println("8. Doctor Tax Deducted:");
    scanner.nextLine();
    taxDeducted = scanner.nextDouble();
    newPayee.setTaxDeducted(taxDeducted);

    System.out.println("-----------------------------------");
    System.out.println("9. Doctor Total Amount:");
    scanner.nextLine();
    totalAmount = scanner.nextDouble();
    newPayee.setTotalAmount(totalAmount);
    try {

      savePay.savePayroll(newPayee, connection);
      System.out.println("Payroll data saved successfully");
    } catch (Exception e) {
      System.out.println("Data could not be saved to DB");
    }
  }

  private void module2() throws SQLException {
    System.out.println("You Selected: 2. View Payroll Details For All Doctors");
    IPayrollPersistence getAllPay = new PayrollPersistence();
    ResultSet rs = getAllPay.getAllPayroll(connection);
    ResultSetMetaData rsmd = rs.getMetaData();
    int columnsNumber = rsmd.getColumnCount();
    for (int i = 1; i <= columnsNumber; i++) {
      System.out.print(String.format(PADDED_SPACE, rsmd.getColumnName(i)));
    }
    System.out.println("");
    while (rs.next()) {
      for (int i = 1; i <= columnsNumber; i++) {
        String columnValue = rs.getString(i);
        System.out.print(String.format(PADDED_SPACE, columnValue));
      }
      System.out.println("");
    }
  }

  private void module3() throws SQLException {
    System.out.println("You Selected: 3. View Payroll Details For One Doctor");
    System.out.println("Enter Doctor ID For Payroll:");
    scanner.nextLine();
    int doctorID = scanner.nextInt();
    IPayrollPersistence getAllPay = new PayrollPersistence();
    ResultSet rs = getAllPay.getOnePayroll(doctorID, connection);
    ResultSetMetaData rsmd = rs.getMetaData();
    int columnsNumber = rsmd.getColumnCount();
    for (int i = 1; i <= columnsNumber; i++) {
      System.out.print(String.format(PADDED_SPACE, rsmd.getColumnName(i)));
    }
    System.out.println("");
    while (rs.next()) {
      for (int i = 1; i <= columnsNumber; i++) {
        String columnValue = rs.getString(i);
        System.out.print(String.format(PADDED_SPACE, columnValue));
      }
      System.out.println("");
    }
  }

  private void module4() throws SQLException {
    int doctorID;
    System.out.println("4. View Final Salary Amount Of A Doctor");
    System.out.println("Enter Doctor ID For Payroll:");
    scanner.nextLine();
    doctorID = scanner.nextInt();
    IPayrollPersistence getAllPay = new PayrollPersistence();
    ResultSet rs = getAllPay.getOnePayroll(doctorID, connection);
    double amount = 0.0;
    double pendingamt = 0.0;
    double profitshare = 0.0;
    while (rs.next()) {
      amount = rs.getDouble("Amount");
      pendingamt = rs.getDouble("Pending_Amount");
      profitshare = rs.getDouble("Profit_Sharing_Incentive");
    }
    ITotalAmount am = new TotalAmount(amount, pendingamt, profitshare);
    IIncentiveBasedPay ibp = new IncentiveBasedPay(9.0, 12);
    double totalAmt = 9.0;
    totalAmt = am.calculateTotalAmount(ibp);
    System.out.println("Total Amount Of Doctor ID: " + doctorID + " is " + totalAmt);

  }
}