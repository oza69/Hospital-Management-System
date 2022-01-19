/**
 * @author Vishvesh Bharatbhai Naik
 * @description Insurance for doctors will get the doctors who are working on
 * highly contagious disease and enrol them into policy
 */
package hms.database.interfaces.insurance.insurancefordoctors;

import java.sql.Connection;
import java.sql.ResultSet;

public interface IInsuranceForDoctorsPersistence {

  /**
   * This method gets the doctors who are eligible and are working highly
   * contagious disease.
   * @param connection connection object for the database
   * @return ResultSet that will provide all the doctors who are eligible
   */
  ResultSet getDoctorList (Connection connection);

  /**
   * This methods put the the insurance into the doctors.
   * @param doctorId taken as an parameter to set policy for doctors.
   * @param connection connection object for the database
   * @return true if it goes into the try block or false
   */
  boolean setDoctorInsurance(int doctorId, Connection connection);
}
