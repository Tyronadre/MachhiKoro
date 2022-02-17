package com.henrik.model.cards.types;

import com.henrik.model.Player;
import com.henrik.model.cards.CardType;
import com.henrik.model.cards.Monuments;

public class Familienrestaurant extends Red {

    public Familienrestaurant() {
        super(3);
    }

    @Override
    public void consume(Player owner) {
        if (controller.getDice() == 9 || controller.getDice() == 10)
            owner.addCoins(controller.getCurrentPlayer().removeCoins(2 + (owner.hasMonument(Monuments.Monument.EINKAUFSZENTRUM)? 1 : 0)));
    }

    @Override
    public CardType getCardType() {
        return CardType.FAMILIEN_RESTAURANT;
    }


    @Override
    public boolean isRestaurant() {
        return true;
    }
}
