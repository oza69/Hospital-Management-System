/**
 * @author Dhruv Oza
 * @description : Test CountWorkingYears class
 */
package hms.models.doctor.workingyears;

import hms.models.classes.doctor.workingyears.CountWorkingYears;
import hms.models.interfaces.doctor.workingyears.ICountWorkingYears;
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

public class CountWorkingYearsTest {

  @Test
  @DisplayName("Checked whether calculation of years is correct or not!!")
  public void workingYearsCalculationTest() throws ParseException {
    Date workingYears = null;
    String filterDate = "2015-07-31";
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    workingYears = dateFormatter.parse(filterDate);
    ICountWorkingYears iCountWorkingYears =
        new CountWorkingYears(workingYears);
    assertNotNull(iCountWorkingYears.workingYearsCalculation(),
        "Wrong Date given!!");
  }

  @Test
  @DisplayName("Check whether workingYears is 0 or not!!")
  public void isValidTest_1() {
    ICountWorkingYears iCountWorkingYears = new CountWorkingYears(null);
    assertFalse(iCountWorkingYears.isValid());
  }

  @Test
  @DisplayName("Check whether workingYears is 0 or not!!")
  public void isValidTest_2() throws ParseException {
    Date workingYears = null;
    String filterDate = "2016-07-31";
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    workingYears = dateFormatter.parse(filterDate);
    ICountWorkingYears iCountWorkingYears =
        new CountWorkingYears(workingYears);
    assertTrue(iCountWorkingYears.isValid());
  }

  @Test
  @DisplayName("Check whether workingYears is 0 or not!!")
  public void setWorkingYearsTest() throws ParseException {
    Date workingYears = null;
    String filterDate = "2016-07-31";
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    workingYears = dateFormatter.parse(filterDate);
    ICountWorkingYears iCountWorkingYears =
        new CountWorkingYears(workingYears);
    iCountWorkingYears.setWorkingYears(workingYears);
    assertEquals(iCountWorkingYears.getWorkingYears(), workingYears,
        "workingYears not match!!");
  }

  @Test
  @DisplayName("Check whether workingYears is 0 or not!!")
  public void getWorkingYearsTest() throws ParseException {
    Date workingYears = null;
    String filterDate = "2016-07-31";
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    workingYears = dateFormatter.parse(filterDate);
    ICountWorkingYears iCountWorkingYears =
        new CountWorkingYears(workingYears);
    iCountWorkingYears.setWorkingYears(workingYears);
    assertTrue(iCountWorkingYears.getWorkingYears() != null,
        "workingYears not match!!");
  }
}
