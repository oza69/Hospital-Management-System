/**
  @author Dhruv Oza
  @description : This class will save, get and update package
  details from database
*/
package hms.database.interfaces.packageandcoupons.packagedetails;

import hms.models.interfaces.packageandcoupons.packagedetails.IPackage;

import java.sql.Connection;
import java.sql.ResultSet;

/* PackagePersistence will save, get and update package details into database */
public interface IPackagePersistence {

  /**
   This method saves all package details into database
   @params iPackage as object of IPackage class
   @params connection as object of Connection class
   @return true if all data uploaded otherwise return false
   */
  public boolean savePackage(IPackage iPackage, Connection connection);

  /**
    This method selects all details and fetch them from database
    @params connection as object of Connection class
    @return resultData if fetched all data from database otherwise return null
  */
  public ResultSet getAllPackage(Connection connection);

  /*
    This method updated all package details based on packageID in database
    @params packageID as integer
    @params name as string
    @params description as string
    @params validity as string
    @params amount as double
    @params couponCode as string
    @params connection as object
    @return true if all details updated otherwise return false
  */
  public boolean updatePackage(int packageID, String name,
                               String description, String validity,
                               double amount, String couponCode,
                               Connection connection);
}
