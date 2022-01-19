/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains test cases for Disease class
 */
package hms.models.disease.disease;

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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DiseaseTest {

  ConnectorDao connector = new Connector();
  Connection connection = connector.getConnection();
  String diseaseName = "Corona";
  String diseaseDescription =
      "Corona is super spreading virus from COVID-19 family.";
  Double fatalityFactor = 0.7;
  Double contagiousFactor = 0.8;
  IZeroToOneScale factorChecker = new ZeroToOneScale();
  IDisease corona = new Disease(diseaseName, diseaseDescription, fatalityFactor,
      contagiousFactor);

  /**
   * getContagiousRiskFactor method returns the contagious risk factor for
   * the disease
   */
  @Test
  public void testGetContagiousRiskFactor() {
    assertNotNull("Contagious risk factor is NULL",
        corona.getContagiousRiskFactor());
  }

  /* getDescription method returns the description for the disease */
  @Test
  public void testGetDescription() {
    assertNotNull("Disease description is NULL", corona.getDescription());
  }

  /**
   * getFatalityRiskFactor method returns the fatality risk factor for the
   * disease
   */
  @Test
  public void testGetFatalityRiskFactor() {
    assertNotNull("Fatality risk factor is NULL",
        corona.getFatalityRiskFactor());
  }

  /* getId method returns the id for the disease */
  @Test
  public void testGetId() {
    Integer id = 1;
    corona.setId(id);
    assertEquals("Unable to get Disease id", id, corona.getId());
  }

  /* getName method returns the name for the disease */
  @Test
  public void testGetName() {
    assertNotNull("Disease name is NULL", corona.getName());
  }

  /**
   * setContagiousRiskFactor method sets new contagious risk factor for the
   * disease
   */
  @Test
  public void testSetContagiousRiskFactor() {
    Double newContagiousRiskFactor = 0.8;
    corona.setContagiousRiskFactor(newContagiousRiskFactor);
    assertEquals("Contagious risk factor is not updated",
        newContagiousRiskFactor, corona.getContagiousRiskFactor());
  }

  /* setDescription method sets new description for the disease */
  @Test
  public void testSetDescription() {
    String newDescription =
        "Corona Delta is now the most super-spreader version of corona.";
    corona.setDescription(newDescription);
    assertEquals("Description is not updated", newDescription,
        corona.getDescription());
  }

  /**
   * setFatalityRiskFactor method sets new fatality risk factor for the
   * disease
   */
  @Test
  public void testSetFatalityRiskFactor() {
    Double newFatalityRiskFactor = 0.8;
    corona.setFatalityRiskFactor(newFatalityRiskFactor);
    assertEquals("Fatality risk factor is not updated", newFatalityRiskFactor,
        corona.getFatalityRiskFactor());
  }

  /* setId method sets new id for the disease */
  @Test
  public void testSetId() {
    Integer newId = 2;
    corona.setId(newId);
    assertEquals("Id is not updated", newId, corona.getId());
  }

  /* setName method sets new name for the disease */
  @Test
  public void testSetName() {
    String newName = "Corona Delta";
    corona.setName(newName);
    assertEquals("Name is not updated", newName, corona.getName());
  }

  /* isValid method returns true if disease has valid parameters */
  @Test
  public void testIsValidTrue() {
    assertTrue("Disease parameters are not valid",
        corona.isValid(factorChecker));
  }

  /* isValid method returns false if disease has invalid parameters */
  @Test
  public void testIsValidFalse() {
    Double newContagiousRiskFactor = 1.2;
    corona.setContagiousRiskFactor(newContagiousRiskFactor);
    assertFalse("Disease parameters are correct",
        corona.isValid(factorChecker));
  }

  /* save method returns true if disease object stored to database successfully */
  @Test
  public void testSave() {
    IDiseasePersistence diseasePersistence = new DiseasePersistence();
    assertTrue("Unable to save disease in the disease table",
        corona.save(connection, diseasePersistence, factorChecker));
  }

  /**
   * load method returns true if disease object loaded from the database
   * successfully
   */
  @Test
  public void testLoad() {
    Integer diseaseId = 1;
    IDisease disease = new Disease();
    IDiseasePersistence diseasePersistence = new DiseasePersistence();
    assertTrue("Unable to load disease from the disease table",
        disease.load(diseaseId, connection, diseasePersistence, factorChecker));
  }

  /* load method returns false if no disease object found in the database */
  @Test
  public void testLoadNonExistentDisease() {
    Integer diseaseId = 99999;
    IDisease disease = new Disease();
    IDiseasePersistence diseasePersistence = new DiseasePersistence();
    assertFalse("Disease loaded from the disease table",
        disease.load(diseaseId, connection, diseasePersistence, factorChecker));
  }

  /**
   * update method returns true if disease object updated in database
   * successfully
   */
  @Test
  public void testUpdate() {
    Integer diseaseId = 1;
    String newName = "Corona delta variant";
    IDisease disease = new Disease();
    IDiseasePersistence diseasePersistence = new DiseasePersistence();
    disease.load(diseaseId, connection, diseasePersistence, factorChecker);
    disease.setName(newName);
    assertTrue("Unable to update disease in the disease table",
        disease.update(connection, diseasePersistence, factorChecker));
  }
}