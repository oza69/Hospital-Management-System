/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file presents option 10: HM-Analysis
 */
package hms.presentation.options;

import hms.database.classes.disease.diseasepersistence.DiseasePersistence;
import hms.database.classes.hmanalysis.getdiseaseinrange.GetDiseasesInRangePersistence;
import hms.database.interfaces.disease.diseasepersistence.IDiseasePersistence;
import hms.database.interfaces.hmanalysis.getdiseaseinrange.IGetDiseasesInRangePersistence;
import hms.models.classes.disease.datacomparator.DateComparator;
import hms.models.classes.disease.diseasesorter.DiseaseSorter;
import hms.models.classes.disease.zerotoonescale.ZeroToOneScale;
import hms.models.classes.hmanalysis.contagiousandriskydiseases.ContagiousAndRiskyDiseases;
import hms.models.classes.hmanalysis.diseasesbasedonriskfactor.RiskFactorBasedDiseases;
import hms.models.classes.hmanalysis.diseasescausetogether.DiseasesCauseTogether;
import hms.models.classes.hmanalysis.mostcausedinrange.MostCausedInRange;
import hms.models.interfaces.disease.datacomparator.IDateComparator;
import hms.models.interfaces.disease.diseasesorter.IDiseaseSorter;
import hms.models.interfaces.disease.zerotoonescale.IZeroToOneScale;
import hms.models.interfaces.hmanalysis.contagiousandriskydiseases.IContagiousAndRiskyDiseases;
import hms.models.interfaces.hmanalysis.diseasesbasedonriskfactor.IRiskFactorBasedDiseases;
import hms.models.interfaces.hmanalysis.diseasescausetogether.IDiseasesCauseTogether;
import hms.models.interfaces.hmanalysis.mostcausedinrange.IMostCausedInRange;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Option10 {

  private final Scanner scanner;
  private final Connection connection;
  private final IDiseasePersistence diseasePersistence;
  private final IGetDiseasesInRangePersistence getDiseasesInRangePersistence;
  private final IDateComparator dateComparator;
  private final IZeroToOneScale factorChecker;
  private final IDiseaseSorter sorter;

  public Option10(Scanner scanner, Connection connection) {
    this.scanner = scanner;
    this.connection = connection;
    this.diseasePersistence = new DiseasePersistence();
    this.getDiseasesInRangePersistence = new GetDiseasesInRangePersistence();
    this.dateComparator = new DateComparator();
    this.factorChecker = new ZeroToOneScale();
    this.sorter = new DiseaseSorter();
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
    System.out.println("You selected - HM-Analysis");
    System.out.println("-----------------------------------");
    System.out.println("1. Find Most Caused Diseases");
    System.out.println("2. Find Most Caused Diseases Based On Risk Factor");
    System.out.println("3. Find Diseases Found Contagious and Risky");
    System.out.println("4. Find Diseases Commonly Found Together");
    System.out.println("0. Back");
    System.out.println("-----------------------------------");
    System.out.println("Please choose an option (enter no.):");
  }

  private void module1() {
    System.out.println("You selected - Find Most Caused Diseases");
    System.out.println("-----------------------------------");
    System.out.println("1. Enter Start Date (YYYY-MM-DD):");
    scanner.nextLine();
    Date startDate = Date.valueOf(scanner.nextLine());
    System.out.println("2. Enter End Date (YYYY-MM-DD):");
    Date endDate = Date.valueOf(scanner.nextLine());
    if (dateComparator.compare(startDate, endDate)) {
      IMostCausedInRange mostCausedInRange = new MostCausedInRange();
      Map<String, Double> diseases = mostCausedInRange
          .getMostCases(startDate, endDate, connection, diseasePersistence,
              getDiseasesInRangePersistence,
              sorter);
      Integer counter = 1;
      System.out.println("===================================");
      System.out.println("Rank\t| Disease\t| Total Number Of Cases");
      System.out.println("===================================");
      for (String name : diseases.keySet()) {
        System.out
            .println(counter + "\t| " + name + "\t| " + diseases.get(name));
        counter++;
      }
    } else {
      System.out.println("Invalid dates.");
    }

    System.out.println("===================================");
    System.out.println("Enter any number to continue.");
    scanner.nextInt();
  }

  private void module2() {
    System.out.println("You selected - Find Most Caused Diseases");
    System.out.println("-----------------------------------");
    System.out.println("1. Enter Start Date (YYYY-MM-DD):");
    scanner.nextLine();
    Date startDate = Date.valueOf(scanner.nextLine());
    System.out.println("2. Enter End Date (YYYY-MM-DD):");
    Date endDate = Date.valueOf(scanner.nextLine());
    if (dateComparator.compare(startDate, endDate)) {
      IRiskFactorBasedDiseases riskFactorBasedDiseases =
          new RiskFactorBasedDiseases();
      Map<String, Double> diseases = riskFactorBasedDiseases
          .getFrequentCases(startDate, endDate, connection, diseasePersistence,
              getDiseasesInRangePersistence,
              sorter);
      Integer counter = 1;
      System.out.println("===================================");
      System.out.println("Rank\t| Disease\t| Risk Factor");
      System.out.println("===================================");
      for (String name : diseases.keySet()) {
        System.out
            .println(counter + "\t| " + name + "\t| " + diseases.get(name));
        counter++;
      }
    } else {
      System.out.println("Invalid dates.");
    }

    System.out.println("===================================");
    System.out.println("Enter any number to continue.");
    scanner.nextInt();
  }

  private void module3() {
    System.out
        .println("You selected - Find Diseases Found Contagious and Risky");
    System.out.println("-----------------------------------");
    System.out.println("1. Enter Start Date (YYYY-MM-DD):");
    scanner.nextLine();
    Date startDate = Date.valueOf(scanner.nextLine());
    System.out.println("2. Enter End Date (YYYY-MM-DD):");
    Date endDate = Date.valueOf(scanner.nextLine());
    if (dateComparator.compare(startDate, endDate)) {
      IContagiousAndRiskyDiseases contagiousAndRiskyDiseases =
          new ContagiousAndRiskyDiseases();
      Map<String, Map<String, Double>> diseases = contagiousAndRiskyDiseases
          .getDiseases(startDate, endDate, connection, diseasePersistence,
              getDiseasesInRangePersistence,
              factorChecker, sorter);
      Integer counter = 1;
      System.out.println("===================================");
      System.out.println(
          "Rank\t| Disease\t| Fatality Risk Factor\t| Contagious Risk Factor" +
              "\t| Overall Factor");
      System.out.println("===================================");
      for (String name : diseases.keySet()) {
        System.out.println(
            counter + "\t| " + name + "\t| " +
                diseases.get(name).get("fatalityRiskFactor") + "\t| " +
                diseases.get(name).get("contagiousRiskFactor") + "\t| " +
                diseases.get(name).get("overallRiskFactor"));
        counter++;
      }
    } else {
      System.out.println("Invalid dates.");
    }

    System.out.println("===================================");
    System.out.println("Enter any number to continue.");
    scanner.nextInt();
  }

  private void module4() {
    System.out.println("You selected - Find Diseases Commonly Found Together");
    System.out.println("-----------------------------------");
    System.out.println("1. Enter Start Date (YYYY-MM-DD):");
    scanner.nextLine();
    Date startDate = Date.valueOf(scanner.nextLine());
    System.out.println("2. Enter End Date (YYYY-MM-DD):");
    Date endDate = Date.valueOf(scanner.nextLine());
    if (dateComparator.compare(startDate, endDate)) {
      IDiseasesCauseTogether diseasesCauseTogether =
          new DiseasesCauseTogether();
      Map<String, List<String>> diseases = diseasesCauseTogether
          .getDiseasesCauseTogether(startDate, endDate, connection,
              diseasePersistence, getDiseasesInRangePersistence, sorter);
      Integer counter = 1;
      System.out.println("===================================");
      System.out.println("Rank\t| Disease\t| Diseases Caused Together");
      System.out.println("===================================");
      for (String disease : diseases.keySet()) {
        System.out.print(counter + "\t| ");
        System.out.print(disease + "\t| ");
        for (String diseaseCaused : diseases.get(disease)) {
          System.out.print(diseaseCaused + ", ");
        }

        System.out.print("\n");
        counter++;
      }
    } else {
      System.out.println("Invalid dates.");
    }

    System.out.println("===================================");
    System.out.println("Enter any number to continue.");
    scanner.nextInt();
  }
}