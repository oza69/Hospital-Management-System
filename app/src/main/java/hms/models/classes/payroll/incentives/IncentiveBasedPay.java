/**
 * @author Dhruv Oza
 * @description : This class will calculate incentives based on totalHours
 * worked
 */
package hms.models.classes.payroll.incentives;

import hms.models.interfaces.payroll.incentives.IIncentiveBasedPay;

public class IncentiveBasedPay implements IIncentiveBasedPay {

  /* Initialization of workingHours, totalWorked */
  private double workingHours;
  private double totalWorked;

  /* Constructor to initialize workingHours, totalWorked from user */
  public IncentiveBasedPay(double workingHours, double totalWorked) {
    this.workingHours = workingHours;
    this.totalWorked = totalWorked;
  }

  /* getter method */
  public double getWorkingHours() {
    return workingHours;
  }

  /* setter method */
  public void setWorkingHours(double workingHours) {
    this.workingHours = workingHours;
  }

  /* getter method */
  public double getTotalWorked() {
    return totalWorked;
  }

  /* setter method */
  public void setTotalWorked(double totalWorked) {
    this.totalWorked = totalWorked;
  }

  @Override
  public double incentiveCalculation() {
    double incentives;
    double extraHours;
    double ratePerHour;
    ratePerHour = 300;
    if (workingHours < totalWorked && isValid() == true) {
      extraHours = totalWorked - workingHours;
      incentives = extraHours * ratePerHour;
      return incentives;
    } else {
      return 0;
    }
  }

  /* validation of workingHours, totalWorked */
  public boolean isValid() {
    return (workingHours >= 0 && totalWorked >= 0);
  }
}
