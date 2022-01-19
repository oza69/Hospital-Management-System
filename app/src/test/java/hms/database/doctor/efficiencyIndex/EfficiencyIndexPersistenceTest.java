/**
 * @author Eklavya Nautiyal
 * @description Creating EfficiencyIndexPersistenceTest class to run test cases
 */
package hms.database.doctor.efficiencyIndex;

import hms.configuration.Connector;
import hms.database.classes.doctor.efficiencyindex.EfficiencyIndexPersistence;
import hms.database.interfaces.cases.efficiencyindex.IEfficiencyIndexPersistence;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

public class EfficiencyIndexPersistenceTest {

  /**
   * Initializing common variables and objects
   */
  private Connector con = new Connector();
  public static int DocID = 1;
  public static double indexValue = 3;
  IEfficiencyIndexPersistence db = new EfficiencyIndexPersistence(con);

  /**
   * Test funtion to check Not Null of getFeedback method
   */
  @Test
  public void getFeedbackTest() throws SQLException {

    assertNotNull("Contigious risk factor is NULL", db.getFeedback(DocID));
  }

  /**
   * Test funtion to check Not Null of putEfficiency method
   */
  @Test
  public void putEfficiencyTest() throws SQLException {

    assertNotNull("Contigious risk factor is NULL",
        db.putEfficiencyIndex(DocID, indexValue));
  }
}