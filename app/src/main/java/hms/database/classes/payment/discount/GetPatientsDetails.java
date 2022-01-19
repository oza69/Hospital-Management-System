package hms.database.classes.payment.discount;

import hms.configuration.Connector;
import hms.database.interfaces.payment.Discount.IGetPatientDetails;

import java.sql.*;

public class GetPatientsDetails implements IGetPatientDetails {



    public float getpatientDtls(int PatientId) {
        float PatientAmnt=0;
        ResultSet rs1 = null;
        try {
            Connector con = new Connector();
            Connection arik = con.getConnection();
            String sql = "SELECT amount FROM PAYMENT where patient_id=" + PatientId;
            Statement stmt = arik.createStatement();
            rs1 = stmt.executeQuery(sql);
            PatientAmnt = rs1.getInt("amount");

        } catch (Exception e) {
            e.printStackTrace();
       }
        //finally
//        {
//            arik.close();
//        }

        return PatientAmnt;
    }
    public float getDiscount(int patientid) {
        float discount=0;
        ResultSet rs1 = null;
        try{
            Connector con = new Connector();
            Connection arik = con.getConnection();
            String sql = "SELECT package_id FROM patients where patient_id="+patientid;
            Statement stmt = arik.createStatement();
            rs1 = stmt.executeQuery(sql);
            int packageId = rs1.getInt("package_id");

            String sql1 = "SELECT coupon_code FROM package where patient_id="+packageId;
            rs1=null;
            rs1=stmt.executeQuery(sql1);
            String coupon_code=rs1.getString("coupon_code");

            String sql2 = "SELECT coupon_discount FROM coupons where patient_id="+coupon_code;
            rs1=null;
            rs1=stmt.executeQuery(sql1);
            discount=rs1.getFloat("coupon_discount");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
//        finally {
//            arik.close();
//        }
        return discount;
    }



}
