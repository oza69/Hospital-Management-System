/**
 * @author Vishvesh Bharatbhai Naik
 * @description Insurance For Doctors will set the policy for doctor
 * who are working for highly contagious disease
 */
package hms.models.classes.doctor.insurancefordoctors;

import hms.database.classes.insurance.insurancefordoctors.InsuranceForDoctorsPersistence;
import hms.database.interfaces.insurance.insurancefordoctors.IInsuranceForDoctorsPersistence;
import hms.models.interfaces.doctor.insurancefordoctors.IInsuranceForDoctors;

import java.sql.Connection;
import java.sql.ResultSet;

public class InsuranceForDoctors implements IInsuranceForDoctors {

  IInsuranceForDoctorsPersistence insurance =
      new InsuranceForDoctorsPersistence();

  @Override
  public boolean setPolicyForDoctors(Connection connection) {
    try {
      ResultSet rs = insurance.getDoctorList(connection);
      while (rs.next()) {
        int doctorId = rs.getInt("doctor_id");
        insurance.setDoctorInsurance(doctorId, connection);
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}