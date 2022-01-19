/**
 * @author Dhruv Oza
 * @description : This class will act as presentation layer class for doctor
 * related details
 */
package hms.presentation.options;

import hms.database.classes.doctor.doctorpersistence.DoctorPersistence;
import hms.database.classes.insurance.insurancefordoctors
    .InsuranceForDoctorsPersistence;
import hms.database.interfaces.doctor.doctorpersistence.IDoctorPersistence;
import hms.database.interfaces.insurance.insurancefordoctors
    .IInsuranceForDoctorsPersistence;
import hms.models.classes.doctor.doctor.Doctor;
import hms.models.classes.doctor.efficiencyindex.EfficiencyIndex;
import hms.models.classes.doctor.insurancefordoctors.InsuranceForDoctors;
import hms.models.interfaces.doctor.doctor.IDoctor;
import hms.models.interfaces.doctor.efficiencyindex.IEfficiencyIndex;
import hms.models.interfaces.doctor.insurancefordoctors.IInsuranceForDoctors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import static hms.constants.CallableStatements.PADDED_SPACE;

public class Option1 {

  private Scanner scanner;
  private Connection connection;
  IDoctor iDoctor;

  public Option1(Scanner scanner, Connection connection) throws SQLException {
    this.scanner = scanner;
    this.connection = connection;

    iDoctor = new Doctor();

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
        case 7:
          module7();
          break;
        default:
          presentOption();
      }
      presentOption();
    }
  }

  private void presentOption() {
    System.out.println("You selected - Doctor");
    System.out.println("-----------------------------------");
    System.out.println("1. Add Doctor Details For a Doctor");
    System.out.println("2. View Doctor Details For Single Doctor");
    System.out.println("3. View Doctor Details Of All Doctor");
    System.out.println("4. Add Attendance of a Doctor");
    System.out.println("5. Add Overtime of a Doctor");
    System.out.println("6. Calculate Doctor's Efficiency Index");
    System.out.println("7. Insurance for Doctors working on Highly " +
        "Contagious Diseases");
    System.out.println("0. Back");
    System.out.println("-----------------------------------");
    System.out.println("Please choose an option (enter no.):");
  }

  private void module1() {
    // Declaring private variables
    String fullName;
    String gender;
    String address;
    int contactNo;
    String dob;
    String speciality;
    String status;
    double workingHours;
    double efficiencyIndex;
    String dateOfWorking;
    double revenueShared;
    int policyID;

    IDoctorPersistence iDoctorPersistence = new DoctorPersistence();

    System.out.println("You Selected: 1. Add Doctor Details For A Doctor ");

    System.out.println("-----------------------------------");
    System.out.println("1. Doctor Full Name:");
    scanner.nextLine();
    fullName = scanner.nextLine();
    iDoctor.setFullName(fullName);

    System.out.println("-----------------------------------");
    System.out.println("2. Doctor Gender:");
    gender = scanner.nextLine();
    iDoctor.setGender(gender);

    System.out.println("-----------------------------------");
    System.out.println("3. Doctor Address:");
    address = scanner.nextLine();
    iDoctor.setAddress(address);

    System.out.println("-----------------------------------");
    System.out.println("4. Doctor ContactNo:");
    contactNo = scanner.nextInt();
    iDoctor.setContactNo(contactNo);

    System.out.println("-----------------------------------");
    System.out.println("5. Doctor date of birth:");
    scanner.nextLine();
    dob = scanner.nextLine();
    iDoctor.setDob(dob);

    System.out.println("-----------------------------------");
    System.out.println("6. Doctor Speciality:");
    speciality = scanner.nextLine();
    iDoctor.setSpeciality(speciality);

    System.out.println("-----------------------------------");
    System.out.println("7. Doctor Status:");
    status = scanner.nextLine();
    iDoctor.setStatus(status);

    System.out.println("-----------------------------------");
    System.out.println("8. Doctor Working Hours:");
    workingHours = scanner.nextDouble();
    iDoctor.setWorkingHours(workingHours);

    System.out.println("-----------------------------------");
    System.out.println("9. Doctor Efficiency Index:");
    efficiencyIndex = scanner.nextDouble();
    iDoctor.setEfficiencyIndex(efficiencyIndex);

    System.out.println("-----------------------------------");
    System.out.println("10. Doctor date of working:");
    scanner.nextLine();
    dateOfWorking = scanner.nextLine();
    iDoctor.setDateOfWorking(dateOfWorking);

    System.out.println("-----------------------------------");
    System.out.println("11. Doctor revenue shared:");
    revenueShared = scanner.nextDouble();
    iDoctor.setRevenueShared(revenueShared);

    System.out.println("-----------------------------------");
    System.out.println("12. Doctor Policy ID:");
    policyID = scanner.nextInt();
    iDoctor.setPolicyID(policyID);

    try {
      iDoctorPersistence.saveDoctor(iDoctor, connection);
      System.out.println("Doctor data saved successfully");
    } catch (Exception e) {
      System.out.println("Data could not be saved to DB");
    }
  }

  private void module2() throws SQLException {
    System.out.println("You Selected: 2. View Doctor" +
        " Details For Single Doctor");
    System.out.println("Enter Doctor ID of Doctor:");
    scanner.nextLine();
    int doctorID = scanner.nextInt();
    IDoctorPersistence iDoctorPersistence = new DoctorPersistence();
    ResultSet rs = iDoctorPersistence.getOneDoctor(doctorID, connection);
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
    System.out.println("You Selected: 3. View Doctor " +
        "Details Of All Doctor");
    IDoctorPersistence iDoctorPersistence = new DoctorPersistence();
    ResultSet rs = iDoctorPersistence.getAllDoctor(connection);
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

  private void module4() {
    int doctorID;
    double attendence;
    System.out.println("You Selected: 4. Add Attendance of a Doctor");
    System.out.println("Enter DoctorID: ");
    doctorID = scanner.nextInt();
    System.out.println("Add Attendence: ");
    attendence = scanner.nextDouble();
    IDoctorPersistence iDoctorPersistence = new DoctorPersistence();
    try {
      iDoctorPersistence.addAttendence(doctorID, attendence, connection);
      System.out.println("Doctor data saved successfully");
    } catch (Exception e) {
      System.out.println("Data could not be saved to DB");
    }
  }

  private void module5() {
    int doctorID;
    double overtime;
    System.out.println("You Selected: 5. Add Overtime Hours of a Doctor");
    System.out.println("Enter DoctorID: ");
    doctorID = scanner.nextInt();
    System.out.println("Add Overtime Hours: ");
    overtime = scanner.nextDouble();
    IDoctorPersistence iDoctorPersistence = new DoctorPersistence();
    try {
      iDoctorPersistence.setOvertime(doctorID, overtime, connection);
      System.out.println("DoctorID as " + doctorID + " and Overtime " +
          "Hours for that DoctorID added as " + overtime);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  private void module6() throws SQLException {
    double efficiencyIndex = 0;
    System.out.println("You Selected: 6. Doctor's Efficiency Index");
    int doctorID;
    System.out.println("Enter DoctorID: ");
    doctorID = scanner.nextInt();
    IEfficiencyIndex iEfficiencyIndex = new EfficiencyIndex();
    efficiencyIndex = iEfficiencyIndex.calcEfficiency(doctorID);
    System.out.println("Doctor " + doctorID + " Calculated Efficiency" +
        " Index is " + efficiencyIndex);
    iEfficiencyIndex.putEfficiency(doctorID, efficiencyIndex);
    System.out.println("Efficiency Index updated successfully!!");
  }

  private void module7() throws SQLException {
    System.out.println("You Selected: 7. Insurance for Doctors working " +
        "on Highly Contagious Diseases");
    IInsuranceForDoctorsPersistence iInsuranceForDoctorsPersistence =
        new InsuranceForDoctorsPersistence();
    ResultSet resultSet = iInsuranceForDoctorsPersistence
        .getDoctorList(connection);
    System.out.println("Doctors working on Highly " +
        "Contagious Diseases are : ");
    while (resultSet.next()) {
      int columnValue = resultSet.getInt("doctor_id");
      System.out.println(columnValue);
    }
    IInsuranceForDoctors insuranceForDoctors = new InsuranceForDoctors();
    insuranceForDoctors.setPolicyForDoctors(connection);
    System.out.println("Policy has been updated for above Doctors");
  }
}