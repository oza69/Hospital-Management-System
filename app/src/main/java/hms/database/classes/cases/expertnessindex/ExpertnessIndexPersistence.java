/**
 * @author Eklavya Nautiyal
 * @description class to retrieve best doctors from database
 */
package hms.database.classes.cases.expertnessindex;

import hms.configuration.Connector;
import hms.database.interfaces.doctor.expertnessindex.IExpertnessIndexPersistence;

import java.sql.CallableStatement;
import java.sql.ResultSet;

import static hms.constants.CallableStatements.GET_EXPERT_DOCTOR;

public class ExpertnessIndexPersistence implements IExpertnessIndexPersistence {

  private Connector con;
  private ResultSet result = null;

  public ExpertnessIndexPersistence(Connector con) {
    this.con = con;
  }

  @Override
  public ResultSet getExpertDoc(int diseaseID) {

    try {
      CallableStatement callS = con.getConnection().prepareCall(GET_EXPERT_DOCTOR);
      callS.setInt(1, diseaseID);
      result = callS.executeQuery();
      return result;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
