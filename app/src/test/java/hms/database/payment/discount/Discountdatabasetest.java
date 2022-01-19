package hms.database.payment.discount;

//import hms.database.cases.Test;
import hms.database.classes.payment.discount.GetPatientsDetails;
import hms.database.interfaces.payment.Discount.IGetPatientDetails;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;


public class Discountdatabasetest {
	IGetPatientDetails pdetails = new GetPatientsDetails();
	 
	 int PatientId = 1;
	
	 @Test
	    public void testGetAllPatientDetails() {
	        assertNotNull("Patient Details", pdetails.getpatientDtls(PatientId) );

	    }
	 
	 @Test
	    public void testGetAllDiscountDetails() {
	        assertNotNull("Discount Details", pdetails.getDiscount(PatientId));

	    }

}
