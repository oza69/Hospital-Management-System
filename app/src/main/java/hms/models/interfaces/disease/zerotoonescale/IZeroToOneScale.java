/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains ZeroToOne interface which will help to
 * implement ZeroToOne class
 */
package hms.models.interfaces.disease.zerotoonescale;

public interface IZeroToOneScale {

  /**
   * isCorrectFormat checks for proper format of given factor
   * @param factor is a value between 0 and 1 with one decimal (Ex 0.1, 0.2,...)
   * @return True if factor is between 0 and 1 with one decimal format
   */
  boolean isCorrectFormat(Double factor);

  /**
   * This method converts given double value to the 0 to 1 range value with one
   * decimal
   * @param factor The double value to be converted
   * @return New converted double value of one decimal
   */
  Double scale(Double factor);
}