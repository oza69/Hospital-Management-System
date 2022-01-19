/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains Disease interface which will help to implement
 * Disease class
 */
package hms.models.interfaces.disease.disease;

import hms.database.interfaces.disease.diseasepersistence.IDiseasePersistence;
import hms.models.interfaces.disease.zerotoonescale.IZeroToOneScale;
import java.sql.Connection;

public interface IDisease {

  /**
   * Getter method for disease id
   * @return Id of the disease
   */
  Integer getId();

  /**
   * Setter method for disease id
   * @param id Id of the disease
   */
  void setId(Integer id);

  /**
   * Getter method for disease name
   * @return Name of the disease
   */
  String getName();

  /**
   * Setter method for disease name
   * @param name Name of the disease
   */
  void setName(String name);

  /**
   * Getter method for disease description
   * @return Description of the disease
   */
  String getDescription();

  /**
   * Setter method for disease description
   * @param description Description about the disease
   */
  void setDescription(String description);

  /**
   * Getter method for fatality risk factor
   * @return Fatality risk factor between 0 to 1
   */
  Double getFatalityRiskFactor();

  /**
   * Setter method for fatality risk factor of the disease
   * @param fatalityRiskFactor Fatality risk factor between 0 to 1
   */
  void setFatalityRiskFactor(Double fatalityRiskFactor);

  /**
   * Getter method for contagious risk factor
   * @return Contagious risk factor between 0 to 1
   */
  Double getContagiousRiskFactor();

  /**
   * Setter method for contagious risk factor of the disease
   * @param contagiousRiskFactor Contagious risk factor between 0 to 1
   */
  void setContagiousRiskFactor(Double contagiousRiskFactor);

  /**
   * This method checks for valid parameters
   * @param factorChecker ZeroToOneScale object to check factor range
   * @return True if all parameters are correct
   */
  boolean isValid(IZeroToOneScale factorChecker);

  /**
   * This method saves disease in the database
   * @param connection Connection object to perform sql operations
   * @param diseasePersistence DiseasePersistence object to interact with disease table
   * @param factorChecker factorChecker to check risk factors for disease
   * @return True if disease saved
   */
  boolean save(Connection connection, IDiseasePersistence diseasePersistence,
      IZeroToOneScale factorChecker);

  /**
   * This method loads disease from the database
   * @param connection Connection object to perform sql operations
   * @param diseasePersistence DiseasePersistence object to interact with disease table
   * @param factorChecker factorChecker to check risk factors for disease
   * @return True if disease loaded
   */
  boolean load(Integer diseaseId, Connection connection,
      IDiseasePersistence diseasePersistence,
      IZeroToOneScale factorChecker);

  /**
   * This method updates disease in the database
   * @param connection Connection object to perform sql operations
   * @param diseasePersistence DiseasePersistence object to interact with disease table
   * @param factorChecker factorChecker to check risk factors for disease
   * @return True if disease loaded
   */
  boolean update(Connection connection, IDiseasePersistence diseasePersistence,
      IZeroToOneScale factorChecker);
}