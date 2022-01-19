/**
 * @author Vishvesh Bharatbhai Naik
 * @description This file tests all the methods present in Payment Persistence
 *  * which check the data connectivity with database.
 */
package hms.database.payment.paymentpersistence;

import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import hms.database.classes.payment.paymentpersistence.PaymentPersistence;
import hms.database.interfaces.payment.paymentpersistence.IPaymentPersistence;
import hms.models.classes.payment.payment.Payment;
import hms.models.interfaces.payment.payment.IPayment;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PaymentPersistenceTest {

  int patientId = 1;
  Double amount = 50000.0;
  Double discountApplied = 0.15;
  Double finalAmount = 50000.0;
  String paymentStatus = "Paid";
  String paymentMode = "Cash";
  String insuranceApplied = "No";
  String billingDate = "2021-10-01";
  ConnectorDao connector = new Connector();
  Connection connection = connector.getConnection();
  IPaymentPersistence iPayment = new PaymentPersistence();

  /**
   * savePayment method returns false if unable to insert payment record
   */
  @Test
  public void testSavePayment() {
    IPayment payment = new Payment(patientId, amount, paymentMode,
        paymentStatus, discountApplied, insuranceApplied,
        finalAmount, billingDate);
    assertTrue("Case unable to save in the database",
        iPayment.savePayment(payment, connection));
  }

  /**
   * getAllPayment method returns null if any error occurs while
   * fetching payment records
   */
  @Test
  public void testGetAllPayment() {
    assertNotNull("Cases can not be retrieved",
        iPayment.getAllPayment(connection));
  }
}
