/**
 * @author Nachiket Niranjanbhai Panchal
 * @description This file contains DiseaseSorter class which will help to create
 * DiseaseSorter objects which will help to sort diseases lists according to values
 */
package hms.models.classes.disease.diseasesorter;

import hms.models.interfaces.disease.diseasesorter.IDiseaseSorter;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class DiseaseSorter<K, Number extends Comparable<? super Number>>
    implements IDiseaseSorter<K, Number> {

  @Override
  public Map<K, Number> sortByValue(Map<K, Number> list) {
    return list.entrySet().stream()
        .sorted(Collections.reverseOrder(Entry.comparingByValue()))
        .collect(Collectors
            .toMap(Entry::getKey, Entry::getValue,
                (nListKey, nListValue) -> nListValue, LinkedHashMap::new));
  }
}