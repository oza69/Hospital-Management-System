package hms.models.packageandcoupons.discount;

import hms.models.classes.packageandcoupons.discount.DiscountCalculation;
import hms.models.interfaces.packageandcoupons.discount.IDiscount;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class DiscountTest {
	
	//DiscountCalculation cal;
    IDiscount cal = new DiscountCalculation();
	int patientid = 1;
	double patientAmnt = 500;
	double discountAmt = 50.00 ;
    
    @Test
    public void testDiscountcal() {
        //double result= cal.discountCal();
        //assertEquals("Total Discount is invalid",50.00,cal.discountCal());


        try {
            assertEquals("Total Discount is invalid",50.00,cal.discountCal());

        } catch (Exception e) {
            e.printStackTrace();

        }


    }

	
	
}
