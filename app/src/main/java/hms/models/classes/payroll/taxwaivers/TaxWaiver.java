/**
 * @author Dhruv Oza
 * @description : This class will calculate tax based on age of doctor
 */
package hms.models.classes.payroll.taxwaivers;

import hms.models.interfaces.payroll.taxwaivers.ITaxWaiver;
import hms.models.interfaces.payroll.totalamounts.ITotalAmount;
import hms.models.interfaces.doctor.ages.IAge;
import hms.models.interfaces.payroll.incentives.IIncentiveBasedPay;

public class TaxWaiver implements ITaxWaiver {

  /* Initialization of totalTax, totalRevenue */
  private double totalTax;
  private double totalRevenue;

  /* Constuctor to initialize totalRevenue from user */
  public TaxWaiver(double totalRevenue) {
    this.totalTax = 0.30;
    this.totalRevenue = totalRevenue;
  }

  /* getter method */
  public double getTotalRevenue() {
    return totalRevenue;
  }

  /* setter method */
  public void setTotalRevenue(double totalRevenue) {
    this.totalRevenue = totalRevenue;
  }

  @Override
  public double taxSetup(IAge iAge) {
    int years = iAge.ageCalculate();
    if (years >= 60) {
      totalTax = totalTax - 0.15;
    } else if (years < 60 && years >= 45) {
      totalTax = totalTax - 0.08;
    } else {
      totalTax = 0.30;
    }
    return totalTax;
  }

  @Override
  public double taxDeducted(ITotalAmount iTotalAmount,
                            IIncentiveBasedPay iIncentiveBasedPay) {
    double totalAmount = iTotalAmount
        .calculateTotalAmount(iIncentiveBasedPay);
    if (isValid() == true) {
      return totalRevenue - (totalAmount * totalTax);
    } else {
      return 0;
    }
  }

  /* validation of totalRevenue */
  @Override
  public boolean isValid() {
    return (totalRevenue >= 0);
  }
}

