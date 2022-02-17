package com.henrik.model.cards.types;

import com.henrik.model.Player;
import com.henrik.model.cards.CardType;

public class Fernsehsender extends Violett {

    public Fernsehsender() {
        super(7);
    }

    @Override
    public void consume(Player owner) {
        if (controller.getDice() == 6)
            owner.addCoins(controller.getActOnPlayer().removeCoins(5));
    }

    @Override
    public CardType getCardType() {
        return CardType.FERNSEHSENDER;
    }


    @Override
    public boolean isBuilding() {
        return true;
    }
}
