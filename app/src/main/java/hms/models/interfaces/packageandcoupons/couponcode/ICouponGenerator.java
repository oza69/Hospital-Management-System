/**
 * @author Dhruv Oza
 * @description : This class will generate couponcode based on years worked
 */
package hms.models.interfaces.packageandcoupons.couponcode;

/* CouponGenerator will generate coupon using hashcode */
public interface ICouponGenerator {

  /* getter method */
  public double getTotalDiscountGenerated();

  /* setter method */
  public void setTotalDiscountGenerated(double totalDiscountGenerated);

  /**
   * couponGenerated based on totalDiscountGenerated
   * @return couponCode as generated using totalDiscountGenerated
   */
  public String couponGenerated();
}
