/**
 * @author Vishvesh Bharatbhai Naik
 * @description Revenue persistence will show and insert revenue generated
 * from database
 */
package hms.database.interfaces.revenue.revenuepersistence;

import hms.models.interfaces.revenue.revenue.IRevenue;

import java.sql.Connection;
import java.sql.ResultSet;

public interface IRevenuePersistence {

  /**
   * This method helps to insert record in REVENUE table
   * @param iRevenue Revenue object to store in table
   * @param connection Connection object to handle database connection
   * @return True if data is stored successfully into REVENUE table
   */
  boolean saveRevenue(IRevenue iRevenue, Connection connection);

  /**
   * This method helps to retrieve all records in REVENUE table
   * @param connection Connection object to handle database connection
   * @return ResultSet of data if retrieved successfully from the REVENUE table,
   * else return null
   */
  ResultSet getAllRevenue(Connection connection);
}
