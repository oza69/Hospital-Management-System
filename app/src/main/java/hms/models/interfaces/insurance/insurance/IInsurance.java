/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains Insurance interface which will help to
 * implement Insurance class
 */
package hms.models.interfaces.insurance.insurance;

import hms.database.interfaces.insurance.insurancepersistence.IInsurancePersistence;
import hms.models.interfaces.disease.datacomparator.IDateComparator;
import java.sql.Connection;

public interface IInsurance {

  /**
   * This method is helpful to get insurance policy id
   * @return Policy id
   */
  Integer getPolicyId();

  /**
   * This method is helpful to set insurance policy type
   * @param policyId Policy id of the insurance
   */
  void setPolicyId(Integer policyId);

  /**
   * This method is helpful to get insurance policy name
   * @return Policy name
   */
  String getName();

  /**
   * This method sets insurance policy name
   * @param name Policy name
   */
  void setName(String name);

  /**
   * This method is helpful to get insurance policy description
   * @return Policy description
   */
  String getDescription();

  /**
   * This method sets insurance policy description
   * @param description Policy description
   */
  void setDescription(String description);

  /**
   * This method is helpful to get amount covered under insurance policy
   * @return Amount covered under insurance
   */
  Integer getAmountCovered();

  /**
   * This method is helpful to set amount covered under insurance policy
   * @param amountCovered Amount covered under insurance
   */
  void setAmountCovered(Integer amountCovered);

  /**
   * This method is helpful to get starting date for an insurance policy
   * @return Start date of insurance policy
   */
  String getStartDate();

  /**
   * This method is helpful to set starting date for an insurance policy
   * @param startDate Start date of insurance policy
   */
  void setStartDate(String startDate);

  /**
   * This method is helpful to get ending date for an insurance policy
   * @return End date of insurance policy
   */
  String getEndDate();

  /**
   * This method is helpful to set ending date for an insurance policy
   * @param endDate End date of insurance policy
   */
  void setEndDate(String endDate);

  /**
   * This method is helpful to get insurance policy type
   * @return Policy type, 1 if policy is for doctor else 0 for patients
   */
  Integer getPolicyType();

  /**
   * This method is helpful to set insurance policy type
   * @param type Policy type, 1 if policy is for doctor else 0 for patients
   */
  void setPolicyType(Integer type);

  /**
   * This method validates the insurance object
   * @param dateComparator DateComparator object to compare dates
   * @return True if all variables are valid
   */
  boolean isValid(IDateComparator dateComparator);

  /**
   * This method saves insurance in the database
   * @param connection Connection object to perform sql operations
   * @param insurancePersistence insurancePersistence object to interact with
   * insurance table
   * @return True if insurance saved
   */
  boolean save(Connection connection,
      IInsurancePersistence insurancePersistence,
      IDateComparator dateComparator);

  /**
   * This method loads insurance from the database
   * @param policyId Policy id which is required
   * @param connection Connection object to perform sql operations
   * @param insurancePersistence insuranceComparator object to interact with
   * insurance table
   * @param dateComparator dateComparator to check dates for insurance
   * @return True if insurance loaded
   */
  boolean load(Integer policyId, Connection connection,
      IInsurancePersistence insurancePersistence,
      IDateComparator dateComparator);

  /**
   * This method updates insurance in the database
   * @param connection Connection object to perform sql operations
   * @param insurancePersistence InsurancePersistence object to interact with
   * insurance table
   * @param dateComparator DateComparator to check dates for insurance policy
   * @return True if insurance updated
   */
  boolean update(Connection connection,
      IInsurancePersistence insurancePersistence,
      IDateComparator dateComparator);
}