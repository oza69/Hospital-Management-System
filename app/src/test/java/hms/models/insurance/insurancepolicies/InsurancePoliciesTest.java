/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains test cases for InsurancePolicies class
 */
package hms.models.insurance.insurancepolicies;

import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import hms.database.classes.insurance.insurancepersistence.InsurancePersistence;
import hms.database.interfaces.insurance.insurancepersistence.IInsurancePersistence;
import hms.models.classes.insurance.insurancepolicies.InsurancePolicies;
import hms.models.interfaces.insurance.insurancepolicies.IInsurancePolicies;
import org.junit.Test;
import java.sql.Connection;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class InsurancePoliciesTest {

  Integer policyId = 1;
  ConnectorDao connector = new Connector();
  Connection connection = connector.getConnection();
  IInsurancePersistence insurancePersistence = new InsurancePersistence();
  IInsurancePolicies insurancePolicies = new InsurancePolicies();

  /**
   * deductAmount method returns the amount after deduction of insurance
   * amount
   */
  @Test
  public void testDeductAmount() {
    Integer amountAfterDeduction =
        insurancePolicies.deductAmount(1000, policyId, connection);
    assertTrue("Unable to deduct amount", amountAfterDeduction >= 0);
  }

  /* deductAmount method returns null for invalid amount given */
  @Test
  public void testDeductAmountInvalidAmount() {
    Integer amountAfterDeduction =
        insurancePolicies.deductAmount(-1000, policyId, connection);
    assertNull("Unable to deduct invalid amount", amountAfterDeduction);
  }

  /* deductAmount method returns null for invalid policy id given */
  @Test
  public void testDeductAmountInvalidPolicyId() {
    Integer invalidPolicyId = 1000;
    Integer amountAfterDeduction =
        insurancePolicies.deductAmount(1000, invalidPolicyId, connection);
    assertNull("Unable to deduct invalid policyId", amountAfterDeduction);
  }
}