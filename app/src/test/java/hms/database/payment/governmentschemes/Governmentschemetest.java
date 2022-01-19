package hms.database.payment.governmentschemes;

import hms.database.classes.payment.governmentschemes.GovernmentSchemePersistence;
import hms.database.interfaces.payment.governmentschemespersistence.IGovernmentSchemePersistence;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class Governmentschemetest {
	
	IGovernmentSchemePersistence govtscheme = new GovernmentSchemePersistence();
	
    int patientid = 1;
	
	@Test
       public void testSalaryDetails() {
        
        assertNotNull("Cannot Fetch Patient Salary Details", govtscheme.getpatientSalDtls(patientid));

    }
	
	@Test
    public void testFinalAmount() {
     
     assertNotNull("Cannot Fetch FinalAmount", govtscheme.updateFinalAmount(patientid));

 }

}
