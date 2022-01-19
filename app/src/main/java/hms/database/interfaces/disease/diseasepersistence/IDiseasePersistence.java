/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains interface for DiseasePersistence class which
 * handles various operations for DISEASE table in database
 */
package hms.database.interfaces.disease.diseasepersistence;

import hms.models.interfaces.disease.disease.IDisease;
import java.sql.Connection;
import java.util.Map;

public interface IDiseasePersistence {

  /**
   * This method helps to insert record in DISEASE table
   * @param disease Disease object to store in table
   * @param connection Connection object to handle database connection
   * @return True if data is stored successfully into DISEASE table
   */
  boolean saveDisease(IDisease disease, Connection connection);

  /**
   * This method helps to get a DISEASE from table
   * @param diseaseId Disease id which is required
   * @param connection Connection object to handle database connection
   * @return True if disease successfully retrieved
   */
  Boolean getDisease(Integer diseaseId, IDisease disease,
      Connection connection);

  /**
   * This method helps to update record in DISEASE table
   * @param disease Disease object to update in table
   * @param connection Connection object to handle database connection
   * @return True if data is updated successfully in DISEASE table
   */
  boolean updateDisease(IDisease disease, Connection connection);

  /**
   * This method helps to retrieve all records from DISEASE table
   * @param connection Connection object to handle database connection
   * @return Returns Map of diseases if retrieved successfully from the DISEASE
   * table, else return null
   */
  Map<Integer, IDisease> getAllDiseases(Connection connection);
}