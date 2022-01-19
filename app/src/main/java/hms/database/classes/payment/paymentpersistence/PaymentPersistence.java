/**
 * @author Vishvesh Bharatbhai Naik
 * @description Payment Persistence will insert and get all values
 * from the database
 */
package hms.database.classes.payment.paymentpersistence;

import hms.database.interfaces.payment.paymentpersistence.IPaymentPersistence;
import hms.models.interfaces.payment.payment.IPayment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static hms.constants.CallableStatements.INSERT_PAYMENT;
import static hms.constants.CallableStatements.SELECT_PAYMENT;

public class PaymentPersistence implements IPaymentPersistence {

  @Override
  public boolean savePayment(IPayment iPayment, Connection connection) {
    try {
      PreparedStatement statement = connection.prepareStatement(INSERT_PAYMENT);
      statement.setInt(1, iPayment.getPatientId());
      statement.setDouble(2, iPayment.getAmount());
      statement.setString(3, iPayment.getPaymentMode());
      statement.setString(4, iPayment.getPaymentStatus());
      statement.setDouble(5, iPayment.getDiscountApplied());
      statement.setString(6, iPayment.getInsuranceApplied());
      statement.setDouble(7, iPayment.getFinalAmount());
      statement.setDate(8, Date.valueOf(iPayment.getBillingDate()));
      statement.executeUpdate();
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public ResultSet getAllPayment(Connection connection) {
    try {
      PreparedStatement statement = connection.prepareCall(SELECT_PAYMENT);
      return statement.executeQuery();
    } catch (Exception e) {
      return null;
    }
  }
}
