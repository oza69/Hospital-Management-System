/**
 * @author Eklavya Nautiyal
 * @description Creating Efficiency Index persistence Interface to handle
 * Doctor's Efficiency Index
 */

package hms.database.interfaces.cases.efficiencyindex;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IEfficiencyIndexPersistence {

  /**
   * @param docId Doctor ID to fetch the feedback for
   * @return ArrayList of feedbacks
   * @throws SQLException
   */
  ArrayList getFeedback(int docId) throws SQLException;

  /**
   * @param docID Doctor ID to fetch the feedback for
   * @param indexValue efficiency index value to store in the database
   * @return true or false
   * @throws SQLException
   */
  boolean putEfficiencyIndex(int docID, double indexValue) throws SQLException;
}