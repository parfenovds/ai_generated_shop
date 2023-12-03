package com.example.ai_generated_shop.service;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.param.ChargeCreateParams;
import org.springframework.stereotype.Component;

@Component
public class StripeChargeCreator implements ChargeCreator {

  @Override
  public Charge createCharge(ChargeCreateParams params) throws StripeException {
    return Charge.create(params);
  }
}