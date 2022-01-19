/**
 * @author Eklavya Nautiyal
 * @description Creating Payroll Creating Payroll Databridge interface
 */
package hms.database.interfaces.payroll.payrollpersistence;

import java.sql.Connection;
import java.sql.ResultSet;

import hms.models.interfaces.payroll.payroll.IPayroll;

/**
 *
 */
public interface IPayrollPersistence {

  /**
   * This method helps to insert record in Payroll table
   * @param iPayroll Payroll object to store in table
   * @param connection Connection object to handle database connection
   * @return True if data is stored successfully into Payroll table
   */
  boolean savePayroll(IPayroll iPayroll, Connection connection);

  /**
   * This method helps to retrive all records in Payroll table
   * @param connection Connection object to handle database connection
   * @return ResultSet of data if retrived successfully from the Payroll table,
   * else return null
   */
  ResultSet getAllPayroll(Connection connection);

  /**
   * This method helps to retrive one records in Payroll table wtf doc ID
   * @param connection Connection object to handle database connection
   * @return ResultSet of data if retrived successfully from the Payroll table,
   * else return null
   */
  ResultSet getOnePayroll(int docId, Connection connection);
}