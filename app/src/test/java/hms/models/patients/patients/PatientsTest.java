/**
 * @author Vishvesh Bharatbhai Naik
 * @description Testing all the Patient's setter and getters
 */
package hms.models.patients.patients;

import hms.models.classes.patients.patients.Patients;
import hms.models.interfaces.patients.patients.IPatients;
import org.junit.Test;


import static org.junit.Assert.*;

public class PatientsTest {

  int assignedDoctorId = 1;
  String patientFullName = "Espi Das";
  String addressName = "18 - Anandnagar";
  String genderName = "Male";
  int ageNo = 5;
  String bloodGroup = "A+";
  String arrivalDate = "2021-02-01";
  int contactNo = 955845664;
  String diseaseName = "";
  String bPLInfo = "";
  Double annualIncome = 50000.0;
  int feedbackNo = 4;
  int policyId = 1;
  String governmentScheme = "NA";
  int packageId = 0;
  IPatients patients = new Patients(assignedDoctorId, patientFullName,
      addressName, genderName, ageNo, bloodGroup, arrivalDate, contactNo,
      diseaseName, bPLInfo, annualIncome, feedbackNo, policyId,
      governmentScheme, packageId);

  /**
   * GetAssignedDoctorId to get from Patient table
   */
  @Test
  public void testGetAssignedDoctorId() {
    assertTrue("Assigned Doctor Id is null",
        patients.getAssignedDoctorId() >= 0);
  }

  /**
   * SetAssignedDoctorId to set into Patient table
   */
  @Test
  public void testSetAssignedDoctorId() {
    int newDocId = 1;
    patients.setAssignedDoctorId(newDocId);
    assertEquals("Assigned Doctor Id not updated", newDocId,
        patients.getAssignedDoctorId());
  }

  /**
   * GetPatientFullName to get from Patient table
   */
  @Test
  public void testGetPatientFullName() {
    assertNotNull("Patient Full Name is null",
        patients.getPatientFullName());
  }

  /**
   * SetPatientFullName to set into Patient table
   */
  @Test
  public void testSetPatientFullName() {
    String name = "Dhruv";
    patients.setPatientFullName(name);
    assertEquals("Patient Full Name not updated", name,
        patients.getPatientFullName());
  }

  /**
   * GetAddress_Name to get from Patient table
   */
  @Test
  public void testGetAddressName() {
    assertNotNull("Address is null", patients.getAddressName());
  }

  /**
   * SetAddress_Name to set into Patient table
   */
  @Test
  public void testSetAddressName() {
    String address = "18 Anandnagar";
    patients.setAddressName(address);
    assertEquals("Address not updated", address,
        patients.getAddressName());
  }

  /**
   * GetGender_Name to get from Patient table
   */
  @Test
  public void testGetGenderName() {
    assertNotNull("Gender is null", patients.getGenderName());
  }

  /**
   * SetGender_Name to set into Patient table
   */
  @Test
  public void testSetGenderName() {
    String gender = "Male";
    patients.setGenderName(gender);
    assertEquals("Gender not updated", gender, patients.getGenderName());
  }

  /**
   * GetAge_no to get from Patient table
   */
  @Test
  public void testGetAgeNo() {
    assertTrue("Get Age is null", patients.getAgeNo() >= 0);
  }

  /**
   * SetAge_no to set into Patient table
   */
  @Test
  public void testSetAgeNo() {
    int newAge = 10;
    patients.setAgeNo(newAge);
    assertEquals("Age not updated", newAge, patients.getAgeNo());
  }

  /**
   * GetBloodGroup to get from Patient table
   */
  @Test
  public void testGetBloodGroup() {
    assertNotNull("Patient's Blood Group is null",
        patients.getBloodGroup());
  }

  /**
   * SetBloodGroup to set into Patient table
   */
  @Test
  public void testSetBloodGroup() {
    String newBlood = "A+";
    patients.setBloodGroup(newBlood);
    assertEquals("Patient's Blood Group not updated", newBlood,
        patients.getBloodGroup());
  }

  /**
   * GetArrivalDate to get from Patient table
   */
  @Test
  public void testGetArrivalDate() {
    assertNotNull("Arrival Date is null", patients.getArrivalDate());
  }

