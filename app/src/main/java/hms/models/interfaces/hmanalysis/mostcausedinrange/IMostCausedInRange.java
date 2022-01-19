/**
 * @author Vishvesh Bharatbhai Naik
 * @description Most Caused Disease will get the number of cases
 * that are enrolling by the patients with specific disease.
 */
package hms.models.interfaces.hmanalysis.mostcausedinrange;

import hms.database.interfaces.disease.diseasepersistence.IDiseasePersistence;
import hms.database.interfaces.hmanalysis.getdiseaseinrange.IGetDiseasesInRangePersistence;
import hms.models.interfaces.disease.diseasesorter.IDiseaseSorter;

import java.sql.Connection;
import java.sql.Date;
import java.util.Map;

/**
 * Creating IMostCausedInRange interface
 */
public interface IMostCausedInRange {

  /**
   * This method will get all the cases from the cases tables and map them
   * to a specific disease and increment as the count of disease
   * goes up and returns a Map.
   * @param startDate Initial date, from where to fetch cases data from
   * @param endDate Final date, till where to fetch cases data
   * @param connection Connector object to perform sql operations on database
   * @param getDiseaseId getting the disease id from Disease Id
   * @param getDiseasesInRange Fetching all disease in given range of date
   * @param sort sorting them in descending order
   * @return Map with String and Double
   */
  Map<String, Double>
  getMostCases(Date startDate, Date endDate, Connection connection,
               IDiseasePersistence getDiseaseId,
               IGetDiseasesInRangePersistence getDiseasesInRange,
               IDiseaseSorter sort);
}