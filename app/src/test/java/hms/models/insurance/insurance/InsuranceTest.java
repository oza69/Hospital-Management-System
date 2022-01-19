/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains test cases for Insurance class
 */
package hms.models.insurance.insurance;

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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InsuranceTest {

  ConnectorDao connector = new Connector();
  Connection connection = connector.getConnection();
  IDateComparator dateComparator = new DateComparator();
  String name = "Deluxe policy";
  String description = "Covers handsome amount of insurance.";
  Integer amount = 3000;
  String startDate = "2020-01-01";
  String endDate = "2021-01-01";
  Integer policyType = 0;
  IInsurance newPolicy =
      new Insurance(name, description, amount, startDate, endDate, policyType);
  IInsurancePersistence insurancePersistence = new InsurancePersistence();

  /* getName method returns the insurance policy id */
  @Test
  public void testGetPolicyId() {
    Integer policyId = 1;
    newPolicy.setPolicyId(policyId);
    assertEquals("Policy id is not valid", policyId, newPolicy.getPolicyId());
  }

  /* setName method sets the insurance policy name */
  @Test
  public void testSetPolicyId() {
    Integer policyId = 2;
    newPolicy.setPolicyId(policyId);
    assertEquals("Unable to set new policy id", policyId,
        newPolicy.getPolicyId());
  }

  /* getName method returns the insurance policy name */
  @Test
  public void testGetName() {
    assertEquals("Policy name is not valid", name, newPolicy.getName());
  }

  /* setName method sets the insurance policy name */
  @Test
  public void testSetName() {
    String newName = "Freedom package";
    newPolicy.setName(newName);
    assertEquals("Unable to set policy name", newName, newPolicy.getName());
  }

  /* getDescription method returns the insurance policy description */
  @Test
  public void testGetDescription() {
    assertEquals("Policy description is not valid", description,
        newPolicy.getDescription());
  }

  /* setDescription method sets the insurance policy description */
  @Test
  public void testSetDescription() {
    String newDescription = "Freedom package is great for all.";
    newPolicy.setDescription(newDescription);
    assertEquals("Unable to set policy description", newDescription,
        newPolicy.getDescription());
  }

  /* getAmountCovered method returns the insurance policy amount */
  @Test
  public void testGetAmountCovered() {
    assertEquals("Policy amount is not valid", amount,
        newPolicy.getAmountCovered());
  }

  /* setAmountCovered method sets the insurance policy amount */
  @Test
  public void testSetAmountCovered() {
    Integer newAmount = 3500;
    newPolicy.setAmountCovered(newAmount);
    assertEquals("Unable to set policy amount", newAmount,
        newPolicy.getAmountCovered());
  }

  /* getStartDate method returns the insurance policy start date */
  @Test
  public void testGetStartDate() {
    assertEquals("Policy start date is not valid", startDate,
        newPolicy.getStartDate());
  }

  /* setStartDate method sets the insurance policy start date */
  @Test
  public void testSetStartDate() {
    String newStartDate = "2019-01-01";
    newPolicy.setStartDate(newStartDate);
    assertEquals("Unable to set policy start date", newStartDate,
        newPolicy.getStartDate());
  }

  /* getEndDate method returns the insurance policy end date */
  @Test
  public void testGetEndDate() {
    assertEquals("Policy end date is not valid", endDate,
        newPolicy.getEndDate());
  }

  /* setEndDate method sets the insurance policy end date */
  @Test
  public void testSetEndDate() {
    String newEndDate = "2022-01-01";
    newPolicy.setEndDate(newEndDate);
    assertEquals("Unable to set policy end date", newEndDate,
        newPolicy.getEndDate());
  }

  /* getPolicyType method returns the insurance policy type */
  @Test
  public void testGetPolicyType() {
    assertEquals("Policy type is not valid", policyType,
        newPolicy.getPolicyType());
  }

  /* setEndDate method sets the insurance policy end date */
  @Test
  public void testSetPolicyType() {
    Integer newType = 1;
    newPolicy.setPolicyType(newType);
    assertEquals("Unable to set policy type", newType,
        newPolicy.getPolicyType());
  }

  /* isValid method returns true if the insurance object is valid */
  @Test
  public void testIsValid() {
    IDateComparator dateComparator = new DateComparator();
    assertTrue("Insurance policy is not valid",
        newPolicy.isValid(dateComparator));
  }

  /**
   * save method returns true if insurance object stored to database
   * successfully
   */
  @Test
  public void testSave() {
    assertTrue("Unable to save insurance in the insurance table",
        newPolicy.save(connection, insurancePersistence, dateComparator));
  }

  /**
   * load method returns true if insurance object loaded from the database
   * successfully
   */
  @Test
  public void testLoad() {
    Integer policyId = 1;
    IInsurance insurance = new Insurance();
    assertTrue("Unable to load insurance from the insurance table",
        insurance
            .load(policyId, connection, insurancePersistence, dateComparator));
  }

  /* load method returns false if no insurance object found in the database */
  @Test
  public void testLoadNonExistentInsurance() {
    Integer policyId = 99999;
    IInsurance insurance = new Insurance();
    assertFalse("Invalid insurance loaded from the insurance table",
        insurance
            .load(policyId, connection, insurancePersistence, dateComparator));
  }

  /**
   * update method returns true if insurance object updated in database
   * successfully
   */
  @Test
  public void testUpdate() {
    Integer policyId = 1;
    String newName = "CORONA HELP POLICY";
    IInsurance insurance = new Insurance();
    insurance.load(policyId, connection, insurancePersistence, dateComparator);
    insurance.setName(newName);
    assertTrue("Unable to update insurance in the insurance table",
        insurance.update(connection, insurancePersistence, dateComparator));
  }
}