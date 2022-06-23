package org.nagarro;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class StockMoneyTest {

    @Test
    public void multiplyMoney(){
        Money money = new Money(BigDecimal.valueOf(5), Currency.DOLLAR);
        StockItem stockItem = new StockItem(money, 2);

        assertThat(stockItem.multiplyShares().getValue()).isEqualTo(BigDecimal.valueOf(10));
        assertThat(stockItem.getMoney().getCurrency()).isEqualTo(Currency.DOLLAR);
    }

    @Test
    public void divideMoney(){
        Money money = new Money(BigDecimal.valueOf(4002), Currency.DOLLAR);
        StockItem stockItem = new StockItem(money, 4);

        assertThat(stockItem.divideShares().getValue().toString()).isEqualTo("1000.50");
        assertThat(stockItem.getMoney().getCurrency()).isEqualTo(Currency.DOLLAR);
    }

}
