package hms.models.classes.doctor.revenuesharing;

import hms.models.interfaces.doctor.revenuesharing.IRevenueSharing;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class RevenueSharing implements IRevenueSharing {

    hms.revenuesharing.IRevenueSharing IRevenueSharing;

    public boolean RevenueShareCalc(){
        boolean result= false;
        float totamt=0;
        float totmnths=0;
        float eachmnthrevenue=0;

        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter from date in the format of dd-mm-yyyy");
            String d1 = sc.next();
            Date fromDt=new SimpleDateFormat("dd-MM-YYYY").parse(d1);
            System.out.println("Enter to date in the format of dd-mm-yyyy");
            String d2 = sc.next();
            Date ToDt=new SimpleDateFormat("dd-MM-YYYY").parse(d2);
            totamt= IRevenueSharing.getTotAmnt(fromDt,ToDt);
            totmnths= IRevenueSharing.getTotMnths(fromDt,ToDt);
            float profitPer=(float) (totamt*0.2);
            eachmnthrevenue=profitPer/totmnths;
            boolean upddocincentive= IRevenueSharing.updDocIncentive(eachmnthrevenue,fromDt,ToDt);
            if(upddocincentive){
                result=true;
                System.out.println("Revenue share of each  doctor updated");
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}


