/**
 * @author Vishvesh Bharatbhai Naik
 * @description This file tests all the methods present in Insurance for doctors
 * Persistence which check the data connectivity with database.
 */
package hms.database.insurance.insurancefordoctors;

import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import hms.database.classes.insurance.insurancefordoctors.InsuranceForDoctorsPersistence;

import static org.junit.Assert.*;

import org.junit.Test;

import java.sql.Connection;

public class InsuranceForDoctorsPersistenceTest {

  InsuranceForDoctorsPersistence insurance =
      new InsuranceForDoctorsPersistence();
  ConnectorDao connector = new Connector();
  Connection connection = connector.getConnection();
  int doctorId = 3;

  /**
   * This test checks if data is being fetched from database is not null
   */
  @Test
  public void testGetDoctorList() {
    assertNotNull("Data is not retrieved", insurance
        .getDoctorList(connection));
  }

  /**
   * This test checks if the method goes into try block where the set is.
   */
  @Test
  public void testSetDoctorInsurance() {
    assertTrue("Data is being set",
        insurance.setDoctorInsurance(doctorId, connection));
  }
}