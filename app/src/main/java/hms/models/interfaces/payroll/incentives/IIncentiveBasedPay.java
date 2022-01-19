/**
 * @author Dhruv Oza
 * @description : This class will calculate incentives based on total hours
 * worked
 */
package hms.models.interfaces.payroll.incentives;

/* IncentiveBasedPay will calculate incentives */
public interface IIncentiveBasedPay {

  public double getWorkingHours();  /* getter method */

  public void setWorkingHours(double workingHours);  /* setter method */

  public double getTotalWorked();  /* getter method */

  public void setTotalWorked(double totalWorked);  /* setter method */

  /**
   * Calculating Incentives based on total working hours
   * @return incentives calculated after checking following conditions
   */
  public double incentiveCalculation();  /* incentive calculation */

  public boolean isValid();  /* validation of workingHours, totalWorked */
}
