package com.henrik.model.cards.types;

import com.henrik.model.Player;
import com.henrik.model.cards.Card;
import com.henrik.model.cards.CardType;
import com.henrik.model.cards.Monuments;

public class MiniMarkt extends Green {

    public MiniMarkt() {
        super(2);
    }

    @Override
    public void consume(Player owner) {
        if (controller.getDice() == 4)
            owner.addCoins(3 + (owner.hasMonument(Monuments.Monument.EINKAUFSZENTRUM)? 1 : 0));
    }

    @Override
    public CardType getCardType() {
        return CardType.MINI_MARKT;
    }


    @Override
    public boolean isLebensmittelgeschaeft() {
        return true;
    }
}
