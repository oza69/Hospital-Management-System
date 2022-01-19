/*
  @author Dhruv Oza
  @description : This class will load taxWaiver based details from database
*/
package hms.database.interfaces.payroll.taxwaiverpersistence;

import hms.configuration.ConnectorDao;

import java.sql.SQLException;

/* TaxWaiverFromDatabase will fetch revenueID and connectorDao
will connect to database */
public interface ITaxWaiverPersistence {

  /**
   * Loading revenueID from database to get Total Revenue
   * @return totalRevenue
   * @params revenueID as int
   * @params connectorDao as object of ConnectorDao
   */
  public double loadDB(int revenueID, ConnectorDao connectorDao)
      throws SQLException;
}
