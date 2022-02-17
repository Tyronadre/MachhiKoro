package com.henrik.model.cards.types;

import com.henrik.model.Player;
import com.henrik.model.cards.CardType;

public class Bauernhof extends Blue{
    public Bauernhof() {
        super(1);
    }

    @Override
    public void consume(Player owner) {

    }

    @Override
    public CardType getCardType() {
        return CardType.BAUERNHOF;
    }

    @Override
    public boolean isTierFarm() {
        return true;
    }
}
