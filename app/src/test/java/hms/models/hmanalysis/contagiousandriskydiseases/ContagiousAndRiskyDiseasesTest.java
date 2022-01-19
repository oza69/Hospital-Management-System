/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains test cases for ContagiousAndRiskyDiseases
 * class
 */
package hms.models.hmanalysis.contagiousandriskydiseases;

import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import hms.database.classes.disease.diseasepersistence.DiseasePersistence;
import hms.database.classes.hmanalysis.getdiseaseinrange.GetDiseasesInRangePersistence;
import hms.database.interfaces.disease.diseasepersistence.IDiseasePersistence;
import hms.database.interfaces.hmanalysis.getdiseaseinrange.IGetDiseasesInRangePersistence;
import hms.models.classes.disease.diseasesorter.DiseaseSorter;
import hms.models.classes.disease.zerotoonescale.ZeroToOneScale;
import hms.models.classes.hmanalysis.contagiousandriskydiseases.ContagiousAndRiskyDiseases;
import hms.models.interfaces.disease.diseasesorter.IDiseaseSorter;
import hms.models.interfaces.disease.zerotoonescale.IZeroToOneScale;
import hms.models.interfaces.hmanalysis.contagiousandriskydiseases.IContagiousAndRiskyDiseases;
import org.junit.Test;
import java.sql.Connection;
import java.sql.Date;
import static org.junit.Assert.assertNotNull;

public class ContagiousAndRiskyDiseasesTest {

  Date startDate = Date.valueOf("2021-01-01");
  Date endDate = Date.valueOf("2021-01-05");
  ConnectorDao connector = new Connector();
  Connection connection = connector.getConnection();
  IDiseasePersistence diseasePersistence = new DiseasePersistence();
  IGetDiseasesInRangePersistence diseasesInRangePersistence =
      new GetDiseasesInRangePersistence();
  IZeroToOneScale factorChecker = new ZeroToOneScale();
  IDiseaseSorter<String, Double> sorter = new DiseaseSorter();

  /**
   * The getDisease method returns the list of diseases based on
   * overall risk factor, else null if any error occurs while fetching
   * the data from the database.
   */
  @Test
  public void testGetDiseases() {
    IContagiousAndRiskyDiseases contagiousAndRiskyDiseases =
        new ContagiousAndRiskyDiseases();
    assertNotNull("Unable to get diseases", contagiousAndRiskyDiseases
        .getDiseases(startDate, endDate, connection, diseasePersistence,
            diseasesInRangePersistence, factorChecker, sorter));
  }
}