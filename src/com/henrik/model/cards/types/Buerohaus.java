package com.henrik.model.cards.types;

import com.henrik.model.Player;
import com.henrik.model.cards.CardType;

public class Buerohaus extends Violett {

    public Buerohaus() {
        super(8);
    }

    @Override
    public void consume(Player owner) {
        //TODO
    }

    @Override
    public CardType getCardType() {
        return CardType.BUEROHAUS;
    }


    @Override
    public boolean isBuilding() {
        return true;
    }
}