  /**
   * SetArrivalDate to set into Patient table
   */
  @Test
  public void testSetArrivalDate() {
    String newDate = "2021/01/02";
    patients.setArrivalDate(newDate);
    assertEquals("Arrival Date not updated", newDate,
        patients.getArrivalDate());
  }

  /**
   * GetContactNo to get from Patient table
   */
  @Test
  public void testGetContactNo() {
    assertTrue("Contact number is null",
        patients.getContactNo() >= 0);
  }

  /**
   * SetContactNo to set into Patient table
   */
  @Test
  public void testSetContactNo() {
    int newContact = 955885481;
    patients.setContactNo(newContact);
    assertEquals("Contact number not updated", newContact,
        patients.getContactNo());
  }

  /**
   * GetDisease_Name to get from Patient table
   */
  @Test
  public void testGetDiseaseName() {
    assertNotNull("Disease is null", patients.getDiseaseName());
  }

  /**
   * SetDisease_Name to set into Patient table
   */
  @Test
  public void testSetDiseaseName() {
    String newDisease = "Covid";
    patients.setDiseaseName(newDisease);
    assertEquals("Disease not updated", newDisease,
        patients.getDiseaseName());
  }

  /**
   * GetbPLInfo to get from Patient table
   */
  @Test
  public void testGetbPLInfo() {
    assertNotNull("Patient BPL is null", patients.getbPLInfo());
  }

  /**
   * SetbPLInfo to set into Patient table
   */
  @Test
  public void testSetbPLInfo() {
    String newInfo = "Yes";
    patients.setbPLInfo(newInfo);
    assertEquals("Patient BPL not updated", newInfo,
        patients.getbPLInfo());
  }

  /**
   * testGetAnnualIncome to get from Patient table
   */
  @Test
  public void testGetAnnualIncome() {
    assertTrue("Annual Income is null",
        patients.getAnnualIncome() >= 0);
  }

  /**
   * testSetAnnualIncome to set into Patient table
   */
  @Test
  public void testSetAnnualIncome() {
    Double newAmount = 545.0;
    patients.setAnnualIncome(newAmount);
    assertEquals("Annual Income updated", newAmount,
        patients.getAnnualIncome());
  }

  /**
   * testGetFeedback_No to get from Patient table
   */
  @Test
  public void testGetFeedbackNo() {
    assertTrue("Feedback is null",
        patients.getFeedbackNo() >= 0);
  }

  /**
   * testSetFeedback_No to set into Patient table
   */
  @Test
  public void testSetFeedbackNo() {
    int newFeedback = 2;
    patients.setFeedbackNo(newFeedback);
    assertEquals("Feedback not updated", newFeedback,
        patients.getFeedbackNo());
  }

  /**
   * testGetPolicyId to get from Patient table
   */
  @Test
  public void testGetPolicyId() {
    assertTrue("Policy id is null",
        patients.getPolicyId() >= 0);
  }

  /**
   * testSetPolicyId to set into Patient table
   */
  @Test
  public void testSetPolicyId() {
    int newPolicy = 5;
    patients.setPolicyId(newPolicy);
    assertEquals("Policy id not updated", newPolicy,
        patients.getPolicyId());
  }

  /**
   * testGetGovernmentScheme to get from Patient table
   */
  @Test
  public void testGetGovernmentScheme() {
    assertNotNull("Government Scheme is null",
        patients.getGovernmentScheme());
  }

  /**
   * testSetGovernmentScheme to set into Patient table
   */
  @Test
  public void testSetGovernmentScheme() {
    String newInfo = "Yes";
    patients.setGovernmentScheme(newInfo);
    assertEquals("Government Scheme not updated", newInfo,
        patients.getGovernmentScheme());
  }

  /**
   * testGetPackageId to get from Patient table
   */
  @Test
  public void testGetPackageId() {
    assertTrue("Package Id is null",
        patients.getPackageId() >= 0);
  }

  /**
   * testSetPackageId to set into Patient table
   */
  @Test
  public void testSetPackageId() {
    int newPackage = 2;
    patients.setPackageId(newPackage);
    assertEquals("Package Id not updated", newPackage,
        patients.getPackageId());
  }
}
