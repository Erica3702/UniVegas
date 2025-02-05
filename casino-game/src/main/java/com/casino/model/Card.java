package com.casino.model;

public class Card {
    private String value;
    private String type;

    public Card(String value, String type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public int getCardValue() {
        if ("AJQK".contains(value)) {
            if (value.equals("A")) {
                return 11;
            }
            return 10;
        }
        return Integer.parseInt(value);
    }

    public boolean isAce() {
        return value.equals("A");
    }

    public String getImagePath() {
        return "/cards/" + toString() + ".png";
    }

    @Override
    public String toString() {
        return value + "-" + type;
    }
}