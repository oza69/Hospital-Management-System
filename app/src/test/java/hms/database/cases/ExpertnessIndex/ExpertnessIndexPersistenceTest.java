/**
 * @author Eklavya Nautiyal
 * @description Test class for Expertness Index persistence methods
 */
package hms.database.cases.ExpertnessIndex;

import hms.configuration.Connector;
import hms.database.classes.cases.expertnessindex.ExpertnessIndexPersistence;
import hms.database.interfaces.doctor.expertnessindex.IExpertnessIndexPersistence;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ExpertnessIndexPersistenceTest {

  private int diseaseID = 1;
  private Connector con = new Connector();
  IExpertnessIndexPersistence expdr = new ExpertnessIndexPersistence(con);

  /**
   * Test method to check if the db is not returning any null values
   */
  @Test
  public void getExpDocTest() throws SQLException {
    assertNotNull("DB not returned any suggested doctors", expdr.getExpertDoc(diseaseID));
  }
}