package org.nagarro;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * This class is responsible for computing the type of a hand of Camel Cards.
 *
 * A map of characters and frequencies, where the key is the character and the value is the frequency
 * 222AA
 * Key: 2. Frequency: 3
 * Key: A. Frequency: 2
 * 23456
 * Key 2. Frequency: 1
 * Key 3, Frequency: 1
 * .....
 *
 * Then analyze the frequencies
 *
 * For above examples
 * 2 and 3 = Full house
 * 1 and 4 = Four of a kind
 * 1, 1 and 3 = Three of a kind
 * 1, 2 and 2 = two pairs
 * 1, 1, 1, and 2 = one pair
 * 1, 1, 1, 1 and 1 = high card
 *
 * TODO: We can abstract above combinations to make a generic tool, e.g. arbitrary number of hands and arbitrary number of rules.
 * @author marco.avila@nagarro.com
 */
public class CamelCards {
  public HandType computeType(String hand) {
    validateParameters(hand);
    return parseFrequencies(createFrequencies(extractFrequenciesFromCharacters(hand)));
  }

  private static void validateParameters(String hand) {
    if (Objects.isNull(hand)) {
      throw new IllegalArgumentException("Invalid hand (null)");
    }

    boolean matches = hand.matches("^[AKQJT98765432]{5}$");

    if (!matches) {
      throw new IllegalArgumentException("Invalid hand (" + hand + ")");
    }
  }

  private static HandType parseFrequencies(List<Long> frequencies) {
    if (frequencies.equals(List.of(1L, 4L))) {
      return HandType.FourOfAKind;
    } else if (frequencies.equals(List.of(2L, 3L))) {
      return HandType.FullHouse;
    } else if (frequencies.equals(List.of(1L, 1L, 3L))) {
      return HandType.ThreeOfAKind;
    } else if (frequencies.equals(List.of(1L, 2L, 2L))) {
      return HandType.TwoPairs;
    } else if (frequencies.equals(List.of(1L, 1L, 1L, 2L))) {
      return HandType.OnePair;
    } else if (frequencies.equals(List.of(5L))) {
      return HandType.FiveOfAKind;
    } else if (frequencies.equals(List.of(1L, 1L, 1L, 1L, 1L))) {
      return HandType.HighCard;
    }
    return null;
  }

  private static List<Long> createFrequencies(Map<Character, Long> frequencyMap) {
    return frequencyMap.values().stream().sorted().toList();
  }

  private static Map<Character, Long> extractFrequenciesFromCharacters(String hand) {
    return hand.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }
}
