/**
 * @author Eklavya Nautiyal
 * @description class to retrieve feedback from database
 * and put efficiency index into database
 */
package hms.database.classes.doctor.efficiencyindex;

import hms.configuration.Connector;
import hms.database.interfaces.cases.efficiencyindex.IEfficiencyIndexPersistence;

import java.sql.*;
import java.util.ArrayList;

import static hms.constants.CallableStatements.GET_FEEDBACK;
import static hms.constants.CallableStatements.SET_EFFICIENCY;

public class EfficiencyIndexPersistence implements IEfficiencyIndexPersistence {

  private Connector con;
  private ResultSet result = null;

  public EfficiencyIndexPersistence(Connector con) {
    this.con = con;
  }

  @Override
  public ArrayList getFeedback(int docId) throws SQLException {
    try {
      ArrayList<Integer> feedbackarray = new ArrayList<Integer>();
      CallableStatement callS = con.getConnection().prepareCall(GET_FEEDBACK);
      callS.setInt(1, docId);
      result = callS.executeQuery();
      while (result.next()) {
        int res = result.getInt("Doctor_Feedback");
        feedbackarray.add(res);
      }

      if (feedbackarray == null) {

        System.out.println("feedback Array is null in DB class");
        return null;
      } else {

        return feedbackarray;
      }
    } catch (Exception e) {

      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean putEfficiencyIndex(int docID, double indexValue) throws SQLException {
    try {

      CallableStatement callS = con.getConnection().prepareCall(SET_EFFICIENCY);
      callS.setInt(1, docID);
      callS.setDouble(2, indexValue);
      callS.execute();
      return true;
    } catch (Exception e) {

      e.printStackTrace();
      return false;
    }
  }
}