/**
 * @author Eklavya Nautiyal
 * @description Creating  Get Risk Factor Persistance Interface to handle
 * Doctor's Efficiency Index
 */

package hms.database.interfaces.disease.getriskfactor;

import java.sql.SQLException;
import java.util.List;

public interface IGetRiskFactorsPersistence {

  /**
   * Method To Get All The Riskfactor Of A Disease ID from Disease Table.
   * Method calls the stored procedure getRiskfactor.
   * @return riskFactorArray
   */
  List<Double> getRiskFactor() throws SQLException;

  /**
   * Set disease id
   * @param diseaseID - takes diseaseID to calculate riskfactor for
   */
  void setDiseaseID(int diseaseID);

  /**
   * get disease ID
   * @return doctor ID
   */
  int getDiseaseID();
}