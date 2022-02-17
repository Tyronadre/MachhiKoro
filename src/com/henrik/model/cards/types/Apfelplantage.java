package com.henrik.model.cards.types;

import com.henrik.model.Player;
import com.henrik.model.cards.Card;
import com.henrik.model.cards.CardType;

public class Apfelplantage extends Blue {

    public Apfelplantage() {
        super(3);
    }

    @Override
    public void consume(Player owner) {
        owner.addCoins(3);
    }

    @Override
    public CardType getCardType() {
        return CardType.APFELPLANTAGE;
    }

    @Override
    public boolean isPflanzenFarm() {
        return true;
    }
}
