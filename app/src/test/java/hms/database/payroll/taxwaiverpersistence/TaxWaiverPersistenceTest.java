/**
 * @author Dhruv Oza
 * @description : Test TaxWaiverFromDatabase class
 */
package hms.database.payroll.taxwaiverpersistence;

import hms.database.interfaces.payroll.taxwaiverpersistence
    .ITaxWaiverPersistence;
import hms.database.classes.payroll.taxwaiverpersistence.TaxWaiverPersistence;
import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaxWaiverPersistenceTest {

  @Test
  @DisplayName("Check whether Revenue_ID is correct or not!!")
  public void loadDBTest_1() throws SQLException {
    ConnectorDao connectorDao = new Connector();
    ITaxWaiverPersistence iTaxWaiverPersistence =
        new TaxWaiverPersistence();
    assertNotNull(iTaxWaiverPersistence.loadDB(1, connectorDao));
  }

  @Test
  @DisplayName("Check whether Revenue_ID is correct or not!!")
  public void loadDBTest_2() throws SQLException {
    ConnectorDao connectorDao = new Connector();
    ITaxWaiverPersistence iTaxWaiverPersistence =
        new TaxWaiverPersistence();
    assertNotNull(iTaxWaiverPersistence.loadDB(-1, connectorDao));
  }
}
