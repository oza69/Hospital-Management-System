/**
 * @author Vishvesh Bharatbhai Naik
 * @description Patient Persistence will insert, update, view from patient view
 */
package hms.database.interfaces.patients.patientpersistence;

import hms.models.interfaces.patients.patients.IPatients;

import java.sql.Connection;
import java.sql.ResultSet;

public interface IPatientsPersistence {

  /**
   * This method helps to insert record in patient table
   * @param iPatients patient object to store in table
   * @param connection Connection object to handle database connection
   * @return True if data is stored successfully into CASES table
   */
  boolean savePatient(IPatients iPatients, Connection connection);

  /**
   * This method helps to retrieve all records in CASES table
   * @param connection Connection object to handle database connection
   * @return ResultSet of data if retrieved successfully from the CASES table,
   * else return null
   */
  ResultSet getAllPatients(Connection connection);

  /**
   * Getting the Patient row by using Patient
   * @param patientId Patient Id
   * @param connection Connection object to handle database connection
   * @return Result set row
   */
  ResultSet viewPatient(int patientId, Connection connection);

  /**
   * This method updates the patients info in the database for a patient id
   * @param patientId Patient Id as input
   * @param assignedDoctorId assigned doctor id
   * @param patientFullName patient full name
   * @param address_Name patient address
   * @param gender_Name Gender name view
   * @param age_no Patient age
   * @param bloodGroup Patient blood group
   * @param arrivalDate Patient's arrival date
   * @param contactNo Patient contact number
   * @param disease_Name Patient disease
   * @param bPLInfo Patient BPL info
   * @param annualIncome Patient annual income
   * @param feedback_No Patient Feedback
   * @param policyId Patient policy id
   * @param governmentScheme Patient government scheme
   * @param packageId Patient package id
   * @param connection connection to the database
   * @return True if it it access the try block and false if otherwise
   */
  boolean updatePatient(int patientId, int assignedDoctorId,
                        String patientFullName, String address_Name,
                        String gender_Name, int age_no, String bloodGroup,
                        String arrivalDate, int contactNo, String disease_Name,
                        String bPLInfo, Double annualIncome, int feedback_No,
                        int policyId, String governmentScheme, int packageId,
                        Connection connection);
}
