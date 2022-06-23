package org.nagarro;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StockItem {
    private final Money money;
    private final int shares;

    public StockItem(Money money, int shares) {
        this.money = money;
        this.shares = shares;
    }

    public Money getMoney() {
        return money;
    }

    public int getShares() {
        return shares;
    }

    public Money multiplyShares(){
        BigDecimal value = this.getMoney().getValue().multiply(BigDecimal.valueOf(this.shares));
        return new Money(value, this.money.getCurrency());
    }

    public Money divideShares() {
        BigDecimal value = this.getMoney().getValue().divide(BigDecimal.valueOf(this.shares), 2, RoundingMode.HALF_UP);
        return new Money(value, this.money.getCurrency());
    }
}
