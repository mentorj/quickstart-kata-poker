package com.javaxpert.books.prodev.katas.poker;

import io.vavr.*;
import io.vavr.collection.List;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This component is used to check hands for the combos used to evaluate hands
 * @author deadbrain
 */
public class HandChecker {

 //   private final Function4<Function<Card,Criteria>,Predicate<Tuple2<Criteria, List<Card>>>,Function0<Integer>,Hand,Boolean> genericFunction=Function4.of(HandChecker::handConformsToCriterias);
 //   private final Function3<Predicate<Tuple2<Criteria, List<Card>>>,Function0<Integer>,Hand,Boolean> groupByRank = genericFunction.apply(Card::getRank);
  //  private final Function2<Function0<Integer>,Hand,Boolean> findPairs = groupByRank.apply((tuple2)-> (tuple2._2.size()==2));

    private boolean checkForNCardsWithSameRankWithOccurences(Hand hand,int groupSize,int occurences){
        return handConformsToCriterias(Card::getRank,
                criteriaListTuple2 -> criteriaListTuple2._2.size()==groupSize,
                ()-> {return occurences;},
                hand
                );

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

    public boolean handContainsFlush(Hand hand){
        return hand.getCards()
                .groupBy(card -> card.getColor())
                .filter(colorListTuple2 -> colorListTuple2._2.size()==5)
                .size()==1;
    }
    private static boolean handConformsToCriterias(
            Function<Card,Criteria> groupingFunction,
            Predicate<Tuple2<Criteria, List<Card>>> predicate,
            Function0<Integer> sizeCriteria,
            Hand targetHand

    ) {
        return targetHand.getCards()
                .groupBy(groupingFunction)
                .filter(predicate)
                .size()==sizeCriteria.apply()
                ;

    }
}
