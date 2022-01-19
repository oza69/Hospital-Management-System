/**
 * @author Dhruv Oza
 * @description : This class will discount based on years worked
 */
package hms.models.classes.packageandcoupons.percentagebaseddiscount;

import hms.models.interfaces.packageandcoupons.percentagebaseddiscount
    .IPercentageBased;
import hms.models.interfaces.doctor.workingyears.ICountWorkingYears;

public class PercentageBased implements IPercentageBased {

  /* Initialization of years, discountApplied */
  private int years;
  private double discountApplied;

  /* Constructor to initialize discountApplied, years */
  public PercentageBased(ICountWorkingYears iCountWorkingYears) {
    this.discountApplied = 0.30;
    this.years = iCountWorkingYears.workingYearsCalculation();
  }

  /* getter method */
  public int getYears() {
    return years;
  }

  /* setter method */
  public void setYears(int years) {
    this.years = years;
  }

  public double discountCalculation() {
    double totalDiscount;
    if (years >= 5) {
      totalDiscount = discountApplied;
    } else if (years >= 2 && years < 5) {
      totalDiscount = discountApplied - 0.15;
    } else {
      totalDiscount = 0;
    }
    return totalDiscount;
  }
}
