/**
 * @author Eklavya Nautiyal
 * @description OverAllRiskFactorTest class to run test cases
 */
package hms.models.disease.overallriskfactor;

import hms.models.classes.disease.overallriskfactor.OverAllRiskFactor;
import org.junit.Test;
import hms.models.interfaces.disease.overallriskfactor.IOverallRiskFactor;
import java.sql.SQLException;
import static org.junit.Assert.*;

public class OverAllRiskFactorTest {

  /**
   * Initializing common variables and objects
   */
  private int diseaseId = 1;
  IOverallRiskFactor rf = new OverAllRiskFactor(diseaseId);

  /**
   * getDiseaseId will compare the database value of
   * both database and test case.
   */
  @Test
  public void getDiseaseId() {
    assertEquals(diseaseId, rf.getDiseaseId());
  }

  /**
   * setDiseasesId will compare the set database value of
   * both database and test case
   */
  @Test
  public void setDiseaseId() {
    rf.setDiseaseId(diseaseId);
    assertEquals(diseaseId,rf.getDiseaseId());
  }


  /**
   * setRiskFactor will check if the value that is being fetch is not null.
   * @throws SQLException SQL error will be handled here
   */
  @Test
  public void getRiskfactors() throws SQLException {
    assertNotNull("Db did not return anything", rf.getRiskfactors(diseaseId));
  }


  /**
   * calcOverallRiskFactor() will check if the value
   * that is being fetch is not null.
   * @throws SQLException SQL error will be handled here
   */
  @Test
  public void calcOverallRiskFactor() throws SQLException {
    rf.setDiseaseId(diseaseId);
    assertNotNull("overall risk factor is null",rf.calcOverallRiskFactor());
  }
}