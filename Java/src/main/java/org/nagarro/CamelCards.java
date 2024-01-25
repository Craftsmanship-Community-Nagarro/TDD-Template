package org.nagarro;

public class CamelCards {
    public HandType computeType(String hand) {

        for (int i = 0; i < 2; i++) {
            final int currentChar = hand.charAt(i);
            long count = hand.chars().filter(x->x== currentChar).count();
            if(count == 5)
            {
                return HandType.FiveOfAKind;
            }
            if (count == 4) {
                return HandType.FourOfAKind;
            }
        }
        return null;
    }
}
