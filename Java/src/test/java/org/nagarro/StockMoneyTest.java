package org.nagarro;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

public class StockMoneyTest {

    @Test
    public void addMoney(){
        Money money = new Money(BigDecimal.valueOf(5), Currency.DOLLAR);
        StockItem stockItem = new StockItem(money, 2);

        assertThat(stockItem.value().getValue()).isEqualTo(BigDecimal.valueOf(10));
        assertThat(stockItem.getMoney().getCurrency()).isEqualTo(Currency.DOLLAR);
    }

}
