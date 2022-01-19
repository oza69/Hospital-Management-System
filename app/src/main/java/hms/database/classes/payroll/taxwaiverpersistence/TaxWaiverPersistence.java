/**
 * @author Dhruv Oza
 * @description : This class will fetch totalRevenue from database
 * based on revenueID
 */
package hms.database.classes.payroll.taxwaiverpersistence;

import hms.database.interfaces.payroll.taxwaiverpersistence
    .ITaxWaiverPersistence;
import hms.configuration.ConnectorDao;
import hms.models.classes.payroll.taxwaivers.TaxWaiver;
import hms.models.interfaces.payroll.taxwaivers.ITaxWaiver;

import static hms.constants.CallableStatements.INSERT_SPECIFIC_REVENUE;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaxWaiverPersistence implements ITaxWaiverPersistence {

  @Override
  public double loadDB(int revenueID, ConnectorDao connectorDao)
      throws SQLException {
    Double totalRevenue = null;
    if (revenueID > 0) {
      Connection con = connectorDao.getConnection();
      CallableStatement cs = con.prepareCall(INSERT_SPECIFIC_REVENUE);
      cs.setInt(1, revenueID);
      ResultSet resultSet = cs.executeQuery();
      while (resultSet.next()) {
        totalRevenue = resultSet.getDouble(1);
      }
      ITaxWaiver iTaxWaiver = new TaxWaiver(totalRevenue);
      return iTaxWaiver.getTotalRevenue();
    } else {
      return 0;
    }
  }
}
