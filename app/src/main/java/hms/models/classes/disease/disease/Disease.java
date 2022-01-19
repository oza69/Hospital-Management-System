/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains Disease class which will help to create
 * disease objects
 */
package hms.models.classes.disease.disease;

import hms.database.interfaces.disease.diseasepersistence.IDiseasePersistence;
import hms.models.interfaces.disease.disease.IDisease;
import hms.models.interfaces.disease.zerotoonescale.IZeroToOneScale;
import java.sql.Connection;

public class Disease implements IDisease {

  private Integer id;
  private String name;
  private String description;
  private Double fatalityRiskFactor;
  private Double contagiousRiskFactor;

  public Disease() {}

  public Disease(String name, String description, Double fatalityRiskFactor,
      Double contagiousRiskFactor) {
    this.name = name;
    this.description = description;
    this.fatalityRiskFactor = fatalityRiskFactor;
    this.contagiousRiskFactor = contagiousRiskFactor;
  }

  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public void setId(Integer id) {
    this.id = id;
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
  public Double getFatalityRiskFactor() {
    return fatalityRiskFactor;
  }

  @Override
  public void setFatalityRiskFactor(Double fatalityRiskFactor) {
    this.fatalityRiskFactor = fatalityRiskFactor;
  }

  @Override
  public Double getContagiousRiskFactor() {
    return contagiousRiskFactor;
  }

  @Override
  public void setContagiousRiskFactor(Double contagiousRiskFactor) {
    this.contagiousRiskFactor = contagiousRiskFactor;
  }

  @Override
  public boolean isValid(IZeroToOneScale factorChecker) {
    boolean isNotNull = (name != null && description != null);
    if (!isNotNull) {
      return false;
    }
    boolean isNotEmpty = (!name.equals("") && !description.equals(""));
    boolean isFactorsCorrect =
        factorChecker.isCorrectFormat(fatalityRiskFactor) &&
            factorChecker.isCorrectFormat(contagiousRiskFactor);
    return (isNotEmpty && isFactorsCorrect);
  }

  @Override
  public boolean save(Connection connection,
      IDiseasePersistence diseasePersistence, IZeroToOneScale factorChecker) {
    if (isValid(factorChecker)) {
      return diseasePersistence.saveDisease(this, connection);
    }
    return false;
  }

  @Override
  public boolean load(Integer diseaseId, Connection connection,
      IDiseasePersistence diseasePersistence, IZeroToOneScale factorChecker) {
    diseasePersistence.getDisease(diseaseId, this, connection);
    return this.isValid(factorChecker);
  }

  @Override
  public boolean update(Connection connection,
      IDiseasePersistence diseasePersistence, IZeroToOneScale factorChecker) {
    if (isValid(factorChecker)) {
      return diseasePersistence.updateDisease(this, connection);
    }
    return false;
  }
}