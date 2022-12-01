package com.javaxpert.books.prodev.katas.poker;

/**
 * This component is used to check hands for the combos used to evaluate hands
 * @author deadbrain
 */
public class HandChecker {
    private boolean checkForNCardsWithSameRankWithOccurences(Hand hand,int groupSize,int occurences){
        return hand.getCards()
                .groupBy(card -> card.getRank())
                .filter((rank, cards) -> cards.size()==groupSize)
                .size()==occurences;
    }
    public boolean checkHandForOnePair(Hand hand) {
        return checkForNCardsWithSameRankWithOccurences(hand,2,1);
    }

    public boolean checkForThreeOfAKindInHand(Hand hand) {
        return checkForNCardsWithSameRankWithOccurences(hand,3,1);
    }

    public boolean checkHandContainsFourOfAKind(Hand hand){
        return checkForNCardsWithSameRankWithOccurences(hand,4,1);
    }

    public boolean handContains2Pairs(Hand hand){
        return checkForNCardsWithSameRankWithOccurences(hand,2,2);
    }

    public boolean handContainsFullHouse(Hand hand){
        return checkHandForOnePair(hand) && checkForThreeOfAKindInHand(hand);
    }
}
