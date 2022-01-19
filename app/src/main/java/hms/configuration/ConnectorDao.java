/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains connector interface which helps to implement
 * connector class for database connection
 */
package hms.configuration;

import java.sql.Connection;

public interface ConnectorDao {

  /**
   * This method will create mysql connection
   * @return connection object
   */
  Connection getConnection();

  /**
   * This method will close mysql connection
   */
  void closeConnection();
}