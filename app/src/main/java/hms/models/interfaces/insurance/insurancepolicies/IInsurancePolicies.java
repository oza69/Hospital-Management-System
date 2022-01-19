/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains InsurancePolicies interface which will help
 * to implement InsurancePolicies class
 */
package hms.models.interfaces.insurance.insurancepolicies;

import java.sql.Connection;

public interface IInsurancePolicies {

  /**
   * This method calculates new amount after deduction of insurance amount
   * @param currentAmount The current billing amount
   * @param policyId Policy id to get deduction amount
   * @param connection Connection object to perform database operations
   * @return The amount after deduction
   */
  Integer deductAmount(Integer currentAmount, Integer policyId,
      Connection connection);
}