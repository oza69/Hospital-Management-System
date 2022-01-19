/**
 * @author Eklavya Nautiyal
 * @description Test class for Expertness Index methods
 */
package hms.models.cases.expertnessindex;

import hms.configuration.Connector;
import hms.models.classes.cases.expertnessindex.ExpertnessIndex;
import hms.models.interfaces.cases.expertnessindex.IExpertnessIndex;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ExpertnessIndexTest {

  private int diseaseID = 1;
  Connector connector = new Connector();
  IExpertnessIndex expdr = new ExpertnessIndex(connector);

  /**
   * Test method to check if the method is setting disease ID
   */
  @Test
  public void setDiseaseIdTest() {
    expdr.setDiseaseId(diseaseID);
    assertEquals(diseaseID, expdr.getDiseaseId());
  }

  /**
   * Test method to check if the method is returning correct disease id
   */
  @Test
  public void getDiseaseIdTest() {
    assertEquals(0, expdr.getDiseaseId());
  }

  /**
   * Test method to check if the method is returning the null values
   */
  @Test
  public void suggestBestDocsTest() throws SQLException {
    assertTrue("No suggested doctors returned", expdr.suggestBestDocs(1));
  }
}