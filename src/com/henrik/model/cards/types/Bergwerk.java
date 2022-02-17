package com.henrik.model.cards.types;

import com.henrik.model.Player;
import com.henrik.model.cards.CardType;

public class Bergwerk extends Blue{

    public Bergwerk() {
        super(6);
    }

    @Override
    public void consume(Player owner) {
        owner.addCoins(5);
    }

    @Override
    public CardType getCardType() {
        return CardType.BERGWERK;
    }


    @Override
    public boolean isWorkingPlace() {
        return true;
    }
}
