/**
 * @author Dhruv Oza
 * @description : Test CouponGenerator class
 */
package hms.models.packageandcoupons.couponcode;

import hms.models.classes.packageandcoupons.couponCode.CouponGenerator;
import hms.models.classes.packageandcoupons
    .percentagebaseddiscount.PercentageBased;
import hms.models.classes.doctor.workingyears.CountWorkingYears;
import hms.models.interfaces.packageandcoupons.couponcode.ICouponGenerator;
import hms.models.interfaces.packageandcoupons
    .percentagebaseddiscount.IPercentageBased;
import hms.models.interfaces.doctor.workingyears.ICountWorkingYears;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CouponGeneratorTest {

  @Test
  @DisplayName("Check whether totalDiscount is 0 or not!!")
  public void setTotalDiscountGeneratedTest() throws ParseException {
    Date workingYears = null;
    String filterDate = "2016-07-31";
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    workingYears = dateFormatter.parse(filterDate);
    ICountWorkingYears iCountWorkingYears =
        new CountWorkingYears(workingYears);
    IPercentageBased iPercentageBased =
        new PercentageBased(iCountWorkingYears);
    ICouponGenerator iCouponGenerator =
        new CouponGenerator(iPercentageBased);
    iCouponGenerator
        .setTotalDiscountGenerated(iPercentageBased.discountCalculation());
    assertEquals(iCouponGenerator.getTotalDiscountGenerated(),
        iPercentageBased.discountCalculation(),
        "totalDiscount not match!!");
  }

  @Test
  @DisplayName("Check whether totalDiscount is 0 or not!!")
  public void getTotalDiscountGeneratedTest() throws ParseException {
    Date workingYears = null;
    String filterDate = "2016-07-31";
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    workingYears = dateFormatter.parse(filterDate);
    ICountWorkingYears iCountWorkingYears =
        new CountWorkingYears(workingYears);
    IPercentageBased iPercentageBased =
        new PercentageBased(iCountWorkingYears);
    ICouponGenerator iCouponGenerator =
        new CouponGenerator(iPercentageBased);
    iCouponGenerator.
        setTotalDiscountGenerated(iPercentageBased.discountCalculation());
    assertTrue(iCouponGenerator.getTotalDiscountGenerated() != 0,
        "totalDiscount not match!!");
  }

  @Test
  @DisplayName("Check whether coupon generated or not!!")
  public void couponGeneratedTest() throws ParseException {
    Date workingYears = null;
    String filterDate = "2016-07-31";
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    workingYears = dateFormatter.parse(filterDate);
    ICountWorkingYears iCountWorkingYears =
        new CountWorkingYears(workingYears);
    IPercentageBased iPercentageBased =
        new PercentageBased(iCountWorkingYears);
    ICouponGenerator iCouponGenerator =
        new CouponGenerator(iPercentageBased);
    assertNotNull(iCouponGenerator.couponGenerated(),
        "Coupon not generated !!");
  }
}
