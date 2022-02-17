package com.henrik.model.cards.types;

import com.henrik.model.Player;
import com.henrik.model.cards.CardType;
import com.henrik.model.cards.Monuments;

public class Cafe extends Red{

    public Cafe() {
        super(2);
    }

    @Override
    public void consume(Player owner) {
        if (controller.getDice() == 3)
            owner.addCoins(controller.getCurrentPlayer().removeCoins(1 + (owner.hasMonument(Monuments.Monument.EINKAUFSZENTRUM) ? 1 : 0)));
    }

    @Override
    public CardType getCardType() {
        return CardType.CAFE;
    }


    @Override
    public boolean isRestaurant() {
        return true;
    }
}
