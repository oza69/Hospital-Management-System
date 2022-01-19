/**
 * @author Dhruv Oza
 * @description : Test TaxWaiver class
 */
package hms.models.payroll.taxwaivers;

import hms.models.classes.doctor.ages.Age;
import hms.models.interfaces.doctor.ages.IAge;
import hms.models.interfaces.payroll.incentives.IIncentiveBasedPay;
import hms.models.interfaces.payroll.taxwaivers.ITaxWaiver;
import hms.models.classes.payroll.incentives.IncentiveBasedPay;
import hms.models.classes.payroll.taxwaivers.TaxWaiver;
import hms.models.classes.payroll.totalamounts.TotalAmount;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaxWaiverTest {

  @Test
  @DisplayName("Check whether totalRevenue is 0 or not!!")
  public void setTotalRevenueTest() throws ParseException {
    double totalRevenue = 1;
    ITaxWaiver iTaxWaiver = new TaxWaiver(totalRevenue);
    iTaxWaiver.setTotalRevenue(totalRevenue);
    assertEquals(iTaxWaiver.getTotalRevenue(), totalRevenue,
        "totalRevenue not match!!");
  }

  @Test
  @DisplayName("Check whether totalRevenue is 0 or not!!")
  public void getTotalRevenueTest() throws ParseException {
    double totalRevenue = -1;
    ITaxWaiver iTaxWaiver = new TaxWaiver(totalRevenue);
    iTaxWaiver.setTotalRevenue(totalRevenue);
    assertFalse(iTaxWaiver.getTotalRevenue() >= 0,
        "totalRevenue not match!!");
  }

  @Test
  @DisplayName("Check whether Tax Waived or not for age below 45 years!!")
  public void taxSetupTest_1() throws ParseException {
    double totalRevenue = 45000.23;
    ITaxWaiver iTaxWaiver = new TaxWaiver(totalRevenue);
    Date birthDate = null;
    String filterDate = "2002-07-31";
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    birthDate = dateFormatter.parse(filterDate);
    IAge iAge = new Age(birthDate);
    iAge.ageCalculate();
    assertNotNull(iTaxWaiver.taxSetup(iAge), "Tax waived!!");
  }

  @Test
  @DisplayName("Check whether Tax Waived or not for age " +
      "above 45 years and below 60!!")
  public void taxSetupTest_2() throws ParseException {
    double totalRevenue = 45000.23;
    ITaxWaiver iTaxWaiver = new TaxWaiver(totalRevenue);
    Date birthDate = null;
    String filterDate = "1970-07-31";
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    birthDate = dateFormatter.parse(filterDate);
    IAge iAge = new Age(birthDate);
    iAge.ageCalculate();
    assertNotNull(iTaxWaiver.taxSetup(iAge),
        "Tax waived more as expected!!");
  }

  @Test
  @DisplayName("Check whether Tax Waived or not for age above 60 years!!")
  public void taxSetupTest_3() throws ParseException {
    double totalRevenue = 45000.23;
    ITaxWaiver iTaxWaiver = new TaxWaiver(totalRevenue);
    Date birthDate = null;
    String filterDate = "1947-07-31";
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    birthDate = dateFormatter.parse(filterDate);
    IAge iAge = new Age(birthDate);
    iAge.ageCalculate();
    assertNotNull(iTaxWaiver.taxSetup(iAge),
        "Tax waived more as expected!!");
  }

  @Test
  @DisplayName("Check whether Tax Waived amount deducted " +
      "from total revenue for age above 60 years!!")
  public void taxDeducted_1() throws ParseException {
    double totalRevenue = 45000.23;
    ITaxWaiver iTaxWaiver = new TaxWaiver(totalRevenue);
    Date birthDate = null;
    String filterDate = "1947-07-31";
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    birthDate = dateFormatter.parse(filterDate);
    IAge iAge = new Age(birthDate);
    iAge.ageCalculate();
    iTaxWaiver.taxSetup(iAge);
    IIncentiveBasedPay iIncentiveBasedPay =
        new IncentiveBasedPay(10, 20);
    TotalAmount totalAmount =
        new TotalAmount(10000, 2000,
            2000);
    totalAmount.calculateTotalAmount(iIncentiveBasedPay);
    assertNotNull(iTaxWaiver.taxDeducted(totalAmount, iIncentiveBasedPay),
        "Tax waived amount deducted more as expected!!");
  }

  @Test
  @DisplayName("Check whether Tax Waived amount deducted from " +
      "total revenue for age between 45 to 60 years!!")
  public void taxDeducted_2() throws ParseException {
    double totalRevenue = 45000.23;
    ITaxWaiver iTaxWaiver = new TaxWaiver(totalRevenue);
    Date birthDate = null;
    String filterDate = "1970-07-31";
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    birthDate = dateFormatter.parse(filterDate);
    IAge iAge = new Age(birthDate);
    iAge.ageCalculate();
    iTaxWaiver.taxSetup(iAge);
    IIncentiveBasedPay iIncentiveBasedPay =
        new IncentiveBasedPay(10, 20);
    TotalAmount totalAmount =
        new TotalAmount(10000, 2000,
            2000);
    totalAmount.calculateTotalAmount(iIncentiveBasedPay);
    assertNotNull(iTaxWaiver.taxDeducted(totalAmount, iIncentiveBasedPay),
        "Tax waived amount deducted more as expected!!");
  }

  @Test
  @DisplayName("Check whether Tax Waived amount deducted from " +
      "total revenue for age below 45 years!!")
  public void taxDeducted_3() throws ParseException {
    double totalRevenue = 45000.23;
    ITaxWaiver iTaxWaiver = new TaxWaiver(totalRevenue);
    Date birthDate = null;
    String filterDate = "2002-07-31";
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    birthDate = dateFormatter.parse(filterDate);
    IAge iAge = new Age(birthDate);
    iAge.ageCalculate();
    iTaxWaiver.taxSetup(iAge);
    IIncentiveBasedPay iIncentiveBasedPay =
        new IncentiveBasedPay(10, 20);
    TotalAmount totalAmount =
        new TotalAmount(10000, 2000,
            2000);
    totalAmount.calculateTotalAmount(iIncentiveBasedPay);
    assertNotNull(iTaxWaiver.taxDeducted(totalAmount, iIncentiveBasedPay),
        "Tax waived amount deducted more as expected!!");
  }

  @Test
  @DisplayName("Check whether totalRevenue is 0 or not!!")
  public void isValidTest_1() {
    ITaxWaiver iTaxWaiver = new TaxWaiver(-1);
    assertFalse(iTaxWaiver.isValid());
  }

  @Test
  @DisplayName("Check whether totalRevenue is 0 or not!!")
  public void isValidTest_2() {
    ITaxWaiver iTaxWaiver = new TaxWaiver(1);
    assertTrue(iTaxWaiver.isValid());
  }
}
