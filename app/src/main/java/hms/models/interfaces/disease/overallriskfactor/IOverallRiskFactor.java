/**
 * @author Eklavya Nautiyal
 * @description Creating  Overall Risk Factor Interface to handle
 * Overall Risk Factor of disease
 */
package hms.models.interfaces.disease.overallriskfactor;

import java.sql.SQLException;
import java.util.List;


public interface IOverallRiskFactor {

  /**
   * getRiskFactor will check if the value that is being fetch is not null.
   * @throws SQLException SQL error will be handled here
   */
  List<Double> getRiskfactors(int diseaseID) throws SQLException;

  /**
   * calcOverallRiskFactor() will check if the value
   * that is being fetch is not null.
   * @throws SQLException SQL error will be handled here
   */
  Double calcOverallRiskFactor() throws SQLException;

  /**
   * getDiseaseId will compare the database value of
   * both database and test case.
   */
  int getDiseaseId();

  /**
   * setDiseasesId will compare the set database value of
   * both database and test case
   */
  void setDiseaseId(int diseaseId);
}
