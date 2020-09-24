package com.phawlicki.binarycalculator.Controller;


import com.phawlicki.binarycalculator.Service.BinaryCalculatorService;
import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/")
public class BinaryCalculatorController {

  @Autowired
  private BinaryCalculatorService binaryCalculatorService;

  @GetMapping("api/test/{prime}")
  public ResponseEntity<String> convertToBinary(@PathVariable(required = true) BigInteger prime) {
    Boolean result = binaryCalculatorService.convertBigIntegerToBinary(prime);
    return new ResponseEntity<>("Given number " + prime + " has the same occurrences of 0 and 1 in binary notation: " + result, HttpStatus.ACCEPTED);
  }
}
