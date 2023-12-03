package com.example.ai_generated_shop.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentResultTest {

  @Test
  public void testPaymentResult_Success() {
    PaymentResult paymentResult = new PaymentResult(true, null);

    assertTrue(paymentResult.isSuccess());
    assertNull(paymentResult.getError());
  }

  @Test
  public void testPaymentResult_Failure() {
    String errorMessage = "Payment failed";
    PaymentResult paymentResult = new PaymentResult(false, errorMessage);

    assertFalse(paymentResult.isSuccess());
    assertEquals(errorMessage, paymentResult.getError());
  }

  @Test
  public void testPaymentResult_SettersAndGetters() {
    PaymentResult paymentResult = new PaymentResult(false, null);

    assertFalse(paymentResult.isSuccess());
    assertNull(paymentResult.getError());

    paymentResult.setSuccess(true);
    paymentResult.setError("Some error");

    assertTrue(paymentResult.isSuccess());
    assertEquals("Some error", paymentResult.getError());
  }
}