package com.javaxpert.books.prodev.katas.poker;

import io.vavr.Function1;
import io.vavr.Tuple2;
import io.vavr.collection.List;

import java.util.function.Predicate;

public class ComboSelectorHolder {
    private Function1<Card,Criteria> groupingFn;
    private Predicate<Tuple2<Criteria, List<Card>>>sortingPredicate;
    private int groupSize;

    public ComboSelectorHolder(Function1<Card, Criteria> groupingFn) {
        this.groupingFn = groupingFn;
    }

    public Function1<Card, Criteria> getGroupingFn() {
        return groupingFn;
    }

    public Predicate<Tuple2<Criteria, List<Card>>> getSortingPredicate() {
        return sortingPredicate;
    }

    public int getGroupSize() {
        return groupSize;
    }
}
