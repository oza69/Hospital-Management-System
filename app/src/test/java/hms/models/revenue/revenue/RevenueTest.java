/**
 * @author Vishvesh Bharatbhai Naik
 * @description Testing all the Revenue setter and getters
 */
package hms.models.revenue.revenue;

import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import hms.database.classes.revenue.revenuepersistence.RevenuePersistence;
import hms.database.interfaces.revenue.revenuepersistence.IRevenuePersistence;
import hms.models.classes.revenue.revenue.Revenue;
import hms.models.interfaces.revenue.revenue.IRevenue;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class RevenueTest {

  String fromDate = "2021-01-01";
  String toDate = "2021-02-01";
  double revenueGenerated = 50000;
  ConnectorDao connector = new Connector();
  Connection connection = connector.getConnection();
  IRevenue iRevenue = new Revenue(fromDate, toDate, revenueGenerated);

  /**
   * getFromDate to get from revenue table
   */
  @Test
  public void testGetFromDate() {
    assertNotNull("Patient Full Name is null", iRevenue.getFromDate());
  }

  /**
   * setFromDate to set on revenue table
   */
  @Test
  public void testSetFromDate() {
    String newDate = "2021/01/02";
    iRevenue.setFromDate(newDate);
    assertEquals("Arrival Date not updated", newDate,
        iRevenue.getFromDate());
  }

  /**
   * getToDate to get from revenue table
   */
  @Test
  public void testGetToDate() {
    assertNotNull("Patient Full Name is null", iRevenue.getToDate());
  }

  /**
   * setToDate to set on revenue table
   */
  @Test
  public void testSetToDate() {
    String newDate = "2021/02/02";
    iRevenue.setToDate(newDate);
    assertEquals("Arrival Date not updated", newDate,
        iRevenue.getToDate());
  }

  /**
   * getRevenueGenerated to get from revenue table
   */
  @Test
  public void testGetRevenueGenerated() {
    assertTrue("Revenue generated is null",
        iRevenue.getRevenueGenerated() >= 0);
  }

  /**
   * setRevenueGenerated to set on revenue table
   */
  @Test
  public void testSetRevenueGenerated() {
    Double newAmount = 545.0;
    iRevenue.setRevenueGenerated(newAmount);
    assertEquals("Revenue generated updated", newAmount,
        iRevenue.getRevenueGenerated());
  }

  /**
   * testSaveRevenue will test if the connection is not null when saving
   */
  @Test
  public void testSaveRevenue() {
    IRevenuePersistence iRevenuePersistence = new RevenuePersistence();
    assertNotNull("Revenue Save failed",
        iRevenue.saveRevenue(connection, iRevenuePersistence));
  }
}
