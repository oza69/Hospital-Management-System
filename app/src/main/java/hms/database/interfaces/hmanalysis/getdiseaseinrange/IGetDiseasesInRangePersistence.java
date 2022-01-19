/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains interface for GetDiseasesInRangePersistence
 * class which handles various select operations to fetch output from database
 */
package hms.database.interfaces.hmanalysis.getdiseaseinrange;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface IGetDiseasesInRangePersistence {

  /**
   * This method helps to retrieve records from CASES table for given range of days
   * @param startDate Initial date from where to retrieve records
   * @param endDate End date till where to retrieve records
   * @param connection Connection object to handle database connection
   * @return Returns Map of Disease id as key and count as value if data is
   * successfully retrieved table, else returns null
   */
  Map<Integer, Integer> getDiseases(Date startDate, Date endDate,
      Connection connection);

  /**
   * This method helps to retrieve distinct records of patients and diseases
   * from CASES table for given range of days
   * @param startDate Initial date from where to retrieve records
   * @param endDate End date till where to retrieve records
   * @param connection Connection object to handle database connection
   * @return Map of patient id as key and diseases as value if data is
   * successfully retrieved table, else returns null
   */
  Map<Integer, List<Integer>> getDistinctDiseasesPerPatient(Date startDate,
      Date endDate, Connection connection);
}