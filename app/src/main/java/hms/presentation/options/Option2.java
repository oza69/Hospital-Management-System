/**
 * @author Vishvesh Bharatbhai Naik
 * @description Option 2 Presentation Layer
 */
package hms.presentation.options;

import hms.database.classes.patients.patientpersistence.PatientsPersistence;
import hms.database.interfaces.patients.patientpersistence.IPatientsPersistence;
import hms.models.classes.patients.patients.Patients;
import hms.models.interfaces.patients.patients.IPatients;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import static hms.constants.CallableStatements.PADDED_SPACE;

public class Option2 {

  private Scanner scanner;
  private Connection connection;
  IPatients iPatients;

  public Option2(Scanner scanner, Connection connection) throws SQLException {

    this.scanner = scanner;
    this.connection = connection;
    iPatients = new Patients();

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
    System.out.println("You selected - Patients");
    System.out.println("-----------------------------------");
    System.out.println("1. Add Patient Details");
    System.out.println("2. View all Patient Details");
    System.out.println("3. View Patient Details");
    System.out.println("4. Update Patient Details");
    System.out.println("0. Back");
    System.out.println("-----------------------------------");
    System.out.println("Please choose an option (enter no.):");
  }

  /**
   * Module1 will call all the payment from the database
   */
  private void module1() {
    int assignedDoctorId;
    String patientFullName;
    String address_Name;
    String gender_Name;
    int age_no;
    String bloodGroup;
    String arrivalDate;
    int contactNo;
    String disease_Name;
    String bPLInfo;
    double annualIncome;
    int feedback_No;
    int policyId;
    String governmentScheme;
    int packageId;

    System.out.println("You Selected: 1. Add Patient Details ");
    System.out.println("-----------------------------------");
    System.out.println("1. Patient Full Name:");
    scanner.nextLine();
    patientFullName = scanner.nextLine();
    iPatients.setPatientFullName(patientFullName);
    System.out.println("-----------------------------------");
    System.out.println("2. Patient Address :");
    address_Name = scanner.nextLine();
    iPatients.setAddressName(address_Name);
    System.out.println("-----------------------------------");
    System.out.println("3. Patient Gender :");
    gender_Name = scanner.nextLine();
    iPatients.setGenderName(gender_Name);
    System.out.println("-----------------------------------");
    System.out.println("4. Patient Age :");
    age_no = scanner.nextInt();
    iPatients.setAgeNo(age_no);
    System.out.println("-----------------------------------");
    System.out.println("5. Patient Blood Group :");
    scanner.nextLine();
    bloodGroup = scanner.nextLine();
    iPatients.setBloodGroup(bloodGroup);
    System.out.println("-----------------------------------");
    System.out.println("6. Patient Arrival Date :");
    arrivalDate = scanner.nextLine();
    iPatients.setArrivalDate(arrivalDate);
    System.out.println("-----------------------------------");
    System.out.println("7. Patient Contact No :");
    contactNo = scanner.nextInt();
    iPatients.setContactNo(contactNo);
    System.out.println("-----------------------------------");
    System.out.println("8. Patient Disease Name :");
    scanner.nextLine();
    disease_Name = scanner.nextLine();
    iPatients.setDiseaseName(disease_Name);
    System.out.println("-----------------------------------");
    System.out.println("9. Patient BPL Info :");
    bPLInfo = scanner.nextLine();
    iPatients.setbPLInfo(bPLInfo);
    System.out.println("-----------------------------------");
    System.out.println("10. Patient Annual Income :");
    annualIncome = scanner.nextDouble();
    iPatients.setAnnualIncome(annualIncome);
    System.out.println("-----------------------------------");
    System.out.println("11. Patient Feedback :");
    scanner.nextLine();
    feedback_No = scanner.nextInt();
    iPatients.setFeedbackNo(feedback_No);
    System.out.println("-----------------------------------");
    System.out.println("12. Patient Policy Id :");
    scanner.nextLine();
    policyId = scanner.nextInt();
    iPatients.setPolicyId(policyId);
    System.out.println("-----------------------------------");
    System.out.println("13. Patient Government Scheme :");
    scanner.nextLine();
    governmentScheme = scanner.nextLine();
    iPatients.setDiseaseName(governmentScheme);
    System.out.println("-----------------------------------");
    System.out.println("14. Patient Assigned Doctor Id :");
    assignedDoctorId = scanner.nextInt();
    iPatients.setAssignedDoctorId(assignedDoctorId);
    System.out.println("-----------------------------------");
    System.out.println("15. Patient Package Id :");
    packageId = scanner.nextInt();
    iPatients.setPackageId(packageId);
  }

