package com.henrik.model.cards.types;

import com.henrik.model.Player;
import com.henrik.model.cards.CardType;
import com.henrik.model.cards.Monuments;

public class Baeckerei extends Green {

    public Baeckerei() {
        super(1);
    }

    @Override
    public void consume(Player owner) {
        if (controller.getDice() == 2 || controller.getDice() == 3)
            owner.addCoins(1 + (owner.hasMonument(Monuments.Monument.EINKAUFSZENTRUM) ? 1 : 0));
    }

    @Override
    public CardType getCardType() {
        return CardType.BAECKEREI;
    }

    @Override
    public boolean isLebensmittelgeschaeft() {
        return true;
    }
}
