package com.henrik.controller;

import com.henrik.model.cards.Card;
import com.henrik.model.cards.CardType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.henrik.model.cards.CardType.*;

public class CardHelper {

    static Tupel[] initStack = new Tupel[]{
            new Tupel(6, WEIZENFELD),
            new Tupel(6, BAUERNHOF),
            new Tupel(6, BAECKEREI),
            new Tupel(6, CAFE),
            new Tupel(6, MINI_MARKT),
            new Tupel(6, WALD),
            new Tupel(4, STADION),
            new Tupel(4, FERNSEHSENDER),
            new Tupel(4, BUEROHAUS),
            new Tupel(6, MOLKEREI),
            new Tupel(6, MOEBELFABRIK),
            new Tupel(6, BERGWERK),
            new Tupel(6, FAMILIEN_RESTAURANT),
            new Tupel(6, APFELPLANTAGE),
            new Tupel(6, MARKTHALLE),
    };

    public static List<Card> getInitStack() {
        List<Card> cardList = new ArrayList<>();
        for (Tupel tuple : initStack) {
            for (int i = 0; i < tuple.number; i++) {
                cardList.add(Card.getCardOfType(tuple.type));
            }
        }

        Collections.shuffle(cardList);

        return cardList;
    }

    private static class Tupel {
        int number;
        CardType type;

        Tupel(int number, CardType type) {
            this.number = number;
            this.type = type;
        }
    }
}
