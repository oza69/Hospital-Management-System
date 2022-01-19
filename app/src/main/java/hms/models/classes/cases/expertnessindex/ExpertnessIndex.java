/**
 * @author Eklavya Nautiyal
 * @description class to retrieve best doctors from and print them
 */
package hms.models.classes.cases.expertnessindex;

import hms.configuration.Connector;
import hms.database.classes.cases.expertnessindex.ExpertnessIndexPersistence;
import hms.database.interfaces.doctor.expertnessindex.IExpertnessIndexPersistence;
import hms.models.interfaces.cases.expertnessindex.IExpertnessIndex;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ExpertnessIndex implements IExpertnessIndex {

  private int diseaseId;
  Connector con = new Connector();
  IExpertnessIndexPersistence expObj = new ExpertnessIndexPersistence(con);

  public ExpertnessIndex(Connector con) {
    this.con = con;
  }

  public ExpertnessIndex() {
  }

  @Override
  public void setDiseaseId(int diseaseID) {
    this.diseaseId = diseaseID;
  }

  @Override
  public int getDiseaseId(){
    return this.diseaseId;
  }

  @Override
  public boolean suggestBestDocs(int diseaseId) {
    try{
      ResultSet rs = expObj.getExpertDoc(diseaseId);
      ResultSetMetaData rsmd = rs.getMetaData();
      int columnsNumber = rsmd.getColumnCount();
      for (int i = 1; i <= columnsNumber; i++)  {
        System.out.print(String.format("%20s", rsmd.getColumnName(i)));
      }
      System.out.println("");
      while (rs.next()) {
        for (int i = 1; i <= columnsNumber; i++) {
          String columnValue = rs.getString(i);
          System.out.print(String.format("%20s",columnValue));
        }
        System.out.println("");
      }
      return true;
    } catch (Exception e)  {
      e.printStackTrace();
      return false;
    }
  }
}
