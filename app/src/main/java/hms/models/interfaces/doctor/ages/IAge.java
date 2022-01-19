/**
 * @author Dhruv Oza
 * @description : This class will calculate age based on date of birth of doctor
 */
package hms.models.interfaces.doctor.ages;

import java.util.Date;

/* Age will calculate age using date of birth */
public interface IAge {

  /* getter method */
  public Date getBirthDate();

  /* setter method */
  public void setBirthDate(Date birthDate);

  /**
   * Age Calculation based on Birth Date
   * @return years as calculated using date of birth
   */
  public int ageCalculate();

  /* validation of birthDate */
  public boolean isValid();
}
