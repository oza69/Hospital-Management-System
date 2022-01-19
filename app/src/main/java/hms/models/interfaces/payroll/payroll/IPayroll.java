/**
 * @author Eklavya Nautiyal
 * @description Creating Payroll Creating Payroll interface to insert payroll
 * data and retrieve data from database
 */
package hms.models.interfaces.payroll.payroll;

/**
 * Creating Payroll interface
 */
public interface IPayroll {

  /**
   * Getter method for doctorID
   * @return doctorID
   */
  int getDoctorID();


  /**
   * Setter method for doctorID
   * @param doctorID doctorID for the case
   */
  void setDoctorID(int doctorID);


  /**
   * Getter method for amount
   * @return Amount
   */
  Double getAmount();

  /**
   * Setter method for amount
   * @param amount Total amount for the case
   */
  void setAmount(Double amount);

  /**
   * Getter method for case description
   * @return age
   */
  int getAge();

  /**
   * Setter method for description
   * @param age age of doctor
   */
  void setAge(int age);

  /**
   * Getter method for Attendence
   * @return Attendence
   */
  Double getAttendence();

  /**
   * Setter method for attendance
   * @param attendance attendance of the doctor
   */
  void setAttendence(Double attendance);

  /**
   * Getter method for PendingAmount
   * @return PendingAmount
   */
  Double getPendingAmount();

  /**
   * Setter method for feedback
   * @param pendingAmount Feedback for the case
   */
  void setPendingAmount(Double pendingAmount);

  /**
   * Getter method for OvertimeAmount
   * @return OvertimeAmount
   */
  Double getOvertimeAmount();

  /**
   * Setter method for reference id
   * @param overtimeAmount OvertimeAmount of any doctor
   */
  void setOvertimeAmount(Double overtimeAmount);

  /**
   * Getter method for ProfitIncentive
   * @return Profit Sharing Incentive
   */
  Double getProfitIncentive();

  /**
   * Setter method for ProfitIncentive
   * @param profitIncentive ProfitIncentive for the doctor , if available
   */
  void setProfitIncentive(Double profitIncentive);


  /**
   * Getter method for TaxDeducted
   * @return TaxDeducted
   */
  Double getTaxDeducted();

  /**
   * Setter method for date
   * @param taxDeducted Date of the case
   */
  void setTaxDeducted(Double taxDeducted);

  /**
   * Getter method for TotalAmount
   * @return TotalAmount
   */
  Double getTotalAmount();

  /**
   * Setter method for totalAmount
   * @param totalAmount total amount
   */
  void setTotalAmount(Double totalAmount);
}

