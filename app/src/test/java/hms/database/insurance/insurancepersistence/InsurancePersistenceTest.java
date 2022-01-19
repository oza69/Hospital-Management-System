/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains test cases for InsurancePersistence
 * class
 */
package hms.database.insurance.insurancepersistence;

import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import hms.database.classes.insurance.insurancepersistence.InsurancePersistence;
import hms.database.interfaces.insurance.insurancepersistence.IInsurancePersistence;
import hms.models.classes.disease.datacomparator.DateComparator;
import hms.models.classes.insurance.insurance.Insurance;
import hms.models.interfaces.disease.datacomparator.IDateComparator;
import hms.models.interfaces.insurance.insurance.IInsurance;
import org.junit.Test;
import java.sql.Connection;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class InsurancePersistenceTest {

  ConnectorDao connector = new Connector();
  Connection connection = connector.getConnection();
  String name = "Deluxe policy";
  String description = "Covers handsome amount of insurance.";
  Integer amount = 3000;
  String startDate = "2020-01-01";
  String endDate = "2021-01-01";
  Integer policyType = 0;
  Integer policyId = 1;
  IInsurance newPolicy =
      new Insurance(name, description, amount, startDate, endDate, policyType);
  IInsurancePersistence insurancePersistence = new InsurancePersistence();
  IDateComparator dateComparator = new DateComparator();

  /**
   * saveInsurance method returns false if any error occurs
   * while saving insurance record
   */
  @Test
  public void testSaveInsurance() {
    assertTrue("Unable to save insurance",
        insurancePersistence.saveInsurance(newPolicy, connection));
  }

  /**
   * getInsurance method returns null if any error occurs
   * while fetching insurance data
   */
  @Test
  public void testGetInsurance() {
    IInsurance insurance = new Insurance();
    assertNotNull("Unable to retrieve insurance data",
        insurancePersistence.getInsurance(policyId, insurance, connection));
  }

  /* checking if getInsurance method fetching correct insurance data or not */
  @Test
  public void testGetInsuranceIsValid() {
    IInsurance insurance = new Insurance();
    assertTrue("Unable to retrieve insurance",
        insurancePersistence.getInsurance(policyId, insurance, connection));
  }

  /* getInsurance method returns false if invalid insurance id passed */
  @Test
  public void testGetNonExistentInsurance() {
    Integer invalidPolicyId = 999999;
    IInsurance insurance = new Insurance();
    assertFalse("Invalid Insurance retrieved",
        insurancePersistence
            .getInsurance(invalidPolicyId, insurance, connection));
  }

  /**
   * updateInsurance method returns false if unable to update
   * insurance record
   */
  @Test
  public void testUpdateInsurance() {
    Integer policyId = 1;
    IInsurance insurance = new Insurance();
    insurance.load(policyId, connection, insurancePersistence, dateComparator);
    String newDescription = "Super insurance to defeat corona";
    insurance.setDescription(newDescription);
    assertTrue("Unable to update insurance in the database",
        insurancePersistence.updateInsurance(insurance, connection));
  }

  /**
   * getAllInsurances method returns null if any error occurs
   * while fetching insurance data
   */
  @Test
  public void testGetAllInsurances() {
    assertNotNull("Unable to retrieve insurances",
        insurancePersistence.getAllInsurances(connection));
  }
}