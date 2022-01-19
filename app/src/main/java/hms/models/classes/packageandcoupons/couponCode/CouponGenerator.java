/**
 * @author Dhruv Oza
 * @description : This class will generate couponCode based on
 * percentage discount
 */
package hms.models.classes.packageandcoupons.couponCode;

import hms.models.interfaces.packageandcoupons.couponcode.ICouponGenerator;
import hms.models.interfaces.packageandcoupons.percentagebaseddiscount
    .IPercentageBased;

import java.lang.Double;


public class CouponGenerator implements ICouponGenerator {

  /* Initialization of totalDiscountGenerated */
  private double totalDiscountGenerated;

  /* Constuctor to initialize totalDiscountGenerated */
  public CouponGenerator(IPercentageBased iPercentageBased) {
    this.totalDiscountGenerated = iPercentageBased.discountCalculation();
  }

  /* getter method */
  public double getTotalDiscountGenerated() {
    return totalDiscountGenerated;
  }

  /* setter method */
  public void setTotalDiscountGenerated(double totalDiscountGenerated) {
    this.totalDiscountGenerated = totalDiscountGenerated;
  }

  public String couponGenerated() {
    int couponHashCode = Double.hashCode(totalDiscountGenerated);
    String couponCode = String.valueOf(couponHashCode);
    return couponCode;
  }
}
