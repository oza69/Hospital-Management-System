/**
 * @author Dhruv Oza
 * @description : Test LoadCouponCode class
 */
package hms.database.packageandcoupons.loadcouponcode;

import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import hms.database.classes.packageandcoupons.loadcouponspersistence
    .LoadCouponPersistence;
import hms.database.interfaces.packageandcoupons.loadcouponpersistence
    .ILoadCouponPersistence;
import hms.models.classes.packageandcoupons.couponCode.CouponGenerator;
import hms.models.classes.packageandcoupons.percentagebaseddiscount
    .PercentageBased;
import hms.models.classes.doctor.workingyears.CountWorkingYears;
import hms.models.interfaces.packageandcoupons.couponcode.ICouponGenerator;
import hms.models.interfaces.packageandcoupons.percentagebaseddiscount
    .IPercentageBased;
import hms.models.interfaces.doctor.workingyears.ICountWorkingYears;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoadCouponCodeTest {

  @Test
  @DisplayName("Check whether data is loading into database or not!!")
  public void loadingTest() throws ParseException, SQLException {
    ILoadCouponPersistence iLoadCouponPersistence =
        new LoadCouponPersistence();
    Date date = null;
    String filterDate = "2015-01-01";
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    date = dateFormatter.parse(filterDate);
    ConnectorDao connectorDao = new Connector();
    ICountWorkingYears iCountWorkingYears = new CountWorkingYears(date);
    IPercentageBased iPercentageBased =
        new PercentageBased(iCountWorkingYears);
    ICouponGenerator iCouponGenerator =
        new CouponGenerator(iPercentageBased);
    assertNotNull(iLoadCouponPersistence
            .loading(iCouponGenerator, connectorDao),
        "Data not accurate to be loaded!!");
  }
}
