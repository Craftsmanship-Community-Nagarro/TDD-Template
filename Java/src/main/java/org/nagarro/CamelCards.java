package org.nagarro;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CamelCards {
  public HandType computeType(String hand) {
    validateParameters(hand);
    return analyzeFrequencies(createFrequencies(extractFrequenciesFromCharacters(hand)));
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

  private static HandType analyzeFrequencies(List<Long> frequencies) {
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
