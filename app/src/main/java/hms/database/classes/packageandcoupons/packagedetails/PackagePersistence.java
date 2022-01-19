/**
 * @author Dhruv Oza
 * @description : This class will save, get and update package details
 * based on opeations into database
 */
package hms.database.classes.packageandcoupons.packagedetails;

import hms.database.interfaces.packageandcoupons.
    packagedetails.IPackagePersistence;
import hms.models.interfaces.packageandcoupons.packagedetails.IPackage;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static hms.constants.CallableStatements.INSERT_PACKAGE;
import static hms.constants.CallableStatements.SELECT_ALL_PACKAGE;
import static hms.constants.CallableStatements.UPDATE_PACKAGE;

public class PackagePersistence implements IPackagePersistence {

  public boolean savePackage(IPackage iPackage, Connection connection) {
    try {
      PreparedStatement statement = connection.prepareStatement(INSERT_PACKAGE);
      statement.setString(1, iPackage.getName());
      statement.setString(2, iPackage.getDescription());
      statement.setDate(3, Date.valueOf(iPackage.getValidity()));
      statement.setDouble(4, iPackage.getAmount());
      statement.setString(5, iPackage.getCouponCode());
      statement.executeUpdate();
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public ResultSet getAllPackage(Connection connection) {
    try {
      PreparedStatement statement = connection.prepareCall(SELECT_ALL_PACKAGE);
      ResultSet resultData = statement.executeQuery();
      return resultData;
    } catch (Exception e) {
      return null;
    }
  }

  public boolean updatePackage(int packageID, String name,
                               String description, String validity,
                               double amount, String couponCode,
                               Connection connection) {
    try {
      CallableStatement callS = connection.prepareCall(UPDATE_PACKAGE);
      callS.setInt(1, packageID);
      callS.setString(2, name);
      callS.setString(3, description);
      callS.setString(4, validity);
      callS.setDouble(5, amount);
      callS.setString(6, couponCode);
      callS.executeUpdate();
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
