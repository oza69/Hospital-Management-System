/**
 * @author Eklavya Nautiyal
 * @description class to retrieve risk factor from database
 */
package hms.database.classes.disease.riskfactors;

import hms.configuration.Connector;
import hms.database.interfaces.disease.getriskfactor.IGetRiskFactorsPersistence;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static hms.constants.CallableStatements.GET_RISK_FACTORS;

public class GetRiskFactorsPersistence implements IGetRiskFactorsPersistence {

  private Connector con;
  private ResultSet result = null;
  private int diseaseID;

  public GetRiskFactorsPersistence(Connector con) {
    this.con = con;
  }

  @Override
  public void setDiseaseID(int diseaseID) {
    this.diseaseID = diseaseID;
  }

  @Override
  public int getDiseaseID() {
    return this.diseaseID;
  }

  @Override
  public List<Double> getRiskFactor() throws SQLException {
    try {
      List<Double> riskFactorArray = new ArrayList<Double>();
      CallableStatement callS = con.getConnection().prepareCall(GET_RISK_FACTORS);
      callS.setInt(1, this.diseaseID);
      result = callS.executeQuery();
      while (result.next()) {
        double res1 = result.getDouble("Fatality_Risk_Factor");
        riskFactorArray.add(res1);
        double res2 = result.getDouble("Contagious_Risk_Factor");
        riskFactorArray.add(res2);
      }
      if (riskFactorArray == null) {
        System.out.println("RiskFactor Array is null in DB class");
        return null;
      } else {
        return riskFactorArray;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}