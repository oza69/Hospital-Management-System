/**
 * @author Eklavya Nautiyal
 * @description Creating  Efficiency Index Interface to handle
 * efficiency Index of a doctor
 */
package hms.models.interfaces.doctor.efficiencyindex;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IEfficiencyIndex {

  /**
   * @param docID to fetch the feedbacks and to insert the efficientcyIndex
   * @return Double - Calculated Efficiency
   * @return ArrayList of feedbacks
   * @throws SQLException
   */
  Double calcEfficiency(int docID) throws SQLException;

  /**
   * Method to return the feedbacks of a doctor
   * @param docID it will take doctor id as input
   * @return ArrayList of of various feedback which the doctor got
   * @throws SQLException SQL error will be handled here
   */
  ArrayList<Integer> getFeedback(int docID) throws SQLException;

  /**
   * Method to put the efficiency index back to doctor table
   * @param docID it will take doctor id as an input
   * @param index efficiency index will be as an input
   * @return ture if the values matches or false if they don't
   * @throws SQLException SQL error will be handled here
   */
  boolean putEfficiency(int docID, double index) throws SQLException;
}
