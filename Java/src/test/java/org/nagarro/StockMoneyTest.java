package org.nagarro;

import org.assertj.core.data.Percentage;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class StockMoneyTest {

  @Test
  public void multiplyMoney() {
    Money money = new Money(BigDecimal.valueOf(5), Currency.USD);
    StockItem stockItem = new StockItem(money, 2);

    assertThat(stockItem.multiplyShares().getValue()).isEqualTo(BigDecimal.valueOf(10));
    assertThat(stockItem.getMoney().getCurrency()).isEqualTo(Currency.USD);
  }

  @Test
  public void divideMoney() {
    Money money = new Money(BigDecimal.valueOf(4002), Currency.USD);
    StockItem stockItem = new StockItem(money, 4);

    assertThat(stockItem.divideShares().getValue().toString()).isEqualTo("1000.50");
    assertThat(stockItem.getMoney().getCurrency()).isEqualTo(Currency.USD);
  }

  @Test
  public void convertCurrencyConversionFromUSDToEUR() {
    Money money = new Money(BigDecimal.valueOf(4002), Currency.USD);
    Money moneyInEuro = CurrencyConverter.convert(/*from*/money, /*to*/Currency.EUR);

    assertThat(moneyInEuro.getValue()).isCloseTo(BigDecimal.valueOf(3802.46D), Percentage.withPercentage(2));
  }

  @Test
  public void convertCorrencyConversionFromKRWToUSD() {
    Money money = new Money(BigDecimal.valueOf(10000), Currency.KRW);
    Money moneyInEuro = CurrencyConverter.convert(/*from*/money, /*to*/Currency.USD);

    assertThat(moneyInEuro.getValue()).isCloseTo(BigDecimal.valueOf(7.69D), Percentage.withPercentage(2));
  }

  @Test
  public void testSumDifferentCurrencies() {
    Money fiveUSD = new Money(BigDecimal.valueOf(5), Currency.USD);
    Money tenEUR = new Money(BigDecimal.valueOf(10), Currency.EUR);

    Money money = CurrencyConverter.addCurrencies(Currency.USD, Arrays.asList(fiveUSD, tenEUR));

    assertThat(money.getValue().toString()).isEqualTo("15.50");
    assertThat(money.getCurrency()).isEqualTo(Currency.USD);
    assertThat(money.getCurrency().getDescription()).isEqualTo("US Dollar");
    // assertThat(stockItem.getMoney().getCurrency()).isEqualTo(Currency.USD);
  }
}
