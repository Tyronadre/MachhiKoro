package com.henrik.model.cards.types;

import com.henrik.model.Player;
import com.henrik.model.cards.Card;
import com.henrik.model.cards.CardType;

public class StartWeizenFeld extends Blue{


    public StartWeizenFeld() {
        super(0);
    }

    @Override
    public void consume(Player owner) {
        if (controller.getDice() == 1)
            owner.addCoins(1);
    }

    @Override
    public CardType getCardType() {
        return CardType.WEIZENFELD;
    }


    @Override
    public boolean isPflanzenFarm() {
        return true;
    }
}
