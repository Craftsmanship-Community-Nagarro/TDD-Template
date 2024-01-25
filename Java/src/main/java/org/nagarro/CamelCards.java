package org.nagarro;

import java.util.List;
import java.util.stream.Collectors;

public class CamelCards {
  public HandType computeType(String hand) {

    List<Integer> frequencies = frequencies(hand);
//TODO: Validate parameters

    if (frequencies.contains(5)) {
      return HandType.FiveOfAKind;
    }
    if (frequencies.contains(4)) {
      return HandType.FourOfAKind;
    }
    if (frequencies.contains(3) && frequencies.contains(2)) {
      return HandType.FullHouse;
    }
    if (frequencies.contains(3)) {
      return HandType.ThreeOfAKind;
    }
    if (frequencies.stream().filter(e -> e == 2).count() == 4) {
      return HandType.TwoPair;
    }

    if (frequencies.contains(2)) {
      return HandType.OnePair;
    }


    //TODO: Refactor to Stream API
    return HandType.HighCard;
  }

  private List<Integer> frequencies(String hand) {
    return hand.chars().mapToObj(c -> (int) hand.chars().filter(x -> x == c).count()).collect(Collectors.toList());

  }
}
