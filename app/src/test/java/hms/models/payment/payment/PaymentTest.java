/**
 * @author Vishvesh Bharatbhai Naik
 * @description Testing all the Payment setter and getters
 */
package hms.models.payment.payment;

import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import hms.database.classes.payment.paymentpersistence.PaymentPersistence;
import hms.database.interfaces.payment.paymentpersistence.IPaymentPersistence;
import hms.models.classes.payment.payment.Payment;
import hms.models.interfaces.payment.payment.IPayment;
import org.junit.Test;


import java.sql.Connection;

import static org.junit.Assert.*;

public class PaymentTest {

  int patientId = 1;
  double amount = 50000.0;
  double discountApplied = 0.15;
  double finalAmount = 50000.0;
  String paymentStatus = "Paid";
  String paymentMode = "Cash";
  String insuranceApplied = "No";
  String billingDate = "2021-10-01";
  ConnectorDao connector = new Connector();
  Connection connection = connector.getConnection();
  IPayment payment = new Payment(patientId, amount, paymentMode,
      paymentStatus, discountApplied, insuranceApplied,
      finalAmount, billingDate);

  /**
   * getPatientId to get from Patient table
   */
  @Test
  public void testGetPatientId() {
    assertTrue("Patient id is not valid",
        payment.getPatientId() >= 0);
  }

  /**
   * setPatientId to set into Patient table
   */
  @Test
  public void testSetPatientId() {
    int newPatient = 1;
    payment.setPatientId(newPatient);
    assertEquals("Patient id not updated", newPatient,
        payment.getPatientId());
  }

  /**
   * getAmount to get from Patient table
   */
  @Test
  public void testGetAmount() {
    assertTrue("Amount is not valid",
        payment.getAmount() >= 0);
  }

  /**
   * setAmount to set into Patient table
   */
  @Test
  public void testSetAmount() {
    Double newAmount = 4512.0;
    payment.setAmount(newAmount);
    assertEquals("Amount not updated", newAmount, payment.getAmount());
  }

  /**
   * getPaymentMode to get from Patient table
   */
  @Test
  public void testGetPaymentMode() {
    assertNotNull("Payment Mode is not valid", payment.getPaymentMode());
  }

  /**
   * setPaymentMode to set into Patient table
   */
  @Test
  public void testSetPaymentMode() {
    String newPayment = "Cash";
    payment.setPaymentMode(newPayment);
    assertEquals("Payment Mode not updated", newPayment,
        payment.getPaymentMode());
  }

  /**
   * getPaymentStatus to get from Patient table
   */
  @Test
  public void testGetPaymentStatus() {
    assertNotNull("Payment Status is not valid",
        payment.getPaymentStatus());
  }

  /**
   * setPaymentStatus to set into Patient table
   */
  @Test
  public void testSetPaymentStatus() {
    String newPayment = "Cash";
    payment.setPaymentStatus(newPayment);
    assertEquals("Payment Status not updated", newPayment,
        payment.getPaymentStatus());
  }

  /**
   * getDiscountApplied to get from Patient table
   */
  @Test
  public void testGetDiscountApplied() {
    assertTrue("Discount Applied is not valid",
        payment.getDiscountApplied() >= 0);
  }

  /**
   * setDiscountApplied to set into Patient table
   */
  @Test
  public void testSetDiscountApplied() {
    Double newDiscount = 0.15;
    payment.setDiscountApplied(newDiscount);
    assertEquals("Discount Applied not updated", newDiscount,
        payment.getDiscountApplied());
  }

  /**
   * getInsuranceApplied to get from Patient table
   */
  @Test
  public void testGetInsuranceApplied() {
    assertNotNull("Insurance Applied is not valid",
        payment.getInsuranceApplied());
  }

  /**
   * setInsuranceApplied to set into Patient table
   */
  @Test
  public void testSetInsuranceApplied() {
    String newInsurance = "Yes";
    payment.setInsuranceApplied(newInsurance);
    assertEquals("Insurance Applied not updated", newInsurance,
        payment.getInsuranceApplied());
  }

  /**
   * getFinalAmount to get from Patient table
   */
  @Test
  public void testGetFinalAmount() {
    assertTrue("Final Amount is not valid",
        payment.getFinalAmount() >= 0);
  }

  /**
   * setFinalAmount to set into Patient table
   */
  @Test
  public void testSetFinalAmount() {
    Double newFinalAmount = 0.15;
    payment.setFinalAmount(newFinalAmount);
    assertEquals("Final Amount not updated", newFinalAmount,
        payment.getFinalAmount());
  }

  /**
   * getBillingDate to get from Patient table
   */
  @Test
  public void testGetBillingDate() {
    assertNotNull("BillingDate is not valid",
        payment.getBillingDate());
  }

  /**
   * setBillingDate to set into Patient table
   */
  @Test
  public void testSetBillingDate() {
    String newBillDate = "2021-02-01";
    payment.setBillingDate(newBillDate);
    assertEquals("BillingDate not updated", newBillDate,
        payment.getBillingDate());
  }

  /**
   * testSavePayment will test if the connection is not null when saving
   */
  @Test
  public void testSavePayment() {
    IPaymentPersistence iPaymentPersistence = new PaymentPersistence();
    assertNotNull("",
        payment.savePayment(connection, iPaymentPersistence));
  }
}