/**
 * @author Dhruv Oza
 * @description : This class will calculate total amount based on
 * pendingAmount, amount, profitSharingIncentive
 */
package hms.models.classes.payroll.totalamounts;

import hms.models.interfaces.payroll.totalamounts.ITotalAmount;
import hms.models.interfaces.payroll.incentives.IIncentiveBasedPay;

public class TotalAmount implements ITotalAmount {

  private double amount;
  private double pendingAmount;
  private double profitSharingIncentive;

  public TotalAmount(double amount, double pendingAmount,
                     double profitSharingIncentive) {
    this.amount = amount;
    this.pendingAmount = pendingAmount;
    this.profitSharingIncentive = profitSharingIncentive;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public double getPendingAmount() {
    return pendingAmount;
  }

  public void setPendingAmount(double pendingAmount) {
    this.pendingAmount = pendingAmount;
  }

  public double getProfitSharingIncentive() {
    return profitSharingIncentive;
  }

  public void setProfitSharingIncentive(double profitSharingIncentive) {
    this.profitSharingIncentive = profitSharingIncentive;
  }

  @Override
  public double calculateTotalAmount(IIncentiveBasedPay iIncentiveBasedPay) {
    double incentives = iIncentiveBasedPay.incentiveCalculation();
    double totalAmount;
    if (isValid() == true) {
      totalAmount = amount + pendingAmount + profitSharingIncentive
          + incentives;
      return totalAmount;
    } else {
      return 0;
    }
  }

  public boolean isValid() {
    return (amount >= 0 && pendingAmount >= 0 && profitSharingIncentive >= 0);
  }
}
