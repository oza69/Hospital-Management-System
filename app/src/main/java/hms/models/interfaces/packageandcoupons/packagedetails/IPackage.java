/**
  @author Dhruv Oza
  @description : This class will set and get all values passed
  in constructor as Package
*/
package hms.models.interfaces.packageandcoupons.packagedetails;

/* Package will set and get package details */
public interface IPackage {

  public String getName(); /* getter method */

  public void setName(String name); /* setter method */

  public String getDescription(); /* getter method */

  public void setDescription(String description); /* setter method */

  public String getValidity(); /* getter method */

  public void setValidity(String validity); /* setter method */

  public double getAmount(); /* getter method */

  public void setAmount(double amount); /* setter method */

  public String getCouponCode(); /* getter method */

  public void setCouponCode(String couponCode); /* setter method */

  public boolean isValid(); /* check if entered details are valid or not */
}
