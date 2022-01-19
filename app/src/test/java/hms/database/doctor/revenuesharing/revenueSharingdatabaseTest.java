package hms.database.doctor.revenuesharing;

import hms.database.classes.doctor.revenuesharing.RevenueSharing;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

public class revenueSharingdatabaseTest {

	RevenueSharing rev = new RevenueSharing();
	public Date StringToDate(String s){

	    Date result = null;
	    try{
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        result  = dateFormat.parse(s);
	    }

	    catch(ParseException e){
	        e.printStackTrace();

	    }
	    return result ;
	}
	
	Date fromDt = StringToDate("13-01-2020");
	Date toDt = StringToDate("13-01-2021");
    float eachmnthrevenue = 500000;
	
	
	 @Test
	    public void testTotalMonths() {
	        
	        assertNotNull("Total Months cannot be retrieved", rev.getTotMnths(fromDt, toDt));

	    }
	 @Test
	    public void testTotalAmount() {
	        
	        assertNotNull("Total Amount cannot be retrieved", rev.getTotAmnt(fromDt, toDt));

	    }

	@Test
	public void testUpdatedDocument() {

		assertNotNull("Doc incentive isn't updated", rev.updDocIncentive(eachmnthrevenue, fromDt, toDt));

	}

}
