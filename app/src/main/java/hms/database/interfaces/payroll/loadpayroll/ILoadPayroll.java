/**
 * @author Dhruv Oza
 * @description : This class will load all payroll details in
 * database after calculating
 */
package hms.database.interfaces.payroll.loadpayroll;

import hms.configuration.ConnectorDao;
import hms.database.interfaces.doctor.doctoragepersistence
    .IDoctorAgePersistence;
import hms.models.interfaces.doctor.ages.IAge;
import hms.models.interfaces.payroll.incentives.IIncentiveBasedPay;
import hms.models.interfaces.payroll.taxwaivers.ITaxWaiver;
import hms.models.interfaces.payroll.totalamounts.ITotalAmount;

import java.sql.SQLException;

/* LoadPayroll will load all values into database */
public interface ILoadPayroll {

  /**
   * Uploading all calculated values into database
   * @param iAge object to get age for taxsetup
   * @param iTotalAmount object to get all amounts calculated
   * @param iIncentiveBasedPay object to get calculated incentives
   * @param iTaxWaiver object to get tax setup according to age
   * @param IDoctorAgePersistence object to get doctorID
   * @param connectorDao object to handle database connection
   * @return true if all values are uploaded successfully
   */
  public boolean loading(IAge iAge, ITotalAmount iTotalAmount,
                         IIncentiveBasedPay iIncentiveBasedPay,
                         ITaxWaiver iTaxWaiver,
                         IDoctorAgePersistence IDoctorAgePersistence,
                         ConnectorDao connectorDao) throws SQLException;
}
