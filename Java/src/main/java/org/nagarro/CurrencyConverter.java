package org.nagarro;

import java.math.BigDecimal;
import java.util.List;

public final class CurrencyConverter {

  private CurrencyConverter() {
  }

  public static Money convert(Money from, Currency to) {
    if (from.getCurrency().equals(to)) {
      return from;
    }
    BigDecimal conversionRate = CurrencyTable.getValue(new ConversionElement(from.getCurrency(), to));
    return new Money(conversionRate.multiply(from.getValue()), to);
  }

  public static Money addCurrencies(Currency output, List<Money> monies) {
    BigDecimal total =
            monies
                    .stream()
                    .map(money -> convert(money, output))
                    .map(money -> money.getValue())
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
    return new Money(
            total,
            output);
  }
}
