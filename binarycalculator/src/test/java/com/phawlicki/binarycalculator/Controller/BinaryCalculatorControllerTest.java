package com.phawlicki.binarycalculator.Controller;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.phawlicki.binarycalculator.Service.BinaryCalculatorService;
import java.math.BigInteger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryCalculatorController.class)
public class BinaryCalculatorControllerTest {


  @Autowired
  private MockMvc mockMvc;

  @MockBean
  BinaryCalculatorService binaryCalculatorService;

  @Test
  public void shouldCheckResponseCodeAndMessageWhenCorrect() throws Exception {

    //when
    Mockito.when(binaryCalculatorService.convertBigIntegerToBinary(Mockito.any())).thenReturn(true);
    this.mockMvc.perform(get("/api/test/10")).andDo(print()).andExpect(status().isAccepted())
        .andExpect(MockMvcResultMatchers.content().string("Given number 10 has the same occurrences of 0 and 1 in binary notation: true"));
    //then
    verify(binaryCalculatorService, times(1)).convertBigIntegerToBinary(BigInteger.TEN);
  }

  @Test
  public void shouldCheckResponseCodeWhenMissingParam() throws Exception {

    //when
    this.mockMvc.perform(get("/api/test/")).andDo(print()).andExpect(status().isNotFound());
    //then
    verify(binaryCalculatorService, times(0)).convertBigIntegerToBinary(BigInteger.TEN);
  }

  @Test
  public void shouldCheckResponseCodeAndMessageWhenInvalidParam() throws Exception {

    //when
    this.mockMvc.perform(get("/api/test/test")).andDo(print()).andExpect(status().isBadRequest()).andExpect(MockMvcResultMatchers.content().string
        ("Provided param is not a number. Please provide correct parameters"));
    //then
    verify(binaryCalculatorService, times(0)).convertBigIntegerToBinary(BigInteger.TEN);
  }

}