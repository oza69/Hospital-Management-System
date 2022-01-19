/**
 * @author Dhruv Oza
 * @description : This class will fetch birthdate of doctor based on doctorID
 * from database
 */
package hms.database.interfaces.doctor.doctoragepersistence;

import hms.configuration.ConnectorDao;

import java.sql.SQLException;

/* DoctorAgePersistence will fetch doctorID and birthDate from database */
public interface IDoctorAgePersistence {

  /** @return doctorID initialize by setter method */
  public int getDoctorID();

  /* set doctorID passed as parameter in
     constructor
  */
  public void setDoctorID(int doctorID);

  /** Extracting DoctorID with birth date
   @param connectorDao object to handle database connection
   @return calculated age using date of birth
   */
  public int loadDB(ConnectorDao connectorDao) throws SQLException;

  /* validation of doctorID */
  public boolean isValid();
}
