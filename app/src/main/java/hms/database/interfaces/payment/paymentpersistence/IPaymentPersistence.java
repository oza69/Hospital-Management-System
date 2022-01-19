/**
 * @author Vishvesh Bharatbhai Naik
 * @description Payment Persistence will insert and get all values
 * from the database
 */
package hms.database.interfaces.payment.paymentpersistence;

import hms.models.interfaces.payment.payment.IPayment;

import java.sql.Connection;
import java.sql.ResultSet;

public interface IPaymentPersistence {

  /**
   * This method helps to insert record in payment table
   * @param iPayment payment object to store in table
   * @param connection Connection object to handle database connection
   * @return True if data is stored successfully into Payment table
   */
  boolean savePayment(IPayment iPayment, Connection connection);

  /**
   * This method helps to retrieve all records in payment table
   * @param connection Connection object to handle database connection
   * @return ResultSet of data if retrieved successfully from the Payment table,
   * else return null
   */
  ResultSet getAllPayment(Connection connection);
}
