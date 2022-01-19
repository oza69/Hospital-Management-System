/**
 * @author Vishvesh Bharatbhai Naik
 * @description Final amount Persistence will get age, insurance, amount values
 * from database to calculate the final patient amount
 */
package hms.database.interfaces.payment.finalamountpersistence;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IFinalAmountPersistence {

    /**
     * getAge will fetch the age from Patient table
     * @param patientId will take Patient id as an argument
     * @return The age.
     */
    int getAge(int patientId);

    /**
     * getPolicyId will fetch the Id from Insurance table
     * @param patientId will take Patient id as an argument
     * @return The Policy Id
     */
    int getPolicyId(int patientId);

    /**
     * getPolicyEndDate will fetch the date from Insurance table
     * @param policyId will take Policy id as an argument
     * @return The End date of Policy
     * @throws SQLException SQL error will be handled here
     */
    Date getPolicyEndDate(int policyId) throws SQLException;

    /**
     * getAmount will fetch the amount from Cases table
     * @param patientId will take Patient id as an argument
     * @return The Amount
     */
    int getAmount(int patientId);

    /**
     * getInsurance will fetch the Insurance Amount form the Insurance Table
     * @param policyId will take Policy id as an argument
     * @return The Insurance Amount
     */
    int getInsuranceAmount(int policyId);

    /**
     * putFinalAmount will set the calculated final amount in the Payment table
     * @param finalAmount Put the final amount into payment table
     * @param patientId will take Patient id as an argument
     */
    void putFinalAmount(double finalAmount, int patientId);

    /**
     * Getting the Payment row by using PaymentId
     * @param paymentId paymentId
     * @return Result set row
     */
    ResultSet viewPayment(int paymentId);
}