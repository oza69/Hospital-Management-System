/**
 * @author Dhruv Oza
 * @description : This class will calculate total amount based
 * on other pending amounts
 */
package hms.models.interfaces.payroll.totalamounts;

import hms.models.interfaces.payroll.incentives.IIncentiveBasedPay;

/* TotalAmount will be calculated */
public interface ITotalAmount {

  /* getter method */
  public double getAmount();

  /* setter method */
  public void setAmount(double amount);

  /* getter method */
  public double getPendingAmount();

  /* setter method */
  public void setPendingAmount(double pendingAmount);

  /* getter method */
  public double getProfitSharingIncentive();

  /* setter method */
  public void setProfitSharingIncentive(double profitSharingIncentive);

  /**
   * Calculating Total Amount based on other payments to be made
   * @param iIncentiveBasedPay objectto calculate incentives
   * @return totalAmount calculated amount
   */
  public double calculateTotalAmount(IIncentiveBasedPay iIncentiveBasedPay);

  /* validation of amount, pendingAmount, profitSharingIncentive */
  public boolean isValid();
}
