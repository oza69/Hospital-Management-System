/**
 * @author Dhruv Oza
 * @description : Test DoctorsYears class
 */
package hms.database.doctor.doctorsyears;

import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import hms.database.classes.doctor.doctorsyears.DoctorsYears;
import hms.database.interfaces.doctor.doctorsyears.IDoctorsYears;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DoctorsYearsTest {

  @Test
  @DisplayName("Check whether Doctor_ID is correct or not!!")
  public void loadDBTest() throws SQLException {
    int doctorID = 1;
    ConnectorDao connectorDao = new Connector();
    IDoctorsYears IDoctorsYears = new DoctorsYears(doctorID);
    IDoctorsYears.setDoctorID(doctorID);
    IDoctorsYears.getDoctorID();
    assertNotNull(IDoctorsYears.loadDB(connectorDao));
  }

  @Test
  @DisplayName("Check whether Doctor_ID is 0 or not!!")
  public void isValidTest_1() {
    IDoctorsYears IDoctorsYears = new DoctorsYears(-1);
    assertFalse(IDoctorsYears.isValid());
  }

  @Test
  @DisplayName("Check whether Doctor_ID is greater than 0 or not!!")
  public void isValidTest_2() {
    IDoctorsYears IDoctorsYears = new DoctorsYears(1);
    assertTrue(IDoctorsYears.isValid());
  }

  @Test
  @DisplayName("Check whether Doctor_ID is greater than 0 or not!!")
  public void setDoctorIDTest() {
    int doctorID = 1;
    IDoctorsYears IDoctorsYears = new DoctorsYears(doctorID);
    IDoctorsYears.setDoctorID(doctorID);
    assertEquals(IDoctorsYears.getDoctorID(), doctorID,
        "DoctorID not matched!!");
  }

  @Test
  @DisplayName("Check whether Doctor_ID is greater than 0 or not!!")
  public void getDoctorIDTest() {
    int doctorID = 1;
    IDoctorsYears IDoctorsYears = new DoctorsYears(doctorID);
    IDoctorsYears.setDoctorID(doctorID);
    assertTrue(IDoctorsYears.getDoctorID() > 0,
        "DoctorID not matched!!");
  }
}
