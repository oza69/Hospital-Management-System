/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file handles operations related to DISEASE table for
 * fetching data from the database
 */
package hms.database.classes.hmanalysis.getdiseaseinrange;

import hms.database.interfaces.hmanalysis.getdiseaseinrange.IGetDiseasesInRangePersistence;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static hms.constants.CallableStatements.SELECT_DISEASES_IN_RANGE;
import static hms.constants.CallableStatements.SELECT_DISTINCT_DISEASES_IN_RANGE;

public class GetDiseasesInRangePersistence implements
    IGetDiseasesInRangePersistence {

  @Override
  public Map<Integer, Integer> getDiseases(Date startDate, Date endDate,
      Connection connection) {
    try {
      ResultSet diseasesInRange = inRangeQueryBinder(SELECT_DISEASES_IN_RANGE,
          startDate, endDate, connection);
      Map<Integer, Integer> diseaseInRangeList = new HashMap<>();
      if (diseasesInRange != null) {
        while (diseasesInRange.next()) {
          Integer diseaseId = diseasesInRange.getInt("Disease_ID");
          Integer totalCases = diseasesInRange.getInt("Total_Cases");
          diseaseInRangeList.put(diseaseId, totalCases);
        }
        return diseaseInRangeList;
      } else {
        return null;
      }
    } catch (SQLException e) {
      return null;
    }
  }

  @Override
  public Map<Integer, List<Integer>> getDistinctDiseasesPerPatient(
      Date startDate, Date endDate, Connection connection) {
    try {
      ResultSet distinctDiseases =
          inRangeQueryBinder(SELECT_DISTINCT_DISEASES_IN_RANGE, startDate,
              endDate, connection);
      Map<Integer, List<Integer>> patientsWithDiseases = new HashMap<>();
      if (distinctDiseases != null) {
        while (distinctDiseases.next()) {
          Integer patientID = distinctDiseases.getInt("Patient_ID");
          Integer diseaseID = distinctDiseases.getInt("Disease_ID");
          if (!patientsWithDiseases.containsKey(patientID)) {
            patientsWithDiseases.put(patientID, new ArrayList<>());
          }

          List<Integer> diseaseList = patientsWithDiseases.get(patientID);
          if (!diseaseList.contains(diseaseID)) {
            diseaseList.add(diseaseID);
          }
        }
        return patientsWithDiseases;
      } else {
        return null;
      }
    } catch (SQLException e) {
      return null;
    }
  }

  private ResultSet inRangeQueryBinder(String query, Date startDate,
      Date endDate, Connection connection) {
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setDate(1, startDate);
      statement.setDate(2, endDate);
      return statement.executeQuery();
    } catch (SQLException e) {
      return null;
    }
  }
}