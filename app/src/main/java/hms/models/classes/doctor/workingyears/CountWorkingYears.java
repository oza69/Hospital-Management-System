/**
 * @author Dhruv Oza
 * @description : This class will calculate working years based on
 * date of joining of doctor
 */
package hms.models.classes.doctor.workingyears;

import hms.models.interfaces.doctor.workingyears.ICountWorkingYears;

import java.util.Calendar;
import java.util.Date;

public class CountWorkingYears implements ICountWorkingYears {

  private Date workingYears;

  public CountWorkingYears(Date workingYears) {
    this.workingYears = workingYears;
  }

  public Date getWorkingYears() {
    return workingYears;
  }

  public void setWorkingYears(Date workingYears) {
    this.workingYears = workingYears;
  }

  public int workingYearsCalculation() {
    int totalYears = 0;
    if (isValid() == true) {
      Calendar dateOfJoining = Calendar.getInstance();
      dateOfJoining.setTimeInMillis(workingYears.getTime());
      long currentDay = System.currentTimeMillis();
      Calendar now = Calendar.getInstance();
      now.setTimeInMillis(currentDay);
      totalYears = now.get(Calendar.YEAR) -
          dateOfJoining.get(Calendar.YEAR);
      return totalYears;
    } else {
      return 0;
    }
  }

  public boolean isValid() {
    return (workingYears != null);
  }
}
