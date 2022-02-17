package com.henrik.model;

import com.henrik.model.cards.Card;
import com.henrik.model.cards.CardType;
import com.henrik.model.cards.Monuments;
import com.henrik.model.cards.types.Baeckerei;
import com.henrik.model.cards.types.StartBaekerei;
import com.henrik.model.cards.types.StartWeizenFeld;
import com.henrik.model.cards.types.WeizenFeld;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Player {
    Monuments monuments = new Monuments();

    List<Card> cards = new ArrayList<>(List.of(new StartWeizenFeld(), new StartBaekerei()));
    int coins = 100;

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card removeCard(CardType cardType) {
        return cards.stream().filter(card1 -> card1.getCardType() == (cardType)).findAny().orElse(null);
    }

    public void addCoins(int number) {
        coins += number;
    }

    public int removeCoins(int count) {
        if (count > coins) {
            int temp = coins;
            coins = 0;
            return temp;
        }
        coins -= count;
        return count;
    }

    public int getCoins() {
        return coins;
    }

    public boolean hasMonument(Monuments.Monument monument) {
        return switch (monument) {
            case BAHNHOF -> monuments.Bahnhof;
            case EINKAUFSZENTRUM -> monuments.Einkaufszentrum;
            case FREIZEITPARK -> monuments.Freizeitpark;
            case FUNKTURM -> monuments.Funkturm;
        };
    }
    public void addMonument(Monuments.Monument monument) {
        switch (monument) {
            case BAHNHOF -> monuments.Bahnhof = true;
            case EINKAUFSZENTRUM -> monuments.Einkaufszentrum = true;
            case FREIZEITPARK -> monuments.Freizeitpark = true;
            case FUNKTURM -> monuments.Funkturm = true;
        }
    }

    public List<Monuments.Monument> getAllMonuments() {
        List<Monuments.Monument> result = new ArrayList<>();
        for (Monuments.Monument mon : Monuments.Monument.values()) {
            if (hasMonument(mon)) result.add(mon);
        }

        return result;
    }

}
