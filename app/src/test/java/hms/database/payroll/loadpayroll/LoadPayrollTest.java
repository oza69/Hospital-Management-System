/**
 * @author Dhruv Oza
 * @description : Test LoadPayrollTest class
 */
package hms.database.payroll.loadpayroll;

import hms.models.classes.doctor.ages.Age;
import hms.models.interfaces.doctor.ages.IAge;
import hms.database.interfaces.doctor.doctoragepersistence
    .IDoctorAgePersistence;
import hms.models.interfaces.payroll.incentives.IIncentiveBasedPay;
import hms.models.interfaces.payroll.taxwaivers.ITaxWaiver;
import hms.models.interfaces.payroll.totalamounts.ITotalAmount;
import hms.models.classes.payroll.incentives.IncentiveBasedPay;
import hms.database.classes.payroll.loadpayroll.LoadPayroll;
import hms.models.classes.payroll.taxwaivers.TaxWaiver;
import hms.models.classes.payroll.totalamounts.TotalAmount;
import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoadPayrollTest {

  @Test
  @DisplayName("Check whether data is loading into database or not!!")
  public void loadingTest() throws ParseException, SQLException {
    LoadPayroll loadPayroll = new LoadPayroll();
    Date date = null;
    String filterDate = "1996-10-04";
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    date = dateFormatter.parse(filterDate);
    IAge iAge = new Age(date);
    ITotalAmount iTotalAmount = new TotalAmount(20000,
        2000, 3000);
    IIncentiveBasedPay iIncentiveBasedPay = new IncentiveBasedPay(
        25, 30);
    ITaxWaiver iTaxWaiver = new TaxWaiver(2500000);
    IDoctorAgePersistence IDoctorAgePersistence = new hms.database.
        classes.doctor.doctoragepersistence.DoctorAgePersistence(2);
    ConnectorDao connectorDao = new Connector();
    assertNotNull(loadPayroll.loading(iAge, iTotalAmount,
        iIncentiveBasedPay, iTaxWaiver, IDoctorAgePersistence,
        connectorDao), "Data not accurate to be loaded!!");
  }
}
