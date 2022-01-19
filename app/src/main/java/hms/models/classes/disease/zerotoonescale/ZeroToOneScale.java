/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains ZeroToOneScale class which will help to
 * create ZeroToOneScale objects which will validate the given factor between
 * zero to one with pattern of 0.0, 0.1, 0.2, ..., 1.0, it also contains a scale
 * method to scale factor to one decimal
 */
package hms.models.classes.disease.zerotoonescale;

import hms.models.interfaces.disease.zerotoonescale.IZeroToOneScale;

public class ZeroToOneScale implements IZeroToOneScale {

  @Override
  public boolean isCorrectFormat(Double factor) {
    String sFactor = Double.toString(Math.abs(factor));
    int integersBeforeDecimal = sFactor.indexOf('.');
    int integersAfterDecimal = sFactor.length() - integersBeforeDecimal - 1;
    int valueBeforeDecimal =
        Integer.parseInt(sFactor.substring(0, integersBeforeDecimal));
    int valueAfterDecimal =
        Integer.parseInt(sFactor.substring(integersBeforeDecimal + 1));
    boolean inMidRange = valueBeforeDecimal == 0 &&
        (valueAfterDecimal >= 0 || valueAfterDecimal <= 9);
    boolean inUpperRange = valueBeforeDecimal == 1 && valueAfterDecimal == 0;
    boolean inRange = (inMidRange || inUpperRange);
    return (integersBeforeDecimal == 1 && integersAfterDecimal == 1 && inRange);
  }

  @Override
  public Double scale(Double factor) {
    return (double) Math.round(factor * 10) / 10;
  }
}