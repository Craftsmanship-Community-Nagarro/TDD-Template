package org.nagarro;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CamelCardsTest {

    @Test
    public void fiveOfAKind() {
        HandType result = new CamelCards().computeType("22222");
        assertThat(result).isEqualTo(HandType.FiveOfAKind);
    }

    @Test
    public void fourOfAKind() {
        HandType result = new CamelCards().computeType("22221");
        assertThat(result).isEqualTo(HandType.FourOfAKind);

        result = new CamelCards().computeType("12222");
        assertThat(result).isEqualTo(HandType.FourOfAKind);
    }

    @Test
    public void threeOfAKind() {
        HandType result = new CamelCards().computeType("22213");
        assertThat(result).isEqualTo(HandType.ThreeOfAKind);
    }

//    @Test
//    public void noNoSense() {
//        HandType result = new CamelCards().computeType("MCNCV");
//        assertThat(result).isEqualTo(null);
//    }

}
