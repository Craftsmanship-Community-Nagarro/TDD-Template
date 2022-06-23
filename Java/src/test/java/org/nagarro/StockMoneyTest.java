package org.nagarro;

import org.assertj.core.data.Percentage;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class StockMoneyTest {

    @Test
    public void multiplyMoney(){
        Money money = new Money(BigDecimal.valueOf(5), Currency.USD);
        StockItem stockItem = new StockItem(money, 2);

        assertThat(stockItem.multiplyShares().getValue()).isEqualTo(BigDecimal.valueOf(10));
        assertThat(stockItem.getMoney().getCurrency()).isEqualTo(Currency.USD);
    }

    @Test
    public void divideMoney(){
        Money money = new Money(BigDecimal.valueOf(4002), Currency.USD);
        StockItem stockItem = new StockItem(money, 4);

        assertThat(stockItem.divideShares().getValue().toString()).isEqualTo("1000.50");
        assertThat(stockItem.getMoney().getCurrency()).isEqualTo(Currency.USD);
    }

    @Test
    public void convertCurrencyFromUSDToEUR(){
        Money money = new Money(BigDecimal.valueOf(4002), Currency.USD);
        Money moneyInEuro = CurrencyConverter.convert(/*from*/money, /*to*/Currency.EUR);

        assertThat(moneyInEuro.getValue()).isCloseTo(BigDecimal.valueOf(3802.46D), Percentage.withPercentage(2));
    }

    @Test
    public void convertCorrencyFromKRWToUSD(){
        Money money = new Money(BigDecimal.valueOf(10000), Currency.KRW);
        Money moneyInEuro = CurrencyConverter.convert(/*from*/money, /*to*/Currency.USD);

        assertThat(moneyInEuro.getValue()).isCloseTo(BigDecimal.valueOf(7.69D), Percentage.withPercentage(2));
    }
}
