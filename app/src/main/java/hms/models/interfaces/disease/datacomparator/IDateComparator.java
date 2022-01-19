/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains DateComparator interface which will help to
 * implement DateComparator class which implements compare method
 */
package hms.models.interfaces.disease.datacomparator;

import java.sql.Date;

public interface IDateComparator {

  /**
   * This method compares start date and end date to check whether start date
   * and end date is in correct sequence or not.
   * @param startDate Initial date
   * @param endDate End date to be compared
   * @return True if endDate comes after startDate, else false
   */
  boolean compare(Date startDate, Date endDate);
}