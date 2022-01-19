/**
 * @author Eklavya Nautiyal & Dhruv Oza
 * @description Presentation layer for option 5
 */
package hms.presentation.options;

import hms.database.classes.packageandcoupons.coupons.CouponsPersistence;
import hms.database.classes.packageandcoupons.packagedetails
    .PackagePersistence;
import hms.database.interfaces.packageandcoupons.coupons
    .ICouponsPersistence;
import hms.database.interfaces.packageandcoupons.packagedetails
    .IPackagePersistence;
import hms.models.classes.packageandcoupons.coupons.Coupons;
import hms.models.classes.packageandcoupons.packagedetails.Package;
import hms.models.interfaces.packageandcoupons.coupons.ICoupons;
import hms.models.interfaces.packageandcoupons.packagedetails.IPackage;

import static hms.constants.CallableStatements.PADDED_SPACE;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class Option5 {

  private Scanner scanner;
  private Connection connection;
  IPackage iPackage;
  ICoupons iCoupons;

  public Option5(Scanner scanner, Connection connection) throws SQLException {
    this.scanner = scanner;
    this.connection = connection;

    iPackage = new Package();
    iCoupons = new Coupons();

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
        case 5:
          module5();
          break;
        case 6:
          module6();
          break;
        default:
          presentOption();
      }
      presentOption();
    }
  }

  private void presentOption() {
    System.out.println("You selected - Package and Coupons");
    System.out.println("-----------------------------------");
    System.out.println("1. Add Package");
    System.out.println("2. View Package");
    System.out.println("3. Update Package");
    System.out.println("4. Add Coupon");
    System.out.println("5. Update Coupon");
    System.out.println("6. View Coupon");
    System.out.println("0. Back");
    System.out.println("-----------------------------------");
    System.out.println("Please choose an option (enter no.):");
  }

  private void module1() {
    // Declaring private variables
    String name;
    String description;
    String validity;
    double amount;
    String couponCode;

    IPackagePersistence iPackagePersistence = new PackagePersistence();

    System.out.println("You Selected: 1. Add Package ");

    System.out.println("-----------------------------------");
    System.out.println("1. Package Name:");
    scanner.nextLine();
    name = scanner.nextLine();
    iPackage.setName(name);

    System.out.println("-----------------------------------");
    System.out.println("2. Package Description:");
    description = scanner.nextLine();
    iPackage.setDescription(description);

    System.out.println("-----------------------------------");
    System.out.println("3. Package Validity:");
    validity = scanner.nextLine();
    iPackage.setValidity(validity);

    System.out.println("-----------------------------------");
    System.out.println("4. Package Amount:");
    amount = scanner.nextDouble();
    iPackage.setAmount(amount);

    System.out.println("-----------------------------------");
    System.out.println("5. Package Coupon:");
    scanner.nextLine();
    couponCode = scanner.nextLine();
    iPackage.setCouponCode(couponCode);

    try {
      iPackagePersistence.savePackage(iPackage, connection);
      System.out.println("Package data saved successfully");
    } catch (Exception e) {
      System.out.println("Data could not be saved to DB");
    }

  }

  private void module2() throws SQLException {
    System.out.println("You Selected: 2. View Package Details");
    IPackagePersistence iPackagePersistence = new PackagePersistence();
    ResultSet rs = iPackagePersistence.getAllPackage(connection);
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

  private void module3() {
    int packageID;
    String name;
    String description;
    String validity;
    double amount;
    String couponCode;

    System.out.println("You Selected: 3. Update Package Details");
    System.out.println("Enter PackageID: ");
    scanner.nextLine();
    packageID = scanner.nextInt();

    System.out.println("Add Name: ");
    scanner.nextLine();
    name = scanner.nextLine();

    System.out.println("Add Description: ");
    description = scanner.nextLine();

    System.out.println("Add Validity: ");
    validity = scanner.nextLine();

    System.out.println("Add Amount: ");
    amount = scanner.nextDouble();

    System.out.println("Add Coupon Code: ");
    scanner.nextLine();
    couponCode = scanner.nextLine();

    IPackagePersistence iPackagePersistence = new PackagePersistence();

    try {
      iPackagePersistence.updatePackage(packageID, name, description, validity,
          amount, couponCode, connection);
      System.out.println("Package data saved successfully");
    } catch (Exception e) {
      System.out.println("Data could not be saved to DB");
    }
  }

  private void module4() {

    ICouponsPersistence cp = new CouponsPersistence();
    String coupons;
    double couponDiscount;
    System.out.println("You selected - Add Coupon");
    System.out.println("-----------------------------------");
    System.out.println("1. Coupon Name:");
    scanner.nextLine();
    coupons = scanner.nextLine();
    iCoupons.setCouponCode(coupons);
    System.out.println("2. Set Coupon Discount:");
    couponDiscount = scanner.nextDouble();
    iCoupons.setCouponDiscount(couponDiscount);
    cp.saveCoupon(iCoupons, connection);
    System.out.println("Coupon Details Added");
    System.out.println("-----------------------------------");
  }

  private void module5() {

    int couponId;
    String couponCode;
    double couponDiscount;
    ICouponsPersistence coupons = new CouponsPersistence();
    System.out.println("You selected - Update Coupon");
    System.out.println("-----------------------------------");
    System.out.println("1. Please enter Coupon ID: ");
    scanner.nextLine();
    couponId = scanner.nextInt();
    System.out.println("1. Set Coupon Name:");
    scanner.nextLine();
    couponCode = scanner.nextLine();
    System.out.println("2. Set Coupon Discount:");
    couponDiscount = scanner.nextDouble();
    coupons.updateCoupon(couponId, couponCode, couponDiscount, connection);
    System.out.println("Coupon Details Updated");
    System.out.println("-----------------------------------");

  }

  private void module6() throws SQLException {

    ICouponsPersistence iCouponsPersistence = new CouponsPersistence();
    System.out.println("You selected - View All Coupons");
    System.out.println("-----------------------------------");
    ResultSet rs = iCouponsPersistence.getAllCoupons(connection);
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
  }
}