/**
 * @author Eklavya Nautiyal
 * @description Handle coupons in coupons table
 */
package hms.models.classes.packageandcoupons.coupons;

import hms.models.interfaces.packageandcoupons.coupons.ICoupons;

public class Coupons implements ICoupons {

  private String couponCode;
  private Double couponDiscount;

  public Coupons(String couponCode, Double couponDiscount) {
    this.couponCode = couponCode;
    this.couponDiscount = couponDiscount;
  }

  public Coupons() {

  }

  @Override
  public String getCouponCode() {
    return couponCode;
  }

  @Override
  public void setCouponCode(String couponCode) {
    this.couponCode = couponCode;
  }

  @Override
  public Double getCouponDiscount() {
    return couponDiscount;
  }

  @Override
  public void setCouponDiscount(Double couponDiscount) {
    this.couponDiscount = couponDiscount;
  }
}
