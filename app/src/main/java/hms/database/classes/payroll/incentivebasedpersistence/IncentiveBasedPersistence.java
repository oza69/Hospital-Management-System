/**
 * @author Dhruv Oza
 * @description : This class will connect database to fetch details
 * from doctor table
 */
package hms.database.classes.payroll.incentivebasedpersistence;

import hms.configuration.ConnectorDao;
import hms.database.interfaces.payroll.incentivebasedpersistence
    .IIncentiveBasedPersistence;
import hms.models.classes.payroll.incentives.IncentiveBasedPay;
import hms.models.interfaces.payroll.incentives.IIncentiveBasedPay;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static hms.constants.CallableStatements.SELECT_HOURS;

public class IncentiveBasedPersistence implements IIncentiveBasedPersistence {

  public boolean loadHours
      (int doctorID, ConnectorDao connectorDao) throws SQLException {
    double workingHours = 0;
    double overtime = 0;
    Connection con = connectorDao.getConnection();
    if (doctorID > 0) {
      CallableStatement cs = con.prepareCall(SELECT_HOURS);
      cs.setInt(1, doctorID);
      ResultSet resultSet = cs.executeQuery();
      while (resultSet.next()) {
        workingHours = resultSet.getDouble(1);
        overtime = resultSet.getDouble(2);
      }
      IIncentiveBasedPay iIncentiveBasedPay =
          new IncentiveBasedPay(workingHours, overtime);
      iIncentiveBasedPay.incentiveCalculation();
      return true;
    } else {
      return false;
    }
  }
}
