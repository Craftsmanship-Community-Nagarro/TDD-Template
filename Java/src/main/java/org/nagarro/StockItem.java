package org.nagarro;

import java.math.BigDecimal;

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

    public Money value(){
        BigDecimal value = this.getMoney().getValue().multiply(BigDecimal.valueOf(this.shares));
        return new Money(value, this.money.getCurrency());
    }
}
