package com.javaxpert.books.prodev.katas.poker;

import io.vavr.*;
import io.vavr.collection.List;
import io.vavr.control.Option;

import java.util.function.Function;
import java.util.function.Predicate;

public class HandChecker2 {
    public boolean handContainsFlush(Hand hand){

        return handConformsToCriterias(Card::getColor,
                criteriaListTuple2 -> criteriaListTuple2._2.size()==5,
                Function0.constant(1),
                hand
        );
    }
    private static boolean handConformsToCriterias(
            Function<Card,Criteria> groupingFunction,
            Function1<Tuple2<Criteria, List<Card>>,Boolean> predicate,
            Function0<Integer> sizeCriteria,
            Hand targetHand

    ) {
        return targetHand.getCards()
                .groupBy(groupingFunction)
                .filter((criteria, cards) -> predicate.apply(Tuple.of(criteria,cards)))
                .size()==sizeCriteria.apply()
                ;

    }

    public boolean handContainsOnePair(Hand hand){

        return handConformsToCriterias(Card::getRank,
                criteriaListTuple2 -> criteriaListTuple2._2.size()==2,
                Function0.constant(1),
                hand
        );
    }


    public Option<ComboRanking> evaluateHandWithCriteria(Hand aHand, Tuple4<Function1<Card,Criteria>, Function1<Tuple2<Criteria,List<Card>>,Boolean>,Integer,ComboRanking> criteriasForCombo){

        boolean conformsToCriterias = handConformsToCriterias(
                criteriasForCombo._1,
                criteriasForCombo._2,
                Function0.of(() -> criteriasForCombo._3),
                aHand
                );

        return conformsToCriterias ? Option.some(criteriasForCombo._4):Option.none();
    }

    public ComboRanking evaluateHand(Hand someHand){
        Tuple4<Function1<Card,Criteria>, Function1<Tuple2<Criteria,List<Card>>,Boolean>,Integer,ComboRanking> criteriasForPair = Tuple.of(Card::getRank, criteriaListTuple2 -> criteriaListTuple2._2.size()==2,1,ComboRanking.PAIR);
        Tuple4<Function1<Card,Criteria>, Function1<Tuple2<Criteria,List<Card>>,Boolean>,Integer,ComboRanking> criteriasFor2Pairs = Tuple.of(Card::getRank, criteriaListTuple2 -> criteriaListTuple2._2.size()==2,2,ComboRanking.TWO_PAIRS);
        Tuple4<Function1<Card,Criteria>, Function1<Tuple2<Criteria,List<Card>>,Boolean>,Integer,ComboRanking> criteriasForColor = Tuple.of(Card::getColor, criteriaListTuple2 -> criteriaListTuple2._2.size()==5,1,ComboRanking.COLOR);

        List<Tuple4<Function1<Card,Criteria>, Function1<Tuple2<Criteria,List<Card>>,Boolean>,Integer,ComboRanking>> rankingCriterias = List.of(criteriasForPair,criteriasForColor,criteriasFor2Pairs);
        List<Option<ComboRanking>> results =  rankingCriterias.map(criteria -> evaluateHandWithCriteria(someHand,criteria));
        return results.filter(option -> option.isDefined() ).map(option -> option.get()).get(0);
    }


}
