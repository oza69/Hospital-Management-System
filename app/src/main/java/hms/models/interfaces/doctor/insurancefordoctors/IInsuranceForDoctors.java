/**
 * @author Vishvesh Bharatbhai Naik
 * @description Insurance For Doctors will set the policy for doctor
 * who are working for highly contagious disease
 */
package hms.models.interfaces.doctor.insurancefordoctors;

import java.sql.Connection;

public interface IInsuranceForDoctors {

  /**
   * This method will set the policy to those doctors who are eligible
   * @param connection connection object for the database
   * @return true if it goes into the try block or false
   */
  boolean setPolicyForDoctors(Connection connection);
}