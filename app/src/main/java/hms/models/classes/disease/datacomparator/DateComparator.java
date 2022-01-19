/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains DateComparator class which will help to create
 * DateComparator objects which will help to check whether the start date comes
 * before the end date or not
 */
package hms.models.classes.disease.datacomparator;

import hms.models.interfaces.disease.datacomparator.IDateComparator;
import java.sql.Date;

public class DateComparator implements IDateComparator {

  @Override
  public boolean compare(Date startDate, Date endDate) {
    return (startDate.compareTo(endDate) <= 0);
  }
}