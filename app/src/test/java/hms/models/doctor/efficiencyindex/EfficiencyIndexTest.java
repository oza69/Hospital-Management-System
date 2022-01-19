/**
 * @author Eklavya Nautiyal
 * @description Creating EfficiencyIndexTest class to run test cases
 */
package hms.models.doctor.efficiencyindex;

import hms.models.classes.doctor.efficiencyindex.EfficiencyIndex;
import hms.models.interfaces.doctor.efficiencyindex.IEfficiencyIndex;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class EfficiencyIndexTest {

  /**
   * Initializing common variables and objects
   */
  IEfficiencyIndex ef = new EfficiencyIndex();
  public static int docID = 1;

  /**
   * Test for the calc efficiencyIndex of a docID.
   */
  @Test
  public void calcEfficiencyTest() throws SQLException {

    assertNotNull("incorrect value", ef.calcEfficiency(docID));
  }

  /**
   * Test for checking feedback is not null for doc id 1.
   */
  @Test
  public void getFeedbackNotNullTest() throws SQLException {

    assertNotNull("Cannot Retrieve", ef.getFeedback(docID));
  }
}