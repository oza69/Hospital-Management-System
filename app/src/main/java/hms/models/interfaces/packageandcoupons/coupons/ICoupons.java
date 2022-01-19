/**
 * @author Eklavya Nautiyal
 * @description Coupon Interface to handle coupons in coupons table
 */
package hms.models.interfaces.packageandcoupons.coupons;

/**
 * Creating Coupons interface
 */
public interface ICoupons {

  /**
   * Getter method for coupon code
   * @return coupon code
   */
  String getCouponCode();


  /**
   * Setter method for coupon code
   * @param couponCode coupon code
   */
  void setCouponCode(String couponCode);


  /**
   * Getter method for coupon amount
   * @return Amount
   */
  Double getCouponDiscount();

  /**
   * Setter method for coupon amount
   */
  void setCouponDiscount(Double couponDiscount);
}
