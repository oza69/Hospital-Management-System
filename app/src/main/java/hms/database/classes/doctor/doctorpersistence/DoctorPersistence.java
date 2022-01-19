/**
 * @author Dhruv Oza
 * @description : This class will connect database to store and fetch details
 * from doctor table
 */
package hms.database.classes.doctor.doctorpersistence;

import hms.database.interfaces.doctor.doctorpersistence.IDoctorPersistence;
import hms.models.interfaces.doctor.doctor.IDoctor;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static hms.constants.CallableStatements.INSERT_DOCTOR;
import static hms.constants.CallableStatements.SELECT_ALL_DOCTOR;
import static hms.constants.CallableStatements.SELECT_ONE_DOCTOR_DETAIL;
import static hms.constants.CallableStatements.SET_ATTENDANCE;
import static hms.constants.CallableStatements.SET_OVERTIME;

public class DoctorPersistence implements IDoctorPersistence {

  private ResultSet result = null;

  public boolean saveDoctor(IDoctor iDoctor, Connection connection) {
    try {
      PreparedStatement statement = connection.prepareStatement(INSERT_DOCTOR);
      statement.setString(1, iDoctor.getFullName());
      statement.setString(2, iDoctor.getGender());
      statement.setString(3, iDoctor.getAddress());
      statement.setInt(4, iDoctor.getContactNo());
      statement.setDate(5, Date.valueOf(iDoctor.getDob()));
      statement.setString(6, iDoctor.getSpeciality());
      statement.setString(7, iDoctor.getStatus());
      statement.setDouble(8, iDoctor.getWorkingHours());
      statement.setDouble(9, iDoctor.getEfficiencyIndex());
      statement.setDate(10, Date.valueOf(iDoctor
          .getDateOfWorking()));
      statement.setDouble(11, iDoctor.getRevenueShared());
      statement.setInt(12, iDoctor.getPolicyID());
      statement.executeUpdate();
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public ResultSet getAllDoctor(Connection connection) {
    try {
      PreparedStatement statement = connection.prepareCall(SELECT_ALL_DOCTOR);
      ResultSet resultData = statement.executeQuery();
      return resultData;
    } catch (Exception e) {
      return null;
    }
  }

  public ResultSet getOneDoctor(int doctorID, Connection connection) {
    try {
      CallableStatement callS = connection.
          prepareCall(SELECT_ONE_DOCTOR_DETAIL);
      callS.setInt(1, doctorID);
      result = callS.executeQuery();
      return result;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public boolean addAttendence(int doctorID, double attendance, Connection
      connection) throws SQLException {
    try {
      CallableStatement callS = connection.prepareCall(SET_ATTENDANCE);
      callS.setInt(1, doctorID);
      callS.setDouble(2, attendance);
      callS.execute();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean setOvertime(int doctorID, double overtime, Connection
      connection) throws SQLException {
    try {
      CallableStatement callS = connection.prepareCall(SET_OVERTIME);
      callS.setInt(1, doctorID);
      callS.setDouble(2, overtime);
      callS.execute();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
}
