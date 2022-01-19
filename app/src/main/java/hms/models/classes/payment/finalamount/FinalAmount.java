/**
 * @author Vishvesh Bharatbhai Naik
 * @description Final amount to calculate to put the final amount and verify
 * insurance policy into the payment table
 */
package hms.models.classes.payment.finalamount;

import hms.database.interfaces.payment.finalamountpersistence.IFinalAmountPersistence;
import hms.models.interfaces.payment.finalamount.IFinalAmount;
import hms.database.classes.payment.fianlamountpersistence.FinalAmountPersistence;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class FinalAmount implements IFinalAmount {

  IFinalAmountPersistence paymentPersistence = new FinalAmountPersistence();

  @Override
  public double finalAmount(int patientId) throws SQLException {
    int policyId = paymentPersistence.getPolicyId(patientId);
    int insuranceAmount = paymentPersistence.getInsuranceAmount(policyId);
    int amount = paymentPersistence.getAmount(patientId);
    int age = paymentPersistence.getAge(patientId);
    double discountPercent, finalAmount;
    try {
      if (age > 40 && age < 60) {
        discountPercent = 0.15;
      } else if (age > 60 && age < 80) {
        discountPercent = 0.25;
      } else if (age > 80 && age < 120) {
        discountPercent = 0.30;
      } else {
        discountPercent = 0;
      }
      if (discountPercent != 0) {
        finalAmount = ((1 - discountPercent) * amount);
      } else {
        finalAmount = amount;
      }
      if (verifyPolicy(policyId)) {
        finalAmount = finalAmount - insuranceAmount;
      }
      if (finalAmount < 0) {
        paymentPersistence.putFinalAmount(finalAmount, patientId);
        return finalAmount = 0.0;
      } else {
        paymentPersistence.putFinalAmount(finalAmount, patientId);
        return finalAmount;
      }
    } catch (Exception e) {
      return 0;
    }
  }

  @Override
  public boolean verifyPolicy(int policyId) {
    try {
      Date getPolicyEndDate = paymentPersistence.getPolicyEndDate(policyId);
      LocalDate todayDate = LocalDate.now();
      return todayDate.isBefore(LocalDate.parse(getPolicyEndDate.toString()));
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
}