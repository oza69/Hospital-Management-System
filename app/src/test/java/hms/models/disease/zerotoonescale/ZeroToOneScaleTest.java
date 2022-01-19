/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains test cases for ZeroToOne class
 */
package hms.models.disease.zerotoonescale;

import hms.models.classes.disease.zerotoonescale.ZeroToOneScale;
import hms.models.interfaces.disease.zerotoonescale.IZeroToOneScale;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ZeroToOneScaleTest {

  IZeroToOneScale factorChecker = new ZeroToOneScale();

  /* isCorrectFormat method returns true for valid factor between 0 to 1 */
  @Test
  public void isCorrectFormatMidRangeTest() {
    assertTrue("Factor value is not between 0.0 to 1.0",
        factorChecker.isCorrectFormat(0.4));
  }

  /* isCorrectFormat method returns true for lower boundary factor - 0 */
  @Test
  public void isCorrectFormatLowerBoundaryTest() {
    assertTrue("Method can not properly detect lower boundary",
        factorChecker.isCorrectFormat(0.0));
  }

  /* isCorrectFormat method returns true for upper boundary factor - 1 */
  @Test
  public void isCorrectFormatUpperBoundaryTest() {
    assertTrue("Method can not properly detect upper boundary",
        factorChecker.isCorrectFormat(1.0));
  }

  /* isCorrectFormat method returns false for out of boundary factor value */
  @Test
  public void isCorrectFormatOutOfBoundaryTest() {
    assertFalse("Method can not detect out of boundary value",
        factorChecker.isCorrectFormat(1.1));
  }

  /* isCorrectFormat method returns false for invalid factor value */
  @Test
  public void isCorrectFormatInvalidDecimalTest() {
    assertFalse("Method can not detect decimal values properly",
        factorChecker.isCorrectFormat(0.11));
  }

  /* scale method returns the formatted double value for given double value */
  @Test
  public void scaleTest() {
    Double originalValue = 0.11;
    Double expectedValue = 0.1;
    assertEquals("Does not returned the expected value", expectedValue,
        factorChecker.scale(originalValue));
  }

  /**
   * scale method returns the formatted double value for given lower boundary
   * value
   */
  @Test
  public void scaleLowerBoundaryTest() {
    Double originalValue = 0.00;
    Double expectedValue = 0.0;
    assertEquals("Does not returned the expected lower boundary value",
        expectedValue, factorChecker.scale(originalValue));
  }

  /**
   * scale method returns the formatted double value for given higher boundary
   * value
   */
  @Test
  public void scaleHigherBoundaryTest() {
    Double originalValue = 120.23231213;
    Double expectedValue = 120.2;
    assertEquals("Does not returned the expected higher boundary value",
        expectedValue, factorChecker.scale(originalValue));
  }
}