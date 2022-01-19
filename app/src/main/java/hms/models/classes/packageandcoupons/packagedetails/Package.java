/**
 * @author Dhruv Oza
 * @description : This class will set and get all values passed in
 * constructor as Package
 */
package hms.models.classes.packageandcoupons.packagedetails;

import hms.models.interfaces.packageandcoupons.packagedetails.IPackage;

public class Package implements IPackage {

  /* Declaring private variables */
  private String name;
  private String description;
  private String validity;
  private double amount;
  private String couponCode;

  /* Constructor to initialize package details from user */
  public Package(String name, String description, String validity,
                 double amount, String couponCode) {
    this.name = name;
    this.description = description;
    this.validity = validity;
    this.amount = amount;
    this.couponCode = couponCode;
  }

  /* Constructor as Package */
  public Package() {
  }

  /* getter method */
  public String getName() {
    return name;
  }

  /* setter method */
  public void setName(String name) {
    this.name = name;
  }

  /* getter method */
  public String getDescription() {
    return description;
  }

  /* setter method */
  public void setDescription(String description) {
    this.description = description;
  }

  /* getter method */
  public String getValidity() {
    return validity;
  }

  /* setter method */
  public void setValidity(String validity) {
    this.validity = validity;
  }

  /* getter method */
  public double getAmount() {
    return amount;
  }

  /* setter method */
  public void setAmount(double amount) {
    this.amount = amount;
  }

  /* getter method */
  public String getCouponCode() {
    return couponCode;
  }

  /* setter method */
  public void setCouponCode(String couponCode) {
    this.couponCode = couponCode;
  }

  /* check if entered details are valid or not */
  public boolean isValid() {
    return (name != "" && description != "" && validity != null &&
        amount > 0 && couponCode != "");
  }
}
