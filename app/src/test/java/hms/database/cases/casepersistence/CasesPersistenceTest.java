/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains test cases for CasesPersistence class
 */
package hms.database.cases.casepersistence;

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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CasesPersistenceTest {

  ConnectorDao connector = new Connector();
  Connection connection = connector.getConnection();
  int patientId = 1;
  int assignedDoctorId = 1;
  String description = "Having minor symptoms of corona virus.";
  int diseaseId = 3;
  Double feedback = 0.7;
  int referenceId = 1;
  int policyId = 1;
  int amount = 100;
  String date = "2021-01-01";
  ICasePersistence casePersistence = new CasePersistence();
  IZeroToOneScale factorChecker = new ZeroToOneScale();

  /**
   * getAllCases method returns null
   * if any error occurs while fetching case records
   */
  @Test
  public void testGetAllCases() {
    assertNotNull("Cases can not be retrieved",
        casePersistence.getAllCases(connection));
  }

  /**
   * getCase method returns false if any error occurs while fetching case data
   */
  @Test
  public void testGetCase() {
    Integer caseId = 1;
    ICases iCases = new Cases();
    assertTrue("Case can not be retrieved",
        casePersistence.getCase(caseId, iCases, connection));
  }

  /* getCase method returns false if invalid case id passed */
  @Test
  public void testGetNonExistentCase() {
    Integer caseId = 999999;
    ICases iCases = new Cases();
    assertFalse("Non-existing Case retrieved",
        casePersistence.getCase(caseId, iCases, connection));
  }

  /* saveCase method returns false if unable to insert case record */
  @Test
  public void testSaveCase() {
    ICases myCase =
        new Cases(patientId, assignedDoctorId, description, diseaseId, feedback,
            referenceId, policyId, amount, date);
    assertTrue("Case unable to save in the database",
        casePersistence.saveCase(myCase, connection));

  }

  /* updateCase method returns false if unable to update case record */
  @Test
  public void testUpdateCase() {
    Integer caseId = 1;
    ICases iCases = new Cases();
    iCases.load(caseId, connection, casePersistence, factorChecker);
    String newDescription = "Urgent treatment needed";
    iCases.setDescription(newDescription);
    assertTrue("Unable to update case in the database",
        casePersistence.updateCase(iCases, connection));
  }

  /* saveCase method returns false if unable to insert case record */
  @Test
  public void testSaveCaseInvalidFeedback() {
    Double newFeedback = 21.1;
    ICases myCase =
        new Cases(patientId, assignedDoctorId, description, diseaseId,
            newFeedback, referenceId, policyId, amount, date);
    assertFalse("Invalid Case saved in the database",
        casePersistence.saveCase(myCase, connection));
  }
}