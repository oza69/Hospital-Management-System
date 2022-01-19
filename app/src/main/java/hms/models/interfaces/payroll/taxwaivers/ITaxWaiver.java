/*
  @author Dhruv Oza
  @description : This class will set up tax based on age of doctor
*/
package hms.models.interfaces.payroll.taxwaivers;

import hms.models.interfaces.payroll.totalamounts.ITotalAmount;
import hms.models.interfaces.doctor.ages.IAge;
import hms.models.interfaces.payroll.incentives.IIncentiveBasedPay;

/* TaxWaiver will setup tax according to ages */
public interface ITaxWaiver {

  /* getter method */
  public double getTotalRevenue();

  /* setter method */
  public void setTotalRevenue(double totalRevenue);

  /**
   * Tax Calculation based on age
   * @param iAge object to use calculated age
   * @return tax according to age comparation
   */
  public double taxSetup(IAge iAge);

  /* Tax deducted from revenue */
  public double taxDeducted(ITotalAmount iTotalAmount,
                            IIncentiveBasedPay iIncentiveBasedPay);

  /* validation of totalRevenue */
  public boolean isValid();
}
