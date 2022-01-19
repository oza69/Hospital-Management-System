/**
 * @author Eklavya Nautiyal
 * @description Expertness Index Interface to retrieve best doctors
 */
package hms.models.interfaces.cases.expertnessindex;

import java.sql.SQLException;

public interface IExpertnessIndex {

  /**
   * return the diseaseid
   */
  int getDiseaseId();

  /**
   * set disease ID
   * @param diseaseID disease id to set
   */
  void setDiseaseId(int diseaseID);

  /**
   * @param diseaseId to fetch the best doctors on a case
   * @return void. suggests list of doctors best for a disease
   * @throws SQLException
   */
  boolean suggestBestDocs(int diseaseId) throws SQLException;
}
