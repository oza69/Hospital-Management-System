/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains test cases for DiseaseSorter class
 */
package hms.models.disease.diseasesorter;

import hms.models.classes.disease.diseasesorter.DiseaseSorter;
import hms.models.interfaces.disease.diseasesorter.IDiseaseSorter;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class DiseaseSorterTest {

  /* sortByValue method returns the sorted list of disease in descending */
  @Test
  public void testDiseaseSortByDouble() {
    Map<String, Double> list = new HashMap<>();
    list.put("Disease1", 0.5);
    list.put("Disease2", 0.7);
    list.put("Disease3", 0.9);
    Map<String, Double> expectedList = new HashMap<>();
    expectedList.put("Disease3", 0.9);
    expectedList.put("Disease2", 0.7);
    expectedList.put("Disease1", 0.5);
    IDiseaseSorter<String, Double> sorter = new DiseaseSorter<>();
    assertEquals("List is not sorted in descending by double value",
        expectedList, sorter.sortByValue(list));
  }

  /* sortByValue method returns the sorted list of disease in descending */
  @Test
  public void testDiseaseSortByInteger() {
    Map<Integer, Integer> list = new HashMap<>();
    list.put(1, 2);
    list.put(2, 5);
    list.put(3, 4);
    Map<Integer, Integer> expectedList = new HashMap<>();
    expectedList.put(2, 5);
    expectedList.put(3, 4);
    expectedList.put(1, 2);
    IDiseaseSorter<Integer, Integer> sorter = new DiseaseSorter<>();
    assertEquals("List is not sorted in descending by integer value",
        expectedList, sorter.sortByValue(list));
  }
}