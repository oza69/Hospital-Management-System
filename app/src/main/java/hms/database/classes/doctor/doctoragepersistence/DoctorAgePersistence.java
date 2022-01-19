/**
 * @author Dhruv Oza
 * @description : This class will fetch birthdate of doctor based on doctorID
 * from database
 */
package hms.database.classes.doctor.doctoragepersistence;

import hms.configuration.ConnectorDao;
import hms.models.classes.doctor.ages.Age;
import hms.models.interfaces.doctor.ages.IAge;
import hms.database.interfaces.doctor.doctoragepersistence
    .IDoctorAgePersistence;

import static hms.constants.CallableStatements.INSERT_SPECIFIC_DOCTOR;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorAgePersistence implements IDoctorAgePersistence {

  private int doctorID;

  public DoctorAgePersistence(int doctorID) {
    this.doctorID = doctorID;
  }

  public int getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(int doctorID) {
    this.doctorID = doctorID;
  }

  @Override
  public int loadDB(ConnectorDao connectorDao) throws SQLException {
    Date birthDate = null;
    Connection con = connectorDao.getConnection();
    if (isValid() == true) {
      CallableStatement cs = con.prepareCall(INSERT_SPECIFIC_DOCTOR);
      cs.setInt(1, getDoctorID());
      ResultSet resultSet = cs.executeQuery();
      while (resultSet.next()) {
        birthDate = resultSet.getDate(1);
      }
      IAge iAge = new Age(birthDate);
      return iAge.ageCalculate();
    } else {
      return 0;
    }
  }

  public boolean isValid() {
    return (doctorID > 0);
  }
}
