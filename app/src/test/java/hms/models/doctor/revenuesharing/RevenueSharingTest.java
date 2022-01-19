package hms.models.doctor.revenuesharing;

import hms.models.classes.doctor.revenuesharing.RevenueSharing;
import hms.models.interfaces.doctor.revenuesharing.IRevenueSharing;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class RevenueSharingTest {

//RevenueSharing revenue;

    IRevenueSharing revenue = new RevenueSharing();

    @Test
    public void revenueCal() {


        try {
            assertNotNull("Revenue calculation isn't fetched", revenue.RevenueShareCalc());

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
