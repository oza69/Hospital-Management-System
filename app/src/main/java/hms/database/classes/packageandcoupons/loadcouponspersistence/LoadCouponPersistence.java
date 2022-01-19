/**
 * @author Dhruv Oza
 * @description : This class will store coupon code and coupon discount
 * based on calculation into database
 */
package hms.database.classes.packageandcoupons.loadcouponspersistence;

import hms.configuration.ConnectorDao;
import hms.database.interfaces.packageandcoupons
    .loadcouponpersistence.ILoadCouponPersistence;
import hms.models.interfaces.packageandcoupons.couponcode.ICouponGenerator;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import static hms.constants.CallableStatements.INSERT_COUPON_DETAILS;

public class LoadCouponPersistence implements ILoadCouponPersistence {

  public boolean loading(ICouponGenerator iCouponGenerator,
                         ConnectorDao connectorDao) throws SQLException {
    try {
      String couponCode = iCouponGenerator.couponGenerated();
      double couponDiscount = iCouponGenerator.getTotalDiscountGenerated();
      Connection con = connectorDao.getConnection();
      CallableStatement cs = con.prepareCall(INSERT_COUPON_DETAILS);
      cs.setString(1, couponCode);
      cs.setDouble(2, couponDiscount);
      cs.execute();
      return true;
    } catch (SQLException e) {
      return false;
    }
  }
}
