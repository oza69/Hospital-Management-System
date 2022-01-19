/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains ContagiousAndRiskyDiseases interface which
 * will help to implement ContagiousAndRiskyDiseases class
 */
package hms.models.interfaces.hmanalysis.contagiousandriskydiseases;

import hms.database.interfaces.disease.diseasepersistence.IDiseasePersistence;
import hms.database.interfaces.hmanalysis.getdiseaseinrange.IGetDiseasesInRangePersistence;
import hms.models.interfaces.disease.diseasesorter.IDiseaseSorter;
import hms.models.interfaces.disease.zerotoonescale.IZeroToOneScale;
import java.sql.Connection;
import java.sql.Date;
import java.util.Map;

public interface IContagiousAndRiskyDiseases {

  /**
   * getDiseases method finds the overall risk factor based on fatality and
   * contagious risk factors in given range of days.
   * @param startDate Initial date, from where to fetch cases data from
   * @param endDate Final date, till where to fetch cases data
   * @param connection Connector object to perform sql operations on database
   * @param diseasePersistence It performs various sql operations related to
   * disease table
   * @param getDiseasesInRangePersistence It performs method to find number of
   * cases per disease in given range
   * @param factorChecker It contains method to check proper value of given factor
   * @param sorter It contains method to sort disease list
   * @return This method returns a Map of diseases with fatality risk factor,
   * contagious risk factor and overall risk factor
   */
  Map<String, Map<String, Double>> getDiseases(Date startDate, Date endDate,
      Connection connection, IDiseasePersistence diseasePersistence,
      IGetDiseasesInRangePersistence getDiseasesInRangePersistence,
      IZeroToOneScale factorChecker, IDiseaseSorter sorter);
}