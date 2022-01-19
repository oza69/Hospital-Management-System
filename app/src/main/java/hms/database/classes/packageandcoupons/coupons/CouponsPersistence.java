/**
 * @author Eklavya Nautiyal
 * @description class to retrieve coupons from database
 * and insert a coupon into database
 */
package hms.database.classes.packageandcoupons.coupons;

import hms.database.interfaces.packageandcoupons.coupons.ICouponsPersistence;
import hms.models.interfaces.packageandcoupons.coupons.ICoupons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static hms.constants.CallableStatements.ADD_COUPONS;
import static hms.constants.CallableStatements.UPDATE_COUPON;
import static hms.constants.CallableStatements.ALL_COUPONS;

public class CouponsPersistence implements ICouponsPersistence {

  @Override
  public boolean saveCoupon(ICoupons iCoupons, Connection connection) {
    try {

      PreparedStatement statement = connection.prepareStatement(ADD_COUPONS);
      statement.setString(1, iCoupons.getCouponCode());
      statement.setDouble(2, iCoupons.getCouponDiscount());
      statement.executeUpdate();
      return true;

    } catch (Exception e) {

      return false;

    }
  }

  @Override
  public ResultSet getAllCoupons(Connection connection) {
    try {

      PreparedStatement statement = connection.prepareCall(ALL_COUPONS);
      ResultSet resultData = statement.executeQuery();
      return resultData;

    } catch (Exception e) {

      return null;

    }
  }

  @Override
  public boolean updateCoupon(int couponId, String couponCode, Double discount,
                              Connection connection) {
    try {

      PreparedStatement statement = connection.prepareStatement(UPDATE_COUPON);
      statement.setInt(1, couponId);
      statement.setString(2, couponCode);
      statement.setDouble(3, discount);
      statement.executeUpdate();
      return true;

    } catch (Exception e) {

      return false;

    }
  }
}

