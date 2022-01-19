/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains Insurance class which will help to create
 * Insurance objects
 */
package hms.models.classes.insurance.insurance;

import hms.database.interfaces.insurance.insurancepersistence.IInsurancePersistence;
import hms.models.interfaces.disease.datacomparator.IDateComparator;
import hms.models.interfaces.insurance.insurance.IInsurance;
import java.sql.Connection;
import java.sql.Date;

public class Insurance implements IInsurance {

  private Integer policyId;
  private String name;
  private String description;
  private Integer amountCovered;
  private String startDate;
  private String endDate;
  private Integer policyType;

  public Insurance(String name, String description, Integer amountCovered,
      String startDate, String endDate, Integer policyType) {
    this.name = name;
    this.description = description;
    this.amountCovered = amountCovered;
    this.startDate = startDate;
    this.endDate = endDate;
    this.policyType = policyType;
  }

  public Insurance() {}

  @Override
  public Integer getPolicyId() {
    return policyId;
  }

  @Override
  public void setPolicyId(Integer policyId) {
    this.policyId = policyId;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
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
  public Integer getAmountCovered() {
    return amountCovered;
  }

  @Override
  public void setAmountCovered(Integer amountCovered) {
    this.amountCovered = amountCovered;
  }

  @Override
  public String getStartDate() {
    return startDate;
  }

  @Override
  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  @Override
  public String getEndDate() {
    return endDate;
  }

  @Override
  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  @Override
  public Integer getPolicyType() {
    return policyType;
  }

  @Override
  public void setPolicyType(Integer type) {
    this.policyType = type;
  }

  @Override
  public boolean isValid(IDateComparator dateComparator) {
    boolean notNull =
        (name != null && description != null && startDate != null &&
            endDate != null);
    if (!notNull) {
      return false;
    }
    boolean notEmpty =
        !name.equals("") && !description.equals("") && !startDate.equals("") &&
            !endDate.equals("");
    boolean areDatesValid =
        dateComparator.compare(Date.valueOf(startDate), Date.valueOf(endDate));
    return notEmpty && areDatesValid && amountCovered > 0 &&
        (policyType == 0 || policyType == 1);
  }

  @Override
  public boolean save(Connection connection,
      IInsurancePersistence insurancePersistence,
      IDateComparator dateComparator) {
    if (isValid(dateComparator)) {
      return insurancePersistence.saveInsurance(this, connection);
    }
    return false;
  }

  @Override
  public boolean load(Integer policyId, Connection connection,
      IInsurancePersistence insurancePersistence,
      IDateComparator dateComparator) {
    insurancePersistence.getInsurance(policyId, this, connection);
    return this.isValid(dateComparator);
  }

  @Override
  public boolean update(Connection connection,
      IInsurancePersistence insurancePersistence,
      IDateComparator dateComparator) {
    if (isValid(dateComparator)) {
      return insurancePersistence.updateInsurance(this, connection);
    }
    return false;
  }
}