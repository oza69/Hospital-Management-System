/**
 * @author Vishvesh Bharatbhai Naik
 * @description Revenue Setter, getter
 */
package hms.models.classes.revenue.revenue;

import hms.database.interfaces.revenue.revenuepersistence.IRevenuePersistence;
import hms.models.interfaces.revenue.revenue.IRevenue;

import java.sql.Connection;

public class Revenue implements IRevenue {

  private String fromDate;
  private String toDate;
  private Double revenueGenerated;

  public Revenue() {
  }

  public Revenue(String fromDate, String toDate, Double revenueGenerated) {
    this.fromDate = fromDate;
    this.toDate = toDate;
    this.revenueGenerated = revenueGenerated;
  }

  @Override
  public String getFromDate() {
    return fromDate;
  }

  @Override
  public void setFromDate(String fromDate) {
    this.fromDate = fromDate;
  }

  @Override
  public String getToDate() {
    return toDate;
  }

  @Override
  public void setToDate(String toDate) {
    this.toDate = toDate;
  }

  @Override
  public Double getRevenueGenerated() {
    return revenueGenerated;
  }

  @Override
  public void setRevenueGenerated(Double revenueGenerated) {
    this.revenueGenerated = revenueGenerated;
  }

  @Override
  public boolean saveRevenue(Connection connection, IRevenuePersistence revenuePersistence) {
    return revenuePersistence.saveRevenue(this, connection);
  }
}
