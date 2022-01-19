/**
 * @author Dhruv Oza
 * @description : Test PercentageBased class
 */
package hms.models.packageandcoupons.percentagebaseddiscount;

import hms.models.classes.packageandcoupons.
    percentagebaseddiscount.PercentageBased;
import hms.models.classes.doctor.workingyears.CountWorkingYears;
import hms.models.interfaces.packageandcoupons.
    percentagebaseddiscount.IPercentageBased;
import hms.models.interfaces.doctor.workingyears.ICountWorkingYears;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PercentageBasedTest {

  @Test
  @DisplayName("Check whether years is 0 or not!!")
  public void setYearsTest() throws ParseException {
    Date workingYears = null;
    String filterDate = "2016-07-31";
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    workingYears = dateFormatter.parse(filterDate);
    ICountWorkingYears iCountWorkingYears =
        new CountWorkingYears(workingYears);
    IPercentageBased iPercentageBased =
        new PercentageBased(iCountWorkingYears);
    iPercentageBased
        .setYears(iCountWorkingYears.workingYearsCalculation());
    assertEquals(iPercentageBased.getYears(),
        iCountWorkingYears.workingYearsCalculation(),
        "years not match!!");
  }

  @Test
  @DisplayName("Check whether years is 0 or not!!")
  public void getYearsTest() throws ParseException {
    Date workingYears = null;
    String filterDate = "2016-07-31";
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    workingYears = dateFormatter.parse(filterDate);
    ICountWorkingYears iCountWorkingYears =
        new CountWorkingYears(workingYears);
    IPercentageBased iPercentageBased =
        new PercentageBased(iCountWorkingYears);
    iPercentageBased.setYears(iCountWorkingYears.workingYearsCalculation());
    assertTrue(iPercentageBased.getYears() != 0,
        "years not match!!");
  }

  @Test
  @DisplayName("Check whether totalDiscount is 0 or not!!")
  public void discountCalculationTest() throws ParseException {
    Date workingYears = null;
    String filterDate = "2016-07-31";
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    workingYears = dateFormatter.parse(filterDate);
    ICountWorkingYears iCountWorkingYears =
        new CountWorkingYears(workingYears);
    IPercentageBased iPercentageBased =
        new PercentageBased(iCountWorkingYears);
    iPercentageBased
        .setYears(iCountWorkingYears.workingYearsCalculation());
    assertNotNull(iPercentageBased.discountCalculation(),
        "totalDiscount not proper!!");
  }
}
