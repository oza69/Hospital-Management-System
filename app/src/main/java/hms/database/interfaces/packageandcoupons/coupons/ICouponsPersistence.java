/**
 * @author Eklavya Nautiyal
 * @description Creating Payroll Databridge interface
 */
package hms.database.interfaces.packageandcoupons.coupons;

import java.sql.Connection;
import java.sql.ResultSet;

import hms.models.interfaces.packageandcoupons.coupons.ICoupons;

public interface ICouponsPersistence {

  /**
   * This method helps to insert record in Coupons table
   * @param iCoupons Coupons object to store in table
   * @param connection Connection object to handle database connection
   * @return True if data is stored successfully into Coupons table
   */
  boolean saveCoupon(ICoupons iCoupons, Connection connection);

  /**
   * This method helps to retrive all records in Coupons table
   * @param connection Connection object to handle database connection
   * @return ResultSet of data if retrived successfully from the Coupons table,
   *      else return null
   */
  ResultSet getAllCoupons(Connection connection);

  /**
   * This method helps to update a coupon in Coupons table
   * @param connection Connection object to handle database connection
   * @param couponId id of existing coupon
   * @param couponCode updated code of coupon
   * @param discount updated discount
   * @return ResultSet of data if retrived successfully from the Coupons table,
   *      else return null
   */
  boolean updateCoupon(int couponId, String couponCode, Double discount,
                       Connection connection);
}