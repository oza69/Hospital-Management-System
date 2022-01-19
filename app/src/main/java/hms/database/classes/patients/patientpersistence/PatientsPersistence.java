/**
 * @author Vishvesh Bharatbhai Naik
 * @description Patient Persistence will insert, update, view from patient view
 */
package hms.database.classes.patients.patientpersistence;

import hms.database.interfaces.patients.patientpersistence.IPatientsPersistence;
import hms.models.interfaces.patients.patients.IPatients;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static hms.constants.CallableStatements.*;

public class PatientsPersistence implements IPatientsPersistence {

  @Override
  public boolean savePatient(IPatients iPatients, Connection connection) {
    try {
      PreparedStatement statement = connection.prepareStatement(INSERT_PATIENT);
      statement.setInt(1, iPatients.getAssignedDoctorId());
      statement.setString(2, iPatients.getPatientFullName());
      statement.setString(3, iPatients.getAddressName());
      statement.setString(4, iPatients.getGenderName());
      statement.setInt(5, iPatients.getAgeNo());
      statement.setString(6, iPatients.getBloodGroup());
      statement.setDate(7, Date.valueOf(iPatients.getArrivalDate()));
      statement.setInt(8, iPatients.getContactNo());
      statement.setString(9, iPatients.getDiseaseName());
      statement.setString(10, iPatients.getbPLInfo());
      statement.setDouble(11, iPatients.getAnnualIncome());
      statement.setInt(12, iPatients.getFeedbackNo());
      statement.setInt(13, iPatients.getPolicyId());
      statement.setString(14, iPatients.getGovernmentScheme());
      statement.setInt(15, iPatients.getPackageId());
      statement.executeUpdate();
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public ResultSet getAllPatients(Connection connection) {
    try {
      PreparedStatement statement = connection.prepareCall(SELECT_ALL_PATIENTS);
      return statement.executeQuery();
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public ResultSet viewPatient(int patientId, Connection connection) {
    try {
      PreparedStatement statement = connection.prepareCall(SELECT_PATIENT_ID);
      statement.setInt(1, patientId);
      return statement.executeQuery();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean updatePatient(int patientId, int assignedDoctorId,
                               String patientFullName, String addressName,
                               String genderName, int ageNo,
                               String bloodGroup, String arrivalDate,
                               int contactNo, String diseaseName,
                               String bPLInfo, Double annualIncome,
                               int feedbackNo, int policyId,
                               String governmentScheme, int packageId,
                               Connection connection) {
    try {
      PreparedStatement statement = connection.prepareStatement(UPDATE_PATIENT);
      statement.setInt(1, patientId);
      statement.setInt(2, assignedDoctorId);
      statement.setString(3, patientFullName);
      statement.setString(4, addressName);
      statement.setString(5, genderName);
      statement.setInt(6, ageNo);
      statement.setString(7, bloodGroup);
      statement.setDate(8, Date.valueOf(arrivalDate));
      statement.setInt(9, contactNo);
      statement.setString(10, diseaseName);
      statement.setString(11, bPLInfo);
      statement.setDouble(12, annualIncome);
      statement.setInt(13, feedbackNo);
      statement.setInt(14, policyId);
      statement.setString(15, governmentScheme);
      statement.setInt(16, packageId);
      statement.executeUpdate();
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
