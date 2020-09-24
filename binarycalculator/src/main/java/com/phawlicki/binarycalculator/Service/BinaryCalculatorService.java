package com.phawlicki.binarycalculator.Service;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BinaryCalculatorService {

  public boolean convertBigIntegerToBinary(BigInteger bigInteger) {
    bigInteger.abs();
    String result = bigInteger.toString(2);
    String[] arr = result.split("");
    List<String> binaryList = Arrays.asList(arr);
    return countOccurrences(binaryList);
  }

  private boolean countOccurrences(List<String> binaryList) {
    int occurrencesOfOne = Collections.frequency(binaryList, "1");
    int occurrencesOfZero = Collections.frequency(binaryList, "0");
    return occurrencesOfOne == occurrencesOfZero;
  }
}