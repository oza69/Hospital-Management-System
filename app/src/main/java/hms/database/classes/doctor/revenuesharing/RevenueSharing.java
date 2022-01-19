package hms.database.classes.doctor.revenuesharing;

import hms.configuration.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;


public class RevenueSharing implements hms.revenuesharing.IRevenueSharing {

    public float getTotMnths(Date fromDt, Date toDt) {
        float totmnths=0;
        ResultSet rs1 = null;
        try{
            Connector con = new Connector();
            Connection arik = con.getConnection();
            PreparedStatement stmt=arik.prepareStatement("select sum(hrs) hours from(select doctor_id,sum(working_hours) hrs from doctor where trunc(dateof_working) BETWEEN to_date(?, 'dd-mm-yyyy') AND to_date(?, 'dd-mm-yyyy'))");
            stmt.setDate(1,(java.sql.Date) fromDt);
            stmt.setDate(1,(java.sql.Date) toDt);
            rs1=stmt.executeQuery();
            while(rs1.next()){
                float hrs=rs1.getFloat("hours");
                totmnths = hrs/720;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return totmnths;
    }

    public float getTotAmnt(Date fromDt, Date toDt) {
        float totAmnt=0;
        ResultSet rs1 = null;
        try{
            Connector con = new Connector();
            Connection arik = con.getConnection();
            PreparedStatement stmt=arik.prepareStatement("select sum(final_amount) amount from payment where trunc(billing_date) BETWEEN to_date(?, 'dd-mm-yyyy') AND to_date(?, 'dd-mm-yyyy')");
            stmt.setDate(1,(java.sql.Date) fromDt);
            stmt.setDate(1,(java.sql.Date) toDt);
            rs1=stmt.executeQuery();
            while(rs1.next()){
                totAmnt=rs1.getFloat("amount");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return totAmnt;
    }

    public boolean updDocIncentive(float eachmnthrevenue, Date fromDt, Date toDt) {
        boolean result=false;
        ResultSet rs1 = null;
        try{
            Connector con = new Connector();
            Connection arik = con.getConnection();
            PreparedStatement stmt=arik.prepareStatement("select doctor_id doc,(sum(working_hours)/720) hrs from doctor where trunc(dateof_working) BETWEEN to_date(?, 'dd-mm-yyyy') AND to_date(?, 'dd-mm-yyyy')");
            stmt.setDate(1,(java.sql.Date) fromDt);
            stmt.setDate(1,(java.sql.Date) toDt);
            rs1=stmt.executeQuery();
            while(rs1.next()){
                PreparedStatement stmt1=arik.prepareStatement("update doctor set revenue_shared=? where doctor_id=?");
                stmt1.setFloat(1,( rs1.getInt("hrs")*eachmnthrevenue));
                stmt1.setInt(2,rs1.getInt("doc"));
                int res=stmt1.executeUpdate();
                result=true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
