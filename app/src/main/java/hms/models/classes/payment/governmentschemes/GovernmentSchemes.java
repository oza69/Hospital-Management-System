package hms.models.classes.payment.governmentschemes;

import hms.database.interfaces.payment.governmentschemespersistence.IGovernmentSchemePersistence;
import hms.models.interfaces.payment.governmentscheme.IGovernmentSchemes;

import java.util.Scanner;

public class GovernmentSchemes implements IGovernmentSchemes {

IGovernmentSchemePersistence IGovernmentSchemePersistence;
IGovernmentSchemePersistence iGovernmentSchemePersistence;
public  boolean GovtSchemeCalc(){

        boolean result=false;
        double TotalIncome;
        //int patientid=10;
        double MaxIncome=200000;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Patient Id:");
        int patientid=sc.nextInt();
        TotalIncome = iGovernmentSchemePersistence.getpatientSalDtls(patientid);
        if(TotalIncome<=MaxIncome){
        int i= iGovernmentSchemePersistence.updateFinalAmount(patientid);
        if(i>0){
                result=true;
        System.out.println("Final amount of patient Updated as per Govt Scheme");
        System.out.println("Patient comes under Govt scheme");
        }
        }
        return result;//----testcase
}
        }
