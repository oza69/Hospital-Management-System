/**
 * @author Vishvesh Bharatbhai Naik
 * @description Insurance for doctors will get the doctors who are working on
 * highly contagious disease and enrol them into policy
 */
package hms.database.classes.insurance.insurancefordoctors;

import hms.database.interfaces.insurance.insurancefordoctors
    .IInsuranceForDoctorsPersistence;

import static hms.constants.CallableStatements.SELECT_GET_RISK_DOCTORS;
import static hms.constants.CallableStatements.SELECT_DOCTOR_INSURANCE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InsuranceForDoctorsPersistence implements
    IInsuranceForDoctorsPersistence {

  @Override
  public ResultSet getDoctorList(Connection connection) {
    try {
      PreparedStatement statement = connection
          .prepareStatement(SELECT_GET_RISK_DOCTORS);
      return statement.executeQuery();
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public boolean setDoctorInsurance(int doctorId, Connection connection) {
    try {
      PreparedStatement statement = connection
          .prepareStatement(SELECT_DOCTOR_INSURANCE);
      statement.setInt(1, doctorId);
      statement.executeQuery();
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
