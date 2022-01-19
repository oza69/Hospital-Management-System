/**
 * @author Vishvesh Bharatbhai Naik
 * @description Testing Get Disease by cases the Revenue setter and getters
 */
package hms.models.hmanalysis.mostcausedinrange;

import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import hms.database.classes.disease.diseasepersistence.DiseasePersistence;
import hms.database.classes.hmanalysis.getdiseaseinrange.GetDiseasesInRangePersistence;
import hms.database.interfaces.disease.diseasepersistence.IDiseasePersistence;
import hms.database.interfaces.hmanalysis.getdiseaseinrange.IGetDiseasesInRangePersistence;
import hms.models.classes.disease.diseasesorter.DiseaseSorter;
import hms.models.classes.hmanalysis.mostcausedinrange.MostCausedInRange;
import hms.models.interfaces.disease.diseasesorter.IDiseaseSorter;
import hms.models.interfaces.hmanalysis.mostcausedinrange.IMostCausedInRange;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;

import static org.junit.Assert.assertNotNull;

public class MostCausedInRangeTest {

  Date startDate = Date.valueOf("2021-02-01");
  Date endDate = Date.valueOf("2021-02-05");
  ConnectorDao connector = new Connector();
  Connection connection = connector.getConnection();
  IDiseasePersistence getDiseaseId = new DiseasePersistence();
  IGetDiseasesInRangePersistence diseasesInRange =
      new GetDiseasesInRangePersistence();
  IDiseaseSorter<String, Double> sort = new DiseaseSorter();

  /**
   * The getCases method returns the list of diseases based on number of cases,
   * else null if any error occurs while fetching the data from the database.
   */
  @Test
  public void testGetDiseaseByCases() {
    IMostCausedInRange mostCausedInRange = new MostCausedInRange();
    assertNotNull("Unable to get diseases", mostCausedInRange
        .getMostCases(startDate, endDate, connection, getDiseaseId,
            diseasesInRange, sort));
  }
}
