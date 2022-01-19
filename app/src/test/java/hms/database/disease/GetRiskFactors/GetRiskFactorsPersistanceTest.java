/**
 * @author Eklavya Nautiyal
 * @description GetRiskFactorsPersistanceTest class to run test cases
 */
package hms.database.disease.GetRiskFactors;

import hms.configuration.Connector;
import hms.database.classes.disease.riskfactors.GetRiskFactorsPersistence;
import org.junit.Test;
import hms.database.interfaces.disease.getriskfactor.IGetRiskFactorsPersistence;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class GetRiskFactorsPersistanceTest {

  /**
   * Initializing common variables and objects
   */
  private Connector connector = new Connector();
  private int diseaseId = 1;
  IGetRiskFactorsPersistence rf = new GetRiskFactorsPersistence(connector);

  @Test
  public void setDiseaseIdTest() {
    rf.setDiseaseID(diseaseId);
    assertEquals(diseaseId, rf.getDiseaseID());
  }

  @Test
  public void getDiseaseTest() {
    assertEquals(0, rf.getDiseaseID());
  }

  /**
   * This test will check if the values are being fetched form Database or not
   * @throws SQLException SQL error will be handled here
   */
  @Test
  public void getRiskFactorTest() throws SQLException {
    rf.setDiseaseID(diseaseId);
    List<Double> rsArr = rf.getRiskFactor();
    assertNotNull("Disease ID does not exist", rsArr);
  }
}