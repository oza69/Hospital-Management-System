/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file presents option 6: Insurance
 */
package hms.presentation.options;

import hms.database.classes.insurance.insurancepersistence.InsurancePersistence;
import hms.database.interfaces.insurance.insurancepersistence.IInsurancePersistence;
import hms.models.classes.disease.datacomparator.DateComparator;
import hms.models.classes.insurance.insurance.Insurance;
import hms.models.interfaces.disease.datacomparator.IDateComparator;
import hms.models.interfaces.insurance.insurance.IInsurance;

import java.sql.Connection;
import java.util.Map;
import java.util.Scanner;

public class Option6 {

  private final Scanner scanner;
  private final Connection connection;
  private final IDateComparator dateComparator;
  private final IInsurancePersistence insurancePersistence;

  public Option6(Scanner scanner, Connection connection) {
    this.scanner = scanner;
    this.connection = connection;
    this.dateComparator = new DateComparator();
    this.insurancePersistence = new InsurancePersistence();
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
    System.out.println("You selected - Insurance");
    System.out.println("-----------------------------------");
    System.out.println("1. Add Insurance");
    System.out.println("2. Update Insurance");
    System.out.println("3. View Insurance");
    System.out.println("4. View All Insurances");
    System.out.println("0. Back");
    System.out.println("-----------------------------------");
    System.out.println("Please choose an option (enter no.):");
  }

  private void module1() {
    IInsurance insurance = new Insurance();
    String name;
    String description;
    Integer amount;
    String startDate;
    String endDate;
    Integer policyType;
    System.out.println("You selected - Add Insurance");
    System.out.println("-----------------------------------");
    System.out.println("1. Insurance Policy Name:");
    scanner.nextLine();
    name = scanner.nextLine();
    insurance.setName(name);
    System.out.println("2. Insurance Policy Description:");
    description = scanner.nextLine();
    insurance.setDescription(description);
    System.out.println("3. Insurance Amount Covered:");
    amount = scanner.nextInt();
    insurance.setAmountCovered(amount);
    System.out.println("4. Start Date (YYYY-MM-DD):");
    scanner.nextLine();
    startDate = scanner.nextLine();
    insurance.setStartDate(startDate);
    System.out.println("5. End Date (YYYY-MM-DD):");
    endDate = scanner.nextLine();
    insurance.setEndDate(endDate);
    System.out.println("6. Policy Type (0 OR 1):");
    policyType = scanner.nextInt();
    insurance.setPolicyType(policyType);
    if (insurance.isValid(dateComparator)) {
      if (insurance.save(connection, insurancePersistence, dateComparator)) {
        System.out.println("Insurance saved successfully.");
      } else {
        System.out.println("Unable to save Insurance.");
      }
    } else {
      System.out.println("Invalid Insurance parameters");
    }

    System.out.println("===================================");
    System.out.println("Enter any number to continue.");
    scanner.nextInt();
  }

  private void module2() {
    IInsurance insurance = new Insurance();
    String name;
    String description;
    Integer amount;
    String startDate;
    String endDate;
    Integer policyType;
    System.out.println("You selected - Update Insurance");
    System.out.println("-----------------------------------");
    System.out.println("Please enter insurance ID:");
    Integer policyId = scanner.nextInt();
    insurance.load(policyId, connection, insurancePersistence, dateComparator);
    System.out.println("Please enter new values to update or press 0 to skip");
    System.out.println("====================================================");
    System.out.println("1. Insurance Policy Name:");
    System.out.println("Current:" + insurance.getName());
    System.out.println("New:");
    scanner.nextLine();
    name = scanner.nextLine();
    if (!name.equals("0")) {
      insurance.setName(name);
    }

    System.out.println("2. Insurance Policy Description:");
    System.out.println("Current:" + insurance.getDescription());
    System.out.println("New:");
    description = scanner.nextLine();
    if (!description.equals("0")) {
      insurance.setDescription(description);
    }

    System.out.println("3. Insurance Amount Covered:");
    System.out.println("Current:" + insurance.getAmountCovered());
    System.out.println("New:");
    amount = scanner.nextInt();
    if (amount > 0) {
      insurance.setAmountCovered(amount);
    }

    System.out.println("4. Start Date (YYYY-MM-DD):");
    System.out.println("Current:" + insurance.getStartDate());
    System.out.println("New:");
    scanner.nextLine();
    startDate = scanner.nextLine();
    if (!startDate.equals("0")) {
      insurance.setStartDate(startDate);
    }

    System.out.println("5. End Date (YYYY-MM-DD):");
    System.out.println("Current:" + insurance.getEndDate());
    System.out.println("New:");
    endDate = scanner.nextLine();
    if (!endDate.equals("0")) {
      insurance.setEndDate(endDate);
    }

    System.out.println("6. Policy Type (0 OR 1) [Any other number to skip]:");
    System.out.println("Current:" + insurance.getPolicyType());
    System.out.println("New:");
    policyType = scanner.nextInt();
    if (policyType == 0 || policyType == 1) {
      insurance.setPolicyType(policyType);
    }

    if (insurance.isValid(dateComparator)) {
      if (insurance.update(connection, insurancePersistence, dateComparator)) {
        System.out.println("Insurance updated successfully.");
      } else {
        System.out.println("Unable to update Insurance.");
      }
    } else {
      System.out.println("Invalid Insurance parameters");
    }

    System.out.println("===================================");
    System.out.println("Enter any number to continue.");
    scanner.nextInt();
  }

  private void module3() {
    IInsurance insurance = new Insurance();
    System.out.println("You selected - View Insurance");
    System.out.println("-----------------------------------");
    System.out.println("Please enter insurance ID:");
    Integer policyId = scanner.nextInt();
    insurance.load(policyId, connection, insurancePersistence, dateComparator);
    if (insurance.isValid(dateComparator)) {
      System.out
          .println("====================================================");
      System.out.println("1. Insurance Policy Name: " + insurance.getName());
      System.out.println(
          "2. Insurance Policy Description: " + insurance.getDescription());
      System.out.println(
          "3. Insurance Amount Covered: " + insurance.getAmountCovered());
      System.out
          .println("4. Start Date (YYYY-MM-DD): " + insurance.getStartDate());
      System.out.println("5. End Date (YYYY-MM-DD): " + insurance.getEndDate());
      System.out.println("6. Policy Type (0->Patient, 1->Doctor): " +
          insurance.getPolicyType());
    } else {
      System.out.println("Unable to fetch insurance details.");
    }

    System.out.println("===================================");
    System.out.println("Enter any number to continue.");
    scanner.nextInt();
  }

  private void module4() {
    System.out.println("You selected - View All Insurances");
    System.out
        .println("---------------------------------------------------------");
    Map<Integer, IInsurance> policies =
        insurancePersistence.getAllInsurances(connection);
    System.out
        .println("=========================================================");
    System.out
        .println("ID\t| Name\t| Description\t| Start Date\t| End Date\t| Type");
    System.out
        .println("=========================================================");
    for (IInsurance policy : policies.values()) {
      System.out.println(
          policy.getPolicyId() + "\t| " + policy.getName() + "\t| " +
              policy.getDescription() + "\t| " +
              policy.getStartDate() + "\t| " + policy.getEndDate() + "\t| " +
              policy.getPolicyType());
    }

    System.out
        .println("=========================================================");
    System.out.println("Enter any number to continue.");
    scanner.nextInt();
  }
}