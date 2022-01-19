/**
 * @author Dhruv Oza
 * @description : This class will fetch dateOfJoining of doctor based on
 * doctorID from database
 */
package hms.database.interfaces.doctor.doctorsyears;

import hms.configuration.ConnectorDao;

import java.sql.SQLException;

/* DoctorsYears will fetch doctorID from database */
public interface IDoctorsYears {

  /* getter method */
  public int getDoctorID();

  /* setter method */
  public void setDoctorID(int doctorID);

  /**
   * Extracting DoctorID
   * @param connectorDao object to handle database connection
   * @return calculated workingYears using dateOfJoining
   */
  public int loadDB(ConnectorDao connectorDao) throws SQLException;

  /* validation of doctorID */
  public boolean isValid();
}
