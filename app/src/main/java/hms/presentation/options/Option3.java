/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file presents option 3: Disease
 */
package hms.presentation.options;

import hms.database.classes.disease.diseasepersistence.DiseasePersistence;
import hms.database.interfaces.disease.diseasepersistence.IDiseasePersistence;
import hms.models.classes.disease.disease.Disease;
import hms.models.classes.disease.zerotoonescale.ZeroToOneScale;
import hms.models.interfaces.disease.disease.IDisease;
import hms.models.interfaces.disease.zerotoonescale.IZeroToOneScale;
import java.sql.Connection;
import java.util.Map;
import java.util.Scanner;

public class Option3 {

  private final Scanner scanner;
  private final Connection connection;
  private final IDiseasePersistence diseasePersistence;
  private final IZeroToOneScale factorChecker;

  public Option3(Scanner scanner, Connection connection) {
    this.scanner = scanner;
    this.connection = connection;
    diseasePersistence = new DiseasePersistence();
    factorChecker = new ZeroToOneScale();
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
    System.out.println("You selected - Diseases");
    System.out.println("-----------------------------------");
    System.out.println("1. Add Disease");
    System.out.println("2. Update Disease");
    System.out.println("3. View Diseases");
    System.out.println("4. View All Diseases");
    System.out.println("0. Back");
    System.out.println("-----------------------------------");
    System.out.println("Please choose an option (enter no.):");
  }

  private void module1() {
    IDisease disease = new Disease();
    String diseaseName;
    String diseaseDescription;
    double fatalityRiskFactor;
    double contagiousRiskFactor;
    System.out.println("You selected - Add Diseases");
    System.out.println("-----------------------------------");
    System.out.println("1. Disease Name:");
    scanner.nextLine();
    diseaseName = scanner.nextLine();
    disease.setName(diseaseName);
    System.out.println("2. Disease Description:");
    diseaseDescription = scanner.nextLine();
    disease.setDescription(diseaseDescription);
    System.out
        .println("3. Fatality Risk Factor (From 0.0 to 1.0, ex 0.1, 0.2...):");
    fatalityRiskFactor = scanner.nextDouble();
    disease.setFatalityRiskFactor(fatalityRiskFactor);
    System.out.println(
        "4. Contagious Risk Factor (From 0.0 to 1.0, ex 0.1, 0.2...):");
    contagiousRiskFactor = scanner.nextDouble();
    disease.setContagiousRiskFactor(contagiousRiskFactor);
    if (disease.isValid(factorChecker)) {
      if (disease.save(connection, diseasePersistence, factorChecker)) {
        System.out.println("Disease saved successfully.");
      } else {
        System.out.println("Unable to save disease.");
      }
    } else {
      System.out.println("Invalid disease parameters");
    }

    System.out.println("===================================");
    System.out.println("Enter any number to continue.");
    scanner.nextInt();
  }

  private void module2() {
    IDisease disease = new Disease();
    IZeroToOneScale zeroToOneScale = new ZeroToOneScale();
    String newDiseaseName;
    String newDiseaseDescription;
    double newFatalityRiskFactor;
    double newContagiousRiskFactor;
    System.out.println("You selected - Update Diseases");
    System.out.println("-----------------------------------");
    System.out.println("Please enter disease ID:");
    Integer diseaseId = scanner.nextInt();
    disease.load(diseaseId, connection, diseasePersistence, factorChecker);
    System.out.println("Please enter new values to update or press 0 to skip");
    System.out.println("====================================================");
    System.out.println("1. Disease Name:");
    System.out.println("Current:" + disease.getName());
    System.out.println("New:");
    scanner.nextLine();
    newDiseaseName = scanner.nextLine();
    if (newDiseaseName != null && !newDiseaseName.equals("") &&
        !newDiseaseName.equals("0")) {
      disease.setName(newDiseaseName);
    }

    System.out.println("2. Disease Description:");
    System.out.println("Current:" + disease.getDescription());
    System.out.println("New:");
    newDiseaseDescription = scanner.nextLine();
    if (newDiseaseDescription != null && !newDiseaseDescription.equals("") &&
        !newDiseaseDescription.equals("0")) {
      disease.setDescription(newDiseaseDescription);
    }

    System.out
        .println("3. Fatality Risk Factor (From 0.0 to 1.0, ex 0.1, 0.2...):");
    System.out.println("Current:" + disease.getFatalityRiskFactor());
    System.out.println("New:");
    newFatalityRiskFactor = scanner.nextDouble();
    if (newFatalityRiskFactor != 0 &&
        factorChecker.isCorrectFormat(newFatalityRiskFactor)) {
      disease.setFatalityRiskFactor(newFatalityRiskFactor);
    }

    System.out.println(
        "4. Contagious Risk Factor (From 0.0 to 1.0, ex 0.1, 0.2...):");
    System.out.println("Current:" + disease.getContagiousRiskFactor());
    System.out.println("New:");
    newContagiousRiskFactor = scanner.nextDouble();
    if (newContagiousRiskFactor != 0 &&
        factorChecker.isCorrectFormat(newContagiousRiskFactor)) {
      disease.setContagiousRiskFactor(newContagiousRiskFactor);
    }

    if (disease.isValid(zeroToOneScale)) {
      if (disease.update(connection, diseasePersistence, factorChecker)) {
        System.out.println("Disease updated successfully.");
      } else {
        System.out.println("Unable to update disease.");
      }
    } else {
      System.out.println("Invalid disease parameters");
    }

    System.out.println("===================================");
    System.out.println("Enter any number to continue.");
    scanner.nextInt();
  }

  private void module3() {
    IDisease disease = new Disease();
    System.out.println("You selected - View Disease");
    System.out.println("-----------------------------------");
    System.out.println("Please enter disease ID:");
    Integer diseaseId = scanner.nextInt();
    disease.load(diseaseId, connection, diseasePersistence, factorChecker);
    if (disease.isValid(factorChecker)) {
      System.out.println("===================================");
      System.out.println("Disease details");
      System.out.println("===================================");
      System.out.println("1. Disease Name: " + disease.getName());
      System.out.println("2. Disease Description: " + disease.getDescription());
      System.out.println(
          "3. Fatality Risk Factor: " + disease.getFatalityRiskFactor());
      System.out.println(
          "4. Contagious Risk Factor: " + disease.getContagiousRiskFactor());
    } else {
      System.out.println("Unable to fetch disease details.");
    }

    System.out.println("===================================");
    System.out.println("Enter any number to continue.");
    scanner.nextInt();
  }

  private void module4() {
    System.out.println("You selected - View All Diseases");
    System.out
        .println("---------------------------------------------------------");
    Map<Integer, IDisease> diseases =
        diseasePersistence.getAllDiseases(connection);
    System.out
        .println("=========================================================");
    System.out
        .println("ID\t|Name\t|Description\t|Fatality Risk\t|Contagious Risk");
    System.out
        .println("=========================================================");
    for (IDisease disease : diseases.values()) {
      System.out.println(disease.getId() + "\t|" + disease.getName() + "\t|" +
          disease.getDescription() + "\t|" +
          disease.getFatalityRiskFactor() + "\t" + "|" +
          disease.getContagiousRiskFactor());
    }

    System.out
        .println("=========================================================");
    System.out.println("Enter any number to continue.");
    scanner.nextInt();
  }
}