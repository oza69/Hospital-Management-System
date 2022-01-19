/**
 * @author Vishvesh Bharatbhai Naik
 * @description Payment's Setter and getter
 */
package hms.models.classes.payment.payment;

import hms.database.interfaces.payment.paymentpersistence.IPaymentPersistence;
import hms.models.interfaces.payment.payment.IPayment;

import java.sql.Connection;

public class Payment implements IPayment {

  private int patientId;
  private Double amount;
  private String paymentMode;
  private String paymentStatus;
  private Double discountApplied;
  private String insuranceApplied;
  private Double finalAmount;
  private String billingDate;

  public Payment() {
  }

  public Payment(int patientId, Double amount, String paymentMode,
                 String paymentStatus, Double discountApplied,
                 String insuranceApplied, Double finalAmount,
                 String billingDate) {
    this.patientId = patientId;
    this.amount = amount;
    this.paymentMode = paymentMode;
    this.paymentStatus = paymentStatus;
    this.discountApplied = discountApplied;
    this.insuranceApplied = insuranceApplied;
    this.finalAmount = finalAmount;
    this.billingDate = billingDate;
  }

  @Override
  public int getPatientId() {
    return patientId;
  }

  @Override
  public void setPatientId(int patientId) {
    this.patientId = patientId;
  }

  @Override
  public Double getAmount() {
    return amount;
  }

  @Override
  public void setAmount(Double amount) {
    this.amount = amount;
  }

  @Override
  public String getPaymentMode() {
    return paymentMode;
  }

  @Override
  public void setPaymentMode(String paymentMode) {
    this.paymentMode = paymentMode;
  }

  @Override
  public String getPaymentStatus() {
    return paymentStatus;
  }

  @Override
  public void setPaymentStatus(String paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  @Override
  public Double getDiscountApplied() {
    return discountApplied;
  }

  @Override
  public void setDiscountApplied(Double discountApplied) {
    this.discountApplied = discountApplied;
  }

  @Override
  public String getInsuranceApplied() {
    return insuranceApplied;
  }

  @Override
  public void setInsuranceApplied(String insuranceApplied) {
    this.insuranceApplied = insuranceApplied;
  }

  @Override
  public Double getFinalAmount() {
    return finalAmount;
  }

  @Override
  public void setFinalAmount(Double finalAmount) {
    this.finalAmount = finalAmount;
  }

  @Override
  public String getBillingDate() {
    return billingDate;
  }

  @Override
  public void setBillingDate(String billingDate) {
    this.billingDate = billingDate;
  }

  @Override
  public boolean isValid() {
    return (patientId > 0 && amount > 0 && paymentMode != "" &&
        paymentStatus != "" && discountApplied >= 0 &&
        insuranceApplied != "" && finalAmount > 0 && billingDate != "");
  }

  @Override
  public boolean savePayment(Connection connection,
                             IPaymentPersistence iPaymentPersistence) {
    return iPaymentPersistence.savePayment(this, connection);
  }
}
