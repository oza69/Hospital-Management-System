/**
 * @author Dhruv Oza
 * @description : Test Age class
 */
package hms.models.doctor.ages;

import hms.models.classes.doctor.ages.Age;
import hms.models.interfaces.doctor.ages.IAge;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AgeTest {

  @Test
  @DisplayName("Checked whether calculation of age is correct or not!!")
  public void ageCalculateTest() throws ParseException {
    Date birthDate = null;
    String filterDate = "2016-07-31";
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    birthDate = dateFormatter.parse(filterDate);
    IAge iAge = new Age(birthDate);
    assertNotNull(iAge.ageCalculate(), "Wrong Date given!!");
  }

  @Test
  @DisplayName("Check whether birthDate is 0 or not!!")
  public void isValidTest_1() {
    IAge iAge = new Age(null);
    assertFalse(iAge.isValid());
  }

  @Test
  @DisplayName("Check whether birthDate is 0 or not!!")
  public void isValidTest_2() throws ParseException {
    Date birthDate = null;
    String filterDate = "2016-07-31";
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    birthDate = dateFormatter.parse(filterDate);
    IAge iAge = new Age(birthDate);
    assertTrue(iAge.isValid());
  }

  @Test
  @DisplayName("Check whether birthDate is 0 or not!!")
  public void setBirthDateTest() throws ParseException {
    Date birthDate = null;
    String filterDate = "2016-07-31";
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    birthDate = dateFormatter.parse(filterDate);
    IAge iAge = new Age(birthDate);
    iAge.setBirthDate(birthDate);
    assertEquals(iAge.getBirthDate(), birthDate,
        "birthDate not match!!");
  }

  @Test
  @DisplayName("Check whether birthDate is 0 or not!!")
  public void getBirthDateTest() throws ParseException {
    Date birthDate = null;
    String filterDate = "2016-07-31";
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    birthDate = dateFormatter.parse(filterDate);
    IAge iAge = new Age(birthDate);
    iAge.setBirthDate(birthDate);
    assertTrue(iAge.getBirthDate() != null,
        "birthDate not match!!");
  }
}