  /**
   * Module2 will call all the Patients from the database
   * @throws SQLException SQL exceptions are handled here
   */
  private void module2() throws SQLException {
    System.out.println("You Selected: 2. View Details for all Patients ");
    IPatientsPersistence iPatientsPersistence = new PatientsPersistence();
    ResultSet rs = iPatientsPersistence.getAllPatients(connection);
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

  /**
   * Module3 will update a patient detail by his Id from the database
   * @throws SQLException SQL exceptions are handled here
   */
  private void module3() throws SQLException {
    System.out.println("You Selected: 3. View Patient Details ");
    System.out.println("Enter Patient ID of Patient:");
    scanner.nextLine();
    int patientID = scanner.nextInt();
    IPatientsPersistence iPatientsPersistence = new PatientsPersistence();
    ResultSet rs = iPatientsPersistence.viewPatient(patientID, connection);
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

  /**
   * Module4 will Update Patient Detail from the database
   */
  private void module4() {
    int assignedDoctorId;
    String patientFullName;
    String address_Name;
    String gender_Name;
    int age_no;
    String bloodGroup;
    String arrivalDate;
    int contactNo;
    String disease_Name;
    String bPLInfo;
    double annualIncome;
    int feedback_No;
    int policyId;
    String governmentScheme;
    int packageId;
    System.out.println("You Selected: 4. Update Patient Detail ");
    System.out.println("Enter Patient ID of Patient:");
    scanner.nextLine();
    int patientID = scanner.nextInt();
    System.out.println("-----------------------------------");
    System.out.println("1. Patient Full Name:");
    scanner.nextLine();
    patientFullName = scanner.nextLine();
    iPatients.setPatientFullName(patientFullName);
    System.out.println("-----------------------------------");
    System.out.println("2. Patient Address :");
    address_Name = scanner.nextLine();
    iPatients.setAddressName(address_Name);
    System.out.println("-----------------------------------");
    System.out.println("3. Patient Gender :");
    gender_Name = scanner.nextLine();
    iPatients.setGenderName(gender_Name);
    System.out.println("-----------------------------------");
    System.out.println("4. Patient Age :");
    age_no = scanner.nextInt();
    iPatients.setAgeNo(age_no);
    System.out.println("-----------------------------------");
    System.out.println("5. Patient Blood Group :");
    scanner.nextLine();
    bloodGroup = scanner.nextLine();
    iPatients.setBloodGroup(bloodGroup);
    System.out.println("-----------------------------------");
    System.out.println("6. Patient Arrival Date :");
    arrivalDate = scanner.nextLine();
    iPatients.setArrivalDate(arrivalDate);
    System.out.println("-----------------------------------");
    System.out.println("7. Patient Contact No :");
    contactNo = scanner.nextInt();
    iPatients.setContactNo(contactNo);
    System.out.println("-----------------------------------");
    System.out.println("8. Patient Disease Name :");
    scanner.nextLine();
    disease_Name = scanner.nextLine();
    iPatients.setDiseaseName(disease_Name);
    System.out.println("-----------------------------------");
    System.out.println("9. Patient BPL Info :");
    bPLInfo = scanner.nextLine();
    iPatients.setbPLInfo(bPLInfo);
    System.out.println("-----------------------------------");
    System.out.println("10. Patient Annual Income :");
    annualIncome = scanner.nextDouble();
    iPatients.setAnnualIncome(annualIncome);
    System.out.println("-----------------------------------");
    System.out.println("11. Patient Feedback :");
    scanner.nextLine();
    feedback_No = scanner.nextInt();
    iPatients.setFeedbackNo(feedback_No);
    System.out.println("-----------------------------------");
    System.out.println("12. Patient Policy Id :");
    scanner.nextLine();
    policyId = scanner.nextInt();
    iPatients.setPolicyId(policyId);
    System.out.println("-----------------------------------");
    System.out.println("13. Patient Government Scheme :");
    scanner.nextLine();
    governmentScheme = scanner.nextLine();
    iPatients.setDiseaseName(governmentScheme);
    System.out.println("-----------------------------------");
    System.out.println("14. Patient Assigned Doctor Id :");
    assignedDoctorId = scanner.nextInt();
    iPatients.setAssignedDoctorId(assignedDoctorId);
    System.out.println("-----------------------------------");
    System.out.println("15. Patient Package Id :");
    packageId = scanner.nextInt();
    iPatients.setPackageId(packageId);
    IPatientsPersistence iPatientsPersistence = new PatientsPersistence();
    iPatientsPersistence.updatePatient(patientID, assignedDoctorId,
        patientFullName, address_Name, gender_Name, age_no, bloodGroup,
        arrivalDate, contactNo, disease_Name, bPLInfo, annualIncome,
        feedback_No, policyId, governmentScheme, packageId, connection);
    System.out.println("-----------------------------------");
    System.out.println("Patient Details Updated ");
    System.out.println("-----------------------------------");
  }
}