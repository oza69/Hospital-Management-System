/**
 * @author Eklavya Nautiyal
 * @description class to retrieve one payroll from databse
 * and retrieve all payroll
 * and save a payroll entry into database
 */
package hms.database.classes.payroll.payrollpersistence;

import hms.database.interfaces.payroll.payrollpersistence.IPayrollPersistence;
import hms.models.interfaces.payroll.payroll.IPayroll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static hms.constants.CallableStatements.ADD_PAYROLL;
import static hms.constants.CallableStatements.ALL_PAYROLL;
import static hms.constants.CallableStatements.GET_ONE_PAYROLL;

public class PayrollPersistence implements IPayrollPersistence {

  @Override
  public boolean savePayroll(IPayroll iPayroll, Connection connection) {

    try {

      PreparedStatement statement = connection.prepareStatement(ADD_PAYROLL);
      statement.setInt(1, iPayroll.getDoctorID());
      statement.setDouble(2, iPayroll.getAmount());
      statement.setInt(3, iPayroll.getAge());
      statement.setDouble(4, iPayroll.getAttendence());
      statement.setDouble(5, iPayroll.getPendingAmount());
      statement.setDouble(6, iPayroll.getOvertimeAmount());
      statement.setDouble(7, iPayroll.getProfitIncentive());
      statement.setDouble(8, iPayroll.getTaxDeducted());
      statement.setDouble(9, iPayroll.getTotalAmount());
      statement.executeUpdate();
      return true;

    } catch (Exception e) {

      return false;

    }
  }

  @Override
  public ResultSet getAllPayroll(Connection connection) {

    try {

      PreparedStatement statement = connection.prepareCall(ALL_PAYROLL);
      ResultSet resultData = statement.executeQuery();
      return resultData;

    } catch (Exception e) {

      return null;

    }
  }

  @Override
  public ResultSet getOnePayroll(int docId, Connection connection) {

    try {

      PreparedStatement statement = connection.prepareCall(GET_ONE_PAYROLL);
      statement.setInt(1, docId);
      ResultSet resultData = statement.executeQuery();
      return resultData;

    } catch (Exception e) {

      return null;

    }
  }
}
