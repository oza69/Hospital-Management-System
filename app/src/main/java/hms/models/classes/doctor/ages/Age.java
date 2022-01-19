/**
 * @author Dhruv Oza
 * @description : This class will calculate age based on birthdate of
 * doctor from database
 */
package hms.models.classes.doctor.ages;

import hms.models.interfaces.doctor.ages.IAge;

import java.util.Calendar;
import java.util.Date;

public class Age implements IAge {

  private Date birthDate;

  public Age(Date birthDate) {
    this.birthDate = birthDate;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  @Override
  public int ageCalculate() {
    int years = 0;
    if (isValid() == true) {
      Calendar dateOfBirth = Calendar.getInstance();
      dateOfBirth.setTimeInMillis(birthDate.getTime());
      long currentDay = System.currentTimeMillis();
      Calendar now = Calendar.getInstance();
      now.setTimeInMillis(currentDay);
      years = now.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
      return years;
    } else {
      return 0;
    }
  }

  @Override
  public boolean isValid() {
    return (birthDate != null);
  }
}
