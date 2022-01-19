/**
 * @author Dhruv Oza
 * @description : This class will calculate years based on date of
 * joining of any doctor
 */
package hms.models.interfaces.doctor.workingyears;

import java.util.Date;

/* CountWorkingYears will calculate totalYears using workingYears */
public interface ICountWorkingYears {

  public Date getWorkingYears(); /* getter method */

  public void setWorkingYears(Date workingYears); /* setter method */

  /**
   * workingYearsCalculation based on workingYears
   * @return totalYears as calculated using workingYears
   */
  public int workingYearsCalculation();

  public boolean isValid(); /* validation of workingYears */
}
