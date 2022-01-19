/**
 * @author Eklavya Nautiyal
 * @description Creating CouponPersistenceTest class to run test cases
 */
package hms.database.packageandcoupons.coupons;

import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import hms.database.classes.packageandcoupons.coupons.CouponsPersistence;
import hms.database.interfaces.packageandcoupons.coupons.ICouponsPersistence;
import hms.models.classes.packageandcoupons.coupons.Coupons;
import hms.models.interfaces.packageandcoupons.coupons.ICoupons;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CouponsPersistenceTest {

  /**
   * Initializing common variables and objects
   */
  private int couponID = 116;
  private String couponCode = "C1";
  private Double couponDiscount = 5.0;
  ConnectorDao connector = new Connector();
  Connection connection = connector.getConnection();
  ICouponsPersistence couponPersistence = new CouponsPersistence();

  /**
   * getAllCoupons method returns null if any error occurs while fetching case
   * records
   */
  @Test
  public void testGetAllCoupons() {

    assertNotNull("Coupons can not be retrieved",
        couponPersistence.getAllCoupons(connection));

  }

  /**
   * saveCoupons method returns false if unable to insert case record
   */
  @Test
  public void testSaveCoupon() {

    ICoupons newCoupon = new Coupons(couponCode, couponDiscount);
    assertTrue("Coupon unable to save in the database",
        couponPersistence.saveCoupon(newCoupon, connection));
  }

  /**
   * update coupon test case
   */
  @Test
  public void testUpdateCoupon() {
    assertTrue("Coupon unable to save in the database",
        couponPersistence.updateCoupon(couponID, couponCode, couponDiscount,
            connection));
  }
}
