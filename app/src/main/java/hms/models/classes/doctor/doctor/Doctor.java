/**
 * @author Dhruv Oza
 * @description : This class will set and get all values passed in
 * constructor as Doctor
 */
package hms.models.classes.doctor.doctor;

import hms.models.interfaces.doctor.doctor.IDoctor;

public class Doctor implements IDoctor {

  private String fullName;
  private String gender;
  private String address;
  private int contactNo;
  private String dob;
  private String speciality;
  private String status;
  private double workingHours;
  private double efficiencyIndex;
  private String dateOfWorking;
  private double revenueShared;
  private int policyID;

  public Doctor(String fullName, String gender, String address,
                int contactNo, String dob, String speciality, String status,
                double workingHours, double efficiencyIndex,
                String dateOfWorking, double revenueShared, int policyID) {
    this.fullName = fullName;
    this.gender = gender;
    this.address = address;
    this.contactNo = contactNo;
    this.dob = dob;
    this.speciality = speciality;
    this.status = status;
    this.workingHours = workingHours;
    this.efficiencyIndex = efficiencyIndex;
    this.dateOfWorking = dateOfWorking;
    this.revenueShared = revenueShared;
    this.policyID = policyID;
  }

  /* Constructor as Doctor */
  public Doctor() {
  }

  /* getter method */
  public String getFullName() {
    return fullName;
  }

  /* setter method */
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  /* getter method */
  public String getGender() {
    return gender;
  }

  /* setter method */
  public void setGender(String gender) {
    this.gender = gender;
  }

  /* getter method */
  public String getAddress() {
    return address;
  }

  /* setter method */
  public void setAddress(String address) {
    this.address = address;
  }

  /* getter method */
  public int getContactNo() {
    return contactNo;
  }

  /* setter method */
  public void setContactNo(int contactNo) {
    this.contactNo = contactNo;
  }

  /* getter method */
  public String getDob() {
    return dob;
  }

  /* setter method */
  public void setDob(String dob) {
    this.dob = dob;
  }

  /* getter method */
  public String getSpeciality() {
    return speciality;
  }

  /* setter method */
  public void setSpeciality(String speciality) {
    this.speciality = speciality;
  }

  /* getter method */
  public String getStatus() {
    return status;
  }

  /* setter method */
  public void setStatus(String status) {
    this.status = status;
  }

  /* getter method */
  public double getWorkingHours() {
    return workingHours;
  }

  /* setter method */
  public void setWorkingHours(double workingHours) {
    this.workingHours = workingHours;
  }

  /* getter method */
  public double getEfficiencyIndex() {
    return efficiencyIndex;
  }

  /* setter method */
  public void setEfficiencyIndex(double efficiencyIndex) {
    this.efficiencyIndex = efficiencyIndex;
  }

  /* getter method */
  public String getDateOfWorking() {
    return dateOfWorking;
  }

  /* setter method */
  public void setDateOfWorking(String dateOfWorking) {
    this.dateOfWorking = dateOfWorking;
  }

  /* getter method */
  public double getRevenueShared() {
    return revenueShared;
  }

  /* setter method */
  public void setRevenueShared(double revenueShared) {
    this.revenueShared = revenueShared;
  }

  /* getter method */
  public int getPolicyID() {
    return policyID;
  }

  /* setter method */
  public void setPolicyID(int policyID) {
    this.policyID = policyID;
  }

  /* check if entered details are valid or not */
  public boolean isValid() {
    return (policyID > 0 && contactNo > 0 && gender != "" &&
        fullName != "" && dob != null && address != "" &&
        workingHours > 0 && speciality != "" && revenueShared > 0 &&
        dateOfWorking != null && status != "" && efficiencyIndex > 0);
  }
}
