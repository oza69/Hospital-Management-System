/**
 * @author Dhruv Oza
 * @description : Test RiskFactorBasedDiseases class
 */
package hms.models.hmanalysis.diseasesbasedonriskfactor;

import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import hms.database.classes.disease.diseasepersistence.DiseasePersistence;
import hms.database.classes.hmanalysis.getdiseaseinrange
    .GetDiseasesInRangePersistence;
import hms.database.interfaces.disease.diseasepersistence.IDiseasePersistence;
import hms.database.interfaces.hmanalysis.getdiseaseinrange
    .IGetDiseasesInRangePersistence;
import hms.models.classes.disease.diseasesorter.DiseaseSorter;
import hms.models.classes.hmanalysis.diseasesbasedonriskfactor
    .RiskFactorBasedDiseases;
import hms.models.interfaces.disease.diseasesorter.IDiseaseSorter;
import hms.models.interfaces.hmanalysis.diseasesbasedonriskfactor
    .IRiskFactorBasedDiseases;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.sql.Connection;
import java.sql.Date;

import static org.junit.Assert.assertNotNull;

public class RiskFactorBasedDiseasesTest {

  Date startDate = Date.valueOf("2021-02-01");
  Date endDate = Date.valueOf("2021-02-05");
  ConnectorDao connector = new Connector();
  Connection connection = connector.getConnection();
  IDiseasePersistence getDiseaseId = new DiseasePersistence();
  IGetDiseasesInRangePersistence diseasesInRange =
      new GetDiseasesInRangePersistence();
  IDiseaseSorter<String, Double> sort = new DiseaseSorter();

  @Test
  @DisplayName("getFrequentCases method returns the list of " +
      "diseases based on risk factor")
  public void getFrequentCasesTest() {
    IRiskFactorBasedDiseases iRiskFactorBasedDiseases =
        new RiskFactorBasedDiseases();
    assertNotNull(iRiskFactorBasedDiseases
        .getFrequentCases(startDate, endDate, connection, getDiseaseId,
            diseasesInRange, sort));
  }
}
