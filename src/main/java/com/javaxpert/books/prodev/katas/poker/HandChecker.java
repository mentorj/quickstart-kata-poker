package com.javaxpert.books.prodev.katas.poker;

/**
 * This component is used to check hands for the combos used to evaluate hands
 * @author deadbrain
 */
public class HandChecker {

    public boolean checkHandForOnePair(Hand hand) {
        return hand.getCards().groupBy(card -> card.getRank()).filter(tuple -> tuple._2.size()==2).size()==1;
    }

    public boolean checkForThreeOfAKindInHand(Hand hand) {
        return hand.getCards()
                .groupBy(card -> card.getRank())
                .filter((rank, cards) -> cards.size()==3)
                .size()==1;
    }
}
