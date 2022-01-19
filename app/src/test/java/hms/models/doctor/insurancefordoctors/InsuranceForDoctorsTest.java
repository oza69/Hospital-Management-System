/**
 * @author Vishvesh Bharatbhai Naik
 * @description Using insuranceForDoctors package
 */
package hms.models.doctor.insurancefordoctors;

import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import hms.models.classes.doctor.insurancefordoctors.InsuranceForDoctors;
import hms.models.interfaces.doctor.insurancefordoctors.IInsuranceForDoctors;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class InsuranceForDoctorsTest {

  ConnectorDao connector = new Connector();
  Connection connection = connector.getConnection();
  IInsuranceForDoctors insurance = new InsuranceForDoctors();

  /**
   * This test check if the the call goes into try block which returns ture
   */
  @Test
  public void testSetPolicyForDoctors() {
    assertTrue("Data is not being put", insurance
        .setPolicyForDoctors(connection));
  }
}