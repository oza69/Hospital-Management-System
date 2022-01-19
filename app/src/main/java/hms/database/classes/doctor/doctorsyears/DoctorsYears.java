/**
 * @author Dhruv Oza
 * @description : This class will fetch date of joining of doctor based on
 * doctorID from database
 */
package hms.database.classes.doctor.doctorsyears;

import hms.configuration.ConnectorDao;
import hms.database.interfaces.doctor.doctorsyears.IDoctorsYears;
import hms.models.classes.doctor.workingyears.CountWorkingYears;
import hms.models.interfaces.doctor.workingyears.ICountWorkingYears;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import static hms.constants.CallableStatements
    .INSERT_SPECIFIC_DOCTOR_JOINING_DATE;

public class DoctorsYears implements IDoctorsYears {

  private int doctorID;

  public DoctorsYears(int doctorID) {
    this.doctorID = doctorID;
  }

  public int getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(int doctorID) {
    this.doctorID = doctorID;
  }

  public int loadDB(ConnectorDao connectorDao) throws SQLException {
    Date dateOfJoining = null;
    Connection con = connectorDao.getConnection();
    if (isValid() == true) {
      CallableStatement cs = con.
          prepareCall(INSERT_SPECIFIC_DOCTOR_JOINING_DATE);
      cs.setInt(1, getDoctorID());
      ResultSet resultSet = cs.executeQuery();
      while (resultSet.next()) {
        dateOfJoining = resultSet.getDate(1);
      }
      ICountWorkingYears iCountWorkingYears =
          new CountWorkingYears(dateOfJoining);
      return iCountWorkingYears.workingYearsCalculation();
    } else {
      return 0;
    }
  }

  public boolean isValid() {
    return (doctorID > 0);
  }
}
