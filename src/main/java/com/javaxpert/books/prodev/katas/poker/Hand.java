package com.javaxpert.books.prodev.katas.poker;


import io.vavr.collection.List;

/**
 * hand of cards (5)
 * use  this as you want, refactor it as often as needed
 * @author deadbrain
 */
public class Hand {
    private List<Card> cards;

    public Hand(java.util.List<Card> cards) {
        this.cards = List.ofAll(cards);
    }

    public List<Card> getCards() {
        return cards;
    }
}
