package org.nagarro;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CamelCardsTest {

    @Test
    public void fiveOfAKind() {
        HandType result = new CamelCards().computeType("22222");
        assertThat(result).isEqualTo(HandType.FiveOfAKind);
    }
}
