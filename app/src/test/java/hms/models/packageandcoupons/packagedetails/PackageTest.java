/**
 * @author Dhruv Oza
 * @description : Test Package class
 */
package hms.models.packageandcoupons.packagedetails;

import hms.models.classes.packageandcoupons.packagedetails.Package;
import hms.models.interfaces.packageandcoupons.packagedetails.IPackage;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PackageTest {

  String name = "Ravi Patel";
  String description = "Very Good Doctor";
  double amount = 900.00;
  String couponCode = "342577111";
  String validityDate = "2021-04-02";

  IPackage iPackage =
      new Package(name, description, validityDate, amount, couponCode);

  @Test
  @DisplayName("getName method")
  public void getNameTest() {
    assertNotNull("Name is NULL", iPackage.getName());
  }

  @Test
  @DisplayName("getDescription method")
  public void getDescriptionTest() {
    assertNotNull("Description is NULL", iPackage.getDescription());
  }

  @Test
  @DisplayName("getValidity method")
  public void getValiditytest() {
    assertNotNull("Validity Date is NULL", iPackage.getValidity());
  }

  @Test
  @DisplayName("getAmount method")
  public void getAmounttest() {
    assertTrue("Amount is less than zero",
        iPackage.getAmount() > 0);
  }

  @Test
  @DisplayName("getCouponCode method")
  public void getCouponCodeTest() {
    assertNotNull("Coupon Code is NULL", iPackage.getCouponCode());
  }

  @Test
  @DisplayName("isValid method")
  public void isValidtest() {
    assertTrue("Not valid case", iPackage.isValid());
  }

  @Test
  @DisplayName("setName method")
  public void setNametest() {
    String newName = "Ravi";
    iPackage.setName(newName);
    assertEquals("Name not updated", newName, iPackage.getName());
  }

  @Test
  @DisplayName("setDescription method")
  public void setDescriptiontest() {
    String description = "Canada";
    iPackage.setDescription(description);
    assertEquals("Description not updated", description,
        iPackage.getDescription());
  }

  @Test
  @DisplayName("setValidity method")
  public void setValiditytest() throws ParseException {
    String validity = "1996-04-02";
    iPackage.setValidity(validity);
    assertEquals("Validity not updated", validity,
        iPackage.getValidity());
  }

  @Test
  @DisplayName("setAmount method")
  public void setAmounttest() {
    double amount = 9.00;
    iPackage.setAmount(amount);
    assertTrue(iPackage.getAmount() > 0);
  }

  @Test
  @DisplayName("setCouponCode method")
  public void setCouponCodetest() {
    String coupon = "Canada";
    iPackage.setCouponCode(coupon);
    assertEquals("Coupon not updated", coupon,
        iPackage.getCouponCode());
  }
}
