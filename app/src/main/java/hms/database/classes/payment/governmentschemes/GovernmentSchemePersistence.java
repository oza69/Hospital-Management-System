package hms.database.classes.payment.governmentschemes;

import hms.configuration.Connector;
import hms.database.interfaces.payment.governmentschemespersistence.IGovernmentSchemePersistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class GovernmentSchemePersistence implements IGovernmentSchemePersistence {


    public double getpatientSalDtls(int patientid) {
        ResultSet rs1 = null;
        double salary=0;
        try{
            Connector con = new Connector();
            Connection arik = con.getConnection();

            PreparedStatement stmt=arik.prepareStatement("select annual_income from patients where patient_id=?");
            stmt.setInt(1,patientid);
            rs1=stmt.executeQuery();
            while(rs1.next()){
                salary=rs1.getDouble("annual_income");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
//        finally {
//            arik.close();
//        }
        return salary;
    }

    public int updateFinalAmount(int patientid) {
        int result=0;

        try{
            Connector con = new Connector();
            Connection arik = con.getConnection();

            PreparedStatement stmt=arik.prepareStatement("update payment set final_amount=? where patient_id=?");
            stmt.setFloat(1, 0);
            stmt.setInt(2,patientid);
            result=stmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
//        finally {
//            arik.close();
//        }
        return result;
    }

}
