/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains test cases for DateComparator class
 */
package hms.models.disease.datacomparator;

import hms.models.classes.disease.datacomparator.DateComparator;
import hms.models.interfaces.disease.datacomparator.IDateComparator;
import org.junit.Test;
import java.sql.Date;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DateComparatorTest {

  IDateComparator comparator = new DateComparator();

  /**
   * compare method returns true if startDate and endDate are in
   * correct sequence
   */
  @Test
  public void testCompareTrue() {
    Date startDate = Date.valueOf("2021-01-01");
    Date endDate = Date.valueOf("2021-01-07");
    assertTrue("startDate and endDate are not in correct sequence.",
        comparator.compare(startDate, endDate));
  }

  /**
   * compare method returns false if startDate and endDate are not in correct
   * sequence
   */
  @Test
  public void testCompareFalse() {
    Date startDate = Date.valueOf("2021-01-10");
    Date endDate = Date.valueOf("2021-01-07");
    assertFalse("startDate and endDate are in correct sequence.",
        comparator.compare(startDate, endDate));
  }

  /* compare method returns true if startDate and endDate are equal */
  @Test
  public void testCompareEqualDates() {
    Date startDate = Date.valueOf("2021-01-01");
    Date endDate = Date.valueOf("2021-01-01");
    assertTrue("startDate and endDate are neither equal nor in sequence.",
        comparator.compare(startDate, endDate));
  }
}