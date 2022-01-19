/**
 * @author Dhruv Oza
 * @description : Testing IncentiveBasedPersistence class
 */
package hms.database.payroll.incentivebasedpersistence;

import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import hms.database.classes.payroll.incentivebasedpersistence.
    IncentiveBasedPersistence;
import hms.database.interfaces.payroll.incentivebasedpersistence.
    IIncentiveBasedPersistence;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IncentiveBasedPersistenceTest {

  @Test
  @DisplayName("Check whether Doctor_ID is correct or not!!")
  public void loadHoursTest() throws SQLException {
    int doctorID = 1;
    ConnectorDao connectorDao = new Connector();
    IIncentiveBasedPersistence iIncentiveBasedPersistence = new
        IncentiveBasedPersistence();
    iIncentiveBasedPersistence.loadHours(doctorID, connectorDao);
    assertTrue(iIncentiveBasedPersistence.loadHours(doctorID, connectorDao));
  }
}
