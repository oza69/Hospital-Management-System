/**
 * @author Vishvesh Bharatbhai Naik
 * @description Revenue persistence will show and insert revenue generated
 * from database
 */
package hms.database.classes.revenue.revenuepersistence;

import hms.database.interfaces.revenue.revenuepersistence.IRevenuePersistence;
import hms.models.interfaces.revenue.revenue.IRevenue;

import java.sql.*;

import static hms.constants.CallableStatements.INSERT_REVENUE;
import static hms.constants.CallableStatements.SELECT_REVENUE;

public class RevenuePersistence implements IRevenuePersistence {

  @Override
  public boolean saveRevenue(IRevenue iRevenue, Connection connection) {
    try {
      PreparedStatement statement = connection.prepareStatement(INSERT_REVENUE);
      statement.setDate(1, Date.valueOf(iRevenue.getFromDate()));
      statement.setDate(2, Date.valueOf(iRevenue.getToDate()));
      statement.setDouble(3, iRevenue.getRevenueGenerated());
      statement.executeUpdate();
      statement.close();
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public ResultSet getAllRevenue(Connection connection) {
    try {
      PreparedStatement statement = connection.prepareCall(SELECT_REVENUE);
      return statement.executeQuery();
    } catch (Exception e) {
      return null;
    }
  }
}
