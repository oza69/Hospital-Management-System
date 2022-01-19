/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file handles operations related to CASES table in database
 */
package hms.database.classes.cases.casepersistence;

import hms.database.interfaces.cases.casepersistence.ICasePersistence;
import hms.models.classes.cases.cases.Cases;
import hms.models.classes.disease.zerotoonescale.ZeroToOneScale;
import hms.models.interfaces.cases.cases.ICases;
import hms.models.interfaces.disease.zerotoonescale.IZeroToOneScale;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import static hms.constants.CallableStatements.INSERT_CASE;
import static hms.constants.CallableStatements.SELECT_ALL_CASES;
import static hms.constants.CallableStatements.SELECT_CASE;
import static hms.constants.CallableStatements.UPDATE_CASE;
import static java.sql.Types.NULL;

public class CasePersistence implements ICasePersistence {

  @Override
  public boolean saveCase(ICases iCases, Connection connection) {
    try {
      PreparedStatement statement = connection.prepareStatement(INSERT_CASE);
      statement.setInt(1, iCases.getPatientId());
      statement.setInt(2, iCases.getAssignedDoctorId());
      statement.setString(3, iCases.getDescription());
      statement.setInt(4, iCases.getDiseaseId());
      statement.setDouble(5, iCases.getFeedback());
      if (iCases.getReferenceId() > 0) {
        statement.setInt(6, iCases.getReferenceId());
      } else {
        statement.setNull(6, NULL);
      }

      if (iCases.getPolicyId() > 0) {
        statement.setInt(7, iCases.getPolicyId());
      } else {
        statement.setNull(7, NULL);
      }

      statement.setInt(8, iCases.getAmount());
      statement.setDate(9, Date.valueOf(iCases.getDate()));
      ResultSet result = statement.executeQuery();
      if (result.next()) {
        Integer caseId = result.getInt("Case_ID");
        iCases.setCaseId(caseId);
        return true;
      } else {
        return false;
      }
    } catch (SQLException e) {
      return false;
    }
  }

  @Override
  public Boolean getCase(Integer caseId, ICases iCases, Connection connection) {
    try {
      PreparedStatement statement = connection.prepareStatement(SELECT_CASE);
      statement.setInt(1, caseId);
      ResultSet result = statement.executeQuery();
      if (result.next()) {
        iCases.setCaseId(result.getInt("Case_ID"));
        iCases.setPatientId(result.getInt("Patient_ID"));
        iCases.setDescription(result.getString("Case_Description"));
        iCases.setDiseaseId(result.getInt("Disease_ID"));
        iCases.setFeedback(result.getDouble("Feedback"));
        iCases.setReferenceId(result.getInt("Reference_ID"));
        iCases.setPolicyId(result.getInt("Policy_ID"));
        iCases.setAmount(result.getInt("Amount"));
        iCases.setDate(result.getDate("Date").toString());
        iCases.setAssignedDoctorId(result.getInt("Doctor_ID"));
        return true;
      } else {
        return false;
      }
    } catch (SQLException e) {
      return false;
    }
  }

  @Override
  public boolean updateCase(ICases iCases, Connection connection) {
    try {
      PreparedStatement statement = connection.prepareStatement(UPDATE_CASE);
      statement.setInt(1, iCases.getCaseId());
      statement.setInt(2, iCases.getPatientId());
      statement.setString(3, iCases.getDescription());
      statement.setInt(4, iCases.getDiseaseId());
      statement.setDouble(5, iCases.getFeedback());
      if (iCases.getReferenceId() > 0) {
        statement.setInt(6, iCases.getReferenceId());
      } else {
        statement.setNull(6, NULL);
      }

      if (iCases.getPolicyId() > 0) {
        statement.setInt(7, iCases.getPolicyId());
      } else {
        statement.setNull(7, NULL);
      }

      statement.setInt(8, iCases.getAmount());
      statement.setDate(9, Date.valueOf(iCases.getDate()));
      statement.setInt(10, iCases.getAssignedDoctorId());
      statement.executeUpdate();
      return true;
    } catch (SQLException e) {
      return false;
    }
  }

  @Override
  public Map<Integer, ICases> getAllCases(Connection connection) {
    try {
      PreparedStatement statement = connection.prepareCall(SELECT_ALL_CASES);
      ResultSet resultData = statement.executeQuery();
      Map<Integer, ICases> caseList = new HashMap<>();
      if (resultData != null) {
        while (resultData.next()) {
          Integer caseId = resultData.getInt("Case_ID");
          Integer patientId = resultData.getInt("Patient_ID");
          String description = resultData.getString("Case_Description");
          Integer diseaseId = resultData.getInt("Disease_ID");
          Double feedback = resultData.getDouble("Feedback");
          Integer referenceId = resultData.getInt("Reference_ID");
          Integer policyId = resultData.getInt("Policy_ID");
          Integer amount = resultData.getInt("Amount");
          String date = resultData.getString("Date");
          Integer doctorId = resultData.getInt("Doctor_ID");
          ICases patientCase = new Cases(patientId, doctorId, description,
              diseaseId, feedback, referenceId, policyId, amount, date);
          patientCase.setCaseId(caseId);
          IZeroToOneScale factorChecker = new ZeroToOneScale();
          if (patientCase.isValid(factorChecker)) {
            caseList.put(caseId, patientCase);
          }
        }
        return caseList;
      } else {
        return null;
      }
    } catch (SQLException e) {
      return null;
    }
  }
}