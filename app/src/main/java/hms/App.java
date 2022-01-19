/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This is the main class file of the Hospital Management System
 */
package hms;

import hms.configuration.Connector;
import hms.configuration.ConnectorDao;
import hms.presentation.Presenter;
import java.sql.Connection;

public class App {

  public static void main(String[] args) {
    ConnectorDao connector = new Connector();
    Connection connection = connector.getConnection();
    new Presenter(connection);
    connector.closeConnection();
  }
}