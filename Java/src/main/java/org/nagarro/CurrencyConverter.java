package org.nagarro;

import java.math.BigDecimal;

public class CurrencyConverter {

  public static Money convert(Money from, Currency to) {
    BigDecimal conversionRate = CurrencyTable.getValue(new ConversionElement(from.getCurrency(), to));
    return new Money(conversionRate.multiply(from.getValue()), to);
  }

}
