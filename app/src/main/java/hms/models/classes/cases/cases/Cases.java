/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains Cases class which will help to create case
 * objects
 */
package hms.models.classes.cases.cases;

import hms.database.interfaces.cases.casepersistence.ICasePersistence;
import hms.models.interfaces.cases.cases.ICases;
import hms.models.interfaces.disease.zerotoonescale.IZeroToOneScale;
import java.sql.Connection;

public class Cases implements ICases {

  private int caseId;
  private int patientId;
  private int assignedDoctorId;
  private String description;
  private int diseaseId;
  private Double feedback;
  private int referenceId;
  private int policyId;
  private int amount;
  private String date;

  public Cases() {}

  public Cases(int patientId, int assignedDoctorId, String description,
      int diseaseId, Double feedback, int referenceId, int policyId, int amount,
      String date) {
    this.patientId = patientId;
    this.assignedDoctorId = assignedDoctorId;
    this.description = description;
    this.diseaseId = diseaseId;
    this.feedback = feedback;
    this.referenceId = referenceId;
    this.policyId = policyId;
    this.amount = amount;
    this.date = date;
  }

  @Override
  public int getCaseId() {
    return caseId;
  }

  @Override
  public void setCaseId(int caseId) {
    this.caseId = caseId;
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
  public String getDescription() {
    return description;
  }

  @Override
  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public int getDiseaseId() {
    return diseaseId;
  }

  @Override
  public void setDiseaseId(int diseaseId) {
    this.diseaseId = diseaseId;
  }

  @Override
  public Double getFeedback() {
    return feedback;
  }

  @Override
  public void setFeedback(Double feedback) {
    this.feedback = feedback;
  }

  @Override
  public int getReferenceId() {
    return referenceId;
  }

  @Override
  public void setReferenceId(int referenceId) {
    this.referenceId = referenceId;
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
  public int getAmount() {
    return amount;
  }

  @Override
  public void setAmount(int amount) {
    this.amount = amount;
  }

  @Override
  public String getDate() {
    return date;
  }

  @Override
  public void setDate(String date) {
    this.date = date;
  }

  @Override
  public boolean isValid(IZeroToOneScale factorChecker) {
    boolean notNull = (description != null && date != null);
    if (!notNull) {
      return false;
    }
    return (patientId > 0 && !description.equals("") && diseaseId > 0 &&
        amount >= 0 &&
        factorChecker.isCorrectFormat(feedback) && !date.equals(""));
  }

  @Override
  public boolean save(Connection connection, ICasePersistence casePersistence,
      IZeroToOneScale factorChecker) {
    if (isValid(factorChecker)) {
      return casePersistence.saveCase(this, connection);
    }
    return false;
  }

  @Override
  public boolean load(Integer caseId, Connection connection,
      ICasePersistence casePersistence,
      IZeroToOneScale factorChecker) {
    casePersistence.getCase(caseId, this, connection);
    return this.isValid(factorChecker);
  }

  @Override
  public boolean update(Connection connection, ICasePersistence casePersistence,
      IZeroToOneScale factorChecker) {
    if (isValid(factorChecker)) {
      return casePersistence.updateCase(this, connection);
    }
    return false;
  }
}