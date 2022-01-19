/**
 * @author Dhruv Oza
 * @description : Test IncentiveBasedPay class
 */
package hms.models.payroll.incentives;

import hms.models.interfaces.payroll.incentives.IIncentiveBasedPay;
import hms.models.classes.payroll.incentives.IncentiveBasedPay;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IncentiveBasedPayTest {

  @Test
  @DisplayName("Checked whether incentive calculation is correct or not!!")
  public void incentiveCollectionTest_1() {
    double workingHours = 3.5;
    double totalWorked = 5;
    IIncentiveBasedPay iIncentiveBasedPay =
        new IncentiveBasedPay(workingHours, totalWorked);
    assertNotNull(iIncentiveBasedPay.incentiveCalculation(),
        "No Incentives as per Hours worked!!");
  }

  @Test
  @DisplayName("Checked whether incentive calculation is correct or not!!")
  public void incentiveCollectionTest_2() {
    double workingHours = 5;
    double totalWorked = 3.5;
    IIncentiveBasedPay iIncentiveBasedPay =
        new IncentiveBasedPay(workingHours, totalWorked);
    assertNotNull(iIncentiveBasedPay.incentiveCalculation(),
        "Incentives not added as per worked hours!!");
  }

  @Test
  @DisplayName("Check whether setWorkingHours is working or not!!")
  public void setWorkingHoursTest() {
    double workingHours = 5;
    double totalWorked = 3.5;
    IIncentiveBasedPay iIncentiveBasedPay =
        new IncentiveBasedPay(workingHours, totalWorked);
    iIncentiveBasedPay.setWorkingHours(workingHours);
    assertEquals(iIncentiveBasedPay.getWorkingHours(),
        workingHours, "Working hours not matched!!");
  }

  @Test
  @DisplayName("Check whether getWorkingHours is working or not!!")
  public void getWorkingHoursTest() {
    double workingHours = -5;
    double totalWorked = 3.5;
    IIncentiveBasedPay iIncentiveBasedPay =
        new IncentiveBasedPay(workingHours, totalWorked);
    iIncentiveBasedPay.setWorkingHours(workingHours);
    assertFalse(iIncentiveBasedPay.getWorkingHours() >= 0,
        "Working hours not matched!!");
  }

  @Test
  @DisplayName("Check whether setWorkingHours is working or not!!")
  public void settotalWorkedTest() {
    double workingHours = 5;
    double totalWorked = 3.5;
    IIncentiveBasedPay iIncentiveBasedPay =
        new IncentiveBasedPay(workingHours, totalWorked);
    iIncentiveBasedPay.setTotalWorked(totalWorked);
    assertEquals(iIncentiveBasedPay.getTotalWorked(),
        totalWorked, "Total Worked hours not matched!!");
  }

  @Test
  @DisplayName("Check whether getWorkingHours is working or not!!")
  public void gettotalWorkedTest() {
    double workingHours = 5;
    double totalWorked = -3.5;
    IIncentiveBasedPay iIncentiveBasedPay =
        new IncentiveBasedPay(workingHours, totalWorked);
    iIncentiveBasedPay.setTotalWorked(totalWorked);
    assertFalse(iIncentiveBasedPay.getTotalWorked() >= 0,
        "Total Worked hours not matched!!");
  }

  @Test
  @DisplayName("Check whether workingHours and totalWorked are 0 or not!!")
  public void isValidTest_1() {
    IIncentiveBasedPay iIncentiveBasedPay =
        new IncentiveBasedPay(1, -1);
    assertFalse(iIncentiveBasedPay.isValid());
  }

  @Test
  @DisplayName("Check whether workingHours and totalWorked are 0 or not!!")
  public void isValidTest_2() {
    IIncentiveBasedPay iIncentiveBasedPay =
        new IncentiveBasedPay(-1, 1);
    assertFalse(iIncentiveBasedPay.isValid());
  }

  @Test
  @DisplayName("Check whether workingHours and totalWorked are 0 or not!!")
  public void isValidTest_3() {
    IIncentiveBasedPay iIncentiveBasedPay =
        new IncentiveBasedPay(-1, -1);
    assertFalse(iIncentiveBasedPay.isValid());
  }

  @Test
  @DisplayName("Check whether workingHours and totalWorked are 0 or not!!")
  public void isValidTest_4() {
    IIncentiveBasedPay iIncentiveBasedPay =
        new IncentiveBasedPay(1, 1);
    assertTrue(iIncentiveBasedPay.isValid());
  }
}
