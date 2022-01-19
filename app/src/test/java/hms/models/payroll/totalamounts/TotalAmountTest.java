/**
 * @author Dhruv Oza
 * @description : Test TotalAmount class
 */
package hms.models.payroll.totalamounts;

import hms.models.interfaces.payroll.incentives.IIncentiveBasedPay;
import hms.models.interfaces.payroll.totalamounts.ITotalAmount;
import hms.models.classes.payroll.incentives.IncentiveBasedPay;
import hms.models.classes.payroll.totalamounts.TotalAmount;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TotalAmountTest {

  @Test
  @DisplayName("Check whether total amount returned is correct or not!!")
  public void calculateTotalAmountTest() {
    IIncentiveBasedPay iIncentiveBasedPay =
        new IncentiveBasedPay(10, 20);
    ITotalAmount iTotalAmount =
        new TotalAmount(10000, 2000,
            2000);
    iTotalAmount.calculateTotalAmount(iIncentiveBasedPay);
    assertNotNull(iTotalAmount.calculateTotalAmount(iIncentiveBasedPay),
        "Output as not expected!!");
  }

  @Test
  @DisplayName("Check whether amount is 0 or not!!")
  public void setAmountTest() {
    double amount = 120.20;
    double pendingAmount = 20.25;
    double profitSharingIncentive = 30.25;
    ITotalAmount iTotalAmount =
        new TotalAmount(amount, pendingAmount, profitSharingIncentive);
    iTotalAmount.setAmount(amount);
    assertEquals(iTotalAmount.getAmount(),
        amount, "amount not match!!");
  }

  @Test
  @DisplayName("Check whether amount is 0 or not!!")
  public void getAmountTest() {
    double amount = 120.20;
    double pendingAmount = 20.25;
    double profitSharingIncentive = 30.25;
    ITotalAmount iTotalAmount =
        new TotalAmount(amount, pendingAmount, profitSharingIncentive);
    iTotalAmount.setAmount(amount);
    assertTrue(iTotalAmount.getAmount() >= 0,
        "amount not match!!");
  }

  @Test
  @DisplayName("Check whether pendingAmount is 0 or not!!")
  public void setPendingAmountTest() {
    double amount = 120.20;
    double pendingAmount = 20.25;
    double profitSharingIncentive = 30.25;
    ITotalAmount iTotalAmount =
        new TotalAmount(amount, pendingAmount, profitSharingIncentive);
    iTotalAmount.setPendingAmount(pendingAmount);
    assertEquals(iTotalAmount.getPendingAmount(),
        pendingAmount, "pendingAmount not match!!");
  }

  @Test
  @DisplayName("Check whether pendingAmount is 0 or not!!")
  public void getPendingAmountTest() {
    double amount = 120.20;
    double pendingAmount = 20.25;
    double profitSharingIncentive = 30.25;
    ITotalAmount iTotalAmount =
        new TotalAmount(amount, pendingAmount, profitSharingIncentive);
    iTotalAmount.setPendingAmount(pendingAmount);
    assertTrue(iTotalAmount.getPendingAmount() >= 0,
        "pendingAmount not match!!");
  }

  @Test
  @DisplayName("Check whether profitSharingIncentive is 0 or not!!")
  public void setProfitSharingIncentiveTest() {
    double amount = 120.20;
    double pendingAmount = 20.25;
    double profitSharingIncentive = 30.25;
    ITotalAmount iTotalAmount =
        new TotalAmount(amount, pendingAmount, profitSharingIncentive);
    iTotalAmount.setProfitSharingIncentive(profitSharingIncentive);
    assertEquals(iTotalAmount.getProfitSharingIncentive(),
        profitSharingIncentive,
        "profitSharingIncentive not match!!");
  }

  @Test
  @DisplayName("Check whether profitSharingIncentive is 0 or not!!")
  public void getProfitSharingIncentiveTest() {
    double amount = 120.20;
    double pendingAmount = 20.25;
    double profitSharingIncentive = 30.25;
    ITotalAmount iTotalAmount =
        new TotalAmount(amount, pendingAmount, profitSharingIncentive);
    iTotalAmount.setProfitSharingIncentive(profitSharingIncentive);
    assertTrue(iTotalAmount.getProfitSharingIncentive() >= 0,
        "profitSharingIncentive not match!!");
  }
}
