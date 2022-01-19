/**
 * @author Vishvesh Bharatbhai Naik
 * @description This file tests all the methods present in Revenue Persistence
 * which check the data connectivity with database.
 */
package hms.database.revenue.revenuepersistence;

import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import hms.database.classes.revenue.revenuepersistence.RevenuePersistence;
import hms.database.interfaces.revenue.revenuepersistence.IRevenuePersistence;
import hms.models.classes.revenue.revenue.Revenue;
import hms.models.interfaces.revenue.revenue.IRevenue;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RevenuePersistenceTest {

  String fromDate = "2021-01-01";
  String toDate = "2021-02-01";
  Double revenueGenerated = 500.0;
  ConnectorDao connector = new Connector();
  Connection connection = connector.getConnection();
  IRevenuePersistence revenue = new RevenuePersistence();

  /**
   * saveRevenue method returns false if unable to insert Revenue
   */
  @Test
  public void testSaveRevenue() {
    IRevenue iRevenue = new Revenue(fromDate, toDate, revenueGenerated);
    assertTrue("Patients unable to save in the database",
        revenue.saveRevenue(iRevenue, connection));
  }

  /**
   * getAllRevenue method returns null if any error occurs
   * while fetching Revenue records
   */
  @Test
  public void testGetAllRevenue() {
    assertNotNull("Patients can not be retrieved", revenue
        .getAllRevenue(connection));
  }
}
