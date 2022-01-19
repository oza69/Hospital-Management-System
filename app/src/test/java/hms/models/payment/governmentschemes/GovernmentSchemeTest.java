package hms.models.payment.governmentschemes;

import hms.models.classes.payment.governmentschemes.GovernmentSchemes;
import hms.models.interfaces.payment.governmentscheme.IGovernmentSchemes;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

public class GovernmentSchemeTest {

    //GovtSchemeDtls govt;
    IGovernmentSchemes govt = new GovernmentSchemes();
    double TotalIncome = 70000;


    @Test
    public void testgovtscheme() {


        try {
            assertTrue("Govt Scheme Calculation is not fetched For the Total Income", govt.GovtSchemeCalc());

        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
