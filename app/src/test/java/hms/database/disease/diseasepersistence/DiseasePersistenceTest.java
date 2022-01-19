/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains test cases for DiseasePersistence class
 */
package hms.database.disease.diseasepersistence;

import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import hms.database.classes.disease.diseasepersistence.DiseasePersistence;
import hms.database.interfaces.disease.diseasepersistence.IDiseasePersistence;
import hms.models.classes.disease.disease.Disease;
import hms.models.classes.disease.zerotoonescale.ZeroToOneScale;
import hms.models.interfaces.disease.disease.IDisease;
import hms.models.interfaces.disease.zerotoonescale.IZeroToOneScale;
import org.junit.Test;
import java.sql.Connection;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DiseasePersistenceTest {

  ConnectorDao connector = new Connector();
  Connection connection = connector.getConnection();
  String diseaseName = "Corona alpha";
  String diseaseDescription =
      "Corona alpha is super spreading virus from COVID-19 family.";
  Double fatalityFactor = 0.7;
  Double contagiousFactor = 0.8;
  IDiseasePersistence diseasePersistence = new DiseasePersistence();
  IZeroToOneScale factorChecker = new ZeroToOneScale();

  /* saveDisease method returns false if unable to insert disease record */
  @Test
  public void testSaveDisease() {
    IDisease corona =
        new Disease(diseaseName, diseaseDescription, fatalityFactor,
            contagiousFactor);
    assertTrue("Disease unable to save in the database",
        diseasePersistence.saveDisease(corona, connection));
  }

  /* saveDisease method returns true for upper boundary of risk factors */
  @Test
  public void testSaveDiseaseUpperBoundary() {
    Double newFatalityRiskFactor = 1.0;
    Double newContagiousRiskFactor = 1.0;
    IDisease corona =
        new Disease(diseaseName, diseaseDescription, newFatalityRiskFactor,
            newContagiousRiskFactor);
    assertTrue("Disease unable to save in the database",
        diseasePersistence.saveDisease(corona, connection));
  }

  /* saveDisease method returns true for lower boundary of risk factors */
  @Test
  public void testSaveDiseaseLowerBoundary() {
    Double newFatalityRiskFactor = 0.0;
    Double newContagiousRiskFactor = 0.0;
    IDisease corona =
        new Disease(diseaseName, diseaseDescription, newFatalityRiskFactor,
            newContagiousRiskFactor);
    assertTrue("Disease unable to save in the database",
        diseasePersistence.saveDisease(corona, connection));
  }

  /**
   * getDisease method returns false if any error occurs while fetching
   * disease data
   */
  @Test
  public void testGetDisease() {
    Integer diseaseId = 1;
    IDisease disease = new Disease();
    assertTrue("Disease can not be retrieved",
        diseasePersistence.getDisease(diseaseId, disease, connection));
  }

  /* getDisease method returns false if invalid disease id passed */
  @Test
  public void testGetNonExistentDisease() {
    Integer diseaseId = 999999;
    IDisease disease = new Disease();
    assertFalse("Disease retrieved",
        diseasePersistence.getDisease(diseaseId, disease, connection));
  }

  /* updateDisease method returns false if unable to update disease record */
  @Test
  public void testUpdateDisease() {
    Integer diseaseId = 1;
    IDisease disease = new Disease();
    disease.load(diseaseId, connection, diseasePersistence, factorChecker);
    String newName = "Corona Alpha";
    disease.setName(newName);
    assertTrue("Unable to update disease in the database",
        diseasePersistence.updateDisease(disease, connection));
  }

  /**
   * getAllDiseases method returns null if any error occurs
   * while fetching disease records
   */
  @Test
  public void testGetAllDiseases() {
    assertNotNull("Diseases can not be retrieved",
        diseasePersistence.getAllDiseases(connection));
  }
}