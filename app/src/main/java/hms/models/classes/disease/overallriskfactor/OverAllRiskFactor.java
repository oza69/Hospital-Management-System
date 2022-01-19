/**
 * @author Eklavya Nautiyal
 * @description Class To compute overall risk factor.
 */
package hms.models.classes.disease.overallriskfactor;

import hms.configuration.Connector;
import hms.database.classes.disease.riskfactors.GetRiskFactorsPersistence;
import hms.database.interfaces.disease.getriskfactor.IGetRiskFactorsPersistence;
import hms.models.interfaces.disease.overallriskfactor.IOverallRiskFactor;

import java.util.List;

public class OverAllRiskFactor implements IOverallRiskFactor {

  private int diseaseId;
  Connector connector = new Connector();
  IGetRiskFactorsPersistence db = new GetRiskFactorsPersistence(connector);

  public OverAllRiskFactor(int diseaseId) {
    this.diseaseId = diseaseId;
  }

  @Override
  public int getDiseaseId() {
    return diseaseId;
  }

  @Override
  public void setDiseaseId(int diseaseId) {
    this.diseaseId = diseaseId;
  }

  @Override
  public List<Double> getRiskfactors(int diseaseId) {
    try {
      List<Double> riskFactors = null;
      db.setDiseaseID(diseaseId);
      riskFactors = db.getRiskFactor();
      if (riskFactors != null)
        return riskFactors;
      else
        return null;

    } catch (Exception e) {

      return null;
    }
  }

  @Override
  public Double calcOverallRiskFactor() {
    double avgriskfactor = 0.0;
    double total = 0.0;
    List<Double> riskfactors = null;
    riskfactors = getRiskfactors(this.diseaseId);
    try {
      for (int i = 0; i < riskfactors.size(); i++) {
        total = total + riskfactors.get(i);
      }
      avgriskfactor = total / riskfactors.size();
      return avgriskfactor;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}