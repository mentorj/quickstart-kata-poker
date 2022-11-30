package com.javaxpert.books.prodev.katas.poker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * tests suite for poker hands evaluation
 * @author deadbrain
 */
public class PokerHandsTestssuite {
    private static final List<Card> fooCards= new ArrayList<>(5);
    private  static Hand fooHand;

    private static final  List<Card> basicPair = new ArrayList<>(5);
    private static Hand basicPairHand;

    private static final List<Card> twoPairs = new ArrayList<>(5);
    private static Hand twoPairsHand;

    private static final List<Card> threeOfAKind = new ArrayList<>(5);
    private static Hand threeOfAKindHand;

    private static final List<Card> fourOfAKind = new ArrayList<>(5);
    private static Hand fourAKindHand;


    private static final List<Card> fullHouse = new ArrayList<>(5);
    private static Hand fullHouseHand;


    private static final List<Card> flush = new ArrayList<>(5);
    private static Hand flushHand;

    private static final List<Card> straight = new ArrayList<>(5);
    private static Hand straightHand;

    private static final List<Card> royalFlush = new ArrayList<>(5);
    private static Hand royalFlushHand;

    @BeforeAll
    static void setupTests(){
        fooCards.add(new Card(Rank.FIVE,Color.DIAMOND));
        fooCards.add(new Card(Rank.SEVEN,Color.DIAMOND));
        fooCards.add(new Card(Rank.SIX,Color.HEART));
        fooCards.add(new Card(Rank.EIGHT,Color.DIAMOND));
        fooCards.add(new Card(Rank.QUEEN,Color.HEART));
        fooHand=new Hand(fooCards);

        basicPair.add(new Card(Rank.QUEEN,Color.HEART));
        basicPair.add(new Card(Rank.QUEEN,Color.SPADE));
        basicPair.add(new Card(Rank.FOUR,Color.SPADE));
        basicPair.add(new Card(Rank.FIVE,Color.SPADE));
        basicPair.add(new Card(Rank.KING,Color.SPADE));
        basicPairHand=new Hand(basicPair);

        twoPairs.add(new Card(Rank.FIVE,Color.SPADE));
        twoPairs.add(new Card(Rank.FIVE,Color.HEART));
        twoPairs.add(new Card(Rank.SIX,Color.HEART));
        twoPairs.add(new Card(Rank.SIX,Color.SPADE));
        twoPairs.add(new Card(Rank.TWO,Color.TREFLE));
        twoPairsHand=new Hand(twoPairs);

        threeOfAKind.add(new Card(Rank.NINE,Color.SPADE));
        threeOfAKind.add(new Card(Rank.NINE,Color.HEART));
        threeOfAKind.add(new Card(Rank.NINE,Color.DIAMOND));
        threeOfAKind.add(new Card(Rank.FOUR,Color.SPADE));
        threeOfAKind.add(new Card(Rank.JACK,Color.TREFLE));
        threeOfAKindHand = new Hand(threeOfAKind);

        fourOfAKind.add(new Card(Rank.JACK,Color.TREFLE));
        fourOfAKind.add(new Card(Rank.JACK,Color.SPADE));
        fourOfAKind.add(new Card(Rank.JACK,Color.DIAMOND));
        fourOfAKind.add(new Card(Rank.JACK,Color.HEART));
        fourOfAKind.add(new Card(Rank.ACE,Color.TREFLE));
        fourAKindHand=new Hand(fourOfAKind);


        fullHouse.add(new Card(Rank.NINE,Color.TREFLE));
        fullHouse.add(new Card(Rank.NINE,Color.HEART));
        fullHouse.add(new Card(Rank.NINE,Color.SPADE));
        fullHouse.add(new Card(Rank.KING,Color.TREFLE));
        fullHouse.add(new Card(Rank.KING,Color.SPADE));
        fullHouseHand=new Hand(fullHouse);

        flush.add(new Card(Rank.SEVEN,Color.TREFLE));
        flush.add(new Card(Rank.EIGHT,Color.TREFLE));
        flush.add(new Card(Rank.NINE,Color.TREFLE));
        flush.add(new Card(Rank.TEN,Color.TREFLE));
        flush.add(new Card(Rank.JACK,Color.TREFLE));
        flushHand=new Hand(flush);

        straight.add(new Card(Rank.SEVEN,Color.TREFLE));
        straight.add(new Card(Rank.EIGHT,Color.DIAMOND));
        straight.add(new Card(Rank.NINE,Color.SPADE));
        straight.add(new Card(Rank.TEN,Color.TREFLE));
        straight.add(new Card(Rank.JACK,Color.HEART));
        straightHand=new Hand(straight);

        royalFlush.add(new Card(Rank.ACE,Color.TREFLE));
        royalFlush.add(new Card(Rank.KING,Color.TREFLE));
        royalFlush.add(new Card(Rank.QUEEN,Color.TREFLE));
        royalFlush.add(new Card(Rank.JACK,Color.TREFLE));
        royalFlush.add(new Card(Rank.TEN,Color.TREFLE));
        royalFlushHand=new Hand(royalFlush);


    }


    @Test
    void checkForSinglePairInHandWithBasicPairHand(){
        HandChecker checker = new HandChecker();
        boolean check = checker.checkHandForOnePair(basicPairHand);
        assertTrue(check);
    }

    @Test
    void checkForSinglePairInHandWithFooHand(){
        HandChecker checker= new HandChecker();
        boolean check = checker.checkHandForOnePair(fooHand);
        assertFalse(check);
    }

    @Test
    void checkForSinglePairInHandWithThreeOfAKind(){
        HandChecker checker = new HandChecker();
        boolean check = checker.checkHandForOnePair(threeOfAKindHand);
        assertFalse(check);
    }

    @Test
    void checkForSinglePairInHandWithHandContaining2Pairs(){
        HandChecker checker = new HandChecker();
        boolean check = checker.checkHandForOnePair(twoPairsHand);
        assertFalse(check);
    }

    @Test
    void checkForThreeOfAKindInHandWithThreeOfAkind(){
        HandChecker checker = new HandChecker();
        assertTrue( checker.checkForThreeOfAKindInHand(threeOfAKindHand));
    }

    @Test
    void checkForThreeOfAKindInHandWithBasicHand(){
        HandChecker checker = new HandChecker();
        assertFalse( checker.checkForThreeOfAKindInHand(fooHand));
    }

    @Test
    void checkForThreeOfAKindInHandWithFourOfAKind(){
        HandChecker checker = new HandChecker();
        assertFalse( checker.checkForThreeOfAKindInHand(fourAKindHand));
    }



}
