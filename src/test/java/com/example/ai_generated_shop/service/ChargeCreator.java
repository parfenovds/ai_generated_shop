package com.example.ai_generated_shop.service;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.param.ChargeCreateParams;

public interface ChargeCreator {
  Charge createCharge(ChargeCreateParams params) throws StripeException;
}