package com.casino.model;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    private ArrayList<Card> hand;
    private int sum;
    private int aceCount;

    public Dealer() {
        hand = new ArrayList<>();
        sum = 0;
        aceCount = 0;
    }

    public void addCard(Card card) {
        hand.add(card);
        sum += card.getCardValue();
        if (card.isAce()) {
            aceCount++;
        }
    }

    public int getSum() {
        return sum;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int reduceAce() {
        while (sum > 21 && aceCount > 0) {
            sum -= 10;
            aceCount--;
        }
        return sum;
    }
    
}
