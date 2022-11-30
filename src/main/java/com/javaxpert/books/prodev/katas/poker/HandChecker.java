package com.javaxpert.books.prodev.katas.poker;

/**
 * This component is used to check hands for the combos used to evaluate hands
 * @author deadbrain
 */
public class HandChecker {
    private boolean checkForNCardsWithSameRank(Hand hand,int groupSize){
        return hand.getCards()
                .groupBy(card -> card.getRank())
                .filter((rank, cards) -> cards.size()==groupSize)
                .size()==1;
    }
    public boolean checkHandForOnePair(Hand hand) {
        return checkForNCardsWithSameRank(hand,2);
    }

    public boolean checkForThreeOfAKindInHand(Hand hand) {
        return checkForNCardsWithSameRank(hand,3);
    }

    public boolean checkHandContainsFourOfAKind(Hand hand){
        return checkForNCardsWithSameRank(hand,4);
    }
}
