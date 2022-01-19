/**
 * @author Dhruv Oza
 * @description : Test PackagePersistence class
 */
package hms.database.packageandcoupons.packageDetails;

import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import hms.database.classes.packageandcoupons.packagedetails.PackagePersistence;
import hms.database.interfaces.packageandcoupons.packagedetails
    .IPackagePersistence;
import hms.models.classes.packageandcoupons.packagedetails.Package;
import hms.models.interfaces.packageandcoupons.packagedetails.IPackage;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PackagePersistenceTest {

  /**
   * Initializing common variables and objects
   */
  ConnectorDao connectorDao = new Connector();
  Connection connection = connectorDao.getConnection();
  String name = "Ravi Patel";
  String description = "Very Good Doctor";
  double amount = 900.00;
  String validityDate = "2021-04-02";
  String couponCode = "342577111";
  int packageID = 1;
  IPackagePersistence iPackagePersistence = new PackagePersistence();

  @Test
  @DisplayName("getAllPackage method returns null if any error " +
      "occurs while fetching case records")
  public void getAllPackageTest() {
    assertNotNull("Package details can not be retrieved",
        iPackagePersistence.getAllPackage(connection));
  }

  @Test
  @DisplayName("savePackage method returns false if unable to " +
      "insert case record")
  public void savePackageTest() {
    IPackage iPackage =
        new Package(name, description, validityDate, amount,
            couponCode);
    assertTrue(iPackagePersistence.savePackage(iPackage, connection),
        "Package details unable to save in the database");
  }

  @Test
  @DisplayName("updatePackage method returns false if any error " +
      "occurs while updating case records")
  public void updatePackageTest() {
    assertNotNull("Package details can not be updated",
        iPackagePersistence.updatePackage(packageID, name, description,
            validityDate, amount, couponCode, connection));
  }
}
