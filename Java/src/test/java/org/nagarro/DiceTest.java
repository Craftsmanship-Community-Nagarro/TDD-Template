package org.nagarro;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiceTest {


    @Test
    public void diceReturnsBetweenOneAndFive() {
        Dice dice = new Dice();

        for (int i =1; i <= 100; i++) {
            Assertions.assertThat(dice.roll()).isBetween(1, 6);
        }
    }




}
