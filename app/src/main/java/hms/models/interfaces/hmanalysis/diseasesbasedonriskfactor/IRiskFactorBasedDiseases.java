/**
 * @author Dhruv Oza
 * @description : This class will find diseases based on risk factor
 * in given time period
 */
package hms.models.interfaces.hmanalysis.diseasesbasedonriskfactor;

import hms.database.interfaces.disease.diseasepersistence.IDiseasePersistence;
import hms.database.interfaces.hmanalysis.getdiseaseinrange
    .IGetDiseasesInRangePersistence;
import hms.models.interfaces.disease.diseasesorter.IDiseaseSorter;

import java.sql.Connection;
import java.sql.Date;
import java.util.Map;

/*
  RiskFactorBasedDiseases class to find diseases
  based on risk factor
*/
public interface IRiskFactorBasedDiseases {

  /**
   * Getting the Disease Id and converting them to their name and count and
   * then according to risk factor sort in decending order
   * @param startDate date from which cases to be fetched
   * @param endDate date till which cases to be fetched
   * @param connection Connector object to handle database
   * @param iDiseasePersistence to get all disease details
   * @param iGetDiseasesInRangePersistence to fetch all disease within range
   * @param iDiseaseSorter sort in decending order
   * @return Map with disease name as keys and risk factor as values
   */
  public Map<String, Double>
  getFrequentCases(Date startDate, Date endDate, Connection connection,
                   IDiseasePersistence iDiseasePersistence,
                   IGetDiseasesInRangePersistence
                       iGetDiseasesInRangePersistence,
                   IDiseaseSorter iDiseaseSorter);
}
