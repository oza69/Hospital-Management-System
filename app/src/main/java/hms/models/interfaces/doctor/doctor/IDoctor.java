/**
 * @author Dhruv Oza
 * @description : This class will set and get all values passed in
 * constructor as Doctor
 */
package hms.models.interfaces.doctor.doctor;

/* IDoctor as interface */
public interface IDoctor {

  public String getFullName(); /* getter method */

  public void setFullName(String fullName); /* setter method */

  public String getGender(); /* getter method */

  public void setGender(String gender); /* setter method */

  public String getAddress(); /* getter method */

  public void setAddress(String address); /* setter method */

  public int getContactNo(); /* getter method */

  public void setContactNo(int contactNo); /* setter method */

  public String getDob(); /* getter method */

  public void setDob(String dob); /* setter method */

  public String getSpeciality(); /* getter method */

  public void setSpeciality(String speciality); /* setter method */

  public String getStatus(); /* getter method */

  public void setStatus(String status); /* setter method */

  public double getWorkingHours(); /* getter method */

  public void setWorkingHours(double workingHours); /* setter method */

  public double getEfficiencyIndex(); /* getter method */

  public void setEfficiencyIndex(double efficiencyIndex); /* setter method */

  public String getDateOfWorking(); /* getter method */

  public void setDateOfWorking(String dateOfWorking); /* setter method */

  public double getRevenueShared(); /* getter method */

  public void setRevenueShared(double revenueShared); /* setter method */

  public int getPolicyID(); /* getter method */

  public void setPolicyID(int policyID); /* setter method */

  public boolean isValid(); /* check if entered details are valid or not */
}
