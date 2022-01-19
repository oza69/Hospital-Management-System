/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains DiseasesCauseTogether class which will help
 * to find diseases that are caused together for majority of patients in given
 * range of days
 */
package hms.models.classes.hmanalysis.diseasescausetogether;

import hms.database.interfaces.disease.diseasepersistence.IDiseasePersistence;
import hms.database.interfaces.hmanalysis.getdiseaseinrange.IGetDiseasesInRangePersistence;
import hms.models.interfaces.disease.disease.IDisease;
import hms.models.interfaces.disease.diseasesorter.IDiseaseSorter;
import hms.models.interfaces.hmanalysis.diseasescausetogether.IDiseasesCauseTogether;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DiseasesCauseTogether implements IDiseasesCauseTogether {

  @Override
  public Map<String, List<String>> getDiseasesCauseTogether(Date startDate,
      Date endDate, Connection connection,
      IDiseasePersistence diseasePersistence,
      IGetDiseasesInRangePersistence getDiseasesInRangePersistence,
      IDiseaseSorter sorter) {
    try {
      Map<Integer, IDisease> allDiseases =
          diseasePersistence.getAllDiseases(connection);
      Map<Integer, List<Integer>> patientsWithDiseases =
          getDiseasesInRangePersistence
              .getDistinctDiseasesPerPatient(startDate, endDate, connection);
      Map<Integer, Integer> diseaseCounter = new HashMap<>();
      Map<Integer, Map<Integer, Integer>> relatedDiseasesList =
          new LinkedHashMap<>();
      for (Integer diseaseID : allDiseases.keySet()) {
        Map<Integer, Integer> relatedDiseases = new HashMap<>();
        for (Integer patientID : patientsWithDiseases.keySet()) {
          List<Integer> patientDiseases = patientsWithDiseases.get(patientID);
          if (patientDiseases.contains(diseaseID)) {
            if (!diseaseCounter.containsKey(diseaseID)) {
              diseaseCounter.put(diseaseID, 1);
            } else {
              diseaseCounter.put(diseaseID, diseaseCounter.get(diseaseID) + 1);
            }
            for (Integer disease : patientDiseases) {
              if (disease != diseaseID) {
                if (!relatedDiseases.containsKey(disease)) {
                  relatedDiseases.put(disease, 1);
                } else {
                  relatedDiseases
                      .put(disease, relatedDiseases.get(disease) + 1);
                }
              }
            }
          }
        }
        if (!relatedDiseases.isEmpty()) {
          relatedDiseasesList.put(diseaseID, relatedDiseases);
        }
      }

      Map<Integer, Integer> sortedDiseases =
          (Map<Integer, Integer>) sorter.sortByValue(diseaseCounter);
      Map<Integer, List<Integer>> diseasesCausedTogetherList =
          new LinkedHashMap<>();
      for (Integer diseaseID : sortedDiseases.keySet()) {
        if (relatedDiseasesList.containsKey(diseaseID)) {
          List<Integer> relatedDiseases = new ArrayList<>();
          Integer totalDiseaseOccurrence = diseaseCounter.get(diseaseID);
          Map<Integer, Integer> causedDiseases =
              relatedDiseasesList.get(diseaseID);
          for (Integer disease : causedDiseases.keySet()) {
            Integer relatedDiseaseOccurrence = causedDiseases.get(disease);
            double causingFactor =
                (double) relatedDiseaseOccurrence / totalDiseaseOccurrence;
            if (causingFactor >= 0.5) {
              relatedDiseases.add(disease);
            }
          }
          diseasesCausedTogetherList.put(diseaseID, relatedDiseases);
        }
      }
      Map<String, List<String>> diseasesCausedTogetherNames =
          new LinkedHashMap<>();
      diseasesCausedTogetherList
          .forEach((disease, relatedDiseasesFoundList) -> {
            String diseaseName = allDiseases.get(disease).getName();
            List<String> relatedDiseasesNames = new ArrayList<>();
            for (Integer relatedDiseaseFound : relatedDiseasesFoundList) {
              relatedDiseasesNames
                  .add(allDiseases.get(relatedDiseaseFound).getName());
            }
            diseasesCausedTogetherNames.put(diseaseName, relatedDiseasesNames);
          });
      return diseasesCausedTogetherNames;
    } catch (NullPointerException e) {
      return null;
    }
  }
}