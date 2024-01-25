package org.nagarro;

import java.util.List;

public class CamelCards {
  public HandType computeType(String hand) {

//TODO: Validate parameters

    for (int i = 0; i < hand.length(); i++) {
      final int currentChar = hand.charAt(i);
      long count = hand.chars().filter(x -> x == currentChar).count();
      if (count == 5) {
        return HandType.FiveOfAKind;
      }
      if (count == 4) {
        return HandType.FourOfAKind;
      }
      List<Integer> counts = frequencies(hand);

      if (count == 3) {
        return HandType.ThreeOfAKind;
      }
      if (count == 2) {
        return HandType.OnePair;
      }
    }



    //TODO: Refactor to Stream API
    return HandType.HighCard;
  }

  private List<Integer> frequencies(String hand) {

  }
}
