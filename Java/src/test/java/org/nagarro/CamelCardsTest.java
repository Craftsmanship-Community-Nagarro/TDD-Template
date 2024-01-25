package org.nagarro;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CamelCardsTest {

    @Test
    public void fiveOfAKind() {
        HandType result = new CamelCards().computeType("22222");

        assertThat(result).isEqualTo(HandType.FiveOfAKind);
    }

    @Test
    public void fourOfAKind() {
        HandType result = new CamelCards().computeType("2222A");

        assertThat(result).isEqualTo(HandType.FourOfAKind);
    }

    @Test
    public void fullHouse() {
        HandType result = new CamelCards().computeType("222AA");

        assertThat(result).isEqualTo(HandType.FullHouse);
    }

    @Test
    public void threeOfAKind() {

        assertThatThrownBy(() -> new CamelCards().computeType("222AB"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Invalid hand (222AB)");

    }

    @Test
    public void twoPairs() {
        HandType result = new CamelCards().computeType("22AA3");

        assertThat(result).isEqualTo(HandType.TwoPairs);
    }

    @Test
    public void onePair() {
        HandType result = new CamelCards().computeType("AA345");

        assertThat(result).isEqualTo(HandType.OnePair);
    }

    @Test
    public void invalidHand() {
        assertThatThrownBy(() -> new CamelCards().computeType("2A34"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Invalid hand (2A34)");
    }

    @Test
    public void nullHand() {
        assertThatThrownBy(() -> new CamelCards().computeType(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Invalid hand (null)");
    }

    @Test
    public void highCard() {
        HandType result = new CamelCards().computeType("23456");

        assertThat(result).isEqualTo(HandType.HighCard);
    }
}
