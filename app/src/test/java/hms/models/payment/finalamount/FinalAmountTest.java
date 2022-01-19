/**
 * @author Vishvesh Bharatbhai Naik
 * @description Final Amount Class Test cases
 */
package hms.models.payment.finalamount;

import hms.models.classes.payment.finalamount.FinalAmount;
import hms.models.interfaces.payment.finalamount.IFinalAmount;

import static org.junit.Assert.*;

import org.junit.Test;

import java.sql.SQLException;

public class FinalAmountTest {

  public static final int patientId = 3;
  public static final int policyId = 1;
  IFinalAmount payment = new FinalAmount();

  /**
   * Testing if the final amount which is getting fetched and
   * calculated are the same.
   */
  @Test
  public void testFinalAmount() throws SQLException {
    assertTrue("Final Amount Failed",
        payment.finalAmount(patientId) >= 0);
  }

  /**
   * Testing if the Policy is valid or not.
   * @throws SQLException SQL error will be handled here
   */
  @Test
  public void testVerifyPolicy() throws SQLException {
    assertTrue("Verify Policy Failed",
        payment.verifyPolicy(policyId));
  }
}