/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains InsurancePolicies class which will help to
 * deduct insurance amount from the total amount given
 */
package hms.models.classes.insurance.insurancepolicies;

import hms.database.classes.insurance.insurancepersistence.InsurancePersistence;
import hms.database.interfaces.insurance.insurancepersistence.IInsurancePersistence;
import hms.models.classes.insurance.insurance.Insurance;
import hms.models.interfaces.insurance.insurance.IInsurance;
import hms.models.interfaces.insurance.insurancepolicies.IInsurancePolicies;
import java.sql.Connection;

public class InsurancePolicies implements IInsurancePolicies {

  @Override
  public Integer deductAmount(Integer currentAmount, Integer policyId,
      Connection connection) {
    IInsurancePersistence insurancePersistence = new InsurancePersistence();
    IInsurance insurance = new Insurance();
    if (insurancePersistence.getInsurance(policyId, insurance, connection)) {
      Integer insuredAmount = insurance.getAmountCovered();
      if (currentAmount > -1 && insuredAmount > -1) {
        if (currentAmount > insuredAmount) {
          return currentAmount - insuredAmount;
        } else {
          return 0;
        }
      } else {
        return null;
      }
    } else {
      return null;
    }
  }
}