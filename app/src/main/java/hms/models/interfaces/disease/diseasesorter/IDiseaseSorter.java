/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains DiseaseSorter interface which will help to
 * implement DiseaseSorter class
 */
package hms.models.interfaces.disease.diseasesorter;

import java.util.Map;

public interface IDiseaseSorter<K, Number> {

  /**
   * This method sorts disease list according to value in descending order.
   * @param list Map of diseases with key and value
   * @return This method returns Map in descending order
   */
  Map<K, Number> sortByValue(Map<K, Number> list);
}