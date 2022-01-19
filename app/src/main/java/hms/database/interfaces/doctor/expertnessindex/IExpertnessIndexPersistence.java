/**
 * @author Eklavya Nautiyal
 * @description Expertness Index Interface to retrieve best doctors for a disease
 */
package hms.database.interfaces.doctor.expertnessindex;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IExpertnessIndexPersistence {

  /**
   * getExpertDoc will retrieve all expert doctors for a disease.
   * @param diseaseID to choose the disease
   * @return Resultset of all the doctors
   * @throws SQLException SQL error will be handled here
   */
  ResultSet getExpertDoc(int diseaseID) throws SQLException;
}
