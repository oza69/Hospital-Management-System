/**
 * @author Vishvesh Bharatbhai Naik
 * @description This file tests all the methods present in Patients Persistence
 * which check the data connectivity with database.
 */
package hms.database.patients.patientpersistence;

import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import hms.database.classes.patients.patientpersistence.PatientsPersistence;
import hms.database.interfaces.patients.patientpersistence.IPatientsPersistence;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import hms.models.classes.patients.patients.Patients;
import hms.models.interfaces.patients.patients.IPatients;
import org.junit.Test;

import java.sql.Connection;

public class PatientPersistenceTest {

  int patientId = 4;
  int assignedDoctorId = 1;
  String patientFullName = "Espi Das";
  String addressName = "18 - Anandnagar";
  String genderName = "Male";
  int ageNo = 5;
  String bloodGroup = "A+";
  String arrivalDate = "2021-02-01";
  int contactNo = 955845664;
  String diseaseName = "Corona";
  String bPLInfo = "NA";
  Double annualIncome = 50000.0;
  int feedbackNo = 4;
  int policyId = 1;
  String governmentScheme = "NA";
  int packageId = 0;
  IPatientsPersistence iPatientsPersistence = new PatientsPersistence();
  ConnectorDao connector = new Connector();
  Connection connection = connector.getConnection();

  /**
   * savePatients method returns false if unable to insert patient record
   */
  @Test
  public void testSavePatients() {
    IPatients ageBased = new Patients(assignedDoctorId,
        patientFullName, addressName, genderName, ageNo, bloodGroup,
        arrivalDate, contactNo, diseaseName, bPLInfo, annualIncome,
        feedbackNo, policyId, governmentScheme, packageId);
    assertTrue("Patients unable to save in the database",
        iPatientsPersistence.savePatient(ageBased, connection));
  }

  /**
   * getAllPatients method returns null if any error occurs
   * while fetching patient records
   */
  @Test
  public void testGetAllPatients() {
    assertNotNull("Patients can not be retrieved", iPatientsPersistence
        .getAllPatients(connection));
  }

  /**
   * ViewPatient will fetch all the details by providing the Id
   */
  @Test
  public void testViewPatient() {
    int patientId = 1;
    assertNotNull("View Patient is null",
        iPatientsPersistence.viewPatient(patientId, connection));
  }

  /**
   * UpdatePatient will update the details of the patient by providing Id
   */
  @Test
  public void testUpdatePatient() {
    assertTrue("Unable to update Patient in the database",
        iPatientsPersistence.updatePatient(patientId, assignedDoctorId,
            patientFullName, addressName, genderName, ageNo, bloodGroup,
            arrivalDate, contactNo, diseaseName, bPLInfo, annualIncome,
            feedbackNo, policyId, governmentScheme, packageId, connection));
  }
}
