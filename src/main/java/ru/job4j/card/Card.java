package ru.job4j.card;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Card {

    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Set<Card> cardList = new HashSet<>();
        Stream.of(Suit.values())
                .flatMap(s -> Stream.of(Value.values())
                        .map(v -> cardList.add(new Card(s, v))));
    }
}
