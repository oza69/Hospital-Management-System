/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file presents option 7: Case
 */
package hms.presentation.options;

import hms.database.classes.cases.casepersistence.CasePersistence;
import hms.database.interfaces.cases.casepersistence.ICasePersistence;
import hms.models.classes.cases.cases.Cases;
import hms.models.classes.cases.expertnessindex.ExpertnessIndex;
import hms.models.classes.disease.zerotoonescale.ZeroToOneScale;
import hms.models.interfaces.cases.cases.ICases;
import hms.models.interfaces.cases.expertnessindex.IExpertnessIndex;
import hms.models.interfaces.disease.zerotoonescale.IZeroToOneScale;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class Option7 {

  private final Scanner scanner;
  private final Connection connection;
  private final ICasePersistence casePersistence;
  private final IZeroToOneScale factorChecker;

  public Option7(Scanner scanner, Connection connection) throws SQLException {
    this.scanner = scanner;
    this.connection = connection;
    this.casePersistence = new CasePersistence();
    this.factorChecker = new ZeroToOneScale();
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
        default:
          presentOption();
      }
      presentOption();
    }
  }

  private void presentOption() {
    System.out.println("You selected - Cases");
    System.out.println("-----------------------------------");
    System.out.println("1. Add Case");
    System.out.println("2. Update Case");
    System.out.println("3. View Case");
    System.out.println("4. View All Cases");
    System.out.println("5. Suggest Best Doctors For A Disease");
    System.out.println("0. Back");
    System.out.println("-----------------------------------");
    System.out.println("Please choose an option (enter no.):");
  }

  private void module1() {
    ICases iCases = new Cases();
    Integer patientId;
    String description;
    Integer diseaseId;
    Double feedback;
    Integer referenceId;
    Integer policyId;
    Integer amount;
    String date;
    Integer doctorId;
    System.out.println("You selected - Add Case");
    System.out.println("-----------------------------------");
    System.out.println("1. Patient ID:");
    patientId = scanner.nextInt();
    iCases.setPatientId(patientId);
    System.out.println("2. Case Description:");
    scanner.nextLine();
    description = scanner.nextLine();
    iCases.setDescription(description);
    System.out.println("3. Disease ID:");
    diseaseId = scanner.nextInt();
    iCases.setDiseaseId(diseaseId);
    System.out.println("4. Feedback (From 0.0 to 1.0, ex 0.1, 0.2...):");
    feedback = scanner.nextDouble();
    iCases.setFeedback(feedback);
    System.out.println("5. Reference ID (0 if none):");
    referenceId = scanner.nextInt();
    iCases.setReferenceId(referenceId);
    System.out.println("6. Policy ID (0 if none):");
    policyId = scanner.nextInt();
    iCases.setPolicyId(policyId);
    System.out.println("7. Amount:");
    amount = scanner.nextInt();
    iCases.setAmount(amount);
    System.out.println("8. Date (YYYY-MM-DD):");
    scanner.nextLine();
    date = scanner.nextLine();
    iCases.setDate(date);
    System.out.println("9. Doctor ID:");
    doctorId = scanner.nextInt();
    iCases.setAssignedDoctorId(doctorId);
    if (iCases.isValid(factorChecker)) {
      if (iCases.save(connection, casePersistence, factorChecker)) {
        System.out.println("Case saved successfully.");
      } else {
        System.out.println("Unable to save case.");
      }
    } else {
      System.out.println("Invalid case parameters");
    }

    System.out.println("===================================");
    System.out.println("Enter any number to continue.");
    scanner.nextInt();
  }

  private void module2() {
    ICases iCases = new Cases();
    Integer patientId;
    String description;
    Integer diseaseId;
    Double feedback;
    Integer referenceId;
    Integer policyId;
    Integer amount;
    String date;
    Integer doctorId;
    System.out.println("You selected - Update Case");
    System.out.println("-----------------------------------");
    System.out.println("Please enter case ID:");
    Integer caseId = scanner.nextInt();
    iCases.load(caseId, connection, casePersistence, factorChecker);
    System.out.println("Please enter new values to update or press 0 to skip");
    System.out.println("====================================================");
    System.out.println("1. Patient ID:");
    System.out.println("Current:" + iCases.getPatientId());
    System.out.println("New:");
    patientId = scanner.nextInt();
    if (patientId > 0) {
      iCases.setPatientId(patientId);
    }

    System.out.println("2. Case Description:");
    System.out.println("Current:" + iCases.getDescription());
    System.out.println("New:");
    scanner.nextLine();
    description = scanner.nextLine();
    if (!description.equals("0")) {
      iCases.setDescription(description);
    }

    System.out.println("3. Disease ID:");
    System.out.println("Current:" + iCases.getDiseaseId());
    System.out.println("New:");
    diseaseId = scanner.nextInt();
    if (diseaseId > 0) {
      iCases.setDiseaseId(diseaseId);
    }

    System.out.println("4. Feedback (From 0.0 to 1.0, ex 0.1, 0.2...):");
    System.out.println("Current:" + iCases.getFeedback());
    System.out.println("New:");
    feedback = scanner.nextDouble();
    if (feedback > 0) {
      iCases.setFeedback(feedback);
    }

    System.out.println("5. Reference ID (0 if none):");
    System.out.println("Current:" + iCases.getReferenceId());
    System.out.println("New:");
    referenceId = scanner.nextInt();
    if (referenceId > 0) {
      iCases.setReferenceId(referenceId);
    }

    System.out.println("6. Policy ID (0 if none):");
    System.out.println("Current:" + iCases.getPolicyId());
    System.out.println("New:");
    policyId = scanner.nextInt();
    if (policyId > 0) {
      iCases.setPolicyId(policyId);
    }

    System.out.println("7. Amount:");
    System.out.println("Current:" + iCases.getAmount());
    System.out.println("New:");
    amount = scanner.nextInt();
    if (amount > 0) {
      iCases.setAmount(amount);
    }

    System.out.println("8. Date (YYYY-MM-DD):");
    System.out.println("Current:" + iCases.getDate());
    System.out.println("New:");
    scanner.nextLine();
    date = scanner.nextLine();
    if (!date.equals("0")) {
      iCases.setDate(date);
    }

    System.out.println("9. Doctor ID:");
    System.out.println("Current:" + iCases.getAssignedDoctorId());
    System.out.println("New:");
    doctorId = scanner.nextInt();
    if (doctorId > 0) {
      iCases.setAssignedDoctorId(doctorId);
    }

    if (iCases.isValid(factorChecker)) {
      if (iCases.update(connection, casePersistence, factorChecker)) {
        System.out.println("Case updated successfully.");
      } else {
        System.out.println("Unable to update case.");
      }
    } else {
      System.out.println("Invalid case parameters");
    }

    System.out.println("===================================");
    System.out.println("Enter any number to continue.");
    scanner.nextInt();
  }

  private void module3() {
    ICases iCases = new Cases();
    System.out.println("You selected - View Case");
    System.out.println("-----------------------------------");
    System.out.println("Please enter case ID:");
    Integer caseId = scanner.nextInt();
    iCases.load(caseId, connection, casePersistence, factorChecker);
    if (iCases.isValid(factorChecker)) {
      System.out.println("===================================");
      System.out.println("Case details");
      System.out.println("===================================");
      System.out.println("1. Patient ID: " + iCases.getPatientId());
      System.out.println("2. Case Description: " + iCases.getDescription());
      System.out.println("3. Disease ID: " + iCases.getDiseaseId());
      System.out.println("4. Feedback: " + iCases.getFeedback());
      System.out.println("5. Reference ID: " + iCases.getReferenceId());
      System.out.println("6. Policy ID: " + iCases.getPolicyId());
      System.out.println("7. Amount: " + iCases.getAmount());
      System.out.println("8. Date: " + iCases.getDate());
      System.out.println("9. Doctor ID: " + iCases.getAssignedDoctorId());
    } else {
      System.out.println("Unable to fetch case details.");
    }

    System.out.println("===================================");
    System.out.println("Enter any number to continue.");
    scanner.nextInt();
  }

  private void module4() {
    System.out.println("You selected - View All Cases");
    System.out
        .println("---------------------------------------------------------");
    Map<Integer, ICases> cases = casePersistence.getAllCases(connection);
    System.out
        .println("=========================================================");
    System.out.println("ID\t|Patient ID\t|Description\t|Feedback\t|Doctor ID");
    System.out
        .println("=========================================================");
    for (ICases iCases : cases.values()) {
      System.out.println(
          iCases.getCaseId() + "\t|" + iCases.getPatientId() + "\t|" +
              iCases.getDescription() + "\t|" +
              iCases.getFeedback() + "\t" + "|" + iCases.getAssignedDoctorId());
    }

    System.out
        .println("=========================================================");
    System.out.println("Enter any number to continue.");
    scanner.nextInt();
  }

  private void module5() throws SQLException {
    int diseaseId;
    System.out.println("You selected - Suggest Best Doctors For A Disease");
    IExpertnessIndex expIdx = new ExpertnessIndex();
    System.out.println("Please Enter Disease ID TO Suggest Top Doctors For: ");
    diseaseId = scanner.nextInt();
    System.out.println("Top 3 Doctors For Disease ID " + diseaseId + " are: ");
    expIdx.suggestBestDocs(diseaseId);
    System.out
        .println("=========================================================");
  }
}