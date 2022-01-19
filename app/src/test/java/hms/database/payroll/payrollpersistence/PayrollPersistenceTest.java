/**
 * @author Eklavya Nautiyal
 * @description Creating PayrollPersistenceTest class to run test cases
 */
package hms.database.payroll.payrollpersistence;

import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import hms.database.classes.payroll.payrollpersistence.PayrollPersistence;
import hms.database.interfaces.payroll.payrollpersistence.IPayrollPersistence;
import hms.models.classes.payroll.payroll.Payroll;
import hms.models.interfaces.payroll.payroll.IPayroll;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PayrollPersistenceTest {

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
  ConnectorDao connector = new Connector();
  Connection connection = connector.getConnection();
  IPayrollPersistence payrollPersistence = new PayrollPersistence();

  /**
   * getAllCases method returns null if any error occurs while fetching
   * case records
   */
  @Test
  public void testGetAllPayroll() {

    assertNotNull("Cases can not be retrieved",
        payrollPersistence.getAllPayroll(connection));

  }

  /**
   * saveCase method returns false if unable to insert case record
   */
  @Test
  public void testSavePayroll() {

    IPayroll newPayroll = new Payroll(doctorID, amount, age, attendance,
        pendingAmount, overtimeAmount, profitIncentive, taxDeducted,
        totalAmount);
    assertTrue("Payroll unable to save in the database",
        payrollPersistence.savePayroll(newPayroll, connection));
  }

  /**
   * getonepayroll method returns one payroll record
   */
  @Test
  public void testGetOnePayroll() {
    assertNotNull("Cases can not be retrieved",
        payrollPersistence.getOnePayroll(doctorID, connection));
  }
}
