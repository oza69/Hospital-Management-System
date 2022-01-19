/**
 * @author Dhruv Oza
 * @description : Test DoctorAgePersistence class
 */
package hms.database.doctor.doctoragepersistence;

import hms.database.interfaces.doctor.doctoragepersistence
    .IDoctorAgePersistence;
import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DoctorAgePersistenceTest {

  @Test
  @DisplayName("Check whether Doctor_ID is correct or not!!")
  public void loadDBTest() throws SQLException {
    int doctorID = 1;
    ConnectorDao connectorDao = new Connector();
    IDoctorAgePersistence IDoctorAgePersistence = new hms.database.classes
        .doctor.doctoragepersistence.DoctorAgePersistence(doctorID);
    IDoctorAgePersistence.setDoctorID(doctorID);
    IDoctorAgePersistence.getDoctorID();
    assertNotNull(IDoctorAgePersistence.loadDB(connectorDao));
  }

  @Test
  @DisplayName("Check whether Doctor_ID is 0 or not!!")
  public void isValidTest_1() {
    IDoctorAgePersistence IDoctorAgePersistence = new hms.database.classes
        .doctor.doctoragepersistence.DoctorAgePersistence(-1);
    assertFalse(IDoctorAgePersistence.isValid());
  }

  @Test
  @DisplayName("Check whether Doctor_ID is greater than 0 or not!!")
  public void isValidTest_2() {
    IDoctorAgePersistence IDoctorAgePersistence = new hms.database.classes
        .doctor.doctoragepersistence.DoctorAgePersistence(1);
    assertTrue(IDoctorAgePersistence.isValid());
  }

  @Test
  @DisplayName("Check whether Doctor_ID is greater than 0 or not!!")
  public void setDoctorIDTest() {
    int doctorID = 1;
    IDoctorAgePersistence IDoctorAgePersistence = new hms.database.classes
        .doctor.doctoragepersistence.DoctorAgePersistence(doctorID);
    IDoctorAgePersistence.setDoctorID(doctorID);
    assertEquals(IDoctorAgePersistence.getDoctorID(), doctorID,
        "DoctorID not matched!!");
  }

  @Test
  @DisplayName("Check whether Doctor_ID is greater than 0 or not!!")
  public void getDoctorIDTest() {
    int doctorID = 1;
    IDoctorAgePersistence IDoctorAgePersistence = new hms.database.classes
        .doctor.doctoragepersistence.DoctorAgePersistence(doctorID);
    IDoctorAgePersistence.setDoctorID(doctorID);
    assertTrue(IDoctorAgePersistence.getDoctorID() > 0,
        "DoctorID not matched!!");
  }
}
