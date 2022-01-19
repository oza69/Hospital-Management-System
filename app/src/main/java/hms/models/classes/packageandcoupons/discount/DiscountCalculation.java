package hms.models.classes.packageandcoupons.discount;

import hms.models.interfaces.packageandcoupons.discount.IDiscount;

import java.util.Scanner;

public class DiscountCalculation implements IDiscount {

    hms.database.interfaces.payment.Discount.IGetPatientDetails getPatientDtls;
//int patientid=10;

    public double discountCal(){
        float totDiscount=0;
        float patientAmnt=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Patient Id:");
        int patientid=sc.nextInt();
        patientAmnt = getPatientDtls.getpatientDtls(patientid);
        float discountAmt= getPatientDtls.getDiscount(patientid);
        totDiscount=patientAmnt-(patientAmnt*discountAmt);

        return totDiscount;
    }

}

