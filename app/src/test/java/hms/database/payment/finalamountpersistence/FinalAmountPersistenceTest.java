/**
 * @author Vishvesh Bharatbhai Naik
 * @description This file tests all the methods present in final amount
 * Persistence which check the data connectivity with database.
 */
package hms.database.payment.finalamountpersistence;

import hms.database.classes.payment.fianlamountpersistence.FinalAmountPersistence;
import hms.database.interfaces.payment.finalamountpersistence.IFinalAmountPersistence;

import static org.junit.Assert.*;

import org.junit.Test;

import java.sql.SQLException;

/**
 * Creating PaymentPersistenceTest class to run test cases
 */
public class FinalAmountPersistenceTest {

  int patientId = 3;
  int policyId = 1;
  int paymentId = 1;
  IFinalAmountPersistence paymentPersistence = new FinalAmountPersistence();

  /**
   * Testing if the age is getting fetched from Database
   */
  @Test
  public void testGetAge() {
    assertTrue("Age doesn't match",
        paymentPersistence.getAge(patientId) >= 0);
  }

  /**
   * Testing if the policyId is getting fetched from Database
   */
  @Test
  public void testGetPolicyId() {
    assertTrue("Policy Id doesn't match",
        paymentPersistence.getPolicyId(patientId) >= 0);
  }

  /**
   * Testing if the policyEndDate is getting fetched from Database
   * @throws SQLException SQL error will be handled here
   */
  @Test
  public void testGetPolicyEndDate() throws SQLException {
    assertNotNull("Data not Retrieved",
        paymentPersistence.getPolicyEndDate(policyId));
  }

  /**
   * Testing if the Amount is getting fetched from Database
   */
  @Test
  public void testGetAmount() {
    assertTrue("Policy Id doesn't match",
        paymentPersistence.getAmount(patientId) >= 0);
  }

  /**
   * Testing if the Insurance Amount is getting fetched from Database
   */
  @Test
  public void testGetInsuranceAmount() {
    assertTrue("Policy Id doesn't match",
        paymentPersistence.getInsuranceAmount(policyId) >= 0);
  }

  /**
   * Testing if the ViewPayment is getting fetched from Database
   */
  @Test
  public void testViewPayment() {
    assertNotNull("ViewPayment is null",
        paymentPersistence.viewPayment(paymentId));
  }
}