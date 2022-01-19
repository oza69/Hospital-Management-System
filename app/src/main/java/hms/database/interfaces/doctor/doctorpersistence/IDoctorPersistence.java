/**
 * @author Dhruv Oza
 * @description : This class will connect database to store and fetch details
 * from doctor table
 */
package hms.database.interfaces.doctor.doctorpersistence;

import hms.models.interfaces.doctor.doctor.IDoctor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/* DoctorPersistence will fetch and store doctor details from database */
public interface IDoctorPersistence {

  /**
   * Method to Save Doctor Details in Database
   * @return true if all details stored in database otherwise return false
   * @params iDoctor as object of IDoctor class
   * @params connection as object of Connection interface
   */
  public boolean saveDoctor(IDoctor iDoctor, Connection connection);

  /**
   * Method to fetch all Doctor Details from database
   * @return resultData if all data fetched successfully otherwise return null
   * @params connection as object of Connection interface
   */
  public ResultSet getAllDoctor(Connection connection);

  /**
   * Method to get doctor details from database according to doctorID
   * @return result if fetched all details of particular doctor
   * otherwise return null
   * @params doctorID as integer to get details according to that
   * @params connection as object of Connection interface
   */
  public ResultSet getOneDoctor(int doctorID, Connection connection);

  /**
   * Method to add Attendence of doctor according to doctorID in database
   * @return true if added attendance in Payroll Table in database otherwise
   * return false
   * @params doctorId as integer
   * @params attendance as double
   * @params connection as Connection interface
   */
  public boolean addAttendence(int doctorID, double attendance, Connection
      connection) throws SQLException;

  /**
   * Method to setOvertime of doctor according to doctorID in database
   * @return true if added setOvertime in doctor Table in database otherwise
   * return false
   * @params doctorId as integer
   * @params overtime as double
   * @params connection as Connection interface
   */
  public boolean setOvertime(int doctorID, double overtime, Connection
      connection) throws SQLException;
}
