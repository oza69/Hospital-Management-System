/**
 * @author Dhruv Oza
 * @description : This class will load all payroll details into database
 */
package hms.database.classes.payroll.loadpayroll;

import hms.database.interfaces.payroll.loadpayroll.ILoadPayroll;
import hms.configuration.ConnectorDao;
import hms.database.interfaces.doctor.doctoragepersistence.
    IDoctorAgePersistence;
import hms.models.interfaces.doctor.ages.IAge;
import hms.models.interfaces.payroll.incentives.IIncentiveBasedPay;
import hms.models.interfaces.payroll.taxwaivers.ITaxWaiver;
import hms.models.interfaces.payroll.totalamounts.ITotalAmount;

import static hms.constants.CallableStatements.UPDATE_PAYROLL_DETAILS;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class LoadPayroll implements ILoadPayroll {

  public boolean loading(IAge iAge, ITotalAmount iTotalAmount,
                         IIncentiveBasedPay iIncentiveBasedPay,
                         ITaxWaiver iTaxWaiver,
                         IDoctorAgePersistence IDoctorAgePersistence,
                         ConnectorDao connectorDao) throws SQLException {
    try {
      int doctor = IDoctorAgePersistence.getDoctorID();
      int years = IDoctorAgePersistence.loadDB(connectorDao);
      double amount = iTotalAmount.getAmount();
      double pendingAmount = iTotalAmount.getPendingAmount();
      double profitSharingIncentive = iTotalAmount.getProfitSharingIncentive();
      double incentives = iIncentiveBasedPay.incentiveCalculation();
      double totalWorked = iIncentiveBasedPay.getTotalWorked();
      double totalValue = iTotalAmount.calculateTotalAmount(iIncentiveBasedPay);
      double taxDeducted = iTaxWaiver.taxSetup(iAge);
      Connection con = connectorDao.getConnection();
      CallableStatement cs = con.prepareCall(UPDATE_PAYROLL_DETAILS);
      cs.setInt(1, doctor);
      cs.setDouble(2, amount);
      cs.setInt(3, years);
      cs.setDouble(4, totalWorked);
      cs.setDouble(5, pendingAmount);
      cs.setDouble(6, incentives);
      cs.setDouble(7, profitSharingIncentive);
      cs.setDouble(8, taxDeducted);
      cs.setDouble(9, totalValue);
      cs.execute();
      return true;
    } catch (SQLException e) {
      return false;
    }
  }
}
