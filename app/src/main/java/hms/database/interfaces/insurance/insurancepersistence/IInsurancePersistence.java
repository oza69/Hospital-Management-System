/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains interface for InsurancePersistence class which
 * handles various operations for INSURANCE table in database
 */
package hms.database.interfaces.insurance.insurancepersistence;

import hms.models.interfaces.insurance.insurance.IInsurance;
import java.sql.Connection;
import java.util.Map;

public interface IInsurancePersistence {

  /**
   * This method helps to insert record in insurance table
   * @param insurance Case object to store in table
   * @param connection Connection object to handle database connection
   * @return True if data is stored successfully into insurance table
   */
  boolean saveInsurance(IInsurance insurance, Connection connection);

  /**
   * This method helps to get insurance policy from the Insurance table
   * @param policyID Id of the insurance policy
   * @param insurance Blank insurance object to store retrieved insurance data
   * @param connection Connection object to handle database connection
   * @return True if insurance policy found in the database
   */
  Boolean getInsurance(Integer policyID, IInsurance insurance,
      Connection connection);

  /**
   * This method helps to update record Insurance table
   * @param insurance Insurance object to update in table
   * @param connection Connection object to handle database connection
   * @return True if data is updated successfully in Insurance table
   */
  boolean updateInsurance(IInsurance insurance, Connection connection);

  /**
   * This method helps to get insurance all policies from the Insurance table
   * @param connection Connection object to handle database connection
   * @return Map containing insurance id as key and Insurance object as value
   */
  Map<Integer, IInsurance> getAllInsurances(Connection connection);
}