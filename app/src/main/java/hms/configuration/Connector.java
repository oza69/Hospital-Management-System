/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains connector class which handles database
 * connection in singleton pattern
 */
package hms.configuration;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector implements ConnectorDao {

  private static Connection connection;

  static {
    String configFile =
        "config.properties";  // File path of the database configuration file
    String DB_URL;            // Database url
    String DB_EVN;            // Database name
    String DB_USER;           // Database username
    String DB_PASSWORD;       // Database password
    try {
      /* Reading database configurations from .properties file */
      FileReader reader = new FileReader(configFile);
      Properties properties = new Properties();
      properties.load(reader);
      DB_URL = properties.getProperty("DB_URL");
      DB_EVN = properties.getProperty("DB_ENV");
      DB_USER = properties.getProperty("DB_USER");
      DB_PASSWORD = properties.getProperty("DB_PASSWORD");
      reader.close();
      /* Creating a mysql connection with the above database configuration */
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection =
          DriverManager
              .getConnection("jdbc:mysql://" + DB_URL + ":3306/" + DB_EVN,
                  DB_USER, DB_PASSWORD);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * This method creates connection with database
   * @return Connection object
   */
  @Override
  public Connection getConnection() {
    return connection;
  }

  /**
   * This method will close mysql connection
   */
  @Override
  public void closeConnection() {
    try {
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}