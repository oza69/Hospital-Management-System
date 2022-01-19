/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains interface for CasePersistence class which
 * handles various operations for CASES table in database
 */
package hms.database.interfaces.cases.casepersistence;

import hms.models.interfaces.cases.cases.ICases;
import java.sql.Connection;
import java.util.Map;

public interface ICasePersistence {

  /**
   * This method helps to insert record in CASES table
   * @param iCases Case object to store in table
   * @param connection Connection object to handle database connection
   * @return True if data is stored successfully into CASES table
   */
  boolean saveCase(ICases iCases, Connection connection);

  /**
   * This method helps to get a case from table
   * @param caseId Case id which is required
   * @param iCases Case object to store retrieved data
   * @param connection Connection object to handle database connection
   * @return True if the case successfully retrieved
   */
  Boolean getCase(Integer caseId, ICases iCases, Connection connection);

  /**
   * This method helps to update record in CASE table
   * @param iCases Case object to update in table
   * @param connection Connection object to handle database connection
   * @return True if data is updated successfully in CASE table
   */
  boolean updateCase(ICases iCases, Connection connection);

  /**
   * This method helps to retrieve all records in CASES table
   * @param connection Connection object to handle database connection
   * @return Map of data if retrieved successfully from the CASES table,
   * else return null
   */
  Map<Integer, ICases> getAllCases(Connection connection);
}