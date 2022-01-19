/**
 * @author Vishvesh Bharatbhai Naik
 * @description Payment's Setter and getter
 */
package hms.models.interfaces.payment.payment;

import hms.database.interfaces.payment.paymentpersistence.IPaymentPersistence;

import java.sql.Connection;

public interface IPayment {

  /**
   * Getter method for patientId
   * @return patientId
   */
  int getPatientId();

  /**
   * Setter method for patientId
   * @param patientId patientId
   */
  void setPatientId(int patientId);

  /**
   * Getter method for amount
   * @return amount
   */
  Double getAmount();

  /**
   * Setter method for amount
   * @param amount amount
   */
  void setAmount(Double amount);

  /**
   * Getter method for paymentMode
   * @return paymentMode
   */
  String getPaymentMode();

  /**
   * Setter method for paymentMode
   * @param paymentMode paymentMode
   */
  void setPaymentMode(String paymentMode);

  /**
   * Getter method for paymentStatus
   * @return paymentStatus
   */
  String getPaymentStatus();

  /**
   * Setter method for paymentStatus
   * @param paymentStatus paymentStatus
   */
  void setPaymentStatus(String paymentStatus);

  /**
   * Getter method for discountApplied
   * @return discountApplied
   */
  Double getDiscountApplied();

  /**
   * Setter method for discountApplied
   * @param discountApplied discountApplied
   */
  void setDiscountApplied(Double discountApplied);

  /**
   * Getter method for insuranceApplied
   * @return insuranceApplied
   */
  String getInsuranceApplied();

  /**
   * Setter method for insuranceApplied
   * @param insuranceApplied insuranceApplied
   */
  void setInsuranceApplied(String insuranceApplied);

  /**
   * Getter method for finalAmount
   * @return finalAmount
   */
  Double getFinalAmount();

  /**
   * Setter method for finalAmount
   * @param finalAmount finalAmount
   */
  void setFinalAmount(Double finalAmount);

  /**
   * Getter method for billingDate
   * @return billingDate
   */
  String getBillingDate();

  /**
   * Setter method for billingDate
   * @param billingDate billingDate
   */
  void setBillingDate(String billingDate);

  /**
   * This method checks all parameters and validates Payment class
   * @return True if all variables are valid
   */
  boolean isValid();

  /**
   * This method saves Payment in the database
   * @param connection Connection object to perform sql operations
   * @param iPaymentPersistence iPaymentTablePersistence
   * object to interact with revenue table
   * @return True if Payment saved
   */
  boolean savePayment(Connection connection, IPaymentPersistence iPaymentPersistence);
}
