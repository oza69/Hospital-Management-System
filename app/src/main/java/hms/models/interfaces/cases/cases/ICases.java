/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains Cases interface which will help to implement
 * cases class
 */
package hms.models.interfaces.cases.cases;

import hms.database.interfaces.cases.casepersistence.ICasePersistence;
import hms.models.interfaces.disease.zerotoonescale.IZeroToOneScale;
import java.sql.Connection;

public interface ICases {

  /**
   * Getter method for case id
   * @return case id
   */
  int getCaseId();

  /**
   * Setter method for case id
   * @param caseId Case id for the patient
   */
  void setCaseId(int caseId);

  /**
   * Getter method for patient id
   * @return Patient id
   */
  int getPatientId();

  /**
   * Setter method for patient id
   * @param patientId Patient id for the case
   */
  void setPatientId(int patientId);

  /**
   * Getter method for doctor id
   * @return doctor id
   */
  int getAssignedDoctorId();

  /**
   * Setter method for doctor id
   * @param assignedDoctorId Doctor id for the case
   */
  void setAssignedDoctorId(int assignedDoctorId);

  /**
   * Getter method for case description
   * @return Description
   */
  String getDescription();

  /**
   * Setter method for description
   * @param description Description about the case
   */
  void setDescription(String description);

  /**
   * Getter method for disease id
   * @return Disease id
   */
  int getDiseaseId();

  /**
   * Setter method for disease id
   * @param diseaseId Disease id of the case
   */
  void setDiseaseId(int diseaseId);

  /**
   * Getter method for feedback
   * @return Feedback
   */
  Double getFeedback();

  /**
   * Setter method for feedback
   * @param feedback Feedback for the case
   */
  void setFeedback(Double feedback);

  /**
   * Getter method for reference id
   * @return Reference id
   */
  int getReferenceId();

  /**
   * Setter method for reference id
   * @param referenceId Reference id of any doctor, if available
   */
  void setReferenceId(int referenceId);

  /**
   * Getter method for policy id
   * @return Policy id
   */
  int getPolicyId();

  /**
   * Setter method for policy id
   * @param policyId Policy id for the patient , if available
   */
  void setPolicyId(int policyId);

  /**
   * This method validates the case object
   * @param factorChecker ZeroToOneScale object to check factor format
   * @return True if all variables are valid
   */
  boolean isValid(IZeroToOneScale factorChecker);

  /**
   * Getter method for amount
   * @return Amount
   */
  int getAmount();

  /**
   * Setter method for amount
   * @param amount Total amount for the case
   */
  void setAmount(int amount);

  /**
   * Getter method for date
   * @return Date
   */
  String getDate();

  /**
   * Setter method for date
   * @param date Date of the case
   */
  void setDate(String date);

  /**
   * This method saves case in the database
   * @param connection Connection object to perform sql operations
   * @param casePersistence casePersistence object to interact with cases table
   * @return True if case saved
   */
  boolean save(Connection connection, ICasePersistence casePersistence,
      IZeroToOneScale factorChecker);

  /**
   * This method loads case from the database
   * @param caseID CaseID which is required
   * @param connection Connection object to perform sql operations
   * @param casePersistence casePersistence object to interact with case table
   * @param factorChecker factorChecker to check feedback for case
   * @return True if case loaded
   */
  boolean load(Integer caseID, Connection connection,
      ICasePersistence casePersistence,
      IZeroToOneScale factorChecker);

  /**
   * This method updates case in the database
   * @param connection Connection object to perform sql operations
   * @param casePersistence casePersistence object to interact with case table
   * @param factorChecker factorChecker to check feedback for case
   * @return True if case loaded
   */
  boolean update(Connection connection, ICasePersistence casePersistence,
      IZeroToOneScale factorChecker);
}