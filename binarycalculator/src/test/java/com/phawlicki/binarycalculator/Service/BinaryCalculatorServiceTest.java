package com.phawlicki.binarycalculator.Service;

import java.math.BigInteger;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BinaryCalculatorServiceTest {

  @Autowired
  BinaryCalculatorService binaryCalculatorService;

  @Captor
  private ArgumentCaptor<List<String>> captureBinaryList;


  @Test
  public void shouldConvertBigIntegerToBinaryAndReturnTrue() {

//given
    BigInteger given = BigInteger.TEN;

//when
    Boolean result = binaryCalculatorService.convertBigIntegerToBinary(given);

//then
    Assert.assertTrue(result);
  }

  @Test
  public void shouldConvertBigIntegerToBinaryAndReturnFalse() {

//given
    BigInteger given = BigInteger.valueOf(11);

//when
    Boolean result = binaryCalculatorService.convertBigIntegerToBinary(given);

//then
    Assert.assertTrue(!result);
  }

}