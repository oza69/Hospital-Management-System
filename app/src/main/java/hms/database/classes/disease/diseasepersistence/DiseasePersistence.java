/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file handles operations related to DISEASE table in database
 */
package hms.database.classes.disease.diseasepersistence;

import hms.database.interfaces.disease.diseasepersistence.IDiseasePersistence;
import hms.models.classes.disease.disease.Disease;
import hms.models.classes.disease.zerotoonescale.ZeroToOneScale;
import hms.models.interfaces.disease.disease.IDisease;
import hms.models.interfaces.disease.zerotoonescale.IZeroToOneScale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import static hms.constants.CallableStatements.INSERT_DISEASE;
import static hms.constants.CallableStatements.SELECT_ALL_DISEASES;
import static hms.constants.CallableStatements.SELECT_DISEASE;
import static hms.constants.CallableStatements.UPDATE_DISEASE;

public class DiseasePersistence implements IDiseasePersistence {

  @Override
  public boolean saveDisease(IDisease disease, Connection connection) {
    try {
      PreparedStatement statement = connection.prepareStatement(INSERT_DISEASE);
      statement.setString(1, disease.getName());
      statement.setString(2, disease.getDescription());
      statement.setDouble(3, disease.getFatalityRiskFactor());
      statement.setDouble(4, disease.getContagiousRiskFactor());
      ResultSet result = statement.executeQuery();
      if (result.next()) {
        Integer diseaseId = result.getInt("Disease_Id");
        disease.setId(diseaseId);
        return true;
      } else {
        return false;
      }
    } catch (SQLException e) {
      return false;
    }
  }

  @Override
  public Boolean getDisease(Integer diseaseId, IDisease disease,
      Connection connection) {
    try {
      PreparedStatement statement = connection.prepareStatement(SELECT_DISEASE);
      statement.setInt(1, diseaseId);
      ResultSet result = statement.executeQuery();
      if (result.next()) {
        disease.setId(result.getInt("Disease_Id"));
        disease.setName(result.getString("Name"));
        disease.setDescription(result.getString("Description"));
        disease.setFatalityRiskFactor(
            result.getDouble("Fatality_Risk_Factor"));
        disease.setContagiousRiskFactor(
            result.getDouble("Contagious_Risk_Factor"));
        return true;
      } else {
        return false;
      }
    } catch (SQLException e) {
      return false;
    }
  }

  @Override
  public boolean updateDisease(IDisease disease, Connection connection) {
    try {
      PreparedStatement statement = connection.prepareStatement(UPDATE_DISEASE);
      statement.setInt(1, disease.getId());
      statement.setString(2, disease.getName());
      statement.setString(3, disease.getDescription());
      statement.setDouble(4, disease.getFatalityRiskFactor());
      statement.setDouble(5, disease.getContagiousRiskFactor());
      statement.executeUpdate();
      return true;
    } catch (SQLException e) {
      return false;
    }
  }

  @Override
  public Map<Integer, IDisease> getAllDiseases(Connection connection) {
    try {
      PreparedStatement statement = connection.prepareCall(SELECT_ALL_DISEASES);
      ResultSet resultData = statement.executeQuery();
      Map<Integer, IDisease> diseaseList = new HashMap<>();
      if (resultData != null) {
        while (resultData.next()) {
          Integer id = resultData.getInt("Disease_ID");
          String name = resultData.getString("Name");
          String description = resultData.getString("Description");
          Double fatalityRiskFactor =
              resultData.getDouble("Fatality_Risk_Factor");
          Double contagiousRiskFactor =
              resultData.getDouble("Contagious_Risk_Factor");
          IDisease disease = new Disease(name, description, fatalityRiskFactor,
              contagiousRiskFactor);
          disease.setId(id);
          IZeroToOneScale factorChecker = new ZeroToOneScale();
          if (disease.isValid(factorChecker)) {
            diseaseList.put(id, disease);
          }
        }
        return diseaseList;
      } else {
        return null;
      }
    } catch (SQLException e) {
      return null;
    }
  }
}