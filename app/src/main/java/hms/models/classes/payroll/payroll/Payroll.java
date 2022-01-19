/**
 * @author Eklavya Nautiyal
 * @description Creating Payroll Creating Payroll Databridge interface
 */
package hms.models.classes.payroll.payroll;

import hms.models.interfaces.payroll.payroll.IPayroll;

public class Payroll implements IPayroll {

  // Declaring private variables
  private int doctorID;
  private Double amount;
  private int age;
  private Double attendance;
  private Double pendingAmount;
  private Double overtimeAmount;
  private Double profitIncentive;
  private Double taxDeducted;
  private Double totalAmount;

  public Payroll(int doctorID, Double amount, int age, Double attendance,
                 Double pendingAmount, Double overtimeAmount, Double profitIncentive,
                 Double taxDeducted, Double totalAmount) {

    this.doctorID = doctorID;
    this.amount = amount;
    this.age = age;
    this.attendance = attendance;
    this.pendingAmount = pendingAmount;
    this.overtimeAmount = overtimeAmount;
    this.profitIncentive = profitIncentive;
    this.taxDeducted = taxDeducted;
    this.totalAmount = totalAmount;
  }

  public Payroll() {

  }

  @Override
  public int getDoctorID() {
    return doctorID;
  }

  @Override
  public void setDoctorID(int doctorID) {
    this.doctorID = doctorID;
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
  public int getAge() {
    return age;
  }

  @Override
  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public Double getAttendence() {
    return attendance;
  }

  @Override
  public void setAttendence(Double attendance) {
    this.attendance = attendance;
  }

  @Override
  public Double getPendingAmount() {
    return pendingAmount;
  }

  @Override
  public void setPendingAmount(Double pendingAmount) {
    this.pendingAmount = pendingAmount;
  }

  @Override
  public Double getOvertimeAmount() {
    return overtimeAmount;
  }

  @Override
  public void setOvertimeAmount(Double overtimeAmount) {
    this.overtimeAmount = overtimeAmount;
  }

  @Override
  public Double getProfitIncentive() {
    return profitIncentive;
  }

  @Override
  public void setProfitIncentive(Double profitIncentive) {
    this.profitIncentive = profitIncentive;
  }

  @Override
  public Double getTaxDeducted() {
    return taxDeducted;
  }

  @Override
  public void setTaxDeducted(Double taxDeducted) {
    this.taxDeducted = taxDeducted;
  }

  @Override
  public Double getTotalAmount() {
    return totalAmount;
  }

  @Override
  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }
}