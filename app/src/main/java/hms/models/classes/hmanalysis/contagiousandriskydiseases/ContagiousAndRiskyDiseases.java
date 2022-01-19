/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains ContagiousAndRiskyDiseases class which will
 * help to find diseases which were highly contagious and risky in given range
 * of dates
 */
package hms.models.classes.hmanalysis.contagiousandriskydiseases;

import hms.database.interfaces.disease.diseasepersistence.IDiseasePersistence;
import hms.database.interfaces.hmanalysis.getdiseaseinrange.IGetDiseasesInRangePersistence;
import hms.models.interfaces.disease.disease.IDisease;
import hms.models.interfaces.disease.diseasesorter.IDiseaseSorter;
import hms.models.interfaces.disease.zerotoonescale.IZeroToOneScale;
import hms.models.interfaces.hmanalysis.contagiousandriskydiseases.IContagiousAndRiskyDiseases;
import java.sql.Connection;
import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ContagiousAndRiskyDiseases implements IContagiousAndRiskyDiseases {

  private static final int TOTAL_FACTOR = 3;

  @Override
  public Map<String, Map<String, Double>> getDiseases(Date startDate,
      Date endDate, Connection connection,
      IDiseasePersistence diseasePersistence,
      IGetDiseasesInRangePersistence getDiseasesInRangePersistence,
      IZeroToOneScale factorChecker, IDiseaseSorter sorter) {
    try {
      Map<Integer, IDisease> allDiseases =
          diseasePersistence.getAllDiseases(connection);
      Map<Integer, Integer> diseaseInRange = getDiseasesInRangePersistence
          .getDiseases(startDate, endDate, connection);
      /* Calculating the overall risk factor */
      Map<Integer, Double> diseaseWithOverallRiskFactor =
          calculateOverAllRisk(allDiseases, diseaseInRange, factorChecker);
      Map<Integer, Double> sortedDiseases = (Map<Integer, Double>) sorter
          .sortByValue(diseaseWithOverallRiskFactor);
      /* Creating disease list with disease name and all risk factors */
      Map<String, Map<String, Double>> diseasesListWithNameAndRiskFactors =
          new LinkedHashMap<>();
      sortedDiseases.forEach((diseaseID, OverallRiskFactor) -> {
        Map<String, Double> riskFactors = new HashMap<>();
        riskFactors.put("contagiousRiskFactor",
            allDiseases.get(diseaseID).getContagiousRiskFactor());
        riskFactors.put("fatalityRiskFactor",
            allDiseases.get(diseaseID).getFatalityRiskFactor());
        riskFactors.put("overallRiskFactor", OverallRiskFactor);
        diseasesListWithNameAndRiskFactors
            .put(allDiseases.get(diseaseID).getName(), riskFactors);
      });
      return diseasesListWithNameAndRiskFactors;
    } catch (NullPointerException e) {
      return null;
    }
  }

  /**
   * This method calculates overall risk factor according to contagious and
   * fatality risk factor, while considering the number of cases for every
   * disease in given range of time.
   * @param diseaseList Map of diseases where every disease is stored with ID
   * as a key and Disease object as a value.
   * @param diseasesInRange Map of diseases with key of disease id, and number
   * of cases per disease as a value.
   * @return This method returns a HashMap of disease id as a key, and
   * calculated overall risk factor as a value.
   */
  private Map<Integer, Double> calculateOverAllRisk(
      Map<Integer, IDisease> diseaseList,
      Map<Integer, Integer> diseasesInRange, IZeroToOneScale factorChecker) {
    Map<Integer, Double> diseaseWithOverallRisk = new HashMap<>();
    Integer totalCases = calculateTotalCases(diseasesInRange);
    for (Map.Entry<Integer, Integer> disease : diseasesInRange.entrySet()) {
      Integer diseaseID = disease.getKey();
      IDisease diseaseObject = diseaseList.get(diseaseID);
      Double fatalityRiskFactor = diseaseObject.getFatalityRiskFactor();
      Double contagiousRiskFactor = diseaseObject.getContagiousRiskFactor();
      Integer cases = disease.getValue();
      Double caseRatio = (double) (cases / totalCases);
      Double overAllRisk =
          (fatalityRiskFactor + contagiousRiskFactor + caseRatio) / TOTAL_FACTOR;
      overAllRisk = factorChecker.scale(overAllRisk);
      diseaseWithOverallRisk.put(diseaseID, overAllRisk);
    }
    return diseaseWithOverallRisk;
  }

  /**
   * This method calculates total number of cases from the disease list.
   * @param diseaseList This Map defines disease id as a key, and associated
   * number of cases as a value.
   * @return This method returns the count of total cases.
   */
  private Integer calculateTotalCases(Map<Integer, Integer> diseaseList) {
    Integer sum = 0;
    for (Integer diseaseCount : diseaseList.values()) {
      sum += diseaseCount;
    }
    return sum;
  }
}