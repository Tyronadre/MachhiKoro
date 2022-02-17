package com.henrik.model.cards.types;

import com.henrik.model.Player;
import com.henrik.model.cards.Card;
import com.henrik.model.cards.CardType;

public class Wald extends Blue{


    public Wald() {
        super(3);
    }

    @Override
    public void consume(Player owner) {
        if (controller.getDice() == 5)
            owner.addCoins(1);
    }

    @Override
    public CardType getCardType() {
        return CardType.WALD;
    }


    @Override
    public boolean isWorkingPlace() {
        return true;
    }
}
