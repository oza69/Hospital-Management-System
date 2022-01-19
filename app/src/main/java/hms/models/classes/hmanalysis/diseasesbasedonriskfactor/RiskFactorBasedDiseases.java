/**
 * @author Dhruv Oza
 * @description : This class will find diseases based on highest
 * riskfactor in given time
 */
package hms.models.classes.hmanalysis.diseasesbasedonriskfactor;

import hms.database.interfaces.disease.diseasepersistence.IDiseasePersistence;
import hms.database.interfaces.hmanalysis.getdiseaseinrange.
    IGetDiseasesInRangePersistence;
import hms.models.interfaces.disease.disease.IDisease;
import hms.models.interfaces.disease.diseasesorter.IDiseaseSorter;
import hms.models.interfaces.hmanalysis.diseasesbasedonriskfactor.
    IRiskFactorBasedDiseases;

import java.sql.Connection;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class RiskFactorBasedDiseases implements IRiskFactorBasedDiseases {

  /*
    Map for disease (details), diseaseInRangeList (diseaseID as key and
    count(frequency of cases between dates) as values
  */
  private Map<Integer, IDisease> diseaseList;
  private Map<Integer, Integer> diseaseInRangeList;
  private Map<String, Double> diseaseListBasedOnRiskFactor;

  public Map<String, Double>
  getFrequentCases(Date startDate, Date endDate, Connection connection,
                   IDiseasePersistence iDiseasePersistence,
                   IGetDiseasesInRangePersistence
                       iGetDiseasesInRangePersistence,
                   IDiseaseSorter iDiseaseSorter) {
    try {
      diseaseList = iDiseasePersistence
          .getAllDiseases(connection);
      diseaseInRangeList =
          iGetDiseasesInRangePersistence
              .getDiseases(startDate, endDate, connection);
      diseaseListBasedOnRiskFactor = new HashMap<>();
      for (int i : diseaseInRangeList.keySet()) {
        diseaseListBasedOnRiskFactor
            .put(diseaseList.get(i).getName(), diseaseList
                .get(i).getFatalityRiskFactor());
      }
      return (Map<String, Double>) iDiseaseSorter
          .sortByValue(diseaseListBasedOnRiskFactor);
    } catch (Exception e) {
      return null;
    }
  }
}
