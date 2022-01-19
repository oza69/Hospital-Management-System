/**
 * @author Eklavya Nautiyal
 * @description Coupon Test class to run test cases
 */
package hms.models.packageandcoupons.coupons;

/**
 * Importing required libraries
 */

import hms.models.classes.packageandcoupons.coupons.Coupons;
import hms.models.interfaces.packageandcoupons.coupons.ICoupons;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Creating PayrollTest class to run test cases
 */
public class CouponsTest {

  /**
   * Initializing common variables and objects
   */
  private String couponCode = "Special";
  private Double coupinDiscount = 20.0;
  ICoupons myCoupon =
      new Coupons(couponCode, coupinDiscount);

  /**
   * CouponCode method returns the Coupon code
   */
  @Test
  public void testGetCouponCode() {
    assertNotNull("Doc ID is not valid", myCoupon.getCouponCode());
  }

  /**
   * set CouponCode
   */
  @Test
  public void testSetCouponCode() {
    String couponCodeNew = "New User";
    myCoupon.setCouponCode(couponCodeNew);
    assertEquals("Coupon Code not updated", couponCodeNew,
        myCoupon.getCouponCode());
  }

  /**
   * GetCouponDiscount method returns the amount
   */
  @Test
  public void testGetCouponDiscount() {
    assertTrue("CouponDiscount is not valid",
        myCoupon.getCouponDiscount() >= 0);
  }

  /**
   * getDate method returns the Case date
   */
  @Test
  public void testSetAmount() {
    Double discount = 8.0;
    myCoupon.setCouponDiscount(discount);
    assertEquals("discount is not set", discount,
        myCoupon.getCouponDiscount());
  }
}

