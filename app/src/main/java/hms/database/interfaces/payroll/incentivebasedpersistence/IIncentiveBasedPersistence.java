/**
 * @author Dhruv Oza
 * @description : This class will connect database to fetch details
 * from doctor table
 */
package hms.database.interfaces.payroll.incentivebasedpersistence;

import hms.configuration.ConnectorDao;

import java.sql.SQLException;

/* IncentiveBasedPersistence will fetch doctor details from database */
public interface IIncentiveBasedPersistence {

  /**
   * Method to fetch all Doctor Details from database
   * @param doctorID as doctorID from database
   * @return true if all data fetched successfully otherwise return false
   * @params connectorDao as object of Connection interface
   */
  public boolean loadHours(int doctorID, ConnectorDao connectorDao)
      throws SQLException;
}
