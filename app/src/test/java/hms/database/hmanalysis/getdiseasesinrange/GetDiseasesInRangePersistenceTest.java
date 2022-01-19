/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains test cases for GetDiseaseInRangePersistence
 * class
 */
package hms.database.hmanalysis.getdiseasesinrange;

import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import hms.database.classes.hmanalysis.getdiseaseinrange.GetDiseasesInRangePersistence;
import hms.database.interfaces.hmanalysis.getdiseaseinrange.IGetDiseasesInRangePersistence;
import org.junit.Test;
import java.sql.Connection;
import java.sql.Date;
import static org.junit.Assert.assertNotNull;

public class GetDiseasesInRangePersistenceTest {

  ConnectorDao connector = new Connector();
  Connection connection = connector.getConnection();
  Date startDate = Date.valueOf("2021-01-01");
  Date endDate = Date.valueOf("2021-01-05");

  /**
   * getDiseases method returns null if any error occurs
   * while fetching case records
   */
  @Test
  public void testGetDiseases() {
    IGetDiseasesInRangePersistence getDiseasesInRangePersistence =
        new GetDiseasesInRangePersistence();
    assertNotNull("Unable to get diseases count in given range",
        getDiseasesInRangePersistence
            .getDiseases(startDate, endDate, connection));

  }

  /**
   * getDistinctDiseasesPerPatient method returns null if any error occurs
   * while fetching case records
   */
  @Test
  public void testGetDistinctDiseasesPerPatient() {
    IGetDiseasesInRangePersistence getDiseasesInRangePersistence =
        new GetDiseasesInRangePersistence();
    assertNotNull("Unable to get distinct diseases in given range",
        getDiseasesInRangePersistence
            .getDistinctDiseasesPerPatient(startDate, endDate, connection));
  }
}