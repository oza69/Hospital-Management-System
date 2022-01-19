/**
 * @author Vishvesh Bharatbhai Naik
 * @description Final amount Persistence will get age, insurance, amount values
 * from database to calculate the final patient amount
 */
package hms.database.classes.payment.fianlamountpersistence;

import hms.configuration.Connector;
import hms.database.interfaces.payment.finalamountpersistence
    .IFinalAmountPersistence;

import java.sql.*;

import static hms.constants.CallableStatements.*;

public class FinalAmountPersistence implements IFinalAmountPersistence {

  CallableStatement callStmt;
  ResultSet rs = null;
  Connector connector = new Connector();
  Connection con = connector.getConnection();

  @Override
  public int getAge(int patientId) {
    int age = 0;
    try {
      callStmt = con.prepareCall(SELECT_AGE);
      callStmt.setInt(1, patientId);
      rs = callStmt.executeQuery();
      if (rs.next()) {
        age = rs.getInt(1);
      }
    } catch (Exception e) {
      return 0;
    }
    return age;
  }

  @Override
  public int getPolicyId(int patientId) {
    int policyId = 0;
    try {
      callStmt = con.prepareCall(SELECT_POLICY_ID);
      callStmt.setInt(1, patientId);
      rs = callStmt.executeQuery();
      if (rs.next()) {
        policyId = rs.getInt(1);
      }
    } catch (Exception e) {
      return 0;
    }
    return policyId;
  }

  @Override
  public Date getPolicyEndDate(int policyId) {
    try {
      callStmt = con.prepareCall(SELECT_POLICY_END_DATE);
      callStmt.setInt(1, policyId);
      rs = callStmt.executeQuery();
      java.sql.Date dbSqlDate = null;
      if (rs.next()) {
        dbSqlDate = rs.getDate("Policy_End_Date");
      }return dbSqlDate;
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public int getAmount(int patientId) {
    int getCaseId = 0;
    try {
      callStmt = con.prepareCall(SELECT_AMOUNT);
      callStmt.setInt(1, patientId);
      rs = callStmt.executeQuery();
      if (rs.next()) {
        getCaseId = rs.getInt(1);
      }
    } catch (Exception e) {
      return 0;
    }
    return getCaseId;
  }

  @Override
  public int getInsuranceAmount(int policyId) {
    int insuranceAmount = 0;
    try {
      callStmt = con.prepareCall(SELECT_AMOUNT_COVERED);
      callStmt.setInt(1, policyId);
      rs = callStmt.executeQuery();
      if (rs.next()) {
        insuranceAmount = rs.getInt(1);
      }
    } catch (Exception e) {
      return 0;
    }
    return insuranceAmount;
  }

  @Override
  public void putFinalAmount(double finalAmount, int patientId) {
    try {
      callStmt = con.prepareCall(UPDATE_FINAL_AMOUNT);
      callStmt.setDouble(1, finalAmount);
      callStmt.setInt(2, patientId);
      callStmt.executeQuery();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public ResultSet viewPayment(int payment) {
    try {
      callStmt = con.prepareCall(SELECT_PAYMENT_ID);
      callStmt.setInt(1, payment);
      rs = callStmt.executeQuery();
      return rs;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}