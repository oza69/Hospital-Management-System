/**
 * @author Vishvesh Bharatbhai Naik
 * @description Patient's setter, getter
 */
package hms.models.classes.patients.patients;

import hms.models.interfaces.patients.patients.IPatients;

public class Patients implements IPatients {

  private int patientId;
  private int assignedDoctorId;
  private String patientFullName;
  private String addressName;
  private String genderName;
  private int ageNo;
  private String bloodGroup;
  private String arrivalDate;
  private int contactNo;
  private String diseaseName;
  private String bPLInfo;
  private Double annualIncome;
  private int feedbackNo;
  private int policyId;
  private String governmentScheme;
  private int packageId;

  public Patients(int assignedDoctorId, String patientFullName,
                  String addressName, String genderName, int ageNo,
                  String bloodGroup, String arrivalDate, int contactNo,
                  String diseaseName, String bPLInfo, Double annualIncome,
                  int feedbackNo, int policyId, String governmentScheme,
                  int packageId) {
    this.assignedDoctorId = assignedDoctorId;
    this.patientFullName = patientFullName;
    this.addressName = addressName;
    this.genderName = genderName;
    this.ageNo = ageNo;
    this.bloodGroup = bloodGroup;
    this.arrivalDate = arrivalDate;
    this.contactNo = contactNo;
    this.diseaseName = diseaseName;
    this.bPLInfo = bPLInfo;
    this.annualIncome = annualIncome;
    this.feedbackNo = feedbackNo;
    this.policyId = policyId;
    this.governmentScheme = governmentScheme;
    this.packageId = packageId;
  }

  public Patients() {
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
  public int getAssignedDoctorId() {
    return assignedDoctorId;
  }

  @Override
  public void setAssignedDoctorId(int assignedDoctorId) {
    this.assignedDoctorId = assignedDoctorId;
  }

  @Override
  public String getPatientFullName() {
    return patientFullName;
  }

  @Override
  public void setPatientFullName(String patientFullName) {
    this.patientFullName = patientFullName;
  }

  @Override
  public String getAddressName() {
    return addressName;
  }

  @Override
  public void setAddressName(String addressName) {
    this.addressName = addressName;
  }

  @Override
  public String getGenderName() {
    return genderName;
  }

  @Override
  public void setGenderName(String genderName) {
    this.genderName = genderName;
  }

  @Override
  public int getAgeNo() {
    return ageNo;
  }

  @Override
  public void setAgeNo(int ageNo) {
    this.ageNo = ageNo;
  }

  @Override
  public String getBloodGroup() {
    return bloodGroup;
  }

  @Override
  public void setBloodGroup(String bloodGroup) {
    this.bloodGroup = bloodGroup;
  }

  @Override
  public String getArrivalDate() {
    return arrivalDate;
  }

  @Override
  public void setArrivalDate(String arrivalDate) {
    this.arrivalDate = arrivalDate;
  }

  @Override
  public int getContactNo() {
    return contactNo;
  }

  @Override
  public void setContactNo(int contactNo) {
    this.contactNo = contactNo;
  }

  @Override
  public String getDiseaseName() {
    return diseaseName;
  }

  @Override
  public void setDiseaseName(String diseaseName) {
    this.diseaseName = diseaseName;
  }

  @Override
  public String getbPLInfo() {
    return bPLInfo;
  }

  @Override
  public void setbPLInfo(String bPLInfo) {
    this.bPLInfo = bPLInfo;
  }

  @Override
  public Double getAnnualIncome() {
    return annualIncome;
  }

  @Override
  public void setAnnualIncome(Double annualIncome) {
    this.annualIncome = annualIncome;
  }

  @Override
  public int getFeedbackNo() {
    return feedbackNo;
  }

  @Override
  public void setFeedbackNo(int feedbackNo) {
    this.feedbackNo = feedbackNo;
  }

  @Override
  public int getPolicyId() {
    return policyId;
  }

  @Override
  public void setPolicyId(int policyId) {
    this.policyId = policyId;
  }

  @Override
  public String getGovernmentScheme() {
    return governmentScheme;
  }

  @Override
  public void setGovernmentScheme(String governmentScheme) {
    this.governmentScheme = governmentScheme;
  }

  @Override
  public int getPackageId() {
    return packageId;
  }

  @Override
  public void setPackageId(int packageId) {
    this.packageId = packageId;
  }

  @Override
  public boolean isValid() {
    return (assignedDoctorId != 0 && patientFullName != "" &&
        addressName != "" && genderName != "" && ageNo > 0 &&
        bloodGroup != "" && arrivalDate != "" && contactNo > 0 &&
        diseaseName != "" && bPLInfo != "" && annualIncome > 0 &&
        feedbackNo > 0 && policyId > 0 && governmentScheme != "" &&
        packageId > 0);
  }
}