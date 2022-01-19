/**
 * @author Eklavya Nautiyal
 * @description Creating PayrollTest class to run test cases
 */
package hms.models.payroll.payroll;

import hms.models.classes.payroll.payroll.Payroll;
import hms.models.interfaces.payroll.payroll.IPayroll;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class PayrollTest {

  /**
   * Initializing common variables and objects
   */
  private int doctorID = 1;
  private Double amount = 50000.0;
  private int age = 45;
  private Double attendance = 9.0;
  private Double pendingAmount = 200.0;
  private Double overtimeAmount = 500.0;
  private Double profitIncentive = 600.0;
  private Double taxDeducted = 500.0;
  private Double totalAmount = 100000.0;
  IPayroll myPayroll =
      new Payroll(doctorID, amount, age, attendance, pendingAmount,
          overtimeAmount, profitIncentive, taxDeducted, totalAmount);

  /**
   * getAmount method returns the DOc ID amount
   */
  @Test
  public void testGetDoctorID() {
    assertTrue("Doc ID is not valid",
        myPayroll.getDoctorID() >= 0);
  }

  /**
   * set doctor test
   */
  @Test
  public void testSetDoctorID() {
    int doctorID = 2;
    myPayroll.setDoctorID(doctorID);
    assertEquals("Doc id not updated",
        doctorID, myPayroll.getDoctorID());
  }

  /**
   * getAmount method returns the amount
   */
  @Test
  public void testGetAmount() {
    assertTrue("Amount is not valid",
        myPayroll.getAmount() >= 0);
  }

  /**
   * getDate method returns the Case date
   */
  @Test
  public void testSetAmount() {
    Double amount = 45000.0;
    myPayroll.setAmount(amount);
    assertEquals("amounnt is not set", amount, myPayroll.getAmount());
  }

  /**
   * getAge method returns the doc age
   */
  @Test
  public void testGetAge() {
    assertTrue("Age is not valid", myPayroll.getAge() >= 0);
  }

  /**
   * setAge method returns doc age
   */
  @Test
  public void testSetAge() {
    int age = 10;
    myPayroll.setAge(age);
    assertEquals("Age is not set", age, myPayroll.getAge());
  }

  /**
   * getAttendance method returns doc attendance
   */
  @Test
  public void testGetAttendence() {
    assertTrue("Attendance is not valid",
        myPayroll.getAttendence() >= 0);
  }

  /**
   * setAttendance method sets doc attendance
   */
  @Test
  public void testSetAttendance() {
    Double attendance = 10.0;
    myPayroll.setAttendence(attendance);
    assertEquals("Attendance is not set", attendance,
        myPayroll.getAttendence());
  }

  /**
   * getPendingAmount method returns doc PendingAmount
   */
  @Test
  public void testGetPendingAmount() {
    assertTrue("Pending amount is not valid",
        myPayroll.getPendingAmount() >= 0);
  }

  /**
   * setPendingAmount method sets doc PendingAmount
   */
  @Test
  public void testSetPendingAmount() {
    Double pendingamt = 10.0;
    myPayroll.setPendingAmount(pendingamt);
    assertEquals("Pending amount is not set", pendingamt,
        myPayroll.getPendingAmount());
  }

  /**
   * getOvertimeAmount method returns doc OvertimeAmount
   */
  @Test
  public void testGetOvertimeAmount() {
    assertTrue("Overtime amount amount is not valid",
        myPayroll.getOvertimeAmount() >= 0);
  }

  /**
   * setOvertimeAmount method sets doc OvertimeAmount
   */
  @Test
  public void testSetOvertimeAmount() {
    Double OvertimeAmount = 10.0;
    myPayroll.setOvertimeAmount(OvertimeAmount);
    assertEquals("Overtime amount is not set", OvertimeAmount,
        myPayroll.getOvertimeAmount());
  }

  /**
   * getProfitIncentive method returns doc ProfitIncentive
   */
  @Test
  public void testGetProfitIncentive() {
    assertTrue("Profit is not valid",
        myPayroll.getProfitIncentive() >= 0);
  }

  /**
   * setProfitIncentive method sets doc ProfitIncentive
   */
  @Test
  public void testSetProfitIncentive() {
    Double profits = 10.0;
    myPayroll.setProfitIncentive(profits);
    assertEquals("Profit is not set", profits,
        myPayroll.getProfitIncentive());
  }

  /**
   * getTaxDeducted method returns doc TaxDeducted
   */
  @Test
  public void testGetTaxDeducted() {
    assertTrue("Tax is not valid",
        myPayroll.getTaxDeducted() >= 0);
  }

  /**
   * setTaxDeducted method sets doc TaxDeducted
   */
  @Test
  public void testSetTaxDeducted() {
    Double tax = 10.0;
    myPayroll.setTaxDeducted(tax);
    assertEquals("Tax is not set", tax, myPayroll.getTaxDeducted());
  }

  /**
   * getTotalAmount method returns doc TotalAmount
   */
  @Test
  public void testGetTotalAmount() {
    assertTrue("TotalAmount is not valid",
        myPayroll.getTotalAmount() >= 0);
  }

  /**
   * setTaxDeducted method sets doc TaxDeducted
   */
  @Test
  public void testSetTotalAmount() {
    Double amt = 10.0;
    myPayroll.setTotalAmount(amt);
    assertEquals("TotalAmount is not set", amt,
        myPayroll.getTotalAmount());
  }
}