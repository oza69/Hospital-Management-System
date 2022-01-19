/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains test cases for Cases class
 */
package hms.models.cases.cases;

import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import hms.database.classes.cases.casepersistence.CasePersistence;
import hms.database.interfaces.cases.casepersistence.ICasePersistence;
import hms.models.classes.cases.cases.Cases;
import hms.models.classes.disease.zerotoonescale.ZeroToOneScale;
import hms.models.interfaces.cases.cases.ICases;
import hms.models.interfaces.disease.zerotoonescale.IZeroToOneScale;
import org.junit.Test;
import java.sql.Connection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CasesTest {

  ConnectorDao connector = new Connector();
  Connection connection = connector.getConnection();
  int patientId = 1;
  int assignedDoctorId = 1;
  String description = "Having minor symptoms of corona virus.";
  int diseaseId = 3;
  Double feedback = 0.5;
  int referenceId = 1;
  int policyId = 1;
  int amount = 100;
  String date = "2021-01-01";
  IZeroToOneScale factorChecker = new ZeroToOneScale();
  ICases myCase =
      new Cases(patientId, assignedDoctorId, description, diseaseId, feedback,
          referenceId, policyId, amount, date);

  /* getCaseId method returns the Case ID */
  @Test
  public void testGetCaseId() {
    int caseId = 1;
    myCase.setCaseId(caseId);
    assertEquals("Case id is not valid", caseId, myCase.getCaseId());
  }

  /* getAmount method returns the Case amount */
  @Test
  public void testGetAmount() {
    assertTrue("Amount is not valid", myCase.getAmount() >= 0);
  }

  /* getAssignedDoctorId method returns the doctor id */
  @Test
  public void testGetAssignedDoctorId() {
    assertTrue("Doctor id is not valid",myCase.getAssignedDoctorId() >= 0);
  }

  /* getDate method returns the Case date */
  @Test
  public void testGetDate() {
    assertNotNull("Date is NULL", myCase.getDate());
  }

  /* getDescription method returns the Case description */
  @Test
  public void testGetDescription() {
    assertNotNull("Description is NULL", myCase.getDescription());
  }

  /* getDiseaseId method returns the disease id for case */
  @Test
  public void testGetDiseaseId() {
    assertTrue("Disease id is not valid", myCase.getDiseaseId() > 0);
  }

  /* getFeedback method returns the Case feedback */
  @Test
  public void testGetFeedback() {
    assertNotNull("Feedback is NULL", myCase.getFeedback());
  }

  /* getPatientId method returns the patient id for case */
  @Test
  public void testGetPatientId() {
    assertTrue("Patient id is not valid", myCase.getPatientId() > 0);
  }

  /* getPolicyId method returns the policy id for patient if any */
  @Test
  public void testGetPolicyId() {
    myCase.setPolicyId(1);
    assertTrue("Policy id is not valid", myCase.getPolicyId() > 0);
  }

  /* getReferenceId method returns the reference id of doctor if available */
  @Test
  public void testGetReferenceId() {
    myCase.setReferenceId(1);
    assertTrue("Reference id is not valid", myCase.getReferenceId() > 0);
  }

  /* isValid method returns true if all required parameters are set */
  @Test
  public void testIsValid() {
    assertTrue("Not valid case", myCase.isValid(factorChecker));
  }

  /* setAmount method sets the Case amount */
  @Test
  public void testSetAmount() {
    int newAmount = 150;
    myCase.setAmount(newAmount);
    assertEquals("Amount not updated", newAmount, myCase.getAmount());
  }

  /* setAssignedDoctorId method sets the doctor id for the case */
  @Test
  public void testSetAssignedDoctorId() {
    int newID = 2;
    myCase.setAssignedDoctorId(newID);
    assertEquals("Doctor id not updated", newID, myCase.getAssignedDoctorId());
  }

  /* setCaseId method sets the Case ID */
  @Test
  public void testSetCaseId() {
    int newCaseId = 2;
    myCase.setCaseId(newCaseId);
    assertEquals("Case not updated", newCaseId, myCase.getCaseId());
  }

  /* setDate method sets the Case date */
  @Test
  public void testSetDate() {
    String newDate = "2021/01/02";
    myCase.setDate(newDate);
    assertEquals("Date not updated", newDate, myCase.getDate());
  }

  /* setDescription method sets the Case description */
  @Test
  public void testSetDescription() {
    String newDescription = "Having major symptoms of corona virus";
    myCase.setDescription(newDescription);
    assertEquals("Description not updated", newDescription,
        myCase.getDescription());
  }

  /* setDiseaseId method sets the disease id for case */
  @Test
  public void testSetDiseaseId() {
    String newDescription = "Having major symptoms of corona virus";
    myCase.setDescription(newDescription);
    assertEquals("Description not updated", newDescription,
        myCase.getDescription());
  }

  /* setFeedback method sets the Case feedback */
  @Test
  public void testSetFeedback() {
    Double newFeedback = 0.6;
    myCase.setFeedback(newFeedback);
    assertEquals("Feedback not updated", newFeedback, myCase.getFeedback());
  }

  /* setPatientId method sets the patient id for case */
  @Test
  public void testSetPatientId() {
    int newPatientID = 2;
    myCase.setPatientId(newPatientID);
    assertEquals("Patient id not updated", newPatientID, myCase.getPatientId());
  }

  /* setPolicyId method sets the policy id for the case */
  @Test
  public void testSetPolicyId() {
    int newPolicyID = 2;
    myCase.setPolicyId(newPolicyID);
    assertEquals("Policy id not updated", newPolicyID, myCase.getPolicyId());
  }

  /* setReferenceId method sets the reference id of doctor if any */
  @Test
  public void testSetReferenceId() {
    int newReferenceID = 2;
    myCase.setReferenceId(newReferenceID);
    assertEquals("Policy id not updated", newReferenceID,
        myCase.getReferenceId());
  }

  /* save method returns true if case object stored to database successfully */
  @Test
  public void testSave() {
    ICasePersistence casePersistence = new CasePersistence();
    assertTrue("Unable to save case in the CASES table",
        myCase.save(connection, casePersistence, factorChecker));
  }

  /* load method returns true if case object loaded from the database successfully */
  @Test
  public void testLoad() {
    Integer caseId = 1;
    ICases iCases = new Cases();
    ICasePersistence casePersistence = new CasePersistence();
    assertTrue("Unable to load case from the CASES table",
        iCases.load(caseId, connection, casePersistence, factorChecker));
  }

  /* load method returns false if no case object found in the database */
  @Test
  public void testLoadNonExistentCase() {
    Integer caseId = 99999;
    ICases iCases = new Cases();
    ICasePersistence casePersistence = new CasePersistence();
    assertFalse("Case loaded from the CASES table",
        iCases.load(caseId, connection, casePersistence, factorChecker));
  }

  /* update method returns true if case object updated in database successfully */
  @Test
  public void testUpdate() {
    Integer caseId = 1;
    String newDescription = "Emergency";
    ICases iCases = new Cases();
    ICasePersistence casePersistence = new CasePersistence();
    iCases.load(caseId, connection, casePersistence, factorChecker);
    iCases.setDescription(newDescription);
    assertTrue("Unable to update case in the CASES table",
        iCases.update(connection, casePersistence, factorChecker));
  }
}