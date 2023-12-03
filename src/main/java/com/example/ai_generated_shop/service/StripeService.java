package com.example.ai_generated_shop.service;

import com.example.ai_generated_shop.entity.Cart;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.param.ChargeCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StripeService {

  @Value("${stripe.secretKey}")
  private String secretKey; // Полученный секретный ключ Stripe из конфигурации приложения

  public PaymentResult processPayment(Cart cart) {
    Stripe.apiKey = secretKey;

    try {
      Charge charge = Charge.create(
          new ChargeCreateParams.Builder()
              .setAmount((long) (cart.getTotalAmount() * 100)) // Convert amount to cents
              .setCurrency("usd") // Set currency (change as needed)
              .setSource("tok_visa")
              .build()
      );

      // Payment successful
      return new PaymentResult(true, "Payment successful");
    } catch (StripeException e) {
      // Payment failed
      return new PaymentResult(false, e.getMessage());
    }
  }
}