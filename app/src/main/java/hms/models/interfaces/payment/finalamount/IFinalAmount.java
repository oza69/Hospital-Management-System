/**
 * @author Vishvesh Bharatbhai Naik
 * @description Final amount to calculate to put the final amount and verify
 * insurance policy into the payment table
 */
package hms.models.interfaces.payment.finalamount;

import java.sql.SQLException;

public interface IFinalAmount {

  /**
   * Interface for Payment Class's finalAmount
   * @param patientId will take Patient id as an argument
   * @return Calculates the finalAmount and sets the final into the database.
   */
  double finalAmount(int patientId) throws SQLException;

  /**
   * Interface for Payment Class's verifyPolicy
   * @param policyId will take Policy id as an argument
   * @return A boolean which checks if the policy date is not expired.
   * @throws SQLException SQL error will be handled here
   */
  boolean verifyPolicy(int policyId) throws SQLException;
}