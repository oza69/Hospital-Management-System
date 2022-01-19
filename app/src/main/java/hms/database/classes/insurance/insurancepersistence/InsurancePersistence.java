/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file handles operations related to INSURANCE in the database
 */
package hms.database.classes.insurance.insurancepersistence;

import hms.database.interfaces.insurance.insurancepersistence.IInsurancePersistence;
import hms.models.classes.insurance.insurance.Insurance;
import hms.models.interfaces.insurance.insurance.IInsurance;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import static hms.constants.CallableStatements.INSERT_INSURANCE;
import static hms.constants.CallableStatements.SELECT_ALL_INSURANCES;
import static hms.constants.CallableStatements.SELECT_INSURANCE;
import static hms.constants.CallableStatements.UPDATE_INSURANCE;

public class InsurancePersistence implements IInsurancePersistence {

  @Override
  public boolean saveInsurance(IInsurance insurance, Connection connection) {
    try {
      PreparedStatement statement =
          connection.prepareStatement(INSERT_INSURANCE);
      statement.setString(1, insurance.getName());
      statement.setString(2, insurance.getDescription());
      statement.setInt(3, insurance.getAmountCovered());
      statement.setDate(4, Date.valueOf(insurance.getStartDate()));
      statement.setDate(5, Date.valueOf(insurance.getEndDate()));
      statement.setInt(6, insurance.getPolicyType());
      ResultSet result = statement.executeQuery();
      if (result != null) {
        while (result.next()) {
          insurance.setPolicyId(result.getInt("Policy_ID"));
        }
        return true;
      } else {
        return false;
      }
    } catch (SQLException e) {
      return false;
    }
  }

  @Override
  public Boolean getInsurance(Integer policyId, IInsurance insurance,
      Connection connection) {
    try {
      PreparedStatement statement = connection.prepareCall(SELECT_INSURANCE);
      statement.setInt(1, policyId);
      ResultSet result = statement.executeQuery();
      if (result.next()) {
        insurance.setPolicyId(result.getInt("Policy_Id"));
        insurance.setName(result.getString("Policy_Name"));
        insurance.setDescription(result.getString("Policy_Description"));
        insurance.setAmountCovered(result.getInt("Amount_Covered"));
        insurance.setStartDate(result.getString("Policy_Start_Date"));
        insurance.setEndDate(result.getString("Policy_End_Date"));
        insurance.setPolicyType(result.getInt("Policy_Type"));
        return true;
      } else {
        return false;
      }
    } catch (SQLException e) {
      return null;
    }
  }

  @Override
  public boolean updateInsurance(IInsurance insurance, Connection connection) {
    try {
      PreparedStatement statement =
          connection.prepareStatement(UPDATE_INSURANCE);
      statement.setInt(1, insurance.getPolicyId());
      statement.setString(2, insurance.getName());
      statement.setString(3, insurance.getDescription());
      statement.setInt(4, insurance.getAmountCovered());
      statement.setDate(5, Date.valueOf(insurance.getStartDate()));
      statement.setDate(6, Date.valueOf(insurance.getEndDate()));
      statement.setInt(7, insurance.getPolicyType());
      statement.executeUpdate();
      return true;
    } catch (SQLException e) {
      return false;
    }
  }

  @Override
  public Map<Integer, IInsurance> getAllInsurances(Connection connection) {
    try {
      PreparedStatement statement =
          connection.prepareCall(SELECT_ALL_INSURANCES);
      ResultSet result = statement.executeQuery();
      Map<Integer, IInsurance> insuranceList = new HashMap<>();
      if (result != null) {
        while (result.next()) {
          Integer id = result.getInt("Policy_Id");
          String name = result.getString("Policy_Name");
          String description = result.getString("Policy_Description");
          Integer amount = result.getInt("Amount_Covered");
          String startDate = result.getString("Policy_Start_Date");
          String endDate = result.getString("Policy_End_Date");
          Integer type = result.getInt("Policy_Type");
          IInsurance insurance =
              new Insurance(name, description, amount, startDate, endDate,
                  type);
          insurance.setPolicyId(id);
          insuranceList.put(id, insurance);
        }
        return insuranceList;
      } else {
        return null;
      }
    } catch (SQLException e) {
      return null;
    }
  }
}