/**
 * @author Dhruv Oza
 * @description : This class will calculate percentage discount
 * based on years worked
 */
package hms.models.interfaces.packageandcoupons.percentagebaseddiscount;

/* PercentageBased will calculate totalDiscount */
public interface IPercentageBased {

  public int getYears(); /* getter method */

  public void setYears(int years); /* setter method */

  /**
   * discountCalculation based on discountApplied
   * @return totalDiscount calculated after checking following conditions
   */
  public double discountCalculation();
}

