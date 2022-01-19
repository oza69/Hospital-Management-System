/**
 * @author Dhruv Oza, Eklavya Nautiyal, Nachiket Panchal, Vishveh Naik
 * @description All procedures constants are defined here
 */
package hms.constants;

public class CallableStatements {

  /* Constants for Nachiket's Classes */
  public static final String INSERT_DISEASE = "{CALL addDisease(?, ?, ?, ?)}";
  public static final String SELECT_DISEASE = "{CALL getDisease(?)}";
  public static final String UPDATE_DISEASE =
      "{CALL updateDisease(?, ?, ?, ?, ?)}";
  public static final String SELECT_ALL_DISEASES = "{CALL allDisease()}";
  public static final String INSERT_CASE =
      "{CALL addCase(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
  public static final String UPDATE_CASE =
      "{CALL updateCase(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
  public static final String SELECT_CASE = "{CALL getCase(?)}";
  public static final String SELECT_ALL_CASES = "{CALL allCases()}";
  public static final String SELECT_DISEASES_IN_RANGE =
      "{CALL getDiseasesInRange(?, ?)}";
  public static final String SELECT_DISTINCT_DISEASES_IN_RANGE =
      "{CALL getDistinctDiseasesInRange(?, ?)}";
  public static final String INSERT_INSURANCE =
      "{CALL addInsurance(?, ?, ?, ?, ?, ?)}";
  public static final String UPDATE_INSURANCE =
      "{CALL updateInsurance(?, ?, ?, ?, ?, ?, ?)}";
  public static final String SELECT_INSURANCE = "{CALL getInsurance(?)}";
  public static final String SELECT_ALL_INSURANCES = "{CALL allInsurance()}";

  /* Constants for Eklavya's Classes*/
  public static final String GET_FEEDBACK = "{ call getFeedback(?) }";
  public static final String SET_EFFICIENCY =
      "{ call setEfficiencyIndex(?, ?) }";
  public static final String GET_RISK_FACTORS = "{ call getRiskFactors(?) }";
  public static final String GET_EXPERT_DOCTOR = "{ call getExpertDoctor(?) }";
  public static final String ALL_PAYROLL = "{ call allPayroll() }";
  public static final String ADD_PAYROLL =
      "{ call addPayroll(?, ?, ?, ?, ?, ?, ?, ?, ?) }";
  public static final String ALL_COUPONS = "{ call allCoupon() }";
  public static final String ADD_COUPONS = "{ call addCoupon(?, ?) }";
  public static final String GET_ONE_PAYROLL = "{ call getOnePayroll(?) }";
  public static final String UPDATE_COUPON = "{ call updateCoupon(?, ?, ?) }";
  public static final String PADDED_SPACE = "%20s";

  /* Constants for Dhruv's Classes*/
  public static final String INSERT_SPECIFIC_DOCTOR =
      "{CALL getSpecificDoctor(?)}";
  public static final String INSERT_SPECIFIC_REVENUE = "{CALL getRevenue(?)}";
  public static final String INSERT_PAYROLL_DETAILS =
      "{CALL addPayroll(?,?,?,?,?,?,?,?,?)}";
  public static final String INSERT_SPECIFIC_DOCTOR_JOINING_DATE =
      "{CALL getSpecificDoctorJoiningDate(?)}";
  public static final String INSERT_COUPON_DETAILS = "{CALL addCoupon(?,?)}";
  public static final String INSERT_DOCTOR =
      "{CALL addDoctor(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
  public static final String SELECT_ALL_DOCTOR = "{CALL allDoctor()}";
  public static final String INSERT_PACKAGE =
      "{CALL addPackage(?, ?, ?, ?, ?)}";
  public static final String SELECT_ALL_PACKAGE = "{CALL allPackage()}";
  public static final String SELECT_ONE_DOCTOR_DETAIL =
      "{CALL getOneDocDetail(?)}";
  public static final String SET_ATTENDANCE = "{ CALL setAttendance(?,?) }";
  public static final String UPDATE_PACKAGE =
      "{ CALL updatePackage(?,?,?,?,?,?) }";
  public static final String UPDATE_PAYROLL_DETAILS =
      "{CALL updatePayroll(?,?,?,?,?,?,?,?,?)}";
  public static final String SET_OVERTIME = "{ CALL setOvertime(?,?) }";
  public static final String SELECT_HOURS = "{ CALL getHours(?) }";

  /* Constants for Vishvesh's Classes */
  public static final String SELECT_AGE = "{ CALL getAge(?) }";
  public static final String SELECT_POLICY_ID = "{ CALL getPolicyId(?) }";
  public static final String SELECT_POLICY_END_DATE =
      "{ CALL getPolicyEndDate(?) }";
  public static final String SELECT_AMOUNT = "{ CALL getAmount(?) }";
  public static final String SELECT_AMOUNT_COVERED =
      "{ CALL getAmountCovered(?) }";
  public static final String UPDATE_FINAL_AMOUNT =
      "{ CALL setFinalAmount(?, ?) }";
  public static final String SELECT_GET_RISK_DOCTORS =
      "{ CALL getDoctorForInsurance }";
  public static final String SELECT_DOCTOR_INSURANCE =
      "{ CALL setInsuranceToDoctor(?) }";
  public static final String INSERT_PATIENT =
      "{ CALL addPatients(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
  public static final String SELECT_ALL_PATIENTS = "{ CALL allPatients() }";
  public static final String INSERT_REVENUE = "{ CALL addRevenue(?,?,?) }";
  public static final String SELECT_REVENUE = "{ CALL allRevenue() }";
  public static final String INSERT_PAYMENT =
      "{ CALL addPayment(?,?,?,?,?,?,?,?) }";
  public static final String SELECT_PAYMENT =
      "{ CALL allPayment() }";
  public static final String SELECT_PAYMENT_ID =
      "{ CALL viewPayment(?) }";
  public static final String SELECT_PATIENT_ID =
      "{ CALL getOnePatientDetail(?) }";
  public static final String UPDATE_PATIENT =
      "{ CALL updatePatient(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
}
