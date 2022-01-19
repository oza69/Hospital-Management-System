/**
 * @author Eklavya Nautiyal
 * @description EfficiencyIndex class to handle doctor's efficiency index
 * and compute and put it back to database
 */
package hms.models.classes.doctor.efficiencyindex;

import hms.configuration.Connector;
import hms.database.classes.doctor.efficiencyindex.EfficiencyIndexPersistence;
import hms.database.interfaces.cases.efficiencyindex.IEfficiencyIndexPersistence;
import hms.models.interfaces.doctor.efficiencyindex.IEfficiencyIndex;

import java.sql.SQLException;
import java.util.ArrayList;

public class EfficiencyIndex implements IEfficiencyIndex {

  Connector connector = new Connector();
  IEfficiencyIndexPersistence db = new EfficiencyIndexPersistence(connector);

  @Override
  public Double calcEfficiency(int docID) throws SQLException {
    double avg = 0;
    double total = 0;
    ArrayList<Integer> feedbacks = null;
    feedbacks = getFeedback(docID);
    try {

      for (int i = 0; i < feedbacks.size(); i++) {
        total = total + feedbacks.get(i);
      }
      avg = total / feedbacks.size();
      putEfficiency(docID, avg);
      return avg;
    } catch (Exception e) {

      e.printStackTrace();
      return null;
    }

  }

  @Override
  public ArrayList<Integer> getFeedback(int docID) throws SQLException {
    try {

      ArrayList<Integer> feedbacks = null;
      feedbacks = db.getFeedback(docID);
      if (feedbacks != null)
        return feedbacks;
      else
        return null;

    } catch (Exception e) {

      return null;
    }
  }

  @Override
  public boolean putEfficiency(int docID, double index) throws SQLException {
    try {
      db.putEfficiencyIndex(docID, index);
      return true;
    } catch (Exception e) {

      e.printStackTrace();
      return false;
    }
  }
}
