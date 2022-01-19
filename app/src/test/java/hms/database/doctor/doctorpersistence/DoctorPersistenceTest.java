/**
 * @author Dhruv Oza
 * @description : Test DoctorPersistence class
 */
package hms.database.doctor.doctorpersistence;

import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import hms.database.classes.doctor.doctorpersistence.DoctorPersistence;
import hms.database.interfaces.doctor.doctorpersistence.IDoctorPersistence;
import hms.models.classes.doctor.doctor.Doctor;
import hms.models.interfaces.doctor.doctor.IDoctor;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DoctorPersistenceTest {

  /**
   * Initializing common variables and objects
   */
  ConnectorDao connectorDao = new Connector();
  Connection connection = connectorDao.getConnection();
  String fullname = "Ravi Patel";
  String gender = "M";
  String address = "Brunswick Street, Canada";
  int contactNo = 987654321;
  String speciality = "Surgeon";
  String status = "A";
  String dob = "1996-04-02";
  String dateOfWorking = "2020-04-02";
  double workingHours = 9.00;
  double efficiencyIndex = 3.00;
  double revenueShared = 2300;
  int policyID = 4;
  int doctorID = 2;
  double attendence = 9.00;
  double overtime = 10.00;
  IDoctorPersistence iDoctorPersistence = new DoctorPersistence();

  @Test
  @DisplayName("getAllDoctor method returns null if any error occurs " +
      "while fetching case records")
  public void getAllDoctorTest() {
    assertNotNull("Doctor details can not be retrieved",
        iDoctorPersistence.getAllDoctor(connection));
  }

  @Test
  @DisplayName("saveDoctor method returns false if unable to insert " +
      "case record")
  public void saveDoctorTest() {
    IDoctor iDoctor =
        new Doctor(fullname, gender, address, contactNo, dob,
            speciality, status, workingHours, efficiencyIndex,
            dateOfWorking, revenueShared, policyID);
    assertTrue(iDoctorPersistence.saveDoctor(iDoctor, connection),
        "Doctor details unable to save in the database");
  }

  @Test
  @DisplayName("getOneDoctor method returns null if any error occurs " +
      "while fetching case records")
  public void getOneDoctorTest() {
    assertNotNull("Doctor details can not be retrieved",
        iDoctorPersistence.getOneDoctor(doctorID, connection));
  }

  @Test
  @DisplayName("addAttendence method returns false if any error occurs " +
      "while adding case records")
  public void addAttendenceTest() throws SQLException {
    assertTrue(iDoctorPersistence.addAttendence(doctorID, attendence,
        connection), "Doctor details unable to save in the database");
  }

  @Test
  @DisplayName("setOvertime method returns false if any error occurs " +
      "while adding case records")
  public void setOvertimeTest() throws SQLException {
    assertTrue(iDoctorPersistence.setOvertime(doctorID, overtime,
        connection), "Doctor details unable to save in the database");
  }
}
