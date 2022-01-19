/**
 * @author Dhruv Oza
 * @description : Test Doctor class
 */
package hms.models.doctor.doctor;

import hms.models.classes.doctor.doctor.Doctor;
import hms.models.interfaces.doctor.doctor.IDoctor;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DoctorTest {

  String fullname = "Ravi Patel";
  String gender = "M";
  String address = "Brunswick Street, Canada";
  int contactNo = 987654321;
  String speciality = "Surgeon";
  String status = "A";
  double workingHours = 9.00;
  double efficiencyIndex = 3.00;
  double revenueShared = 2300;
  int policyID = 4;
  public DoctorTest() throws ParseException {
  }
  String dob = "1996-04-02";
  String dateOfWorking = "1996-04-02";

  IDoctor iDoctor =
      new Doctor(fullname, gender, address, contactNo, dob,
          speciality, status, workingHours, efficiencyIndex,
          dateOfWorking, revenueShared, policyID);

  @Test
  @DisplayName("getFullName method")
  public void getFullNametest() {
    assertNotNull("Full Name is NULL", iDoctor.getFullName());
  }

  @Test
  @DisplayName("getGender method")
  public void getGendertest() {
    assertNotNull("Gender is NULL", iDoctor.getGender());
  }

  @Test
  @DisplayName("getAddress method")
  public void getAddresstest() {
    assertNotNull("Address is NULL", iDoctor.getAddress());
  }

  @Test
  @DisplayName("getContactNo method")
  public void getContactNotest() {
    assertTrue("Contact No is less than zero",
        iDoctor.getContactNo() > 0);
  }

  @Test
  @DisplayName("getDob method")
  public void getDobtest() {
    assertNotNull("DOB is NULL",
        iDoctor.getDob());
  }

  @Test
  @DisplayName("getSpeciality method")
  public void getSpecialitytest() {
    assertNotNull("Speciality is NULL", iDoctor.getSpeciality());
  }

  @Test
  @DisplayName("getStatus method")
  public void getStatustest() {
    assertNotNull("Status is NULL", iDoctor.getStatus());
  }

  @Test
  @DisplayName("getWorkingHours method")
  public void getWorkingHourstest() {
    assertTrue("Working Hours is less than zero",
        iDoctor.getWorkingHours() > 0);
  }

  @Test
  @DisplayName("getEfficiencyIndex method")
  public void getEfficiencyIndextest() {
    assertTrue("Efficiency Index is less than zero",
        iDoctor.getEfficiencyIndex() > 0);
  }

  @Test
  @DisplayName("getDateOfWorking method")
  public void getDateOfWorkingtest() {
    assertNotNull("Date of Working is NULL",
        iDoctor.getDateOfWorking());
  }

  @Test
  @DisplayName("getRevenueShared method")
  public void getRevenueSharedtest() {
    assertTrue("Revenue Shared is less than zero",
        iDoctor.getRevenueShared() > 0);
  }

  @Test
  @DisplayName("getPolicyId method")
  public void getPolicyIDtest() {
    assertTrue("PolicyID is less than zero",
        iDoctor.getPolicyID() > 0);
  }

  @Test
  @DisplayName("isValid method")
  public void isValidtest() {
    assertTrue("Not valid case", iDoctor.isValid());
  }

  @Test
  @DisplayName("setFullName method")
  public void setFullNametest() {
    String newName = "Ravi Shah";
    iDoctor.setFullName(newName);
    assertEquals("Full name not updated", newName,
        iDoctor.getFullName());
  }

  @Test
  @DisplayName("setGender method")
  public void setGendertest() {
    String newGender = "M";
    iDoctor.setGender(newGender);
    assertEquals("Gender not updated", newGender,
        iDoctor.getGender());
  }

  @Test
  @DisplayName("setAddress method")
  public void setAddresstest() {
    String newAddress = "Bombay";
    iDoctor.setAddress(newAddress);
    assertEquals("Address not updated", newAddress,
        iDoctor.getAddress());
  }

  @Test
  @DisplayName("setContactNo method")
  public void setContactNotest() {
    int newContactNo = 2;
    iDoctor.setContactNo(newContactNo);
    assertEquals("ContactNo not updated", newContactNo,
        iDoctor.getContactNo());
  }

  @Test
  @DisplayName("setDob method")
  public void setDobtest() throws ParseException {
    iDoctor.setDob(dob);
    assertEquals("DOB not updated", dob, iDoctor.getDob());
  }

  @Test
  @DisplayName("setSpeciality method")
  public void setSpecialitytest() {
    String speciality = "Surgeon";
    iDoctor.setSpeciality(speciality);
    assertEquals("Speciality not updated", speciality,
        iDoctor.getSpeciality());
  }

  @Test
  @DisplayName("setStatus method")
  public void setStatustest() {
    String status = "A";
    iDoctor.setStatus(status);
    assertEquals("Status not updated", status, iDoctor.getStatus());
  }

  @Test
  @DisplayName("setWorkingHours method")
  public void setWorkingHourstest() {
    double hours = 9.00;
    iDoctor.setWorkingHours(hours);
    assertTrue(iDoctor.getWorkingHours() > 0);
  }

  @Test
  @DisplayName("setEfficiencyIndex method")
  public void setEfficiencyIndextest() {
    double index = 3.00;
    iDoctor.setEfficiencyIndex(index);
    assertTrue(iDoctor.getEfficiencyIndex() > 0);
  }

  @Test
  @DisplayName("setDateOfWorking method")
  public void setDateOfWorkingtest() throws ParseException {
    iDoctor.setDateOfWorking(dateOfWorking);
    assertEquals("Date of Working not updated", dateOfWorking,
        iDoctor.getDateOfWorking());
  }

  @Test
  @DisplayName("setRevenueShared method")
  public void setRevenueSharedtest() {
    double revenue = 3000.00;
    iDoctor.setRevenueShared(revenue);
    assertTrue(iDoctor.getRevenueShared() > 0);
  }

  @Test
  @DisplayName("setPolicyId method")
  public void setPolicyIDtest() {
    int policyID = 3;
    iDoctor.setPolicyID(policyID);
    assertTrue(iDoctor.getPolicyID() > 0);
  }
}
