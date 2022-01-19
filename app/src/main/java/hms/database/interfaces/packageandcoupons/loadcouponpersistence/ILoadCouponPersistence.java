/**
 * @author Dhruv Oza
 * @description : This class will load couponcode details in database
 */
package hms.database.interfaces.packageandcoupons.loadcouponpersistence;

import hms.configuration.ConnectorDao;
import hms.models.interfaces.packageandcoupons.couponcode.ICouponGenerator;

import java.sql.SQLException;

/* LoadCouponCode will load all values into database */
public interface ILoadCouponPersistence {

  /**
   * Uploading all calculated values into database
   * @param iCouponGenerator object to get couponCode, couponDiscount
   * @param connectorDao object to handle database connection
   * @return true if all values are uploaded successfully
   */
  public boolean loading(ICouponGenerator iCouponGenerator,
                         ConnectorDao connectorDao) throws SQLException;
}
