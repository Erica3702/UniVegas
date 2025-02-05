package com.casino.model;

import java.util.ArrayList;
import java.util.Random;

public class Mazzo {
    private ArrayList<Card> deck;
    private Random random;

    public Mazzo() {
        deck = new ArrayList<>();
        random = new Random();
        buildDeck();
        shuffleDeck();
    }

    private void buildDeck() {
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] types = {"C", "D", "H", "S"};

        for (String type : types) {
            for (String value : values) {
                deck.add(new Card(value, type));
            }
        }
    }

    private void shuffleDeck() {
        for (int i = 0; i < deck.size(); i++) {
            int j = random.nextInt(deck.size());
            Card temp = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }
    }

    public Card drawCard() {
        return deck.remove(deck.size() - 1);
    }

    public int getDeckSize() {
        return deck.size();
    }
}