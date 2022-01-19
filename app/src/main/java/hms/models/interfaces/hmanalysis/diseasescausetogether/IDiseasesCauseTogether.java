/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains DiseasesCauseTogether interface which
 * will help to implement DiseasesCauseTogether class
 */
package hms.models.interfaces.hmanalysis.diseasescausetogether;

import hms.database.interfaces.disease.diseasepersistence.IDiseasePersistence;
import hms.database.interfaces.hmanalysis.getdiseaseinrange.IGetDiseasesInRangePersistence;
import hms.models.interfaces.disease.diseasesorter.IDiseaseSorter;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface IDiseasesCauseTogether {

  /**
   * This method calculated which diseases are found in majority of patients
   * @param startDate The start date from where to retrieve records for analysis
   * @param endDate The end date till where to retrieve records for analysis
   * @param connection The connection object to perform operations
   * @param diseasePersistence This object has methods to retrieve and add
   * disease
   * @param getDiseasesInRangePersistence This object has method to retrieve
   * distinct diseases for patients
   * @param sorter This object sorts diseases in descending order
   * @return Returns Map in descending order of most caused disease
   * with List of diseases found together.
   */
  Map<String, List<String>> getDiseasesCauseTogether(Date startDate,
      Date endDate, Connection connection,
      IDiseasePersistence diseasePersistence,
      IGetDiseasesInRangePersistence getDiseasesInRangePersistence,
      IDiseaseSorter sorter);
}