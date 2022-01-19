/**
 * @author Vishvesh Bharatbhai Naik
 * @description Most Caused Disease will get the number of cases
 * that are enrolling by the patients with specific disease.
 */
package hms.models.classes.hmanalysis.mostcausedinrange;

import hms.database.interfaces.disease.diseasepersistence.IDiseasePersistence;
import hms.database.interfaces.hmanalysis.getdiseaseinrange.IGetDiseasesInRangePersistence;
import hms.models.interfaces.disease.disease.IDisease;
import hms.models.interfaces.disease.diseasesorter.IDiseaseSorter;
import hms.models.interfaces.hmanalysis.mostcausedinrange.IMostCausedInRange;

import java.sql.Connection;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class MostCausedInRange implements IMostCausedInRange {

  @Override
  public Map<String, Double>
  getMostCases(Date startDate, Date endDate, Connection connection,
               IDiseasePersistence getDiseaseId,
               IGetDiseasesInRangePersistence getDiseasesInRange,
               IDiseaseSorter sorter) {
    try {
      Map<Integer, IDisease> diseaseList = getDiseaseId
          .getAllDiseases(connection);
      Map<Integer, Integer> diseaseInRangeList = getDiseasesInRange
          .getDiseases(startDate, endDate, connection);
      Map<String, Integer> diseaseListFromCases = new HashMap<>();
      diseaseInRangeList.forEach((diseaseID, count) -> {
        diseaseListFromCases.put(diseaseList.get(diseaseID).getName(), count);
      });
      Map<String, Double> sortDiseasesByCases =
          (Map<String, Double>) sorter.sortByValue(diseaseListFromCases);
      return sortDiseasesByCases;
    } catch (Exception e) {
      return null;
    }
  }
}