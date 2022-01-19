/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains test cases for DiseasesCauseTogether class
 */
package hms.models.hmanalysis.diseasescausetogether;

import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import hms.database.classes.disease.diseasepersistence.DiseasePersistence;
import hms.database.classes.hmanalysis.getdiseaseinrange.GetDiseasesInRangePersistence;
import hms.database.interfaces.disease.diseasepersistence.IDiseasePersistence;
import hms.database.interfaces.hmanalysis.getdiseaseinrange.IGetDiseasesInRangePersistence;
import hms.models.classes.disease.diseasesorter.DiseaseSorter;
import hms.models.classes.hmanalysis.diseasescausetogether.DiseasesCauseTogether;
import hms.models.interfaces.disease.diseasesorter.IDiseaseSorter;
import hms.models.interfaces.hmanalysis.diseasescausetogether.IDiseasesCauseTogether;
import org.junit.Test;
import java.sql.Connection;
import java.sql.Date;
import static org.junit.Assert.assertNotNull;

public class DiseasesCauseTogetherTest {

  Date startDate = Date.valueOf("2021-02-01");
  Date endDate = Date.valueOf("2021-02-05");
  ConnectorDao connector = new Connector();
  Connection connection = connector.getConnection();
  IDiseasePersistence diseasePersistence = new DiseasePersistence();
  IDiseaseSorter<Integer, Integer> sorter = new DiseaseSorter<>();
  IGetDiseasesInRangePersistence getDiseasesInRangePersistence =
      new GetDiseasesInRangePersistence();

  @Test
  public void testGetDiseasesCauseTogether() {
    IDiseasesCauseTogether diseaseCauseTogether = new DiseasesCauseTogether();
    assertNotNull("Unable to retrieve diseases caused together",
        diseaseCauseTogether
            .getDiseasesCauseTogether(startDate, endDate, connection,
                diseasePersistence, getDiseasesInRangePersistence, sorter));
  }
}