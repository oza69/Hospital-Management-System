/**
 * @author Vishvesh Bharatbhai Naik
 * @description Revenue Setter, getter
 */
package hms.models.interfaces.revenue.revenue;

import hms.database.interfaces.revenue.revenuepersistence.IRevenuePersistence;

import java.sql.Connection;

public interface IRevenue {

  /**
   * Getter method of fromDate
   * @return fromDate
   */
  String getFromDate();

  /**
   * Setter method of fromDate
   * @param fromDate fromDate
   */
  void setFromDate(String fromDate);

  /**
   * Getter method of toDate
   * @return toDate
   */
  String getToDate();

  /**
   * Setter method of toDate
   * @param toDate toDate
   */
  void setToDate(String toDate);

  /**
   * Getter method of revenueGenerated
   * @return revenueGenerated
   */
  Double getRevenueGenerated();

  /**
   * Setter method of revenueGenerated
   * @param revenueGenerated revenueGenerated
   */
  void setRevenueGenerated(Double revenueGenerated);

  /**
   * This method saves Revenue in the database
   *
   * @param connection
   *         Connection object to perform sql operations
   * @param revenuePersistence
   *         iRevenuePersistence object to interact with revenue table
   * @return True if revenue saved
   */
  boolean saveRevenue(Connection connection, IRevenuePersistence revenuePersistence);
}
