/**
 * @author Vishvesh Bharatbhai Naik
 * @description Patient's setter, getter
 */
package hms.models.interfaces.patients.patients;

public interface IPatients {

  /**
   * Getter method for Patient Id
   * @return Patient Id as output
   */
  int getPatientId();

  /**
   * Setter method for Patient Id
   * @param patientId patientId as input
   */
  void setPatientId(int patientId);

  /**
   * Getter method for Assigned Doctor Id
   * @return assignedDoctorId
   */
  int getAssignedDoctorId();

  /**
   * Setter method for Assigned Doctor Id
   * @param assignedDoctorId Assigned Doctor Id
   */
  void setAssignedDoctorId(int assignedDoctorId);

  /**
   * Getter method for Patient Full Name
   * @return patientFullName
   */
  String getPatientFullName();

  /**
   * Setter method for Patient Full Name
   * @param patientFullName Patient Full Name
   */
  void setPatientFullName(String patientFullName);

  /**
   * Getter method of Address
   * @return Address Name
   */
  String getAddressName();

  /**
   * Setter method for Address
   * @param addressName address_Name
   */
  void setAddressName(String addressName);

  /**
   * Getter method of Gender
   * @return Gender
   */
  String getGenderName();

  /**
   * Setter method of Gender
   * @param genderName gender_Name
   */
  void setGenderName(String genderName);

  /**
   * Getter method for Age
   * @return Age
   */
  int getAgeNo();

  /**
   * Setter method of age_no
   * @param ageNo age_no
   */
  void setAgeNo(int ageNo);

  /**
   * Getter method for bloodGroup
   * @return bloodGroup
   */
  String getBloodGroup();

  /**
   * Setter method of  bloodGroup
   * @param bloodGroup bloodGroup
   */
  void setBloodGroup(String bloodGroup);

  /**
   * Getter method for arrivalDate
   * @return arrivalDate
   */
  String getArrivalDate();

  /**
   * Setter method of arrivalDate
   * @param arrivalDate arrivalDate
   */
  void setArrivalDate(String arrivalDate);

  /**
   * Getter method for contactNo
   * @return contactNo
   */
  int getContactNo();

  /**
   * Setter method of contactNo
   * @param contactNo contactNo
   */
  void setContactNo(int contactNo);

  /**
   * Getter method for disease_Name
   * @return disease_Name
   */
  String getDiseaseName();

  /**
   * Setter method of disease_Name
   * @param diseaseName disease_Name
   */
  void setDiseaseName(String diseaseName);

  /**
   * Getter method for bPLInfo
   * @return bPLInfo
   */
  String getbPLInfo();

  /**
   * Setter method of bPLInfo
   * @param bPLInfo bPLInfo
   */
  void setbPLInfo(String bPLInfo);

  /**
   * Getter method for annualIncome
   * @return annualIncome
   */
  Double getAnnualIncome();

  /**
   * Setter method of annualIncome
   * @param annualIncome annualIncome
   */
  void setAnnualIncome(Double annualIncome);

  /**
   * Getter method for feedback_No
   * @return feedback_No
   */
  int getFeedbackNo();

  /**
   * Setter method of feedback_No
   * @param feedbackNo feedback_No
   */
  void setFeedbackNo(int feedbackNo);

  /**
   * Getter method for policyId
   * @return policyId
   */
  int getPolicyId();

  /**
   * Setter method of policyId
   * @param policyId policyId
   */
  void setPolicyId(int policyId);

  /**
   * Getter method of governmentScheme
   * @return governmentScheme
   */
  String getGovernmentScheme();

  /**
   * Setter method of governmentScheme
   * @param governmentScheme Government Scheme
   */
  void setGovernmentScheme(String governmentScheme);

  /**
   * Getter method of packageId
   * @return PackageId
   */
  int getPackageId();

  /**
   * Setter method of Package id
   * @param packageId packageId
   */
  void setPackageId(int packageId);

  /**
   * Validity Checker for all getters
   * @return true or false
   */
  boolean isValid();
}