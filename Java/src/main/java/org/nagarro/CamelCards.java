package org.nagarro;

public class CamelCards {
    public HandType computeType(String hand) {
        char firstChar = hand.charAt(0);

        if(hand.chars().allMatch(x->x==firstChar))
        {
            return HandType.FiveOfAKind;
        }

        return null;
    }
}
